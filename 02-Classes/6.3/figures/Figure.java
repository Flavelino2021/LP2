package figures;

import java.awt.*;

public abstract class Figure {
    int x, y, w, h;
    Color contorno, fundo;
    
    public Figure (int x, int y, int w, int h, Color contorno, Color fundo) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.contorno = contorno;
        this.fundo = fundo;
    }

    public abstract void print ();
   
}
