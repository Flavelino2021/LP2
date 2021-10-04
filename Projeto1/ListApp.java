import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import figures.*;



class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    private ArrayList<Figure> figs = new ArrayList<Figure>();
    
    private Random rand = new Random();    
    private Figure focus = null;
    private Point ponto;
    private Point pos = null;

   
    ListFrame () {
     
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                        System.exit(0);
                    }
                }
        );
        
        this.addMouseListener(
            new MouseAdapter()
            {
                public void mousePressed(MouseEvent evt)
                {    Point ponto = getMousePosition();
                     int px = ponto.x; 
                     int py = ponto.y;
                     
                 
                    focus = null;
                    
                           Color contorno = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
                           Color fundo = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
                     
                 
                    for (Figure fig: figs)
                    {
                        if (fig.clicked(evt.getX(), evt.getY()))   
                        {   focus = fig;
                            figs.remove(focus);
						    figs.add(focus);
                            repaint();
                            break;
                        }
                        else
                        { 
                            focus = null;
                            repaint();
                        }
                    }
                    
                }
                
                
            }
        );
        
        this.addMouseMotionListener
        ( 
            new MouseMotionAdapter()
            {
                public void mouseDragged (MouseEvent evt)
                {       if (focus != null) 
                        {   int dx = (evt.getX() - focus.x)-focus.w/2;
        			        int dy = (evt.getY() - focus.y) - focus.h/2;
        			        focus.drag(dx,dy);
        			        repaint();
                        }
                    }
                }
            );
              
        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                pos = getMousePosition();

                        if (pos == null) {
                            return;
                        }
                        
                    int x = pos.x;
                    int y = pos.y;
                    int w = rand.nextInt(50);
                    int h = rand.nextInt(50);
                    int anguloInicial = rand.nextInt(360);
                    int anguloArc = rand.nextInt(360);
                    Color contorno = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
                    Color fundo = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
                    
                    if (evt.getKeyChar() == 'r') {
						
                        Rect r = new Rect(x,y, w,h, contorno, fundo);
                        figs.add(r);
                    }  if (evt.getKeyChar() == 'e') {
					
                        figs.add(new Ellipse(x, y,w, h,contorno, fundo));
                    }
                       if (evt.getKeyChar() == 'a') {
						   
                        figs.add(new Arc(x, y,w, h,contorno, fundo, anguloInicial, anguloArc));
                    }  if (evt.getKeyChar() == 't') {
						
                         figs.add(new Triangulo(x, y, w, h, contorno, fundo));
                    }
                       if(evt.getKeyCode() == 127){
                                figs.remove(focus);
                                focus = null;
                    }
                       if(evt.getKeyChar() == '-'){
			       for(Figure fig: figs){
				       if(focus == fig){
					       fig.w--;
					       fig.h--;
				       }
			       }
		       }
						 
			if(evt.getKeyChar() == '+'){
				for(Figure fig: figs){
					if(focus == fig){
						fig.w++;
						fig.h++;
					}
				}
			} 
			if (evt.getKeyCode() == 37) {
				for(Figure fig: figs){
					if(focus == fig){
						focus.drag(-5,0);     
					}
				}
					   
			}
					   
			if (evt.getKeyCode() == 38) {
				for(Figure fig: figs){
					if(focus == fig){
						focus.drag(0,-5); 
					}
				}
					   
			}
					   
			if (evt.getKeyCode() == 39) {
				for(Figure fig: figs){
					if(focus == fig){
						focus.drag(5,0); 
					}
				}
					   
			}
					   
			if (evt.getKeyCode() == 40) {
				for(Figure fig: figs){
					if(focus == fig){
						focus.drag(0,5); 
					}
				}
					   
			}
			if(evt.getKeyChar() == '1' && focus!=null ){
				focus.fundo=Color.green;
                       }
			if(evt.getKeyChar() == '2' && focus!=null ){
				focus.fundo=Color.red;
                       }
                       if(evt.getKeyChar() == '3' && focus!=null ){
			       focus.fundo=Color.blue;
                       }
                       if(evt.getKeyChar() == '4' && focus!=null ){
			       focus.fundo=Color.pink;
                       }
                       if(evt.getKeyChar() == '5' && focus!=null ){
			       focus.fundo=Color.black;
                       }
                       if(evt.getKeyChar() == '6' && focus!=null ){
			       focus.fundo=Color.yellow;
                       }
                       if(evt.getKeyChar() == '7' && focus!=null ){
			       focus.fundo=Color.white;
                       }
                       if(evt.getKeyChar() == '8' && focus!=null ){
			       focus.fundo=Color.gray;
                       }
                       if(evt.getKeyChar() == '9' && focus!=null ){
			       focus.fundo=Color.orange;
		       }
			repaint();
		}
	    }
	);

        this.setTitle("Projeto 1 - Lista de Figuras");
        this.setSize(800, 800);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g, true);
            Graphics2D g2d = (Graphics2D) g;
            
            if (focus != null){
		    g2d.setColor(Color.RED);
		    g2d.drawRect(focus.x-1, focus.y-1, focus.w+1, focus.h+2);
	    }
            
	}
        
        
    }
}

