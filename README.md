# VRL-VRN-Generator

A VRL-Studio project for neuron mesh generation with a visual programming workflow and configuration of parameter values and packaging respectively containerizing generated meshes into a `.vrn` archive for the virtual reality project. 

The project enables the end-user to create meshes and mesh bundles in our custom container format (`.vrn`) derived from the `zip` file format and is supported to be read and modified in our virtual reality project developed for the Unity gaming platform.

 There is *only* one prerequisite which is a valid installation of the [VRL-Studio](https://vrl-studio.mihosoft.eu/) IDE (and the existence of a precompiled UG4 binary, see [ughub](https://github.com/UG4/ughub) for how to build). In particular for this project see the section on howto build and generate meshes below if you have fulfilled the prerequisites.

**Please note:** For now the path to a precompiled UG4 (ugshell) binary has to be provided manually until further notice. If the developers of the UG4 project will allow our project to include the binary into a derived project, in particular to allow to include the binary as a resource for *this* project then the only requirement which remains is a valid installation of the VRL-Studio IDE which is supported on Linux, OSX and Windows.

### Build status
| Linux  | Windows (WSL) | OSX |
|---|---|---|
| [![Linux](https://github.com/c2m2/VRL-VRN-Generator/actions/workflows/Build.yml/badge.svg)](https://github.com/c2m2/VRL-VRN-Generator/actions/workflows/Build.yml)  |  [![Windows](https://ci.appveyor.com/api/projects/status/lf67s11e2jreogr5?svg=true)](https://ci.appveyor.com/project/stephanmg/vrl-vrn-generator)  | [![OSX](https://travis-ci.org/c2m2/VRL-VRN-Generator.svg?branch=master)](https://travis-ci.org/c2m2/VRL-VRN-Generator)  |

Currently JDK >=8 (up to JDK 13) and Gradle >=6 is supported on the operating systems listed above.

### Releases, documentation, license and code metrics
![GitHub release (latest by date)](https://img.shields.io/github/v/release/c2m2/VRL-VRN-Generator)
[![Docs](https://img.shields.io/badge/Javadoc-%20Documentation-blueviolet.svg)](https://c2m2.github.io/VRL-VRN-Generator/)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-magenta.svg)](https://www.gnu.org/licenses/gpl-3.0)
[![Known Vulnerabilities](https://snyk.io/test/github/c2m2/VRL-VRN-Generator/badge.svg?targetFile=VRL-VRN-Generator/build.gradle)](https://snyk.io/test/github/c2m2/VRL-VRN-Generator?targetFile=VRL-VRN-Generator/build.gradle)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/5e4acf16fe224ef7b815a77ba83e5059)](https://www.codacy.com/gh/c2m2/VRL-VRN-Generator/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=c2m2/VRL-VRN-Generator&amp;utm_campaign=Badge_Grade)
[![GitHub issues open](https://img.shields.io/github/issues/c2m2/VRL-VRN-Generator)](https://github.com/c2m2/VRL-VRN-Generator/issues)
[![Gitter](https://img.shields.io/gitter/room/stephanmg/c2m2.svg?style=flat-square)](https://gitter.im/stephanmg/c2m2)

[![CodeQL](https://github.com/c2m2/VRL-VRN-Generator/actions/workflows/codeql-analysis.yml/badge.svg?branch=master)](https://github.com/c2m2/VRL-VRN-Generator/actions/workflows/codeql-analysis.yml)
[![Release](https://github.com/c2m2/VRL-VRN-Generator/actions/workflows/Release.yml/badge.svg)](https://github.com/c2m2/VRL-VRN-Generator/actions/workflows/Release.yml)
[![Javadoc](https://github.com/c2m2/VRL-VRN-Generator/actions/workflows/Javadoc.yml/badge.svg)](https://github.com/c2m2/VRL-VRN-Generator/actions/workflows/Javadoc.yml)
[![README](https://github.com/c2m2/VRL-VRN-Generator/actions/workflows/Deploy.yml/badge.svg)](https://github.com/c2m2/VRL-VRN-Generator/actions/workflows/Deploy.yml)
[![Build](https://github.com/c2m2/VRL-VRN-Generator/actions/workflows/Build.yml/badge.svg)](https://github.com/c2m2/VRL-VRN-Generator/actions/workflows/Build.yml)

## Workflow for mesh generation in VRL-Studio and a user neuron
![Demo with user geometry](../assets/example.png?raw=true)

## Workflow for mesh generation in VRL-Studio and a shipped neuron
![Demo with shipped geometry](../assets/example_with_geometry.png?raw=true)

## Howto build the project and generate meshes 

### From source
1.  Clone this repository
2.  (Optional) Edit build.properties and set path to your VRL installation
3.  Either `./gradlew installVRLplugin` or `./gradlew jar` and manual installation of the compiled project

### From release (precompiled)
1.  Download a release from the tab on the right (Chose the file `vrl_plugin.zip` from any release)
2.  Decompress the `vrl-plugin.zip` which will create the file `VRL-VRN-Generator.jar`.
3.  Open VRL-Studio and install the plugin via `Plugins->Install Plugin` and select `VRL-VRN-Generator.jar`.

In both cases (re-)start VRL-Studio and then open any of the provided template projects from the menu `File->New Project from template` from within VRL-Studio.

Familarize with the example workflow, then provide a neuron geometry file in the `.swc` format from a [database](http://NeuroMorpho.org) like *NeuroMorpho.org*.

The project ships with an example 1D neuron geometry for which we will create the corresponding 3D geometry, choose the template 
`Mesh Generation - Example workflow with geometry`. The user can also provide their own geometry in this project or load explictly
the template project anticipated for custom input geometries by choosing `Mesh Generation - Example workflow`.

## Latest ten nightly builds
-   [Fri Mar 19 14:42:03 UTC 2021](https://api.github.com/repos/c2m2/VRL-VRN-Generator/actions/artifacts/48144757/zip)
-   [Mon Mar 22 11:31:31 UTC 2021](https://api.github.com/repos/c2m2/VRL-VRN-Generator/actions/artifacts/48603843/zip)
-   [Tue Mar 23 07:12:37 UTC 2021](https://api.github.com/repos/c2m2/VRL-VRN-Generator/actions/artifacts/48605460/zip)
-   [Mon Mar 29 13:46:21 UTC 2021](https://api.github.com/repos/c2m2/VRL-VRN-Generator/actions/artifacts/50209225/zip)
-   [Wed Mar 31 13:09:36 UTC 2021](https://api.github.com/repos/c2m2/VRL-VRN-Generator/actions/artifacts/50753739/zip)
-   [Thu Apr  1 13:50:53 UTC 2021](https://api.github.com/repos/c2m2/VRL-VRN-Generator/actions/artifacts/50986884/zip)
-   [Tue Apr  6 08:56:00 UTC 2021](https://api.github.com/repos/c2m2/VRL-VRN-Generator/actions/artifacts/51856452/zip)
-   [Wed Apr  7 06:59:06 UTC 2021](https://api.github.com/repos/c2m2/VRL-VRN-Generator/actions/artifacts/51857711/zip)
-   [Thu Apr  8 07:00:16 UTC 2021](https://api.github.com/repos/c2m2/VRL-VRN-Generator/actions/artifacts/52117196/zip)
-   [Wed Apr 14 12:57:02 UTC 2021](https://api.github.com/repos/c2m2/VRL-VRN-Generator/actions/artifacts/53811191/zip)
