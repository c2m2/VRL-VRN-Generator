# VRL-VRN-Generator

VRL-Studio project for neuron mesh generation and containerizing to .vrn for virtual reality 

This project enables the user to create VR meshes and bundles thereof in our 
custom container format (`.vrn`) readable in our virtual reality project in Unity.

The *only* prerequisite is a valid installation of VRL-Studio, see section on howto generate meshes below.
An example project / workflow is provided in the `ex` folder locally after the repository has been cloned
or can be downloaded from *this* project website via navigation to the `VRL-VRN-Generator/ex` folder.

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

## Howto generate meshes from source
1.  Clone this repository
2.  Edit build.properties and set path to your VRL installation, usually it is $HOME/.vrl
3.  `./gradlew installVRLplugin` or `./gradlew jar` and manual copy of plugin's `.jar` file from the `build/libs/` folder.
4.  Open VRL-Studio
5.  Open the template project via `File->New Project from template->Mesh generation - Example workflow` from within VRL-Studio
6.  Familarize with the example workflow, then provide `.swc` files from a database

**Note:** For now the path to the ugshell binary and pipeline script has to be provided manually until further notice. If the UG installation is allowed to be included into a spinoff project then the only requirement is the VRL-Studio installation.

## Latest release
For the latest releases check the `Releases` tab on the right hand side.
Simply download a release and unzip it. Install the plugin via the VRL-Studio
plugin tab, restart VRL-Studio and open the example project from the
 `File->New Project from Template` within VRL-Studio.

## Latest nightly builds
-   [Fri Mar 19 12:53:17 UTC 2021](https://api.github.com/repos/c2m2/VRL-VRN-Generator/actions/artifacts/48125423/zip)
=======
-   [Fri Mar 19 14:42:03 UTC 2021](https://api.github.com/repos/c2m2/VRL-VRN-Generator/actions/artifacts/48144757/zip)
-   [Mon Mar 22 09:56:07 UTC 2021](https://api.github.com/repos/c2m2/VRL-VRN-Generator/actions/artifacts/48170568/zip)
-   [Mon Mar 22 09:57:30 UTC 2021](https://api.github.com/repos/c2m2/VRL-VRN-Generator/actions/artifacts/48581917/zip)
