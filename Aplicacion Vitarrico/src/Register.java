import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register {
    public JPanel pnlRegister;
    private JLabel lblName;
    private JTextField textName;
    private JLabel lblLasName;
    private JTextField txtLastName;
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JLabel lblUsername;
    private JTextField textField1;
    private JLabel lblTelephone;
    private JTextField txtTelephone;
    private JLabel lblPassWord;
    private JTextField txtPassWord;
    private JLabel lblUserType;
    private JTextField txtUsertype;
    private JButton btnREGISTER;
    private JButton btnReturn;


    public Register() {


        btnReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame1 = new JFrame("Login Vitarrico");
                frame1.setContentPane(new LoginVitarrico().pnlMain);
                frame1.setSize(1000, 500);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setVisible(true);
            }
        });

    }
}
