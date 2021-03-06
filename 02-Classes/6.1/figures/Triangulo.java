package figures;

import java.awt.*;

public class Triangulo extends Figure {
   private int x[];
   private int y[];
   private int x1, x2, x3;
   private int y1, y2, y3;
    
   

    public Triangulo (int x1, int x2, int x3, int y1, int y2, int y3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
        
        
    }

    public void print () {
        System.out.format("Triangulo nos vertices (%d,%d), (%d,%d), (%d,%d).\n",
             this.x1, this.y1, this.x2, this.y2, this.x3, this.y3);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        
        
        int [] x = {this.x1,this.x2,this.x3};
        int [] y = {this.y1,this.y2,this.y3};
        
        g2d.drawPolygon(x, y, 3);
        
        
    }
}
