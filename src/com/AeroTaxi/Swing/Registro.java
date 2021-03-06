package com.AeroTaxi.Swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro extends JFrame {
    private JPanel registro;
    private JPanel panelDatos;
    private JLabel lb_descripcion;
    private JLabel lb_dni;
    private JTextField tf_edad;
    private JLabel lb_nombre;
    private JTextField tf_apellido;
    private JTextField tf_dni;
    private JLabel lb_edad;
    private JLabel lb_apellid;
    private JTextField tf_nombre;
    private JPasswordField tf_pw;
    private JLabel lb_password;
    private JCheckBox confirmar;
    private JTextArea textArea1;
    private JButton btn_volver;
    private JButton btn_aceptar;
    private Login login;

    public JPanel getRegistro() {
        return registro;
    }

    public Registro(){
        super("Registro.");
        setContentPane(registro);
        setVisible(true);
        setBounds(20,20,500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        tf_dni.setToolTipText("Ingrese su número de DNI.");
        tf_pw.setToolTipText("Su contraseña no podrá tener menos de 4 dígitos.");
        tf_nombre.setToolTipText("Ingrese su nombre.");
        tf_apellido.setToolTipText("Ingrese su apellido.");
        tf_edad.setToolTipText("Ingrese su edad.");
        btn_aceptar.setEnabled(false);

        btn_volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });

        confirmar.addActionListener(new ActionListener() {
                @Override

                public void actionPerformed(ActionEvent e) {

                    btn_aceptar.setEnabled(confirmar.isSelected());
                }
            });

        btn_aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                // guardar usuario nuevo
                new Login();
            }
        });
        }

    public Registro(int opcion) {
        super("Registrar nuevo usuario.");
        setContentPane(registro);
        setVisible(true);
        setBounds(20,20,500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        tf_dni.setToolTipText("Ingrese su número de DNI.");
        tf_pw.setToolTipText("Su contraseña no podrá tener menos de 4 dígitos.");
        tf_nombre.setToolTipText("Ingrese su nombre.");
        tf_apellido.setToolTipText("Ingrese su apellido.");
        tf_edad.setToolTipText("Ingrese su edad.");
        btn_aceptar.setEnabled(false);

        btn_volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new HomeAdmin();
            }
        });

        confirmar.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

                btn_aceptar.setEnabled(confirmar.isSelected());
            }
        });

        btn_aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // guardar usuario nuevo
            }
        });
    }

    }
