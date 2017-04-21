import javax.swing.*;
import java.awt.event.*;

public class opponents extends JButton
{
    private Timer time;
    private player p;
    private int delay = 1000; //Initial speed of opponents
    private int ox;
    private int oy;

    public opponents(player p1)
    {
        super ("op");
        p = p1;
        
        time = new Timer(delay, new ActionListener() { //Inner class
            
            public void actionPerformed(ActionEvent event) 
                {
                Object obj = event.getSource();
                if (obj == time)
                    { //AI functions to chase the main player
                    int px = p.getpx(); //Gets player's most recent location (xy coordinates)
                    int py = p.getpy();
            
                    if(px > ox) {
                        ox = ox + 10;
                    }
                    if(py > oy) {
                        oy = oy + 10;
                    }
                    if(px < ox) {
                        ox = ox - 10;
                    }
                    if(py < oy) {
                        oy = oy - 10;
                    }
                    setBounds(ox,oy,80,30);  
                }        
            }            
        });
      	time.start();
        
        setBounds(ox,oy,80,30);
    }
    
    public void setopponentlocation(int x, int y) {
        ox = x; //Sets opponent's location at first timer countdown
        oy = y;
    }
    
    public int getdelay() {
        return delay;
    }
    
    public void setdelay(int newdelay) {
        this.delay = newdelay;
    }
    
    public Timer gettime() {
        return time;
    }
    
    public void settim(Timer newtime) {
        this.time = newtime;
    }
    
    public int getox() {
        return ox;
    }
    
    public void setox(int x) {
        this.ox = x;
    }
    
    public int getoy() {
        return oy;
    }
    
    public void setoy(int y) {
        this.oy = y;
    }
}
