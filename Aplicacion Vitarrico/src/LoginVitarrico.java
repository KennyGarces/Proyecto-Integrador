import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginVitarrico {

    public JPanel pnlMain;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel lblLogo;
    private JTextField textField1;
    private JLabel lblLogin;
    private JLabel lblPassword;
    private JPasswordField pswPassword;
    private JLabel lblUsername;
    private JLabel lblForget;
    private JButton signUpButton;
    private JButton signInButton;




    public LoginVitarrico(){

       signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                JFrame frame3 = new JFrame(" Menú Principal Vitarrico");
                frame3.setContentPane(new MenuPPal().pnlMenu);
                frame3.setSize(1000,500);
                frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame3.setVisible(true);
                /*LoginVitarrico frame1 = new LoginVitarrico();
                frame1.setVisible(false);
                dispose();*/




            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame2 = new JFrame(" Menú Principal Vitarrico");
                frame2.setContentPane(new Register().pnlRegister);
                frame2.setSize(1000,500);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setVisible(true);

            }
        });


    }
}
