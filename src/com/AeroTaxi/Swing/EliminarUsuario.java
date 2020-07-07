package com.AeroTaxi.Swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                int seleccion = JOptionPane.showOptionDialog(eliminarUsuarioPanel,"¿Desea eliminar el usuario?",
                        "Eliga una opción", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,null,
                        new Object[] { "Si", "No", "Cancelar"},"Si");
                if (seleccion == JOptionPane.OK_OPTION){
                    texto.setText("Usuario Eliminado.");
                    setVisible(false);
                    new HomeAdmin();
                }
                else
                    texto.setText("El usuario NO se ha eliminado.");

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
