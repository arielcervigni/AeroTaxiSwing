package com.AeroTaxi.Swing;

import rojeru_san.componentes.RSDateChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CrearReserva extends JFrame {
    private JPanel panelCrearReserva;
    private JLabel lb_fecha;
    private RSDateChooser seleccionador;
    private JComboBox cmOrigen;
    private JLabel lb_origen;
    private JComboBox cBDestino;
    private JLabel lbDestino;
    private JLabel lbPasajeros;
    private JComboBox cbAvion;
    private JComboBox cbPasajeros;
    private JTextField tfTarifa;
    private JButton btnCancelar;
    private JButton btnConfirmar;
    private JTextArea texto;
    private JButton btn_tarifa;

    public CrearReserva () {

        super("Crear Reserva");
        setContentPane(panelCrearReserva);
        setBounds(20, 20, 500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        btnConfirmar.setEnabled(false);


        btn_tarifa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (veririfcarFecha() && verificarDestinoYOrigen() && verificarCantidadPasajeros())
                {
                    texto.setText("");
                    tfTarifa.setText(" MUCHA PLATA ");
                    btnConfirmar.setEnabled(true);
                }
                else
                    tfTarifa.setText("Error");

            }
        });
        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int opcion = JOptionPane.showOptionDialog(panelCrearReserva, "¿Desea confirmar la reserva?", "Confirmación de reserva",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                        new Object[]{"Si", "No"}, "Si");

                if (opcion == JOptionPane.OK_OPTION) {
                    JOptionPane.showMessageDialog(panelCrearReserva,"Reserva generada", "Reserva generada con éxito",JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                    new HomeAdmin();
                }
            }

        });
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new HomeAdmin();
            }
        });
    }

    public boolean verificarDestinoYOrigen () {
        boolean rta = true;
        if (cmOrigen.getSelectedItem().equals(cmOrigen.getItemAt(0))){
            rta = false;
            texto.setText("\nError: No completó el Origen");
        }
        else if (cBDestino.getSelectedItem().equals(cBDestino.getItemAt(0)))
        {
            rta = false;
            texto.setText("\nError: No completó el Destino");
        }

        else if (cmOrigen.getSelectedItem().equals(cBDestino.getSelectedItem()))
        {
            rta = false;
            texto.setText("\nError: El origen no puede ser el mismo que el destino.");
        }
        return rta;
    }
    public boolean veririfcarFecha () {
        boolean rta = true;
        if (seleccionador.getDatoFecha()!=null)
        {
            String formatoFecha = "dd-MM-yyyy";
            Date fecha = seleccionador.getDatoFecha();
            SimpleDateFormat formateador = new SimpleDateFormat(formatoFecha);
            Date hoy = new Date();

            if (fecha.before(hoy)) {
                rta = false;
                texto.append("\nError: la fecha no puede ser antes de hoy.");
                JOptionPane.showMessageDialog(panelCrearReserva, "La fecha no puede ser anterior a hoy.", "Error en la fecha", 0);
            }

        }
        return rta;
    }
    public boolean verificarCantidadPasajeros () {
        boolean rta = true;
        if(cbPasajeros.getSelectedItem().equals(cbPasajeros.getItemAt(0)))
        {
            texto.setText("\nError: No se puede viajar sin pasajeros.");
            tfTarifa.setText("Error");
            rta = false;
        }
        return rta;
    }

    public static void main(String[] args) {

        new CrearReserva();


    }

}
