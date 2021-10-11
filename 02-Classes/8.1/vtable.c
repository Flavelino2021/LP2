#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);
typedef int  (* Figure_Area)  (struct Figure*);
typedef int  (* Figure_Perimetro)  (struct Figure*);


typedef struct {
    void (* print) (struct Figure*);
    int  (* area)  (struct Figure*);
    int  (* perimetro)  (struct Figure*);
} Figure_vtable;

typedef struct Figure {
    int x, y;
    Color fundo, contorno;
    Figure_vtable* vtable;
} Figure;

///////////////////////////////////////////////////////////////////////////////
//Arco
typedef struct {
    Figure super;
    int w, h;
    int anguloInicial, anguloArc;
} Arc;

void arc_print (Arc* this) {
    Figure* sup = (Figure*) this;
    printf("Arc de tamanho (%d,%d) na posicao (%d,%d) e angulo (%d,%d); area: %d e perimetro: %d.\n\n",
           this->w, this->h, sup->x, sup->y, this->anguloInicial, this->anguloArc,sup->vtable->area(sup), sup->vtable->perimetro(sup));
}

int arc_area (Arc* this) {
    Figure* sup = (Figure*) this;
    return this->w * this->h;
}

int arc_perimetro (Arc* this) {
    Figure* sup = (Figure*) this;
    return this->w*2 + this->h*2;
}

Figure_vtable arc_vtable = {
    (Figure_Print) arc_print,
    (Figure_Area)  arc_area,
    (Figure_Perimetro) arc_perimetro
};


Arc* arc_new (int x, int y, int w, int h, int anguloInicial, int anguloArc) {
    Arc* this = malloc(sizeof(Arc));
    Figure* sup = (Figure*) this;
    sup->vtable = &arc_vtable;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
    this->anguloInicial = anguloInicial;
    this->anguloArc = anguloArc;
    
    
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Triangulo

typedef struct {
    Figure super;
} Triangulo;

void triangulo_print (Triangulo* this) {
    Figure* sup = (Figure*) this;
    printf("Triangulo de tamanho (%d,%d) na posicao (%d,%d), area %d,",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup));;printf(" contorno ");color_fig(sup->fundo);printf("e fundo "); color_fig(sup->contorno);
    printf(".\n");

int triangulo_area (Triangulo* this) {
    Figure* sup = (Figure*) this;
    return (this->w * this->h)/2;
}
void triangulo_paint (Triangulo* this){
    Figure* sup = (Figure*) this;
    
}

Figure_vtable triangulo_vtable = {
    (Figure_Print) triangulo_print,
    (Figure_Area)  triangulo_area
};

Triangulo* triangulo_new (int x, int y, int w, int h,int fundor, int fundog, int fundob, int contornor, int contornog, int contornob) {
    Ellipse* this = malloc(sizeof(Triangulo));
    Figure* sup = (Figure*) this;
    sup->vtable = & triangulo_vtable;
    sup->x = x;
    sup->y = y;
    sup->fundo = cor(fundor,fundog,fundob);
    sup->contorno = cor(contornor,contornog,contornob);
    this->w = w;
    this->h = h;
}
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