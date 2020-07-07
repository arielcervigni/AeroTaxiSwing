package com.AeroTaxi.Swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {
    protected JPanel panel;
    protected JLabel lb_titulo;
    protected JLabel lb_descripcion;
    protected JLabel lb_dni;
    protected JTextField tf_dni;
    protected JLabel lb_contraseña;
    protected JPasswordField tf_pw;
    protected JButton btn_aceptar;
    protected JButton btn_registrarse;
    protected JLabel lb_usuario;
    protected JLabel jl_titulo;


    public Login() {
        super("AeroTaxi.");
        setContentPane(panel);
        setBounds(20,20,500,500);
        setVisible(true);
        //pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setFocusable(true);

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
