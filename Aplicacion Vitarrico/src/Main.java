import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame1 = new JFrame("Login Vitarrico");
        frame1.setSize(1000, 500);
        frame1.setContentPane(new LoginVitarrico().pnlMain);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);


    }


}
