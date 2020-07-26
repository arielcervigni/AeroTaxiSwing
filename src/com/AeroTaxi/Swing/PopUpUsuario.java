package com.AeroTaxi.Swing;

import com.AeroTaxi.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class PopUpUsuario extends JFrame {

    private JPanel panel1;
    private JButton btn_guardar;
    private JButton btn_borrar;
    private JLabel lb_dni;
    private JLabel lb_nombre;
    private JLabel lb_apellido;
    private JLabel lb_edad;
    private JLabel lb_pw;
    private JTextField tf_dni;
    private JTextField tf_nombre;
    private JTextField tf_apellido;
    private JTextField tf_edad;
    private JTextField tf_pw;
    private JPanel panel2;
    private JButton btn_cancelar;
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public PopUpUsuario (Usuario u)
    {
        setContentPane(panel1);
        setVisible(true);
        setBounds(30,30,450,450);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        tf_apellido.setText(u.getApellido());
        tf_nombre.setText(u.getNombre());
        tf_dni.setText(u.getDNI().toString());
        tf_edad.setText(u.getEdad().toString());
        tf_pw.setText(u.getPassword());


        btn_borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcion = JOptionPane.showOptionDialog(panel1,"¿Desea eliminar el usuario?",
                        "Eliga una opción", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,null,
                        new Object[] { "Si", "No", "Cancelar"},"Si");

                if (opcion == JOptionPane.OK_OPTION) {
                    //usuarios.remove(u);
                    //borrar archivo;
                    setVisible(false);
                }
            }
        });
        btn_guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcion = JOptionPane.showOptionDialog(panel1,"¿Desea modificar el usuario?",
                        "Eliga una opción", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,null,
                        new Object[] { "Si", "No"},"Si");

                if (opcion == JOptionPane.OK_OPTION) {
                    //usuarios.remove(u);
                    //modificar archivo;
                    setVisible(false);
                }
            }
        });
        btn_cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        tf_dni.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyTyped(e);
                char tecla = e.getKeyChar();
                if (tecla==KeyEvent.VK_ENTER)
                    btn_guardar.doClick();
            }
        });
        tf_pw.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char tecla = e.getKeyChar();
                if (tecla==KeyEvent.VK_ENTER)
                    btn_guardar.doClick();
            }
        });
        tf_apellido.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyTyped(e);
                char tecla = e.getKeyChar();
                if (tecla==KeyEvent.VK_ENTER)
                    btn_guardar.doClick();
            }
        });
        tf_nombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char tecla = e.getKeyChar();
                if (tecla==KeyEvent.VK_ENTER)
                    btn_guardar.doClick();
            }
        });
        tf_dni.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyTyped(e);
                char tecla = e.getKeyChar();
                if (tecla==KeyEvent.VK_ENTER)
                    btn_guardar.doClick();
            }
        });
        tf_edad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char tecla = e.getKeyChar();
                if (tecla==KeyEvent.VK_ENTER)
                    btn_guardar.doClick();
            }
        });
    }
}
