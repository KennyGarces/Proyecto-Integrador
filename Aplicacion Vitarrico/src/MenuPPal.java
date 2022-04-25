import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPPal {
    public JPanel pnlMenu;
    private JLabel lblAgregar;
    private JLabel lblEliminar;
    private JButton btnAdd;
    private JButton btnDelete;
    private JLabel lblVisualizar;
    private JButton btnBuy;
    private JLabel lblComprar;
    private JButton btnView;
    private JLabel lblIcon;
    private JButton btnExit;
    private JLabel lblDevelopers;


    public MenuPPal(){

       btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame1 = new JFrame("Login Vitarrico");
                frame1.setContentPane(new LoginVitarrico().pnlMain);
                frame1.setSize(1000, 500);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setVisible(true);

            }
        });

       btnAdd.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {

               JFrame frame1 = new JFrame("ADD");
               frame1.setContentPane(new Add().addMain);
               frame1.setSize(1000, 500);
               frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame1.setVisible(true);

           }
       });

       btnView.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {

               JFrame frame1 = new JFrame("ADD");
               frame1.setContentPane(new LIST().ListMain);
               frame1.setSize(1000, 500);
               frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame1.setVisible(true);

           }
       });
    }

}

