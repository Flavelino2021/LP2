#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r, g, b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure {
    int x, y, w, h;
    Color fundo, borda;
    void (* print) (struct Figure*);
} Figure;

///////////////////////////////////////////////////////////////////////////////

// Triangulo

typedef struct {
    Figure super;
} Triangulo;

void triangulo_print (Triangulo* this) {
    Figure* sup = (Figure*) this;

    printf("Triangulo de vertices em (%d,%d), (%d,%d) e (%d,%d).\n",
            sup->x + (sup->w)/2, sup->y, 
            sup->x + sup->w, sup->y + sup->h,
            sup->x, sup->y + sup->h);
}

Triangulo* triangulo_new (int x, int y, int w, int h) {
    Triangulo* this = malloc(sizeof(Triangulo));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) triangulo_print;
    sup->x = x;
    sup->y = y;
    sup->w = w;
    sup->h = h;
}
////////////////////////////////////////////////////////////////////////////////////////////
//Arco

typedef struct {
    Figure super;
    int w, h;
    int anguloInicial, anguloArc;
} Arc;

void arc_print (Arc* this) {
    Figure* sup = (Figure*) this;
    printf("\nArco de tamanho (%d,%d) na posicao (%d,%d) e com angulo de (%d,%d) graus. ",
           this->w, this->h, sup->x, sup->y, this->anguloInicial, this->anguloArc);
    printf("Cor de fundo: "); color_paint(sup->fundo);
    printf("Cor de contorno: "); color_paint(sup->contorno);
}

Arc* arc_new (int x, int y, int w, int h, int anguloInicial, int anguloArc, int fundor, int fundog, int fundob, int contornor, int contornog, int contornob) {
    Arc* this = malloc(sizeof(Arc));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) arc_print;
    sup->x = x;
    sup->y = y;
    sup->fundo = color_new(fundor,fundog,fundob);
    sup->contorno = color_new(contornor,contornog,contornob);
    this->w = w;
    this->h = h;
    this->anguloInicial = anguloInicial;
    this->anguloArc = anguloArc;
    return this;
}

////////////////////////////////////////////////////////////////////////////////////////////////

int main () {
    Figure* figs[4] = {
        (Figure*) triangulo_new(10, 10, 100, 100),
        (Figure*) arc_new(10,10,100,100,45,90)
        (Figure*) triangulo_new(85, 50, 150, 65),
        (Figure*) arc_new(10,10,100,100,50,50)
    };

    for (int i = 0; i < 4; i++) {
        figs[i]->print(figs[i]);
    }

    for (int i = 0; i < 4; i++) {
        free(figs[i]);
    }

    return 0;
}

///////////////////////////////////////////////////////////////////////////////////////////////