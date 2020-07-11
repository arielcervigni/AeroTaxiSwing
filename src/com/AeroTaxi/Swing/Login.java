package com.AeroTaxi.Swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {
    private JPanel panel;
    private JLabel lb_titulo;
    private JLabel lb_descripcion;
    private JLabel lb_dni;
    private JTextField tf_dni;
    private JLabel lb_contraseña;
    private JPasswordField tf_pw;
    private JButton btn_aceptar;
    private JButton btn_registrarse;
    private JLabel lb_usuario;
    private JLabel jl_titulo;

    public JPanel getPanel() {
        return panel;
    }

    public Login() {
        super("AeroTaxi.");
        setContentPane(panel);
        setVisible(true);
        setBounds(20,20,500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        tf_dni.setFocusable(true);

        btn_aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ingresar(tf_dni.getText(), tf_pw.getText()))
                {
                    lb_usuario.setText("Ingreso Correcto.");
                    setVisible(false);
                    new HomeAdmin();

                }
                else{
                    lb_usuario.setText("Ingreso Incorrecto.\n" + tf_dni.getText() + tf_pw.getText());
                }
            }
        });

        btn_registrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Registro();
            }
        });
        tf_dni.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyTyped(e);
                char tecla = e.getKeyChar();
                if (tecla==KeyEvent.VK_ENTER)
                btn_aceptar.doClick();
            }
        });
        tf_pw.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char tecla = e.getKeyChar();
                if (tecla==KeyEvent.VK_ENTER)
                btn_aceptar.doClick();
            }
        });
    }


    public boolean ingresar (String dni, String pw){
        boolean rta;
        System.out.println(dni+pw);
        rta = (dni.equals("0") && pw.equals("holamundo"));
        return rta;
    }

}
