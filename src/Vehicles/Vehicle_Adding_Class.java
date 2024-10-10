package Vehicles;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;
import java.util.Objects;
import javax.swing.*;



class Vehicle_Adding_Class extends myPanel implements ActionListener, Updateable {
    @Serial
    private static final long serialVersionUID = 1L;
    private VehicleData vehicles = VehicleData.getInstance();
    private MainMenu main_menu;

    static final int JEEP_FIELDS = 4;
    static final int FRIGATE_FIELDS = 4;
    static final int GLIDER_GAME_FIELDS = 0;
    static final int GLIDER_SPY_FIELDS = 1;
    static final int BICYCLE_FIELDS = 4;
    static final int CRUISE_SHIP_FIELDS = 6;
    static final int AMPHIBIAN_FIELDS = 7;
    static final int HYBRID_AIRCRAFT_FIELDS = 7;
    static final int ELECTRIC_BIKE_FIELDS = 4;
    static final int NUM_OF_IMGS_PER_VEHICLE = 3;
    static final int NUM_OF_FLAGS = 7;
    String pick = null;
    String vehicleType;
    JPanel vehicle_pick_menu_panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
    JPanel vehicle_add_panel = new JPanel();
    JPanel vehicle_add_panel_labels = new JPanel();
    JPanel vehicle_add_panel_textfields = new JPanel();
    JPanel vehicle_add_panel_images = new JPanel();
    JPanel buttons_pan = new JPanel();
    String[] flags = new String[]{"Israel", "Germany", "USA", "Italy", "Greece", "PIRATE", "Somalia"};
    ImageIcon[][] images = new ImageIcon[][]{
            {
                    new ImageIcon("Images\\Jeep\\j1.jpg"),
                    new ImageIcon("Images\\Jeep\\j2.jpg"),
                    new ImageIcon("Images\\Jeep\\j3.jpg")},
            {
                    new ImageIcon("Images\\Frigate\\f1.jpg"),
                    new ImageIcon("Images\\Frigate\\f2.jpg"),
                    new ImageIcon("Images\\Frigate\\f3.jpg")},
            {
                    new ImageIcon("Images\\GameGlider\\g1.jpg"),
                    new ImageIcon("Images\\GameGlider\\g2.jpg"),
                    new ImageIcon("Images\\GameGlider\\g3.jpg")},
            {
                    new ImageIcon("Images\\SpyGlider\\s1.jpg"),
                    new ImageIcon("Images\\SpyGlider\\s2.jpg"),
                    new ImageIcon("Images\\SpyGlider\\s3.jpg")},
            {
                    new ImageIcon("Images\\Bicycle\\b1.jpg"),
                    new ImageIcon("Images\\Bicycle\\b2.jpg"),
                    new ImageIcon("Images\\Bicycle\\b3.jpg")},
            {
                    new ImageIcon("Images\\Cruise\\c1.jpg"),
                    new ImageIcon("Images\\Cruise\\c2.jpg"),
                    new ImageIcon("Images\\Cruise\\c3.jpg")},
            {
                    new ImageIcon("Images\\Amphibious\\a1.jpg"),
                    new ImageIcon("Images\\Amphibious\\a2.jpg"),
                    new ImageIcon("Images\\Amphibious\\a3.jpg")},
            {
                    new ImageIcon("Images\\HybridAirCraft\\h1.jpg"),
                    new ImageIcon("Images\\HybridAirCraft\\h2.jpg"),
                    new ImageIcon("Images\\HybridAirCraft\\h3.jpg"),},
            {
                    new ImageIcon("Images\\ElectricBike\\eb1.jpg"),
                    new ImageIcon("Images\\ElectricBike\\eb2.jpg"),
                    new ImageIcon("Images\\ElectricBike\\eb3.jpg"),},};
    JComboBox<ImageIcon> vehicle_images_combo = new JComboBox<>();
    JComboBox<String> flags_combo = new JComboBox<>();
    JButton continue_btn = new JButton("Continue ->");
    JButton add_vehicle_btn = new JButton("Add Vehicle");
    JButton load_img_btn = new JButton("Load Image");
    JButton back_btn = new JButton("Back");
    JButton Frigate_btn = new JButton("Frigate");
    JButton jeep_btn = new JButton("Jeep");
    JButton glider_game_btn = new JButton("Glider Game");
    JButton glider_spy_btn = new JButton("Glider Spy");
    JButton bicycle_btn = new JButton("Bicycle");
    JButton cruise_ship_btn = new JButton("Cruise Ship");
    JButton amphibian_btn = new JButton("Amphibian");
    JButton electric_bike_btn = new JButton("Electric bicycle");
    JButton hybrid_aircraft_btn = new JButton("Hybrid Air Craft");
    ImageIcon bg_img = new ImageIcon("Images\\bg.jpg");
    JLabel title_lab = new JLabel("Hey!\n Please Choose Your Agency Vehicles:");
    JLabel model_lab = new JLabel("Model:");
    JLabel max_passengers_lab = new JLabel("Max Passengers:");
    JLabel max_speed_lab = new JLabel("Max Speed:");
    JLabel wheels_lab = new JLabel("Wheels Number:");
    JLabel flag_lab = new JLabel("Flag:");
    JLabel engine_lab = new JLabel("Engine Life:");
    JLabel gas_lab = new JLabel("Gas Consumption:");
    JLabel wind_lab = new JLabel("With Wind direction:");
    JLabel power_source_lab = new JLabel("Power Source:");
    JLabel road_lab = new JLabel("Road:");
    JLabel menu_img;
    //text fields
    JTextField modelTF; JTextField max_passengersTF; JTextField max_speedTF; JTextField wheels_numTF; JTextField engineTF; JTextField gasTF; JTextField power_sourceTF; JTextField roadTF;
    JComponent [] vehicleFields ;
    JFileChooser fc;
    JCheckBox withWindDir = new JCheckBox();
    public Vehicle_Adding_Class() {
        vehicles.addlistener(this);
        frame = new JFrame("Vehicle Agency - Vehicle Adding");
        this.menu_img = new JLabel(this.bg_img);
        this.fc = new JFileChooser();
        //btn action listener adding
        this.continue_btn.addActionListener(this);
        this.load_img_btn.addActionListener(this);
        this.add_vehicle_btn.addActionListener(this);
        this.back_btn.addActionListener(this);
        this.Frigate_btn.addActionListener(this);
        this.jeep_btn.addActionListener(this);
        this.glider_game_btn.addActionListener(this);
        this.glider_spy_btn.addActionListener(this);
        this.bicycle_btn.addActionListener(this);
        this.cruise_ship_btn.addActionListener(this);
        this.amphibian_btn.addActionListener(this);
        this.hybrid_aircraft_btn.addActionListener(this);
        this.electric_bike_btn.addActionListener(this);
        //text fields setup
        this.modelTF = new JTextField();
        this.gasTF = new JTextField();
        this.wheels_numTF = new JTextField();
        this.roadTF = new JTextField();
        this.power_sourceTF = new JTextField();
        this.max_speedTF = new JTextField();
        this.max_passengersTF = new JTextField();
        this.engineTF = new JTextField();
        //panel setup
        this.setLayout(new BorderLayout());
        this.vehicle_add_panel.setLayout(null);
        this.vehicle_add_panel.setBackground(new Color(129, 214, 251));
        this.vehicle_pick_menu_panel.setLayout(null);
        this.vehicle_add_panel_images.setLayout(new FlowLayout());
        this.buttons_pan.setLayout(new FlowLayout());
        this.vehicle_add_panel_labels.setLayout(new FlowLayout());
        this.vehicle_add_panel_textfields.setLayout(new FlowLayout());
        this.vehicle_add_panel_images.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        this.buttons_pan.setBackground(new Color(4, 104, 251));
        this.vehicle_pick_menu_panel.setBackground(new Color(4, 104, 251));
        this.vehicle_add_panel_labels.setBackground(new Color(129, 214, 251));
        this.vehicle_add_panel_textfields.setBackground(new Color(129, 214, 251));
        this.vehicle_add_panel_labels.setBorder(BorderFactory.createLineBorder(new Color(129, 214, 251)));
        this.vehicle_add_panel_textfields.setBorder(BorderFactory.createLineBorder(new Color(129, 214, 251)));
        this.title_lab.setBounds(100, -20, 700, 100);
        this.buttons_pan.setBounds(50, 70, 700, 100);
        this.continue_btn.setBounds(265, 510, 250, 50);
        this.vehicle_add_panel_images.setBounds(150, 300, 800, 300);
        this.add_vehicle_btn.setBounds(400, 400, 60, 60);
        this.menu_img.setBounds(100, 50, 600, 600);
        this.back_btn.setBounds(450, 400, 300, 100);
        this.load_img_btn.setBounds(450, 200, 300, 20);
        this.add_vehicle_btn.setBounds(450, 230, 300, 150);
        this.add_vehicle_btn.setFont(new Font("Courier", Font.BOLD, 34));
        this.vehicle_add_panel_labels.setBounds(20, 0, 200, 500);
        this.vehicle_add_panel_textfields.setBounds(220, 0, 200, 500);
        this.vehicle_images_combo.setBounds(450, 0, 320, 200);
        this.flags_combo.setBounds(220, 800, 200, 100);
        for (int i = 0; i < NUM_OF_FLAGS; ++i) {
            this.flags_combo.addItem(this.flags[i]);
        }
        this.title_lab.setFont(new Font("Serif Bold", Font.BOLD, 30));
        this.continue_btn.setFont(new Font("Courier", Font.BOLD, 26));
        JComponent[] buttons_pan_elements = new JComponent[]{this.jeep_btn, this.Frigate_btn, this.glider_game_btn, this.glider_spy_btn, this.bicycle_btn, this.cruise_ship_btn, this.amphibian_btn, this.hybrid_aircraft_btn, this.electric_bike_btn};
        this.add_elements(this.buttons_pan, buttons_pan_elements);
        JComponent[] vehicle_add_panel_elements = new JComponent[]{this.load_img_btn, this.back_btn, this.add_vehicle_btn, this.vehicle_add_panel_labels, this.vehicle_add_panel_textfields, this.vehicle_images_combo, this.flags_combo};
        this.add_elements(this.vehicle_add_panel, vehicle_add_panel_elements);
        JComponent[] vehicle_pick_menu_panel_elements = new JComponent[]{this.title_lab, this.buttons_pan, this.continue_btn, this.menu_img};
        this.add_elements(this.vehicle_pick_menu_panel, vehicle_pick_menu_panel_elements);
        this.vehicle_add_panel.setVisible(false);
        this.continue_btn.setEnabled(false);
        this.continue_btn.addActionListener(e -> {
            if(main_menu == null){
                EventQueue.invokeLater(() -> {
                    main_menu = MainMenu.getInstance();
                    main_menu.frameToFront(Vehicle_Adding_Class.this);
                    main_menu.updateVehiclesImgs();
                    vehicles.addlistener(main_menu);
                });
            }
            else {
                main_menu.setVisible(true);
                main_menu.toFront();
            }
        });
        this.add(this.vehicle_add_panel, "Center");
        this.add(this.vehicle_pick_menu_panel, "Center");
        makeFrame(FRAME_WIDTH, FRAME_HEIGHT);

    }
    private int tryParse(JTextField field) {
        int n = 0;
        try {
            n = Integer.parseInt(field.getText());
        }catch(NumberFormatException|NullPointerException ignored){}
        return n;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.load_img_btn) {
            this.fc.showDialog(this.vehicle_add_panel, "Attach");
            if (this.fc.getSelectedFile() != null) {
                this.vehicle_images_combo.getModel().setSelectedItem(new ImageIcon(this.fc.getSelectedFile().toString()));
                this.repaint();
                this.revalidate();
            }
        }

