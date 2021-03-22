# VRL-VRN-Generator

VRL-Studio project for neuron mesh generation and containerizing to .vrn for virtual reality 

This project enables the user to create VR meshes and bundles thereof in our 
custom container format (`.vrn`) readable in our virtual reality project in Unity.

The *only* prerequisite is a valid installation of [VRL-Studio](https://vrl-studio.mihosoft.eu/) (and the UG binary, see [ughub](https://github.com/UG4/ughub)), see section on howto build the project and generate meshes below. 

**Note:** For now the path to the ugshell binary has to be provided manually until further notice. If the UG installation is allowed to be included into a spinoff project then the only requirement 
is the VRL-Studio installation.


### Build status

| Linux  | Windows  | OSX  |
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

## Workflow for mesh generation in VRL-Studio via the GUI
![Demo](../assets/example.png?raw=true)

## Howto build the project and generate meshes 

### From source
1.  Clone this repository
2.  (Optional) Edit build.properties and set path to your VRL installation
3.  Either `./gradlew installVRLplugin` or `./gradlew jar` and manual installation of the compiled project
4.  Open the template project via `File->New Project from template->Mesh generation - Example workflow` from within VRL-Studio

### From release (precompiled)
1.  Download a release from the tab on the right
2.  Open VRL-Studio and install the plugin via `Plugins->Install Plugin`
3.  Restart VRL-Studio and open the template project from `File->New Project from template`.

Familarize with the example workflow, then provide `.swc` files from a database, e.g. *NeuroMorpho.org*.

## Latest nightly builds
-   [Fri Mar 19 14:42:03 UTC 2021](https://api.github.com/repos/c2m2/VRL-VRN-Generator/actions/artifacts/48144757/zip)
-   [Mon Mar 22 09:56:07 UTC 2021](https://api.github.com/repos/c2m2/VRL-VRN-Generator/actions/artifacts/48170568/zip)
-   [Mon Mar 22 09:57:30 UTC 2021](https://api.github.com/repos/c2m2/VRL-VRN-Generator/actions/artifacts/48581917/zip)
-   [Mon Mar 22 10:05:32 UTC 2021](https://api.github.com/repos/c2m2/VRL-VRN-Generator/actions/artifacts/48582156/zip)
-   [Mon Mar 22 10:07:27 UTC 2021](https://api.github.com/repos/c2m2/VRL-VRN-Generator/actions/artifacts/48584035/zip)
-   [Mon Mar 22 10:08:37 UTC 2021](https://api.github.com/repos/c2m2/VRL-VRN-Generator/actions/artifacts/48584441/zip)
-   [Mon Mar 22 10:12:57 UTC 2021](https://api.github.com/repos/c2m2/VRL-VRN-Generator/actions/artifacts/48584798/zip)
