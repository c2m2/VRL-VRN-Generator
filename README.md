# VRL-VRN-Generator

VRL-Studio project for neuron mesh generation and containerizing to .vrn for virtual reality 

This project enables the user to create VR meshes and bundles thereof in our 
custom container format (`.vrn`) readable in our virtual reality project in Unity.

The *only* prerequisite is a valid installation of VRL-Studio, see section on howto generate meshes below.
An example project / workflow is provided in the `ex` folder locally after the repository has been cloned.

### Build status

| Linux  | Windows  | OSX  |
|---|---|---|
| [![Linux](https://github.com/c2m2/VRL-VRN-Generator/actions/workflows/Build.yml/badge.svg)](https://github.com/c2m2/VRL-VRN-Generator/actions/workflows/Build.yml)  |  [![Windows](https://ci.appveyor.com/api/projects/status/lf67s11e2jreogr5?svg=true)](https://ci.appveyor.com/project/stephanmg/vrl-vrn-generator)  | [![OSX](https://travis-ci.org/c2m2/VRL-VRN-Generator.svg?branch=master)](https://travis-ci.org/c2m2/VRL-VRN-Generator)  |

Currently JDK >=8 and Gradle >=6 is supported. If errors occur, feel free to open an issue or contact me directly.

### Releases, documentation, license and code metrics
![GitHub release (latest by date)](https://img.shields.io/github/v/release/c2m2/VRL-VRN-Generator)
[![Docs](https://img.shields.io/badge/Javadoc-%20Documentation-blueviolet.svg)](https://c2m2.github.io/VRL-VRN-Generator/)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-magenta.svg)](https://www.gnu.org/licenses/gpl-3.0)
[![Known Vulnerabilities](https://snyk.io/test/github/c2m2/VRL-VRN-Generator/badge.svg?targetFile=VRL-VRN-Generator/build.gradle)](https://snyk.io/test/github/c2m2/VRL-VRN-Generator?targetFile=VRL-VRN-Generator/build.gradle)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/5e4acf16fe224ef7b815a77ba83e5059)](https://www.codacy.com/gh/c2m2/VRL-VRN-Generator/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=c2m2/VRL-VRN-Generator&amp;utm_campaign=Badge_Grade)

## Workflow for mesh generation in VRL-Studio via the GUI
![Demo](../assets/example.png?raw=true)

## Howto generate meshes from source
1.  Clone this repository
2.  Edit build.properties and set path to your VRL installation, usually it is $HOME/.vrl
3.  ./gradlew installVRLplugin
4.  Open VRL-Studio
5.  Open the template project [mesh generation](ex/mesh-generation.vrlp) from within VRL-Studio found in the example folder `ex`.
6.  Follow the example workflow to create meshes

## TODO
-   Integrate the example project from the assets branch as a template project from resource

## Latest release
For the latest releases check the `Releases` tab on the right hand side.
Simply download a release and unzip it. Install the plugin via the VRL-Studio
plugin tab, restart VRL-Studio and open the example project from the `ex` folder.

## Latest nightly builds
-   [Thu Mar 18 16:41:22 UTC 2021](https://api.github.com/repos/c2m2/VRL-VRN-Generator/actions/artifacts/47945693/zip)
-   [Thu Mar 18 17:54:11 UTC 2021](https://api.github.com/repos/c2m2/VRL-VRN-Generator/actions/artifacts/47946318/zip)
