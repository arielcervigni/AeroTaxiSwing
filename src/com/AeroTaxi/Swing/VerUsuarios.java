package com.AeroTaxi.Swing;

import com.AeroTaxi.JsonUsuario;
import com.AeroTaxi.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class VerUsuarios extends JFrame {
    private JPanel verUsuario;
    private JTable tablaDeUsuarios;
    private JScrollPane scrollPanelUsuarios;
    private JTextField tf_dni;
    private JButton btn_buscar;
    private JButton btn_borrar;
    private JButton btn_cancelar;
    private JButton btn_modificar;
    private JLabel lb_dni;

    private ArrayList<Usuario> usuarios;

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public VerUsuarios() {

        btn_modificar.setEnabled(false);
        btn_borrar.setEnabled(false);
        
        File archivoUsuarios = new File("usuarios.json");
        JsonUsuario jsonUsuario = new JsonUsuario();
        usuarios = jsonUsuario.traerUsuarios(archivoUsuarios);

        setContentPane(verUsuario);
        setBounds(20, 20, 500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


        // Armo la tabla
        DefaultTableModel dtm = new DefaultTableModel() {
            // Para que al ser doble click no pueda editar.
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 5)
                    return true;
                else
                    return false;
            }
        };


        scrollPanelUsuarios.setViewportView(tablaDeUsuarios);
        dtm.addColumn("Nombre");
        dtm.addColumn("Apellido");
        dtm.addColumn("Edad");
        dtm.addColumn("DNI");
        dtm.addColumn("Password");
        tablaDeUsuarios.setModel(dtm);

        for (Usuario u : usuarios) {
            dtm.addRow(new Object[]{u.getNombre(), u.getApellido(), u.getEdad(), u.getDNI(), u.getPassword()});
        }


        // Elige una sola fila.
        tablaDeUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // Permite ordenar por columna.
        tablaDeUsuarios.setAutoCreateRowSorter(true);
        TableRowSorter<TableModel> columnaElegida = new TableRowSorter<>(tablaDeUsuarios.getModel());
        tablaDeUsuarios.setRowSorter(columnaElegida);



        tablaDeUsuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btn_modificar.setEnabled(true);
                btn_borrar.setEnabled(true);
                Usuario u;
                u = usuarios.get(tablaDeUsuarios.getSelectedRow());

                if (e.getClickCount() == 2) {
                    u = usuarios.get(tablaDeUsuarios.getSelectedRow());
                    new PopUpUsuario(u);
                }


            }
        });

        btn_modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario u = usuarios.get(tablaDeUsuarios.getSelectedRow());
                new PopUpUsuario(u);
            }
        });


        btn_cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new HomeAdmin();
            }
        });
    }

    private Usuario tablaMouseClicked(MouseEvent evt)
    {
        int seleccion = tablaDeUsuarios.getSelectedRow();
        Usuario u = usuarios.get(seleccion);
        return u;
    }

    public static void main(String[] args) {

        new VerUsuarios();


    }
}