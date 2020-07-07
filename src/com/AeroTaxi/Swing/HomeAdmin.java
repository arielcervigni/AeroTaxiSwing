package com.AeroTaxi.Swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeAdmin extends  JFrame{
    private JPanel homeAdminPanel;
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
    private Registro registro;

    public JPanel getHomeAdminPanel() {
        return homeAdminPanel;
    }

    public HomeAdmin(){
        super("Administrador.");

        setContentPane(homeAdminPanel);
        setBounds(20,20,500,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        int opcion = 0;

        cerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });
        crearUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Registro(opcion);
            }
        });
        eliminarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new EliminarUsuario();
            }
        });

    }
}
