import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add {
    public JPanel addMain;
    private JButton btnexit;
    private JTextField textProduct;
    private JTextField textPrice;
    private JButton ADDButton;
    private JTable tableProduct;

    public Add() {

        String[] cols = {"Name Product", "Unit Price"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        tableProduct.setModel(model);


        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] Datos = {textProduct.getText(), textPrice.getText()};
                model.addRow(Datos);
                textProduct.setText("");
                textProduct.setText("");

            }});

        btnexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame1 = new JFrame("Login Vitarrico");
                frame1.setContentPane(new MenuPPal().pnlMenu);
                frame1.setSize(1000, 500);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setVisible(true);
            }
        });




    }
}