        if (e.getSource() == this.add_vehicle_btn) {
            VehicleFactory factory = new VehicleFactory();
            Vehicle v = null;

           //implementing Vehicle abstract factory
            if (Objects.equals(this.vehicleType, VehicleFactory.LAND)) {
                if (valid_input(modelTF) && isValidNumericFields(max_passengersTF,max_speedTF, gasTF,engineTF,wheels_numTF))
                    v = factory.createLand(pick, modelTF.getText(),tryParse(max_passengersTF), tryParse(max_speedTF), tryParse(engineTF) , tryParse(wheels_numTF), roadTF.getText(),tryParse(gasTF), (String)flags_combo.getSelectedItem());
                else if ((valid_input(modelTF) && isValidNumericFields(gasTF,max_speedTF,engineTF)))
                    v = factory.createLand(pick, modelTF.getText(),tryParse(max_passengersTF), tryParse(max_speedTF), tryParse(engineTF) , tryParse(wheels_numTF), roadTF.getText(),tryParse(gasTF), (String)flags_combo.getSelectedItem());
                else if ( valid_input(modelTF, roadTF) && isValidNumericFields(max_passengersTF,max_speedTF))
                    v = factory.createLand(pick, modelTF.getText(),tryParse(max_passengersTF), tryParse(max_speedTF), tryParse(engineTF) , tryParse(wheels_numTF), roadTF.getText(),tryParse(gasTF), (String)flags_combo.getSelectedItem());
            }
            if (Objects.equals(this.vehicleType, VehicleFactory.WATER)) {
                if (isValidNumericFields(max_passengersTF,max_speedTF, gasTF,engineTF) && valid_input(modelTF))
                    v = factory.createWater(pick,modelTF.getText(), tryParse(max_passengersTF),tryParse(max_speedTF), tryParse(gasTF), (String)flags_combo.getSelectedItem(),tryParse(engineTF), withWindDir.isSelected());
                else if (isValidNumericFields(max_passengersTF,max_speedTF))
                    v = factory.createWater(pick,modelTF.getText(), tryParse(max_passengersTF),tryParse(max_speedTF), tryParse(gasTF), (String)flags_combo.getSelectedItem(),tryParse(engineTF), withWindDir.isSelected());
            }
            if (Objects.equals(this.vehicleType, VehicleFactory.AIR)) {
                if (valid_input(power_sourceTF))
                    v = factory.createAir(pick,power_sourceTF.getText());
                else
                    v = factory.createAir(pick,power_sourceTF.getText()); //for glider game
            }

                if(v == null)
                    return;
                v.setImageSource(Objects.requireNonNull(this.vehicle_images_combo.getSelectedItem()).toString());
                this.vehicles.add(v);
                this.onLeaving_Vehicle_Adding_Menu();
                this.continue_btn.setEnabled(true);
                for(JComponent field :vehicleFields){
                    if(field != null) {
                        if(field instanceof JTextField)
                            ((JTextField)field).setText("");
                        else if(field instanceof JCheckBox)
                            ((JCheckBox)field).setSelected(false);
                        else if(field instanceof JComboBox)
                            ((JComboBox<?>)field).setSelectedIndex(-1);
                    }
                }
                delay();
        }
        if (e.getSource() == this.back_btn) {
            this.onLeaving_Vehicle_Adding_Menu();
        }

