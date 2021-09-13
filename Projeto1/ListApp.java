import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import figures.*;

public class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();
    
	ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
		
        this.addKeyListener (
            new KeyAdapter() {
				
                public void keyPressed (KeyEvent evt) {
					 Point position = getMousePosition();
					 int w = 80;
                     int h = 60;
                  int keyCode = evt.getKeyCode();
				  
				  
                    //Aqui são criadas as figuras//
					if (evt.getKeyChar() == 'e') {
						
						figs.add(new Ellipse(position.x,position.y,w,h,Color.white,Color.cyan ));
						
				
						
						}else if(evt.getKeyChar() == 't'){		
						figs.add(new Triangulo(position.x,position.y,w,h,Color.cyan,Color.white));
												
                    	}else if(evt.getKeyChar() == 'r'){		
						figs.add(new Rect(position.x,position.y,w,h,Color.black, Color.green )); 
						
						}
				}
			}
        this.setTitle("Ellipses");
        this.setSize(800, 800);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Ellipse e: this.el) {
            e.paint(g);
        }
    }
}