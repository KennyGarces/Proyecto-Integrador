import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class DELETE {
    public JPanel deleteMain;
    private JButton btnExit;
    private JButton OPENButton;
    private JButton DELETEButton;
    private JTable tableProducts;

    public DELETE(){

        String[] cols = {"Name Product","Grams", "Unit Price"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        tableProducts.setModel(model);

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame1 = new JFrame("Login Vitarrico");
                frame1.setContentPane(new MenuPPal().pnlMenu);
                frame1.setSize(1000, 500);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setVisible(true);
            }
        });
        OPENButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Producto, Gramos, Precio;
                String archivo = "C:\\Users\\Usuario\\Documents\\Trabajos III\\PI1\\Aplicacion Vitarrico\\ListProductos.txt";
                Scanner linea = null;
                File abrirTxt = new File(archivo);
                try {
                    linea = new Scanner(abrirTxt);
                    while (linea.hasNextLine()) {
                        Producto = linea.nextLine();
                        Gramos = linea.nextLine();
                        Precio = linea.nextLine();
                        model.addRow(new Object[]{Producto, Gramos, Precio});
                    }
                } catch (Exception ez) {
                    JOptionPane.showMessageDialog(null, "Error");
                }

            }
        });


        DELETEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int FilaSeleccionada = tableProducts.getSelectedRow();
                if(FilaSeleccionada >=0){
                    model.removeRow(FilaSeleccionada);
                }else{
                    JOptionPane.showMessageDialog(null,"Select product");
                }
                try {
                    FileWriter save = new FileWriter("C:\\Users\\Usuario\\Documents\\Trabajos III\\PI1\\Aplicacion Vitarrico\\ListProductos.txt");
                    for (int i = 0; i < tableProducts.getRowCount(); i++) {
                        save.write(model.getValueAt(i, 0).toString() + ("\n"));
                        save.write(model.getValueAt(i, 1).toString() + ("\n"));
                        save.write(model.getValueAt(i, 2).toString() + ("\n"));
                    }
                    save.close();
                    JOptionPane.showMessageDialog(null, "Correctly eliminated");
                } catch (Exception ex) {
                    System.out.println("Error");
                }

            }

        });


    }
}



