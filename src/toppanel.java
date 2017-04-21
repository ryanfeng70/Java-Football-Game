import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class toppanel extends JPanel {
    private JButton touchdown;
    private JButton missed;
    private JButton psucolor;
    private JButton osucolor;
    private JButton calcolor;
    private JSlider slider;
    private int min = 100;     //Fastest delay
    private int max = 1700;    //Slowest delay
    private int initial = 900; //Initial delay (halfway between)
    private int speed = initial;
    private player player1 ;
    private opponents op1, op2, op3 ;
	
    public toppanel(player p1) {
        super();
        player1 = p1;
        setBackground(Color.gray);
        
        touchdown = new JButton("Touchdowns: 0" );
        
        missed = new JButton("Misses: 0");
        
        psucolor = new JButton("PSU Colors"); //Buttons to change runningback team
        psucolor.addActionListener(new ActionListener() { //Inner class
        public void actionPerformed(ActionEvent e) { //Selects player button's color (Choices for the running back team)            
            player1.setcolor(Color.BLUE);   //PSU team blue
            }
        } );
        
        osucolor = new JButton("OSU Colors");
        osucolor.addActionListener(new ActionListener() { //Inner class
        public void actionPerformed(ActionEvent e) { 
            player1.setcolor(Color.RED); //OSU team Red
            }
        } );
        
        calcolor = new JButton("CAL Colors");
        calcolor.addActionListener(new ActionListener() { //Inner class
        public void actionPerformed(ActionEvent e) { 
            player1.setcolor(Color.YELLOW); //CAL team Yellow
            }
        } );
        
        slider = new JSlider(JSlider.HORIZONTAL, min, max, initial);
        slider.setName("Opponent Speed");
        slider.setMajorTickSpacing(200);
        
        slider.addChangeListener(new ChangeListener() { //Inner class
            public void stateChanged(ChangeEvent e) {  
                Object source = e.getSource();
        
                    if (source==slider) {
                        speed = slider.getValue();
                        op1.setdelay(speed); //Speed alters for all opponent button objects created in panel
                        op1.gettime().setDelay(speed);
                        op2.setdelay(speed);
                        op2.gettime().setDelay(speed);
                        op3.setdelay(speed);
                        op3.gettime().setDelay(speed);
                    } 
            }
        } );
        
        Hashtable labelTable = new Hashtable(); //this is how oracle docs said I should label JSlider ticks
        labelTable.put( new Integer( min ), new JLabel("Faster") );
        labelTable.put( new Integer( min + 750 ), new JLabel("(Opponent's Speed)") );
        labelTable.put( new Integer( max ), new JLabel("Slower") );
        slider.setLabelTable( labelTable );
        
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        
        add(touchdown);
        add(missed);
        add(psucolor);
        add(osucolor);
        add(calcolor);
        add(slider);
    }
    
    public player gettoppanel_player1() {
        return player1;
    }

    public void settoppanel_player1(player player2) {
        this.player1 = player2;
    }
    
    public opponents gettoppanel_op1() {
        return op1;
    }

    public void settoppanel_op1(opponents passop1) {
        this.op1 = passop1;
    }
    
    public opponents gettoppanel_op2() {
        return op2;
    }

    public void settoppanel_op2(opponents passop2) {
        this.op2 = passop2;
    }
    
    public opponents gettoppanel_op3() {
        return op3;
    }

    public void settoppanel_op3(opponents passop3) {
        this.op3 = passop3;
    }

    public JButton gettouchdown() {
        return touchdown;
    }

    public void settouchdown(JButton button1) {
        this.touchdown = button1;
    }
    
    public JButton getmisses() {
        return missed;
    }

    public void setmisses(JButton button1) {
        this.missed = button1;
    }
    
    
}
