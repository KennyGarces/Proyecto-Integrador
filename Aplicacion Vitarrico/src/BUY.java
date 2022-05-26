import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class BUY {
    private JButton btnExit;
    public JPanel MainBuy;
    private JTextField txtSubTotal;
    private JTextField txtName;
    private JTextField txtUnits;
    private JTextField txtPrice;
    private JButton btnBUY;
    private JButton butR;
    private JTable table1;
    private JTextField txtImpuesto;
    private JTextField txtTotal;

    private File file;
    public Object total() {
        double valorU = Double.parseDouble(txtPrice.getText());
        double cantidad = Double.parseDouble(txtUnits.getText());
        double total = (valorU * cantidad);
        return total;

    }
    private void compraTotal(){
        float suma = 0;
        for(int i= 0;i < table1.getRowCount();i++){
            float renglon;
            renglon = Float.parseFloat(table1.getValueAt(i,3).toString());
            suma += renglon;
        }
        txtSubTotal.setText(String.valueOf(suma));
        txtImpuesto.setText(String.valueOf(suma*0.19));
        txtTotal.setText(String.valueOf(suma*1.19));
    }
    public void limpiar(){
        txtName.setText("");
        txtPrice.setText("");
        txtUnits.setText("");}
    private List<BUY> Buy = new ArrayList<BUY>();

    private void guardarTxt(){
        try{
            FileWriter fw = new FileWriter("C:\\Users\\Usuario\\Documents\\Trabajos III\\PI1\\Aplicacion Vitarrico\\Factura.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print("Product: "+txtName.getText()+"-");
            pw.print("Price: " + txtPrice.getText()+"-");
            pw.print("Units: " + txtUnits.getText()+"\n");
            pw.print("=======================================\n");
            pw.print("Purchase value: " + txtSubTotal.getText()+"\n");
            pw.print("Tax: "+txtImpuesto.getText()+"\n");
            pw.print("TOTAL TO PAY: " + txtTotal.getText()+"\n");
            pw.print("========================================\n");
            pw.print("\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public BUY(){
        String[] cols = {"Product", "Price", "Units", "Total"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        table1.setModel(model);

       butR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Object[] data = {txtName.getText(), txtPrice.getText(), txtUnits.getText(), total()};
                    model.addRow(data);}catch (Exception ex){
                    System.out.println("Error");
                }
                    compraTotal();
                    guardarTxt();
                    limpiar();
                }
        });
            btnBUY.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url ="C:\\Users\\Usuario\\Documents\\Trabajos III\\PI1\\Aplicacion Vitarrico\\Factura.txt";
                ProcessBuilder p = new ProcessBuilder();
                p.command("cmd.exe","/C",url);
                try {

                    p.start();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });



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
    }
}