        if (e.getSource() == this.jeep_btn) {
            this.pick = VehicleFactory.Jeep;
            vehicleFields = new JComponent[] {modelTF, gasTF, max_speedTF, engineTF};
            this.vehicleAdd_menu(new JLabel[]{this.model_lab, this.gas_lab, this.max_speed_lab, this.engine_lab});
        }

        if (e.getSource() == this.Frigate_btn) {
            this.pick = VehicleFactory.Frigate;
            vehicleFields = new JComponent[] {modelTF, max_speedTF, max_passengersTF, withWindDir};
            this.vehicleAdd_menu(new JLabel[]{this.model_lab, this.max_speed_lab, this.max_passengers_lab, this.wind_lab});
        }

        if (e.getSource() == this.glider_game_btn) {
            this.pick = VehicleFactory.GliderGame;
            vehicleFields = new JComponent[]{};
            this.vehicleAdd_menu(new JLabel[0]);
        }

        if (e.getSource() == this.glider_spy_btn) {
            this.pick = VehicleFactory.GliderSpy;
            vehicleFields = new JComponent[] {power_sourceTF};
            this.vehicleAdd_menu(new JLabel[]{this.power_source_lab});
        }

        if (e.getSource() == this.bicycle_btn) {
            this.pick = VehicleFactory.Bicycle;
            vehicleFields = new JComponent[] {modelTF, max_passengersTF,max_speedTF,  roadTF};
            this.vehicleAdd_menu(new JLabel[]{this.model_lab, this.max_passengers_lab, this.max_speed_lab, this.road_lab});
        }

