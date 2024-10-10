package Vehicles;

import java.awt.*;
import javax.swing.*;

public class Driver {
    final JFrame frame ;
    VehicleData vehicles = VehicleData.getInstance();
    public Driver() {
        frame = new JFrame("");
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                final Vehicle_Adding_Class vehicle_adding = new Vehicle_Adding_Class();
            }
        });

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(820, 600);
        frame.setBackground(new Color(25, 41, 88));
        frame.setResizable(false);
        frame.setLocationRelativeTo((Component)null);
    }

    public static void main(String[] args) {
         Driver driver = new Driver();
    }

}
