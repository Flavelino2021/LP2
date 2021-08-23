import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

public class Hello2DAppModificado {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
        frame.setVisible(true);
		
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Hello World! Aluna Flavia Avelino dos Santos");
        this.setSize(500, 500);
		this.getContentPane().setBackground(Color.white);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.red);
        int w = getWidth();
        int h = getHeight();
        g2d.drawLine(0,0, w,h);
        g2d.drawLine(0,h, w,0);
	
		g2d.setColor(new Color(255, 222, 173));
		Rectangle2D.Double retangulo = new Rectangle2D.Double(300, 50, 100, 100);
		g2d.fill(retangulo);
		
		g2d.setColor(new Color(255, 0, 255));
		Ellipse2D.Double circulo = new Ellipse2D.Double(100, 50, 100, 100);
		g2d.fill(circulo);
			
    }
}