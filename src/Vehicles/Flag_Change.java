package Vehicles;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import javax.swing.*;

public class Flag_Change extends myPanel implements ActionListener{

    @Serial
    private static final long serialVersionUID = 1L;
    public static final int FRAME_WIDTH = 820;
    public static final int FRAME_HEIGHT = 600;

    private String flag = null;

    //data structures
    VehicleData vehicles = VehicleData.getInstance();
    private final ArrayList<Waterable> wVehicles = null;
    static final int NUM_OF_FLAGS = 7;

    private final JComboBox<ImageIcon> flags = new JComboBox<ImageIcon>();

    private final JButton flag_choose_btn = new JButton("Choose");
    private final JButton back_btn = new JButton("Back");

    public Flag_Change()
    {
        frame = new JFrame("Change Flag");
        flag_choose_btn.addActionListener(this);
        back_btn.addActionListener(this);
        //flag image array
        ImageIcon[] flag_images = new ImageIcon[NUM_OF_FLAGS];
        //setting up flag images sources
        for(int i = 1; i<NUM_OF_FLAGS + 1; i++)
            flag_images[i-1] = new ImageIcon("Images\\Flags\\f" + i + ".jpg");
        setLayout(null);
        setBackground(Color.CYAN);
        for(int i=0;i<NUM_OF_FLAGS;i++)
            flags.addItem(flag_images[i]);
        back_btn.setBounds(600, 200, 100, 220);
        flag_choose_btn.setBounds(450, 200, 100, 220);
        flags.setBounds(100,200,300,220);
        JLabel choose_flag_lbl = new JLabel("Choose Desired Flag!");
        choose_flag_lbl.setBounds(180, -50, 600, 200);
        choose_flag_lbl.setFont(new Font("Courier", Font.BOLD,36));
        JComponent[] flag_choose_elements = {flag_choose_btn, flags, back_btn, choose_flag_lbl};
        add_elements(this, flag_choose_elements);
        makeFrame(FRAME_WIDTH, FRAME_HEIGHT);
    }

    public void exit()
    {
        frame.dispose();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == flag_choose_btn)
        {
            exit();
            flag = flagChoose();
            new SwingWorker<Void, Void>() {

                @Override
                protected Void doInBackground() throws Exception {
                    delay();
                    for (Vehicle v : vehicles) {
                        if (v instanceof Waterable)
                            ((Waterable)v).set_Current_Country_Flag(flag);
                    }
                    vehicles.notifyListeners();
                    alive = false;
                    return null;
                }
            }.execute();
        }
        if(e.getSource() == back_btn)
        {
            alive = false;
            frame.dispose();
        }
    }


    public String flagChoose(){
        if(Objects.requireNonNull(flags.getSelectedItem()).toString().contains("f1"))
            return "Israel";
        else if(flags.getSelectedItem().toString().contains("f2"))
            return  "Germany";
        else if(flags.getSelectedItem().toString().contains("f3"))
            return  "USA";
        else if(flags.getSelectedItem().toString().contains("f4"))
            return "Italy";
        else if(flags.getSelectedItem().toString().contains("f5"))
            return  "Greece";
        else if(flags.getSelectedItem().toString().contains("f6"))
            return  "PIRATE";
        else return  "Somalia";
    }
}


