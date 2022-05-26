import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Scanner;

public class LIST {
    public JPanel ListMain;
    private JButton btnreturn;
    private JLabel lblNombreArchivo;
    private JButton btnOpen;
    private JTable tableProducts;
    private JTextField textProduct;
    private JButton SEARCHButton;


    private TableRowSorter trsFilter;
    String Filter;

    private File file;

    public void filter(){
        Filter = textProduct.getText();
        trsFilter.setRowFilter(RowFilter.regexFilter(textProduct.getText(),0));
    }

    public LIST(){


        btnreturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame1 = new JFrame("Login Vitarrico");
                frame1.setContentPane(new MenuPPal().pnlMenu);
                frame1.setSize(1000, 500);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setVisible(true);
            }
        });

        String[] cols = {"Name Product","Grams", "Unit Price"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        tableProducts.setModel(model);

        btnOpen.addActionListener(new ActionListener() {
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


        SEARCHButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textProduct.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        String cadena = textProduct.getText();
                        textProduct.setText(cadena);
                        filter();
                    }
                });
            }
        });
        textProduct.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                trsFilter = new TableRowSorter(tableProducts.getModel());
                tableProducts.setRowSorter(trsFilter);
            }
        });


    }
}

