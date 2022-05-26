import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.File;

import java.util.Scanner;


public class Add {
    public JPanel addMain;
    private JButton btnexit;
    private JTextField textProduct;
    private JTextField textPrice;
    private JButton ADDButton;
    private JTable tableProduct;
    private JButton SAVEButton;
    private JTextField textGrams;
    private JButton OPENLISTButton;


    public void limpiar() {
        textProduct.setText("");
        textGrams.setText("");
        textPrice.setText("");
    }

    public Add() {

        String[] cols = {"Name Product","Grams", "Unit Price"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        tableProduct.setModel(model);

        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Object[] data = {textProduct.getText(),textGrams.getText(), textPrice.getText()};
                    model.addRow(data);
                } catch (Exception ex) {
                    System.out.println("Error");
                }
                limpiar();
            }
        });

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

        SAVEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileWriter save = new FileWriter("C:\\Users\\Usuario\\Documents\\Trabajos III\\PI1\\Aplicacion Vitarrico\\ListProductos.txt");
                    for (int i = 0; i < tableProduct.getRowCount(); i++) {
                        save.write(model.getValueAt(i, 0).toString() + ("\n"));
                        save.write(model.getValueAt(i, 1).toString() + ("\n"));
                        save.write(model.getValueAt(i, 2).toString() + ("\n"));
                    }
                    save.close();
                    JOptionPane.showMessageDialog(null, "Data saved correctly ");
                } catch (Exception ex) {
                    System.out.println("Error");
                }
            }
        });
        OPENLISTButton.addActionListener(new ActionListener() {
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





    }
}
/*package edu.poo2;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class RegistroProducto {
    public JPanel pnlRegistroP;
    private JTextField textProducto;
    private JTextField textGramos;
    private JTextField textPrecio;
    private JTable tblProductos;
    private JButton btnAgregar;
    private JButton btnAbrir;
    private JButton btnMod;
    private JButton buscarButton;
    private JLabel lblPro;
    private JLabel lblGr;
    private JLabel lblPre;
    private JButton guardarButton;
    private JButton eliminarButton;

    private TableRowSorter trsFiltro;
    String Filtro;

    public void limpiar() {
        textProducto.setText("");
        textGramos.setText("");
        textPrecio.setText("");
    }
    public void filtro(){
        Filtro = textProducto.getText();
        trsFiltro.setRowFilter(RowFilter.regexFilter(textProducto.getText(),0));
    }

    public RegistroProducto() {


        String[] cols = {"Producto", "Gramos", "Precio"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        tblProductos.setModel(model);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Object[] data = {textProducto.getText(), textGramos.getText(), textPrecio.getText()};
                    model.addRow(data);
                } catch (Exception ex) {
                    System.out.println("Error");
                }
                limpiar();
            }
        });

        btnAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Producto, Gramos, Precio;
                String archivo = "C:\\Users\\angel\\ProyectoIN\\ProyectoIN\\src\\Productos.txt";
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
        btnMod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int FilaSelecccionada = tblProductos.getSelectedRow();
                if(FilaSelecccionada >= 0){
                    textProducto.setText(tblProductos.getValueAt(FilaSelecccionada,0).toString());
                    textGramos.setText(tblProductos.getValueAt(FilaSelecccionada,1).toString());
                    textPrecio.setText(tblProductos.getValueAt(FilaSelecccionada,2).toString());
                    model.removeRow(FilaSelecccionada);
                }else{
                    JOptionPane.showMessageDialog(null,"Seleccione la fila.");
                }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int FilaSeleccionada = tblProductos.getSelectedRow();
                if(FilaSeleccionada >=0){
                    model.removeRow(FilaSeleccionada);
                }else{
                    JOptionPane.showMessageDialog(null,"Selecciones una fila.");
                }
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textProducto.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        String cadena = textProducto.getText();
                        textProducto.setText(cadena);
                        filtro();
                    }
                });
            }
        });

        textProducto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                trsFiltro = new TableRowSorter(tblProductos.getModel());
                tblProductos.setRowSorter(trsFiltro);
            }
        });
    }
}
*/