        if (e.getSource() == this.cruise_ship_btn) {
            this.pick = VehicleFactory.CruiseShip;
            vehicleFields = new JComponent[] {modelTF, max_passengersTF,max_speedTF,  gasTF,engineTF,flags_combo};
            this.vehicleAdd_menu(new JLabel[]{this.model_lab, this.max_passengers_lab, this.max_speed_lab, this.gas_lab, this.engine_lab, this.flag_lab});
        }

        if (e.getSource() == this.amphibian_btn) {
            this.pick = VehicleFactory.Amphibian;
            vehicleFields = new JComponent[] {modelTF, max_passengersTF,max_speedTF, wheels_numTF, engineTF, gasTF,flags_combo};
            this.vehicleAdd_menu(new JLabel[]{this.model_lab, this.max_passengers_lab, this.max_speed_lab, this.wheels_lab, this.engine_lab, this.gas_lab, this.flag_lab});
        }

        if (e.getSource() == electric_bike_btn) {
            pick = VehicleFactory.ElectricBicycle;
            vehicleFields = new JComponent[] {modelTF, max_passengersTF,max_speedTF, roadTF};
            vehicleAdd_menu(new JLabel[]{this.model_lab, this.max_passengers_lab, this.max_speed_lab, this.road_lab});
        }

