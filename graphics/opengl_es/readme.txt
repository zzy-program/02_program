// for ubuntu
sudo apt-get install libglfw3-dev libgles2-mesa-dev

// compile
gcc hello.c -lGLESv2 -lglfw
gcc hello1.c ./Common/Source/esUtil.c ./Common/Source/LinuxX11/esUtil_X11.c -lEGL -lGLESv2 -lglfw -lX11 -I ./Common/Include/

https://askubuntu.com/questions/244133/how-do-i-get-egl-and-opengles-libraries-for-ubuntu-running-on-virtualbox
