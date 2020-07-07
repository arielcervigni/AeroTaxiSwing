package com.AeroTaxi.Swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeAdmin extends  JFrame{
    private JPanel panel3;
    private JPanel barra;
    private JMenuBar menu;
    private JMenu usuario;
    private JMenuItem cerrarSesion;
    private JMenu reservas;
    private JMenuItem crearReserva;
    private JMenuItem cancelarReserva;
    private JMenu aviones;
    private JMenuItem agregarAvion;
    private JMenuItem borrarAvion;
    private JMenuItem modificarAvion;
    private JMenuItem verAviones;
    private JMenuItem verReservasDia;
    private JMenuItem crearUsuario;
    private JMenuItem verTodos;
    private JMenuItem modificarUsuario;
    private JMenuItem eliminarUsuario;

    public HomeAdmin(){
        super("Administrador.");
        setContentPane(panel3);
        setBounds(20,20,500,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });

    }
}
