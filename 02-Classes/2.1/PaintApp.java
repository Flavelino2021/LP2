import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PaintApp {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Rect r1, r2, r3;

    PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
this.setTitle("Painting Figures");
        this.setSize(350, 350);
        this.r1 = new Rect(50, 50, 100, 50, Color.red, Color.blue);
        this.r2 = new Rect(25, 130, 250, 70, Color.yellow, Color.gray);
        this.r3 = new Rect(45, 175, 200, 60, Color.black, Color.green);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint(g);
        this.r3.paint(g);
    }
}
class Rect {
    int x, y, w, h;
    Color fundo, contorno;

    Rect(int x, int y, int w, int h, Color fundo, Color contorno) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.contorno = contorno; 
	    this.fundo = fundo;
    }

    void print() {
        System.out.format("O tamanho do retangulo eh (%d,%d) ele esta na posicao (%d,%d)\n", this.w, this.h, this.x, this.y);
    }
    

void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.contorno);
        g2d.fillRect(this.x,this.y, this.w,this.h);
        g2d.setColor(this.fundo);
        g2d.drawRect(this.x,this.y, this.w,this.h);
        
    }

}