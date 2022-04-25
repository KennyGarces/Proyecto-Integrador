import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;


public class LIST {
    public JPanel ListMain;
    private JButton btnreturn;
    private JTextArea textAList;
    private JLabel lblNombreArchivo;
    private JButton btnOpen;

    private File file;

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

        btnOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de texto", "txt");
                chooser.setFileFilter(filter);
                int result = chooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    try {
                        file = chooser.getSelectedFile();
                        lblNombreArchivo.setText(file.getAbsolutePath());
                        Scanner scan = new Scanner(file);
                        while (scan.hasNext()) {
                            textAList.insert(scan.nextLine() + "\n", textAList.getText().length());
                        }
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(new JFrame(), "Error: " + ex.getMessage());
                    }
                }
            }
        });

    }
}
