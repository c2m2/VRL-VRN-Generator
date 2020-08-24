#!/bin/bash

# temporary build folder
BUILD_FOLDER="$1"
# ug folder (do not use UGROOT since we have multiple installations)
UG_FOLDER=/home/stephan/Code/git/ug4/
# path to VRL.jar or empty to build VRL on-the-fly
VRL=

if [ -z "${BUILD_FOLDER}" -o ! -e "${UG_FOLDER}" ]; then 
   echo "Build folder and ug4 folder required."
   exit 1
fi

# create build folder
test ! -e "${BUILD_FOLDER}" && mkdir "${BUILD_FOLDER}"
cd "${BUILD_FOLDER}"

# build vrl
if [ -z  "${VRL}" ]; then
   if [ ! -d "VRL" ]; then
     git clone https://github.com/VRL-Studio/VRL
   else
     cd VRL && git pull && cd -
   fi
   cd VRL/VRL;
   ant clean; ant compile; ant jar;
   cd ../../;
   VRL=VRL/VRL/dist/VRL.jar
fi

if [ ! -e "${VRL}" ]; then
   echo "VRL.jar required."
   exit 2
fi

# build vrl-ug
cp "${VRL}" VRL-UG/
if [ ! -d "VRL-UG/" ]; then
   git clone https://github.com/VRL-Studio/VRL-UG
else
   cd VRL-UG && git pull && cd -
fi
cd VRL-UG

VRL_UG_PACKAGE_NATIVES=eu/mihosoft/vrl/plugin/content/natives/
COMMON_PART_NATIVES=src/main/resources/${VRL_UG_PACKAGE_NATIVES}

zip -r natives.zip "${UG_FOLDER}/lib/libug4.so"
mkdir -p ${COMMON_PART_NATIVES}linux/x86
mkdir -p ${COMMON_PART_NATIVES}linux/x64
cp natives.zip ${COMMON_PART_NATIVES}linux/x86/natives.zip
cp natives.zip ${COMMON_PART_NATIVES}linux/x64/natives.zip
rm natives.zip
./gradlew jar

# TODO: Add build_tools (consoleApp) to automatically 
#       generate the VRL-UG-API (w/o using VRL-Studio
#       GUI but the headless mode instead for CI/CD)
