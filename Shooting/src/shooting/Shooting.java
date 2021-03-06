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
	JPanel Contentpane; //container ����ص� ������
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
    	Contentpane.setBackground(Color.GREEN);
    	Contentpane.setLayout(null);
        Contentpane.addKeyListener(new MyKeyListener());
        Contentpane.add(Chr);
    }
    
    void CreateChr() {
    	Chr = new JLabel(new ImageIcon("images/haru2.png"));
    	Chr.setLocation(-100, 150);
        Chr.setSize(460,260);
    }
 
    class MyKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
            case KeyEvent.VK_UP:
            	if(Chr.getY()>-60)
            		Chr.setLocation(Chr.getX(), Chr.getY() - Moving);
                break;
            case KeyEvent.VK_DOWN:
            	if(Chr.getY()<360)
            		Chr.setLocation(Chr.getX(), Chr.getY() + Moving);
                break;
            case KeyEvent.VK_LEFT:
            	if(Chr.getX()>-130)
            		Chr.setLocation(Chr.getX() - Moving, Chr.getY());
                break;
            case KeyEvent.VK_RIGHT:
            	if(Chr.getX()<450)
            		Chr.setLocation(Chr.getX() + Moving, Chr.getY());
                break;
            }
        }
    }
 
    public static void main(String[] args) {
        new Shooting();
    }
}