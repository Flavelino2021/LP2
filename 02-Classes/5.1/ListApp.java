import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import figures.*;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Ellipse> el = new ArrayList<Ellipse>();
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
                    if (evt.getKeyChar() == 'e') {
                        int x = rand.nextInt(1500);
                        int y = rand.nextInt(1500);
                        int w = rand.nextInt(150);
                        int h = rand.nextInt(90);
                        el.add(new Ellipse(x,y, w,h,Color.black,Color.black));
                        repaint();  
                    }
                }
            }
        );

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