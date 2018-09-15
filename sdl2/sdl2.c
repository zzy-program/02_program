#include <stdlib.h>
#include <SDL2/SDL.h>
#include <SDL2/SDL_ttf.h>

#define WINDOW_WIDTH 600
#define WINDOW_HEIGHT (WINDOW_WIDTH)

void get_text_and_rect(SDL_Renderer *renderer, int x, int y, char *text,
		TTF_Font *font, SDL_Texture **texture, SDL_Rect *rect) {
	int text_width;
	int text_height;
	SDL_Surface *surface;
	SDL_Color textColor = {255, 255, 255, 0};

	surface = TTF_RenderText_Solid(font, text, textColor);
	*texture = SDL_CreateTextureFromSurface(renderer, surface);
	text_width = surface->w;
	text_height = surface->h;
	SDL_FreeSurface(surface);
	rect->x = x;
	rect->y = y;
	rect->w = text_width;
	rect->h = text_height;
}

int main(int argc, char **argv) {
	SDL_Event event;
	SDL_Rect rect1, rect2, rect;
	SDL_Renderer *renderer;
	SDL_Window *window;
	char *font_path;
	int quit;

	if (argc == 1) {
		font_path = "fzlth.ttf";
	} else if (argc == 2) {
		font_path = argv[1];
	} else {
		fprintf(stderr, "error: too many arguments\n");
		exit(EXIT_FAILURE);
	}

	/* Inint TTF. */
	SDL_Init(SDL_INIT_TIMER | SDL_INIT_VIDEO);
	SDL_CreateWindowAndRenderer(WINDOW_WIDTH, WINDOW_WIDTH, 0, &window, &renderer);
	TTF_Init();
	TTF_Font *font = TTF_OpenFont(font_path, 32);
	if (font == NULL) {
		fprintf(stderr, "error: font not found\n");
		exit(EXIT_FAILURE);
	}

	TTF_SetFontHinting(font, TTF_HINTING_LIGHT);
	TTF_SetFontStyle(font, TTF_STYLE_BOLD);


	int i;
	SDL_SetRenderDrawColor(renderer, 0, 0, 0, 0);
	SDL_RenderClear(renderer);
	for(i=0; i<4; i++) {

		if(i==0) {
			TTF_SetFontHinting(font, TTF_HINTING_NORMAL);
		}
		if(i==1) {
			TTF_SetFontHinting(font, TTF_HINTING_MONO);
		}
		if(i==2) {
			TTF_SetFontHinting(font, TTF_HINTING_NONE);
		}
		if(i==3) {
			TTF_SetFontHinting(font, TTF_HINTING_NORMAL);
		}

		SDL_Color textColor = { 255, 255, 255 };
		wchar_t wcText[] = { L"翡" };
		SDL_Surface *surface_font = TTF_RenderUNICODE_Solid(font, (Uint16*)wcText, textColor);
		SDL_Texture *texture_font = SDL_CreateTextureFromSurface(renderer, surface_font);  
		rect.x = 200+i*32;
		rect.y = 100;
		rect.w = 32;
		rect.h = 32;

		/* Use textures. */
		SDL_RenderCopy(renderer, texture_font, NULL, &rect);
		SDL_RenderPresent(renderer);
	}

	quit = 0;
	while (!quit) {
		while (SDL_PollEvent(&event) == 1) {
			if (event.type == SDL_QUIT) {
				quit = 1;
			}
		}
	}

	/* Deinit TTF. */
	//SDL_DestroyTexture(texture_font);
	TTF_Quit();

	SDL_DestroyRenderer(renderer);
	SDL_DestroyWindow(window);
	SDL_Quit();
	return EXIT_SUCCESS;
}
