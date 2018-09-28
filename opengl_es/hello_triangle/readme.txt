// for ubuntu
sudo apt-get install libglfw3-dev libgles2-mesa-dev

// compile
gcc main.c esUtil.c esUtil_X11.c -lEGL -lGLESv2 -lglfw -lX11 -I .

https://askubuntu.com/questions/244133/how-do-i-get-egl-and-opengles-libraries-for-ubuntu-running-on-virtualbox
