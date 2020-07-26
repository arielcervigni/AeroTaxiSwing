package com.AeroTaxi.Swing;

import rojeru_san.componentes.RSDateChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

public class CancelarReserva extends JFrame{
    private JPanel panelCancelarReserva;
    private JTextArea texto;
    private JTextField tf_reserva;
    private JButton btn_buscar;
    private JButton btn_cancelarReserva;
    private JButton btn_volver;
    private RSDateChooser seleccionador;
    private JLabel lb_reserva;
    private JLabel lb_fecha;

    public CancelarReserva(){
        super("Cancelar Reserva");
        setContentPane(panelCancelarReserva);
        setBounds(20, 20, 500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        btn_cancelarReserva.setEnabled(false);

        btn_buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // validar que haya reserva

                if (verificarFecha()) {
                    if(!tf_reserva.getText().isEmpty()){
                        texto.setText("Estoy mostrando la reserva que coincide.");
                        btn_cancelarReserva.setEnabled(true);
                    }
                    else
                        texto.setText("No hay reserva cargada.");
                }
                else
                {
                    texto.setText("No se puede cancelar la reserva");
                    JOptionPane.showMessageDialog(panelCancelarReserva,"No se puede cancelar la reserva. Tiempo líimite excedido.",
                            "No se puede cancelar", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        btn_cancelarReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tf_reserva.getText().isEmpty())
                {
                    int opcion = JOptionPane.showConfirmDialog(panelCancelarReserva,"¿Desea confirmar la cancelación de la reserva?",
                            "Confirmar cancelación",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if (opcion == JOptionPane.OK_OPTION){
                        JOptionPane.showMessageDialog(panelCancelarReserva,"Reserva eliminada con éxito.", "Reserva Eliminada",
                                JOptionPane.INFORMATION_MESSAGE);

                        setVisible(false);
                        new HomeAdmin();
                    }
                }


            }
        });
        btn_volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new HomeAdmin();
            }
        });
    }

    public boolean verificarFecha (){
        boolean rta = true;
        if (seleccionador.getDatoFecha()!= null)
        {
            Calendar calenda = Calendar.getInstance();
            calenda.setTime(seleccionador.getDatoFecha());
            calenda.add(Calendar.DATE,-1);
            Date fechaLimite = calenda.getTime();
            if(fechaLimite.before(new Date()))
                rta = false;
        }
        return rta;
    }



    public static void main(String[] args) {

        new CancelarReserva();


    }
}
