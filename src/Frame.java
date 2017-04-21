import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame
{
	private panel pn;
        private toppanel tp;
        private player p;
        private opponents op1;
	
        public Frame ()
	{
            super ("L03E Inner Listeners by Ryan Feng");
            p = new player();
            op1 = new opponents(p);
            tp = new toppanel(p);
            pn = new panel(tp);
            tp.settoppanel_op1(pn.getpanel_op1()); //These ensure that the 3 opponent buttons' speed are affected by the JSlider in toppanel
            tp.settoppanel_op2(pn.getpanel_op2()); //Also Dr. Fonseca told me to do it this way
            tp.settoppanel_op3(pn.getpanel_op3());
            tp.settoppanel_player1(pn.getpanel_p1()); //This ensures toppanel can change the team(color) of the player button in panel
            
            add(tp, BorderLayout.NORTH);
            add(pn, BorderLayout.CENTER);          
            
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize (1000, 1000);
            setVisible(true);
	}
}
