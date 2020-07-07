package com.AeroTaxi.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class EliminarUsuario extends JFrame{
    private JPanel eliminarUsuarioPanel;
    private JTextField tf_dni;
    private JLabel lb_titulo;
    private JButton btn_aceptar;
    private JButton btn_volver;
    private JTextArea texto;
    private JOptionPane confirmarEliminacion;

    public EliminarUsuario(){
        super("Eliminar usuario.");
        setContentPane(eliminarUsuarioPanel);
        setVisible(true);
        setBounds(20,20,500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        btn_aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(eliminarUsuarioPanel,"¿Desea eliminar el usuario?");
            }
        });
        btn_volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new HomeAdmin();
            }
        });
    }
}
