import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Rectangle;

public class panel extends JPanel
{
	private JLabel instructions = new JLabel("----------------------Goal Line-----------------------------------------------Goal Line-----------------------------------------------Goal Line-----------------------------------------------Goal Line------------------------------------------------------------------");
        private Timer tim ;
        private int delay = 7; //Checking very oftenly for any intersections (tackles)
        private int score = 0;
        private int misses = 0;
        private toppanel tp; 
        private player p1;
        private opponents op1; 
        private opponents op2;
        private opponents op3;
        
	public panel(toppanel tp1)
	{

    tim = new Timer(delay, new ActionListener() { //Inner class
        public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if (obj == tim) {
            int px = p1.getpx(); //Gets most recent player location (xy coordinates)
            int py = p1.getpy();
            
                  Rectangle p = new Rectangle(px, py, 80, 30); //Makes rectangles representing layout of players for the sake of comparison
              Rectangle opone = new Rectangle(op1.getox(), op1.getoy(), 80, 30);
              Rectangle optwo = new Rectangle(op2.getox(), op2.getoy(), 80, 30);
            Rectangle opthree = new Rectangle(op3.getox(), op3.getoy(), 80, 30);
        
            if(p.intersects(opone) || p.intersects(optwo) || p.intersects(opthree)) { //Checks for opponent buttons touching main player button (tackle)
                misses++; //Increasing misses by 1
                tp.getmisses().setText("Misses: "+misses);
                p1.setpx(500); //set player back to default xy position
                p1.setpy(800);
            }
        }
            if(p1.getpy()==50) { //Checks if player makes it across the goal line (touchdown)
                score++; //Increasing touchdowns by 1
                tp.gettouchdown().setText("Touchdowns: "+score);
                p1.setpx(500); //set player back to default xy position
                p1.setpy(800);
            }
        }
    });
    
            tim.start();
            p1 = new player();
            tp = tp1;
            
            op1 = new opponents(p1);
            op1.setBounds(100, 100, 80, 30); //Sets initial xy location before 1st timer countdown, otherwise all buttons start at 0,0
            op1.setopponentlocation(100, 100); //Sets initial xy location at 1st timer countdown
            
            op2 = new opponents(p1);
            op2.setBounds(500, 100, 80, 30);
            op2.setopponentlocation(500, 100);
            
            op3 = new opponents(p1);
            op3.setBounds(900, 100, 80, 30);
            op3.setopponentlocation(900, 100);
            
            setLayout(null);
            setBackground(Color.green);
            
            add(instructions); //Placing goal line at y = 50
            instructions.setBounds(new Rectangle(0, 50, 1000, 30)); 
            
            add(p1);
            add(op1);
            add(op2);
            add(op3);
        }
    
    public toppanel getpanel_tp() {
        return tp;
    }

    public void setpanel_tp(toppanel tp1) {
        this.tp = tp1;
    }
    
    public player getpanel_p1() {
        return p1;
    }

    public void setpanel_p1(player passp1) {
        this.p1 = passp1;
    }
    
    public opponents getpanel_op1() {
        return op1;
    }

    public void setpanel_op1(opponents passop1) {
        this.op1 = passop1;
    }
    
    public opponents getpanel_op2() {
        return op2;
    }

    public void setpanel_op2(opponents passop2) {
        this.op2 = passop2;
    }
    
    public opponents getpanel_op3() {
        return op3;
    }

    public void setpanel_op3(opponents passop3) {
        this.op3 = passop3;
    }

}
