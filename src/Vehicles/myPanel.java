package Vehicles;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.util.Random;

public abstract class myPanel extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;
    public static final int FRAME_WIDTH = 800;
    public static final int FRAME_HEIGHT = 600;
    protected boolean alive = false;
    protected JFrame frame;

    public myPanel() {
    }

    public void toFront() {
        this.frame.toFront();
        this.frame.show();
    }

    protected void makeFrame(int width, int height) {
        alive = true;
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(this);
    }

    protected void add_elements(JPanel panel, JComponent[] cmps)//add array of elements to panel
    {
        for (JComponent cmp : cmps) panel.add(cmp);
    }

    protected boolean isValidNumericField(JTextField f) {
        try {
            return !f.getText().equals("") && Integer.parseInt(f.getText()) > 0;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    protected boolean isValidNumericFields(JComponent ...tf) {
        boolean check = true;
        for (JComponent comp : tf) {
            if(comp != null){
                if (comp instanceof JTextField && !isValidNumericField((JTextField) comp)) {
                    ((JTextField)comp).setText("");
                    check = false;
                }
            }

        }
     //   if (!check)
      //      JOptionPane.showMessageDialog(null, "Invalid input -Only numeric positive input\ntry again.", "Vehicle System", JOptionPane.INFORMATION_MESSAGE);
        return check;
    }

    protected boolean valid_input(JComponent ...fields) {
        for (JComponent comp : fields) {
            if(comp != null){
                if (comp instanceof JTextField && ((JTextField)comp).getText().equals("")){
                    return false;
                }
            }
        }
        return true;
    }
    public void delay() {
        SwingWorker<Void, Void> sw = new SwingWorker<Void, Void>() {
            final Random rand = new Random();

            @Override
            protected Void doInBackground() {

                //  Information_Window update_db = new Information_Window("Updating database� Please wait");
              //  update_db.makeFrame(Information_Window.FRAME_WIDTH, Information_Window.FRAME_HEIGHT);
              //  update_db.toFront();
                try {
                    JOptionPane.showMessageDialog(null, "Updating database... Please wait...", "Vehicle System", JOptionPane.PLAIN_MESSAGE);
                  Thread.sleep(rand.nextInt(5000) + 3000);



                } catch (InterruptedException ignored) { }
               // update_db.exit();
                return null;
            }
        };

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                sw.execute();
            }
        });
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

    }
}
