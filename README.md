# VRL-VRN-Generator
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-magenta.svg)](https://www.gnu.org/licenses/gpl-3.0)
[![Known Vulnerabilities](https://snyk.io/test/github/c2m2/VRL-VRN-Generator/badge.svg?targetFile=VRL-VRN-Generator/build.gradle)](https://snyk.io/test/github/c2m2/VRL-VRN-Generator?targetFile=VRL-VRN-Generator/build.gradle)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/5e4acf16fe224ef7b815a77ba83e5059)](https://www.codacy.com/gh/c2m2/VRL-VRN-Generator/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=c2m2/VRL-VRN-Generator&amp;utm_campaign=Badge_Grade)

VRL-Studio project for neuron mesh generation and containerizing to .vrn for virtual reality 

## Workflow for mesh generation
![2020-08-21-171307_1920x1080_scrot](https://user-images.githubusercontent.com/1750463/90906309-c0c49480-e3d1-11ea-97d5-346db635b8d9.png)

## Howto build
1. Clone this repository
2. Edit build.properties and set path to your VRL installation, usually it is $HOME/.vrl
3. ./gradlew installVRLplugin
4. Open VRL-Studio
5. Open the template project [mesh generation](ex/mesh-generation.vrlp) from within VRL-Studio found in the example folder `ex`.

## TODO
- Enable CI to automatically build the `.vrlp` plugin.
- Ship ugshell binary and the pipeline script for different operating systems
