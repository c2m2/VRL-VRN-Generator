# VRL-VRN-Generator

VRL-Studio project for neuron mesh generation and containerizing to .vrn for virtual reality 

This project enables the user to create VR meshes and bundles thereof in our 
custom container format (`.vrn`) readable in our virtual reality project in Unity.

The *only* prerequisite is a valid installation of VRL-Studio, see section on howto generate meshes below.
An example project / workflow is provided in the `ex` folder locally after the repository has been cloned.

## Build status and badges

[![Build](https://github.com/c2m2/VRL-VRN-Generator/actions/workflows/Build.yml/badge.svg)](https://github.com/c2m2/VRL-VRN-Generator/actions/workflows/Build.yml)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-magenta.svg)](https://www.gnu.org/licenses/gpl-3.0)
[![Known Vulnerabilities](https://snyk.io/test/github/c2m2/VRL-VRN-Generator/badge.svg?targetFile=VRL-VRN-Generator/build.gradle)](https://snyk.io/test/github/c2m2/VRL-VRN-Generator?targetFile=VRL-VRN-Generator/build.gradle)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/5e4acf16fe224ef7b815a77ba83e5059)](https://www.codacy.com/gh/c2m2/VRL-VRN-Generator/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=c2m2/VRL-VRN-Generator&amp;utm_campaign=Badge_Grade)


## Workflow for mesh generation in VRL-Studio via the GUI
![Demo](../assets/example.png?raw=true)

## Howto generate meshes
1. Clone this repository
2. Edit build.properties and set path to your VRL installation, usually it is $HOME/.vrl
3. ./gradlew installVRLplugin
4. Open VRL-Studio
5. Open the template project [mesh generation](ex/mesh-generation.vrlp) from within VRL-Studio found in the example folder `ex`.
6. Follow the example workflow to create meshes

## Latest builds
- [Thu Mar 18 09:58:42 UTC 2021](https://api.github.com/repos/c2m2/VRL-VRN-Generator/actions/artifacts/47851783/zip)