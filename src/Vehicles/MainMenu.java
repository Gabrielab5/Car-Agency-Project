package Vehicles;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serial;
import java.util.HashMap;
import javax.swing.*;

public class MainMenu extends myPanel implements ActionListener, Updateable {
    @Serial
    private static final long serialVersionUID = 1L;
    private static final MainMenu instance = new MainMenu();
    VehicleData vehicles = VehicleData.getInstance();
    TestDrive test_drive;
    JPanel main_menu_panel = new JPanel();
    JPanel flag_change_panel = new JPanel();
    private final JPanel vehicles_panel = new JPanel();
    JComboBox<ImageIcon> flags = new JComboBox<>();
    ImageIcon[] flag_images = new ImageIcon[7];
    JLabel title_lbl = new JLabel("Welcome To the Best Vehicle Agency Ever!");
    JLabel choose_vehicle_lbl = new JLabel("These Are Our Vehicles:");
    JLabel vehicle_info = new JLabel();
    JLabel distance_lbl = new JLabel("Total distance: ");
    JLabel distance = new JLabel(String.valueOf(VehicleData.getInstance().getTotalDistance()));
    JLabel pick_title_lbl = new JLabel("<html>Chosen Vehicle:</html>");
    JLabel pick_lbl = new JLabel();
    JLabel choose_flag_lbl = new JLabel("Choose Desired Flag!");
    JLabel[] vehicleLabels;
    JButton add_vehicles_btn = new JButton("<html>Add Vehicles</html>");
    JButton buy_btn = new JButton("<html>Buy Vehicle</html>");
    JButton color_change_btn = new JButton("<html>Change Color</html>");
    JButton test_drive_btn = new JButton("<html>Test Drive</html>");
    JButton reset_distance_btn = new JButton("<html>   Reset Distances</html>");
    JButton flag_change_btn = new JButton("<html>Change Flags</html>");
    JButton flag_choose_btn = new JButton("Choose");
    JButton back_flag_choose_btn = new JButton("Back");
    JButton exit_btn = new JButton("Exit");
    JButton inventory_report_btn = new JButton("Get Report");
    JButton save_btn = new JButton("Save");
    JButton loadState_btn = new JButton(("Load State"));
    int pick;
    Inventory_Report inventoryReport;
    private final HashMap<Vehicle, TestDrive> testDriveMap;


    private MainMenu( ) {
        this.frame = new JFrame("Vehicle Agency - Main Menu");
        this.testDriveMap = new HashMap<>();
        //adding action listeners to buttons
        this.buy_btn.addActionListener(this);
        this.reset_distance_btn.addActionListener(this);
        this.test_drive_btn.addActionListener(this);
        this.flag_change_btn.addActionListener(this);
        this.flag_choose_btn.addActionListener(this);
        this.back_flag_choose_btn.addActionListener(this);
        this.inventory_report_btn.addActionListener(this);
        this.add_vehicles_btn.addActionListener(this);
        this.save_btn.addActionListener(this);
        this.color_change_btn.addActionListener(this);
        this.loadState_btn.addActionListener(this);
        this.save_btn.setEnabled(true);
        this.loadState_btn.setEnabled(true);
        this.color_change_btn.setEnabled(false);
        this.exit_btn.addActionListener(new ActionListener() {
            final JFrame f = frame;
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
            }
        });
        int i;
        for(i = 1; i < 8; ++i) {
            this.flag_images[i - 1] = new ImageIcon("Images\\Flags\\f" + i + ".jpg");
        }
        vehicles_panel.setLayout(new FlowLayout());
        vehicles_panel.setBackground(new Color(25, 41, 88));
        this.main_menu_panel.setLayout(null);
        this.flag_change_panel.setLayout(null);
        this.flag_change_panel.setBackground(Color.CYAN);
        this.setSize(1280, 980);
        this.setBorder(BorderFactory.createDashedBorder(Color.lightGray));
        this.setLayout(new BorderLayout());
        this.title_lbl.setFont(new Font("Courier", Font.BOLD, 26));
        this.title_lbl.setBounds(100, -80, 1000, 200);
        this.choose_vehicle_lbl.setFont(new Font("Courier",  Font.BOLD, 20));
        this.choose_vehicle_lbl.setBounds(10, -40, 1000, 200);
        this.vehicle_info.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        this.vehicle_info.setFont(new Font("Courier", Font.BOLD, 16));
        this.vehicle_info.setBounds(5, 340, 860, 80);
        this.pick_title_lbl.setBounds(10, 420, 50, 50);
        this.pick_lbl.setBounds(73, 430, 80, 80);
        this.buy_btn.setBounds(180, 430, 120, 40);
        this.test_drive_btn.setBounds(180, 470, 120, 40);
        this.reset_distance_btn.setBounds(310, 430, 130, 80);
        this.flag_change_btn.setBounds(450, 430, 130, 80);
        this.add_vehicles_btn.setBounds(590, 430, 130, 80);
        this.exit_btn.setBounds(760, 0, 100, 50);
        this.save_btn.setBounds(760, 55, 100, 50);
        this.loadState_btn.setBounds(760, 110, 100, 50);
        this.color_change_btn.setBounds(760, 200, 100, 80);
        this.inventory_report_btn.setBounds(730, 430, 130, 80);
        this.buy_btn.setFont(new Font("Courier", Font.BOLD, 18));
        this.test_drive_btn.setFont(new Font("Courier", Font.BOLD, 18));
        this.reset_distance_btn.setFont(new Font("Courier", Font.BOLD, 18));
        this.flag_change_btn.setFont(new Font("Courier", Font.BOLD, 18));
        this.add_vehicles_btn.setFont(new Font("Courier", Font.BOLD, 18));
        this.inventory_report_btn.setFont(new Font("Courier", Font.BOLD, 18));
        this.distance_lbl.setBounds(550,40,150,50);
        this.distance.setBounds(700,40,50,50);
        this.distance_lbl.setFont(new Font("Courier", Font.BOLD, 18));
        this.distance.setFont(new Font("Courier", Font.BOLD, 18));