        if (e.getSource() == hybrid_aircraft_btn) {
            pick =VehicleFactory.HybridAircraft;
            vehicleFields = new JComponent[] {modelTF, max_passengersTF,max_speedTF, wheels_numTF, engineTF, gasTF,flags_combo};
            vehicleAdd_menu(new JLabel[]{this.model_lab, this.max_passengers_lab, this.max_speed_lab,this.wheels_lab, this.engine_lab, this.gas_lab, this.flag_lab});
        }
    }

    private void onLeaving_Vehicle_Adding_Menu() {
        this.vehicle_add_panel_textfields.removeAll();
        this.vehicle_add_panel_labels.removeAll();
        this.vehicle_add_panel.setVisible(false);
        this.vehicle_pick_menu_panel.setVisible(true);
    }

    private void vehicleAdd_menu(JLabel[] vehicle_label_fields) {
        this.vehicle_images_combo.removeAllItems();
        if (Objects.equals(this.pick, VehicleFactory.Jeep)) {
            vehicleType = VehicleFactory.LAND;
            this.setup_specific_vehicle_menu(vehicle_label_fields, JEEP_FIELDS, 0, false);
        }

        if (Objects.equals(this.pick, VehicleFactory.Frigate)) {
            vehicleType = VehicleFactory.WATER;
            this.setup_specific_vehicle_menu(vehicle_label_fields, FRIGATE_FIELDS, 1, false);
        }

        if (Objects.equals(this.pick, VehicleFactory.GliderGame)) {
            vehicleType = VehicleFactory.AIR;
            this.setup_specific_vehicle_menu(vehicle_label_fields, GLIDER_GAME_FIELDS, 2, false);
        }

        if (Objects.equals(this.pick, VehicleFactory.GliderSpy)) {
            vehicleType = VehicleFactory.AIR;
            this.setup_specific_vehicle_menu(vehicle_label_fields, GLIDER_SPY_FIELDS, 3, false);
        }

        if (Objects.equals(this.pick, VehicleFactory.Bicycle)) {
            vehicleType =  VehicleFactory.LAND;
            this.setup_specific_vehicle_menu(vehicle_label_fields, BICYCLE_FIELDS, 4, false);
        }

        if (Objects.equals(this.pick, VehicleFactory.CruiseShip)) {
            vehicleType =  VehicleFactory.WATER;
            this.setup_specific_vehicle_menu(vehicle_label_fields, CRUISE_SHIP_FIELDS, 5, true);
        }

        if (Objects.equals(this.pick, VehicleFactory.Amphibian)) {
            vehicleType =  VehicleFactory.LAND;
            this.setup_specific_vehicle_menu(vehicle_label_fields, AMPHIBIAN_FIELDS, 6, true);
        }

        if (Objects.equals(pick, VehicleFactory.HybridAircraft)) {
            vehicleType =  VehicleFactory.LAND;
            setup_specific_vehicle_menu(vehicle_label_fields, HYBRID_AIRCRAFT_FIELDS, 7, true);
        }

        if (Objects.equals(pick, VehicleFactory.ElectricBicycle)) {
            vehicleType =  VehicleFactory.LAND;
            setup_specific_vehicle_menu(vehicle_label_fields, ELECTRIC_BIKE_FIELDS, 8, false);
        }

        this.vehicle_add_panel.setBounds(0, 0, 1000, 1000);
        this.vehicle_pick_menu_panel.setVisible(false);
        this.vehicle_add_panel.setVisible(true);
    }

    private void setup_specific_vehicle_menu(JLabel[] vehicle_label_fields, int length, int img_index, boolean is_Water_V) {
        int i;
        for (i = 0; i < length; ++i) {
            vehicle_label_fields[i].setPreferredSize(new Dimension(200, 40));
            if (vehicle_label_fields[i] != flag_lab && vehicle_label_fields[i] != null) {
                this.vehicleFields[i].setPreferredSize(new Dimension(160, 40));
                this.vehicle_add_panel_textfields.add(this.vehicleFields[i]);
            } else {
                this.vehicle_add_panel_textfields.add(flags_combo);
            }
            vehicle_label_fields[i].setFont(new Font("Courier", Font.BOLD, 20));
            this.vehicle_add_panel_labels.add(vehicle_label_fields[i]);
        }

        for (i = 0; i < NUM_OF_IMGS_PER_VEHICLE; ++i) {
            this.vehicle_images_combo.addItem(this.images[img_index][i]);
        }
        if (is_Water_V) {
            flags_combo.setVisible(true);
            if (Objects.equals(this.pick, VehicleFactory.Frigate))
                flags_combo.setEditable(false);
        }
    }


    @Override
    public void updateHandler() {
        this.vehicles = VehicleData.getInstance();
    }
}

