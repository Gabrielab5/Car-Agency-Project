package Vehicles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serial;
import javax.swing.*;


public class Inventory_Report extends myPanel implements Updateable {

    @Serial
    private static final long serialVersionUID = 1L;
    public static final int FRAME_WIDTH = 820;
    public static final int FRAME_HEIGHT = 600;
    private VehicleData vehicles = VehicleData.getInstance();        //Agency vehicle Array
    private final JPanel vehicles_panel = new JPanel();
    private JLabel[] vehicle_lbls = null;
    private final JLabel vehicle_info = new JLabel();
    private final JLabel pick_lbl = new JLabel();
    JButton exit_btn = new JButton("Exit");
    private final MouseListener mouse_listener;
    public Inventory_Report()  {
        frame = new JFrame("Inventory Report");
        vehicles.addlistener(this);
        mouse_listener = new MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
                for (JLabel vehicleLbl : vehicle_lbls) {
                    if (e.getSource() == vehicleLbl) {
                        vehicle_info.setText(null);
                        pick_lbl.setIcon(null);
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                for(int i=0;i<vehicle_lbls.length;i++)
                {
                    if(e.getSource() == vehicle_lbls[i])
                    {
                        vehicle_info.setText("<html>"+ vehicles.get(i).toString() +"</html>");
                        ImageIcon img = new ImageIcon(vehicles.get(i).getImageSource());
                        Image newimg = img.getImage();
                        newimg = newimg.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                        img = new ImageIcon(newimg);
                        pick_lbl.setIcon(img);
                    }
                }
            }
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }
        };

        JScrollPane scroll_pane = new JScrollPane(vehicles_panel);
        setLayout(null);
        setBackground(Color.CYAN);
        vehicles_panel.setBackground(Color.CYAN);
        JPanel container = new JPanel();
        container.setBackground(Color.cyan);
        vehicles_panel.setLayout(new FlowLayout());
        container.setLayout(new FlowLayout());

        JLabel title_lbl = new JLabel("Inventory");
        title_lbl.setBounds(155,0,200,100);
        title_lbl.setFont(new Font("Courier", Font.BOLD,36));

        JLabel vehicle_details_lbl = new JLabel("Vehicle Details:");
        vehicle_details_lbl.setBounds(530, 0,250,100);
        vehicle_details_lbl.setFont(new Font("Courier", Font.BOLD,24));

        pick_lbl.setBounds(550, 105, 150, 150);

        vehicle_info.setBounds(530, 230, 250, 300);
        vehicle_info.setFont(new Font("Courier", Font.BOLD,18));
        vehicle_info.setBackground(new Color(129, 214, 251));
        vehicles_panel.setPreferredSize(new Dimension(480, (vehicles.size() * 110)/4));

        scroll_pane.setPreferredSize(new Dimension(500, 450));

        container.add(scroll_pane);
        container.setBounds(0,100,520,470);

        exit_btn.setBounds(750, 525, 60, 40);
        //container.setBounds(0, 50, 600, 600);
        JComponent[] elements = {container, title_lbl, vehicle_details_lbl,vehicle_info, pick_lbl, exit_btn};
        add_elements(this, elements);
        this.exit_btn.addActionListener(new ActionListener() {
            final JFrame f = frame;
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
            }
        });

        update_vehicles_imgs();
        makeFrame(FRAME_WIDTH, FRAME_HEIGHT);
    }

    public void update_vehicles_imgs()
    //update the vehicle images every time a new vehicle is added via the vehicle adding panel
    {
        if(vehicle_lbls != null)
            for (JLabel vehicleLbl : vehicle_lbls) {
                vehicles_panel.remove(vehicleLbl);
            }
        vehicle_lbls = new JLabel[vehicles.size()];
        for(int i=0;i<vehicle_lbls.length;i++)
        {
            ImageIcon img = new ImageIcon(vehicles.get(i).getImageSource());
            Image newimg = img.getImage();
            newimg = newimg.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            img = new ImageIcon(newimg);
            vehicle_lbls[i] = new JLabel(img);
            vehicle_lbls[i].addMouseListener(mouse_listener);
            vehicle_lbls[i].setBorder(BorderFactory.createDashedBorder(Color.BLACK));
            vehicles_panel.add(vehicle_lbls[i]);
        }
        vehicle_info.setText(null);
        repaint();
    }

    @Override
    public void updateHandler() {
        vehicles = VehicleData.getInstance();
        update_vehicles_imgs();
    }
}