        for(i = 0; i < 7; ++i) {
            this.flags.addItem(this.flag_images[i]);
        }

        this.back_flag_choose_btn.setBounds(600, 200, 100, 220);
        this.flag_choose_btn.setBounds(450, 200, 100, 220);
        this.flags.setBounds(100, 200, 300, 220);
        this.choose_flag_lbl.setBounds(180, -50, 600, 200);
        this.choose_flag_lbl.setFont(new Font("Courier", Font.BOLD, 36));
        JComponent[] flag_choose_elements = new JComponent[]{this.flag_choose_btn, this.flags, this.back_flag_choose_btn, this.choose_flag_lbl};
        this.add_elements(this.flag_change_panel, flag_choose_elements);
        this.buy_btn.setEnabled(false);
        this.test_drive_btn.setEnabled(false);
        JComponent[] main_menu_elements = new JComponent[]{this.choose_vehicle_lbl, this.vehicle_info, this.title_lbl, this.buy_btn, this.test_drive_btn, this.reset_distance_btn, this.flag_change_btn, this.add_vehicles_btn,this.distance_lbl,this.distance, this.exit_btn,this.save_btn, this.loadState_btn, color_change_btn, this.pick_lbl, this.pick_title_lbl, this.inventory_report_btn};
        this.add_elements(this.main_menu_panel, main_menu_elements);
        this.add(this.flag_change_panel, "Center");
        this.add(this.main_menu_panel, "Center");
        vehicles_panel.setPreferredSize(new Dimension(890, (vehicles.size() * 120)/9));
        makeFrame(FRAME_WIDTH+90, FRAME_HEIGHT);
    }
    public void frameToFront(myPanel addVehicle){
        this.add_vehicles_btn.addActionListener(arg0 -> addVehicle.toFront());
    }
    public static MainMenu getInstance(){
        return instance;
    }
    public void updateVehiclesImgs() {
        if(vehicleLabels != null)

            for (JLabel vehicleLbl : vehicleLabels) {
                vehicles_panel.remove(vehicleLbl);
                this.main_menu_panel.remove(vehicleLbl);
            }
        this.vehicleLabels = new JLabel[this.vehicles.size()];
        for(int i = 0; i < this.vehicleLabels.length; ++i) {
            ImageIcon img = new ImageIcon(this.vehicles.get(i).getImageSource());
            Image newimg = img.getImage();
            newimg = newimg.getScaledInstance(80, 80, 4);
            img = new ImageIcon(newimg);
            this.vehicleLabels[i] = new JLabel(img);
            int currentI = i;
            this.vehicleLabels[i].addMouseListener(new MouseListener() {


                public void mouseExited(MouseEvent e) {
                    MainMenu.this.vehicle_info.setText(null);
                    MainMenu.this.vehicle_info.setBorder(BorderFactory.createLineBorder(Color.lightGray));
                }

                public void mouseEntered(MouseEvent e) {
                    JLabel var1 = MainMenu.this.vehicle_info;
                    var1.setText("<html>" + MainMenu.this.vehicles.get(currentI).toString() + "</html>");
                    MainMenu.this.vehicle_info.setBorder(BorderFactory.createLineBorder(MainMenu.this.vehicles.get(currentI).getColor()));
                }
                public void mousePressed(MouseEvent e) {
                    MainMenu.this.buy_btn.setEnabled(true);
                    MainMenu.this.test_drive_btn.setEnabled(true);
                    MainMenu.this.color_change_btn.setEnabled(true);
                    MainMenu.this.pick = currentI;
                    MainMenu.this.pick_lbl.setIcon(((JLabel)e.getSource()).getIcon());
                }
                public void mouseClicked(MouseEvent e) {
                    MainMenu.this.buy_btn.setEnabled(true);
                    MainMenu.this.test_drive_btn.setEnabled(true);
                    MainMenu.this.color_change_btn.setEnabled(true);
                    MainMenu.this.pick = currentI;
                    MainMenu.this.pick_lbl.setIcon(((JLabel)e.getSource()).getIcon());
                }

                public void mouseReleased(MouseEvent e) {

                }
            });
            this.vehicleLabels[i].setBorder(BorderFactory.createDashedBorder(Color.BLACK));
            if (i < 10) {
                this.vehicleLabels[i].setBounds(i * 80, 100, 80, 80);
            } else if (i < 20) {
                this.vehicleLabels[i].setBounds(i % 10 * 80, 180, 80, 80);
            } else {
                this.vehicleLabels[i].setBounds(i % 10 * 80, 260, 80, 80);
            }
            this.main_menu_panel.add(this.vehicleLabels[i]);
        }
        this.repaint();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buy_btn) {
            Vehicle vehicleToBuy = this.vehicles.get(this.pick);
            int response = JOptionPane.showConfirmDialog(MainMenu.this, "Are you sure?", "Validate Purchase Window", JOptionPane.YES_NO_OPTION);
            if (response ==  JOptionPane.YES_OPTION){
                boolean remove = this.vehicles.remove(this.pick);
                if (!remove) {
                    JOptionPane.showMessageDialog(null, "The vehicle is in test drive.", "Vehicle System", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                vehicleToBuy.setStatus(Vehicle.purchase);
                JLabel[] var2 = this.vehicleLabels;

                for (JLabel vehicleLbl : var2) {
                    this.main_menu_panel.remove(vehicleLbl);
                }
                this.updateVehiclesImgs();
                this.buy_btn.setEnabled(false);
                this.test_drive_btn.setEnabled(false);
                this.vehicle_info.setText(null);
                delay();
                JOptionPane.showMessageDialog(null, "You Just Bought A New Vehicle! \nCongratulations!!", "Vehicle System", JOptionPane.INFORMATION_MESSAGE);
                this.pick_lbl.setIcon(null);
                this.repaint();
            }
            if (vehicles.size() == 0) {
                this.color_change_btn.setEnabled(false);
                this.flag_change_btn.setEnabled(false);
                this.reset_distance_btn.setEnabled(false);
            }
            return;
        }

        if (e.getSource() == this.test_drive_btn) {
            if (vehicles == null) {
                JOptionPane.showMessageDialog(null, "No vehicles. Please add vehicles.", "Vehicle System", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            Vehicle v = this.vehicles.get(this.pick);
            if(v.getStatus().equals(Vehicle.testDrive)){
                testDriveMap.get(v).toFront();
                return;
            }
            EventQueue.invokeLater(() -> {
                synchronized (v) {
                   v.setStatus(Vehicle.testDrive);
                }
                test_drive = new TestDrive(v);
                testDriveMap.put(v, test_drive);
                MainMenu.this.vehicle_info.setText("<html>" + v + "</html>");
                if(test_drive != null)
                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            });
        }
        if (e.getSource() == color_change_btn){
            Color color = JColorChooser.showDialog(null, "Set Vehicle Color",Color.WHITE);
            this.vehicles.get(this.pick).setColor(color);
        }
        if (e.getSource() == this.reset_distance_btn) {
            for (Vehicle vehicle : this.vehicles) {
                vehicle.resetDistanceTraveled();
            }
            VehicleData v = VehicleData.getInstance();
            for (Vehicle vehicle : v) {
                vehicle.resetDistanceTraveled();
            }
            this.vehicle_info.setText(null);
            delay();
            JOptionPane.showMessageDialog(null, "Reset Successfully!");
        }

        if (e.getSource() == this.flag_change_btn) {
            Flag_Change flagChange = new Flag_Change();
            delay();
        }

        if (e.getSource() == this.inventory_report_btn){
            if(inventoryReport == null){
                EventQueue.invokeLater(() -> {
                    MainMenu.this.inventoryReport = new Inventory_Report();
                    MainMenu.this.inventoryReport.toFront();
                });
                delay();
            }
            else{
                this.inventoryReport.toFront();
            }
        }
        if( e.getSource() == this.save_btn){
            delay();
            VehicleData.save();
        }

        if (e.getSource() == this.loadState_btn) {
            String[] buttons = {"First Version", "Second Version", "Third Version", "Cancel" };
            int choise = JOptionPane.showOptionDialog(null, "Which state would you like to load ?", "Saved State Loading",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[3]);
            if (choise != 3) {
                delay();
                VehicleData.load(choise);
            }
        }
    }

    public void add_elements(JPanel panel, JComponent[] cmps) {
        for (JComponent cmp : cmps) {
            panel.add(cmp);
        }
    }

    @Override
    public void updateHandler() {
        vehicles = VehicleData.getInstance();
        updateVehiclesImgs();
        distance.setText(String.valueOf(vehicles.getTotalDistance()));
    }
}

