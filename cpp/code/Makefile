TOOLCHAIN=/mnt/sdb/bin/arm_gcc/android-19-arm
SYSROOT=${TOOLCHAIN}/sysroot

CPP=${TOOLCHAIN}/bin/arm-linux-androideabi-g++
AS=${TOOLCHAIN}/bin/arm-linux-androideabi-as
STRIP=${TOOLCHAIN}/bin/arm-linux-androideabi-strip
CFLAGS=-g3 --sysroot=${SYSROOT}

all: hello
hello: hello.cpp
	${CPP} ${CFLAGS} -o hello_arm hello.cpp
hello_arm:
	${CPP} ${CFLAGS} -S hello.cpp
