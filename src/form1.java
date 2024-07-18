import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class form1 extends javax.swing.JFrame {

    private JPanel mainPanel;
    private JButton ACTUALIZARButton;
    private JButton EliminarBtn;

    public form1() {

        setTitle("Menú");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setPreferredSize(new Dimension(400, 200));
        setMinimumSize(new Dimension(400, 200));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        ACTUALIZARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new form2();
                setVisible(false);
            }
        });

        EliminarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new form3();
                setVisible(false);
            }
        });
    }
}
