package com.AeroTaxi.Swing;

import com.AeroTaxi.Usuario;

import javax.swing.*;

public class PopUpUsuario extends JFrame {

    private JButton modificarButton;
    private JPanel panel1;
    private JTextField tf_Nombre;
    private JTextField tf_Apellido;
    private JTextField tf_DNI;
    private JLabel dni;
    private JLabel apellido;
    private JLabel nombre;
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
        setBounds(20,20,350,350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        tf_Apellido.setText(u.getApellido());
        tf_Nombre.setText(u.getNombre());
        tf_DNI.setText(u.getDNI().toString());

    }
}
