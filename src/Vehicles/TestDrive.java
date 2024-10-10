package Vehicles;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.*;

public class TestDrive extends myPanel implements ActionListener{
    @Serial
    private static final long serialVersionUID = 1L;
    private final VehicleData vehicle_data;
    public static final int FRAME_WIDTH = 280;
    public static final int FRAME_HEIGHT = 300;
    private final Vehicle vehicle_tested;
    JLabel title_lbl;
    private final JButton drive_btn = new JButton("Drive");
    private final JButton cancel_btn = new JButton("Cancel");
    private final JTextField distance = new JTextField("0");
    private static final ExecutorService executor = Executors.newFixedThreadPool(3);

    private SwingWorker<Void, Void> sw;

    public TestDrive(Vehicle vehicle_tested) {
        frame = new JFrame("Test Drive information");
        this.vehicle_tested = vehicle_tested;
        this.title_lbl = new JLabel("Test for "+vehicle_tested.getModel());
        vehicle_data = VehicleData.getInstance();
        setLayout(null);
        setBackground(Color.red);
        drive_btn.addActionListener(this);
        cancel_btn.addActionListener(this);
        title_lbl.setBounds(20, 0, 250, 100);
        title_lbl.setFont(new Font("Courier", Font.BOLD,30));
        drive_btn.setBounds(5, 150, 100, 70);
        drive_btn.setFont(new Font("Courier", Font.BOLD,10));
        cancel_btn.setBounds(105, 150, 100, 70);
        cancel_btn.setFont(new Font("Courier", Font.BOLD,10));
        cancel_btn.setEnabled(false);
        distance.setBounds(90, 90, 70, 50);
        JComponent[] flag_choose_elements = {title_lbl, drive_btn,cancel_btn, distance};
        add_elements(this, flag_choose_elements);
        makeFrame(FRAME_WIDTH,FRAME_HEIGHT);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == drive_btn) {
            if (isValidNumericField(distance)) {
                drive_btn.setEnabled(false);
                cancel_btn.setEnabled(true);
                title_lbl.setFont(new Font("Courier", Font.BOLD, 14));
                sw = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() {
                        synchronized (vehicle_tested) {
                            vehicle_tested.setStatus(Vehicle.testDrive);
                            title_lbl.setFont(new Font("Courier", Font.BOLD, 24));
                            TestDrive.this.title_lbl.setText(TestDrive.this.vehicle_tested.getModel()+ " is in test...");
                            try {
                                Thread.sleep(100L * Integer.parseInt(distance.getText()));
                            } catch (NumberFormatException | InterruptedException e1) {
                                vehicle_tested.setStatus(Vehicle.inStock);
                                return null;
                            }
                            System.out.println("SW cancelled "  + isCancelled());
                            exit();
                            delay();
                            title_lbl.setText("Test done");
                            cancel_btn.setEnabled(false);
                            vehicle_tested.setStatus(Vehicle.inStock);
                            System.out.println("unlocked test");
                        }
                        return null;
                    }
                };
                executor.execute(sw);
            }
        }

        if (e.getSource() == cancel_btn) {
            if (sw != null ) {
                boolean wasCancelled = sw.cancel(true);
                this.title_lbl.setText("Test for "+vehicle_tested.getModel());
                cancel_btn.setEnabled(false);
                drive_btn.setEnabled(true);
                vehicle_tested.setStatus(Vehicle.inStock);
            }
        }
    }

        public void exit()
        {
            synchronized (vehicle_tested) {
                vehicle_tested.Travel_Distance(Integer.parseInt(distance.getText()));
                vehicle_data.updateDistance(Integer.parseInt(distance.getText()));
                vehicle_tested.setStatus(Vehicle.inStock);
                vehicle_data.notifyListeners();
            }
            frame.dispose();
            alive = false;
        }
    }




