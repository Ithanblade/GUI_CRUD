import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class form3 extends JFrame {
    private JPanel panel3;
    private JButton eliminarEstudianteButton;
    private JButton regresarAlMenuButton;
    private JTextField cedulaTxt;

    public form3() {
        setTitle("Actualizar Notas");
        setContentPane(panel3);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setPreferredSize(new Dimension(400, 400));
        setMinimumSize(new Dimension(400, 400));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);



        regresarAlMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new form1();
                setVisible(false);
            }
        });
        eliminarEstudianteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String url = "jdbc:mysql://localhost:3306/estudiantes2024";
                String user = "root";
                String password = "123456";
                PreparedStatement pstmt = null;
                Connection conn = null;
                String sql = "delete from estudiantes where cedula = ?";

                try {
                    System.out.println("Base de datos Conectada");
                    conn = DriverManager.getConnection(url,user,password);
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1,cedulaTxt.getText());
                    int n=pstmt.executeUpdate();
                    System.out.println("Se eliminaron: "+n+" lineas");

                    if (n>0){
                        JOptionPane.showMessageDialog(null,"Estudiante eliminado correctamente");
                    }else {
                        JOptionPane.showMessageDialog(null,"No existe el registro del estudiante");

                    }


                }catch (SQLException e1) {
                    System.out.println(e);
                }

            }
        });
    }
}
