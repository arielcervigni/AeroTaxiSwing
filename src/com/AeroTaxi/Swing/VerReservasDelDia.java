package com.AeroTaxi.Swing;

import rojeru_san.componentes.RSDateChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VerReservasDelDia extends JFrame {
    private JPanel panelReservasDelDia;
    private JTextArea texto;
    private RSDateChooser seleccionador;
    private JLabel lb_fecha;
    private JButton btnVolver;
    private JButton btnHoy;
    private JButton btnBuscar;

    public VerReservasDelDia () {
        super("Reservas del día");
        setContentPane(panelReservasDelDia);
        setBounds(20, 20, 500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        btnHoy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionador.setDatoFecha(new Date());
                btnBuscar.doClick();
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (seleccionador.getDatoFecha()!= null)
                {
                    String formatoFecha = "dd-MM-yyyy";
                    Date fecha = seleccionador.getDatoFecha();
                    SimpleDateFormat formateador = new SimpleDateFormat(formatoFecha);
                    texto.setText("Estoy mostrando las reservas para el día: " + formateador.format(fecha));
                }
                else
                    texto.setText("No hay fecha cargada");
            }
        });
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new HomeAdmin();
            }
        });
    }

    public static void main(String[] args) {

        new VerReservasDelDia();


    }

}
