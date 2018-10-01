#include <stdlib.h>
#include <SDL2/SDL.h>
#include <SDL2/SDL_ttf.h>

#define WINDOW_WIDTH 600
#define WINDOW_HEIGHT (WINDOW_WIDTH)

TTF_Font *font = NULL;
SDL_Renderer *renderer = NULL;

int draw_string(wchar_t *string, SDL_Rect rect) {

	if(NULL == font) {
		return -1;
	}

	if(NULL == renderer) {
		return -1;
	}

	TTF_SetFontHinting(font, TTF_HINTING_LIGHT);
	// TTF_SetFontStyle(font, TTF_STYLE_BOLD);

	SDL_SetRenderDrawColor(renderer, 0, 0, 0, 0);
	SDL_RenderClear(renderer);

	while(*string) {

		SDL_Color textColor = { 255, 255, 255 };

		SDL_Surface *surface_font = TTF_RenderUNICODE_Solid(font, (Uint16*)string, textColor);
		SDL_Texture *texture_font = SDL_CreateTextureFromSurface(renderer, surface_font);  

		/* Use textures. */
		SDL_RenderCopy(renderer, texture_font, NULL, &rect);
		SDL_RenderPresent(renderer);
		SDL_DestroyTexture(texture_font);

		rect.x += rect.w+3;

		printf("string: 0x%x\n", (Uint16)*string);
		string++;
	}
}

int main(int argc, char **argv) {
	SDL_Event event;
	SDL_Rect rect;
	
	SDL_Window *window;
	char *font_path;

	wchar_t string[] = {L"你好"}; 

	if (argc == 1) {
		font_path = "fzlth.ttf";
	} else if (argc == 2) {
		font_path = argv[1];
	} else {
		fprintf(stderr, "error: too many arguments\n");
		exit(EXIT_FAILURE);
	}

	// init ttf
	SDL_Init(SDL_INIT_TIMER | SDL_INIT_VIDEO);
	SDL_CreateWindowAndRenderer(WINDOW_WIDTH, WINDOW_WIDTH, 0, &window, &renderer);
	TTF_Init();
	font = TTF_OpenFont(font_path, 32);
	if (font == NULL) {
		fprintf(stderr, "error: font not found\n");
		exit(EXIT_FAILURE);
	}

	rect.x = 200;
	rect.y = 100;
	rect.w = 32;
	rect.h = 32;
	draw_string(string, rect);

	int quit = 0;
	while (!quit) {
		while (SDL_PollEvent(&event) == 1) {
			if (event.type == SDL_QUIT) {
				quit = 1;
			}
		}
	}

	// ttf quit
	TTF_Quit();

	// sdl exit
	SDL_DestroyRenderer(renderer);
	SDL_DestroyWindow(window);
	SDL_Quit();

	return EXIT_SUCCESS;
}
