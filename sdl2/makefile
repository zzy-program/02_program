CC=gcc

sdl2: sdl2.c
	$(CC) -c `sdl2-config --cflags` sdl2.c
	$(CC) -o sdl2 sdl2.o `sdl2-config --libs`  -lSDL2 -lSDL2_ttf

.PHONY: clean
clean:
	rm sdl2 sdl2.o
