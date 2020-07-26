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


        final Usuario[] u = new Usuario[1];

        // Elige una sola fila.
        tablaDeUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // Permite ordenar por columna.
        tablaDeUsuarios.setAutoCreateRowSorter(true);
        TableRowSorter<TableModel> columnaElegida = new TableRowSorter<>(tablaDeUsuarios.getModel());
        tablaDeUsuarios.setRowSorter(columnaElegida);



        tablaDeUsuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 2) {
                    Usuario u = usuarios.get(tablaDeUsuarios.getSelectedRow());
                    new PopUpUsuario(u);
                }

                else if (e.getClickCount() == 1) {
                    System.out.println("Ahora un click");
                    btn_modificar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("Aca");
                            u[0] = usuarios.get(tablaDeUsuarios.getSelectedRow());
                            new PopUpUsuario(u[0]);
                        }
                    });
                    btn_borrar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int opcion = JOptionPane.showOptionDialog(scrollPanelUsuarios, "¿Desea eliminar el usuario?",
                                    "Eliga una opción", JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.QUESTION_MESSAGE, null,
                                    new Object[]{"Si", "No", "Cancelar"}, "Si");

                            if (opcion == JOptionPane.OK_OPTION) {
                                //getUsuarios().remove(u);
                                //borrar archivo;
                                //setVisible(false);
                            }
                        }
                    });
                }

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