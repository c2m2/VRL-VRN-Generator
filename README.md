# VRL-VRN-Generator
VRL-Studio project for neuron mesh generation and containerizing to .vrn

## Workflow for mesh generation
![2020-08-21-171307_1920x1080_scrot](https://user-images.githubusercontent.com/1750463/90906309-c0c49480-e3d1-11ea-97d5-346db635b8d9.png)

## Howto build
1. Clone this repository
2. Edit build.properties and set path to your VRL installation, usually it is $HOME/.vrl
3. ./gradlew installVRLplugin
4. Open VRL-Studio
5. Open the template project [mesh generation](ex/mesh-generation.vrlp) from within VRL-Studio found

