package Vehicles.Images;

import Vehicles.myPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Validate_Purchase_Window extends myPanel implements ActionListener{

    @Serial
    private static final long serialVersionUID = 1L;
    public static final int FRAME_WIDTH = 200;
    public static final int FRAME_HEIGHT = 200;

    JLabel lbl = new JLabel("Are you Sure?");
    JButton yes_btn = new JButton("Yes");
    JButton no_btn = new JButton("No");

    private boolean purchase = false;
    private boolean recieved_input = false;

    public Validate_Purchase_Window() {
        frame = new JFrame("Validate Purchase Window");
        lbl.setBounds(10,0,400,250);
        yes_btn.setBounds(10, 60, 70, 30);
        no_btn.setBounds(100, 60, 70, 30);
        yes_btn.addActionListener(this);
        no_btn.addActionListener(this);
        setLayout(null);
        JComponent[] elements = {lbl, yes_btn, no_btn};
        add_elements(this, elements);
        frame.pack();
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == yes_btn)
        {
            recieved_input = true;
            frame.dispose();
            purchase = true;
        }
        if(e.getSource() == no_btn)
        {
            recieved_input = true;
            frame.dispose();
            purchase = false;
        }
    }

    public boolean isPurchase() {
        return purchase;
    }

    public boolean isRecieved_input() {
        return recieved_input;
    }
}
