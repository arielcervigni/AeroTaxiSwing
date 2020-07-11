package com.AeroTaxi.Swing;

import com.AeroTaxi.JsonUsuario;
import com.AeroTaxi.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

public class VerUsuarios extends JFrame {
    private JPanel verUsuario;
    private JButton btn_Borrar;
    private JButton btn_Modificar;
    private JTable tablaDeUsuarios;
    private JScrollPane scrollPanelUsuarios;

    private ArrayList<Usuario> usuarios;

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public VerUsuarios ()
    {

        File archivoUsuarios = new File("usuarios.json");
        JsonUsuario jsonUsuario = new JsonUsuario();
        usuarios = jsonUsuario.traerUsuarios(archivoUsuarios);

        setContentPane(verUsuario);
        setBounds(20,20,500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        DefaultTableModel dtm = new DefaultTableModel();
        scrollPanelUsuarios.setViewportView(tablaDeUsuarios);
        dtm.addColumn("Nombre");
        dtm.addColumn("Apellido");
        dtm.addColumn("Edad");
        dtm.addColumn("DNI");
        dtm.addColumn("Password");
        tablaDeUsuarios.setModel(dtm);

        for (Usuario u: usuarios)
        {
            dtm.addRow(new Object[] {u.getNombre(),u.getApellido(),u.getEdad(),u.getDNI(),u.getPassword()});
        }



        btn_Borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        tablaDeUsuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int seleccion = tablaDeUsuarios.getSelectedRow();
                Usuario u = usuarios.get(seleccion);

                btn_Modificar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new PopUpUsuario(u);
                    }
                });

                btn_Borrar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int opcion = JOptionPane.showOptionDialog(scrollPanelUsuarios,"¿Desea eliminar el usuario?",
                                "Eliga una opción", JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.QUESTION_MESSAGE,null,
                                new Object[] { "Si", "No", "Cancelar"},"Si");

                        if (opcion == JOptionPane.OK_OPTION) {
                            getUsuarios().remove(seleccion);
                            //borrar archivo;
                            setVisible(false);
                            new VerUsuarios();
                        }
                    }
                });
            }
        });
    }

    public static void main (String []args){

        new VerUsuarios();


    }
}
