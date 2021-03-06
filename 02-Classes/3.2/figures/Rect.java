package figures;

import java.awt.*;

public class Rect {
   private int x, y;
   private int w, h;
   private Color contorno;
   private Color fundo;

    public Rect (int x, int y, int w, int h, Color contorno, Color fundo) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.contorno = contorno;
        this.fundo = fundo;
    }

    private void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(fundo);
        g2d.fillRect(this.x,this.y, this.w,this.h);
        g2d.setColor(contorno);
        g2d.drawRect(this.x,this.y, this.w,this.h);
    }
}
