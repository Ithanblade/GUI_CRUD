import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class form2 extends JFrame {

    private JPanel panel2;
    private JButton actualizarNotasButton;
    private JTextField nota1Txt;
    private JTextField nota2Txt;
    private JTextField cedulaTxt;
    private JButton RegresarBtn;

    public form2() {
        setTitle("Actualizar Notas");
        setContentPane(panel2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setPreferredSize(new Dimension(400, 400));
        setMinimumSize(new Dimension(400, 400));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        RegresarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new form1();
                setVisible(false);
            }
        });
        actualizarNotasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String url = "jdbc:mysql://localhost:3306/estudiantes2024";
                String user = "root";
                String password = "123456";
                PreparedStatement pstmt = null;
                Connection conn = null;


                try {
                    conn = DriverManager.getConnection(url, user, password);

                    System.out.println("Conectado a ala base de datos");
                    String sql="update estudiantes set b1 = ?, b2 = ? where cedula = ?";

                    pstmt = conn.prepareStatement(sql);
                    pstmt.setDouble(1,Double.parseDouble(nota1Txt.getText()));
                    pstmt.setDouble(2,Double.parseDouble(nota2Txt.getText()));
                    pstmt.setString(3,cedulaTxt.getText());
                    pstmt.executeUpdate();
                    int n=pstmt.executeUpdate();
                    if(n>0){
                        JOptionPane.showMessageDialog(null,"Notas Actualizadas");
                    }else{
                        JOptionPane.showMessageDialog(null,"No Existe El Registro");
                    }

                } catch (SQLException e1) {
                    System.out.println(e1);
                }finally {
                    //cerrar la conexion con la base

                    try {
                        if (pstmt != null) {
                            pstmt.close();
                        }
                        if (conn != null) {
                            conn.close();
                        }
                    }catch (SQLException e2) {
                        System.out.println(e2.getMessage());
                    }

                }

            }
        });
    }
}
