#!/bin/bash

# temporary build folder
BUILD_FOLDER="$1"
# ug folder
UG_FOLDER=/home/stephan/Code/git/ug4/
# path to VRL.jar or empty to build
#VRL=/home/stephan/Code/git/VRL/VRL/dist/VRL.jar
VRL=

if [ -z "${BUILD_FOLDER}" -o ! -e "${UG_FOLDER}" ]; then 
   echo "Build folder and ug4 folder required."
   exit 1
fi

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
if [ ! -d "VRL-UG/" ]; then
   git clone https://github.com/VRL-Studio/VRL-UG
else
   cd VRL-UG && git pull && cd -
fi
cp "${VRL}" VRL-UG/
cd VRL-UG

VRL_UG_PACKAGE_NATIVES=eu/mihosoft/vrl/plugin/content/natives/
COMMON_PART_NATIVES=src/main/resources/${VRL_UG_PACKAGE_NATIVES}

cd ${UG_FOLDER}/lib/
zip -r natives.zip "*.so"
cd -
mkdir -p ${COMMON_PART_NATIVES}linux/x86
mkdir -p ${COMMON_PART_NATIVES}linux/x64
cp ${UG_FOLDER}/lib/natives.zip ${COMMON_PART_NATIVES}linux/x86/natives.zip
cp ${UG_FOLDER}/lib/natives.zip ${COMMON_PART_NATIVES}linux/x64/natives.zip
rm natives.zip
./gradlew jar
