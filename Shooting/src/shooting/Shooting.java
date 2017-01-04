package shooting;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Shooting extends JFrame {
	JFrame Frm;
	JPanel Contentpane; //container »ç¿ëÇØµµ ±¦ÂúÀ½
    JLabel Chr;
    final int Moving = 10;
 
    Shooting() {
    	CreateChr();
    	CreateContentpane();
    	CreateFrm();
    }
    
    void CreateFrm() {
    	Frm=new JFrame();
    	Frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Frm.setSize(800, 600);
    	Frm.setContentPane(Contentpane);
    	Frm.setVisible(true);
    	Contentpane.requestFocus();
    }
    
    void CreateContentpane() {
    	Contentpane = new JPanel();
    	Contentpane.setBackground(Color.BLACK);
    	Contentpane.setLayout(null);
        Contentpane.addKeyListener(new MyKeyListener());
        Contentpane.add(Chr);
    }
    
    void CreateChr() {
    	Chr = new JLabel(new ImageIcon("images/haru2.png"));
    	Chr.setLocation(50, 50);
        Chr.setSize(460,260);
    }
 
    class MyKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
            case KeyEvent.VK_UP:
                Chr.setLocation(Chr.getX(), Chr.getY() - Moving);
                break;
            case KeyEvent.VK_DOWN:
                Chr.setLocation(Chr.getX(), Chr.getY() + Moving);
                break;
            case KeyEvent.VK_LEFT:
                Chr.setLocation(Chr.getX() - Moving, Chr.getY());
                break;
            case KeyEvent.VK_RIGHT:
                Chr.setLocation(Chr.getX() + Moving, Chr.getY());
                break;
            }
        }
    }
 
    public static void main(String[] args) {
        new Shooting();
    }
}