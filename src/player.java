import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class player extends JButton {
    private int x = 500; //Initial player xy location
    private int y = 800;
    private int playerspeed = 10; //Initial player speed
    private Color playercolor = Color.WHITE; //Initial team color is white (neutral)
    
    public player()
    {
        super("p1");
        
        setBackground(playercolor);
        addKeyListener(new KeyAdapter() { //Adapter implemented here
            public void keyPressed(KeyEvent evt) {  
                int kk = evt.getKeyCode(); //Player movements controled by keyboard
    
                 if(kk ==  evt.VK_LEFT)  {x=x-playerspeed;} 
            else if(kk ==  evt.VK_RIGHT) {x=x+playerspeed;}
            else if(kk ==  evt.VK_UP)    {y=y-playerspeed;}
            else if(kk ==  evt.VK_DOWN)  {y=y+playerspeed;}
            setBounds(new Rectangle(x,y,80,30));   
            }
        });
        setBounds(x,y,80,30);
    }    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        requestFocusInWindow();
    }
  
    public Color getcolor() {
        return playercolor;
    }
    
    public void setcolor(Color usercolor) {
        setBackground(usercolor);
    }
    
    public int getpx() {
        return x;
    }
    
    public void setpx(int x1) {
        this.x = x1;
    }
    
    public int getpy() {
        return y;
    }
    
    public void setpy(int y1) {
        this.y = y1;
    }
    
}
