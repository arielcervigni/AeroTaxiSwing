package com.AeroTaxi.Swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeUser extends JFrame {

    private JPanel panel2;
    private JPanel barra;
    private JMenuBar menu;
    private JMenu usuario;
    private JMenu reservas;
    private JMenuItem misReservas;
    private JMenuItem crearReserva;
    private JMenuItem cerrarSesion;
    private JMenuItem cancelarReserva;


    public HomeUser() {
        super("Principal");
        setContentPane(barra);
        setBounds(20, 20, 400, 400);
        setVisible(true);

        cerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });


    }

}


