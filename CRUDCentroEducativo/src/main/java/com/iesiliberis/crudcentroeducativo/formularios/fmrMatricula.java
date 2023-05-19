/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.formularios;

import com.iesiliberis.crudcentroeducativo.controladorDAO.AlumnoDaoImp;
import com.iesiliberis.crudcentroeducativo.controladorDAO.MatriculaDaoImp;
import com.iesiliberis.crudcentroeducativo.controladorDAO.UnidadDaoImp;
import com.iesiliberis.crudcentroeducativo.entidades.Alumno;
import com.iesiliberis.crudcentroeducativo.entidades.Matricula;
import com.iesiliberis.crudcentroeducativo.entidades.Unidad;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author alvar
 */
public class fmrMatricula extends javax.swing.JInternalFrame {

    /**
     * Creates new form fmrMatricula
     */
    private List<Integer> idsCursos;
    MatriculaDaoImp matriculaControler = MatriculaDaoImp.getInstance();
    public fmrMatricula(List<Integer> idsCursos) {
        initComponents();
        this.idsCursos = idsCursos;
        configTablaAlumnos();
        configTablaUnidades();
        mostrarValoresEnTablaUnidades();
        setCamposUnidades();
        mostrarValoresEnTablaAlumnos();
        setCamposAlumnos();
        configTablaVerMatriculados();
        mostrarValoresEnTablaVerMatriculados();
    }
    
    private void configTablaVerMatriculados() {
        String col[] = {"nombre", "dni", "codigo"};
        DefaultTableModel modelo = new DefaultTableModel(col, 0);
        jtVerMatriculados.setModel(modelo);
        jtVerMatriculados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void configTablaAlumnos() {
        String col[] = {"dni", "nombre"};
        DefaultTableModel modelo = new DefaultTableModel(col, 0);
        jtAlumnos.setModel(modelo);
        jtAlumnos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void configTablaUnidades() {
        String col[] = {"codigo"};
        DefaultTableModel modelo = new DefaultTableModel(col, 0);
        jtUnidades.setModel(modelo);
        jtUnidades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void mostrarValoresEnTablaUnidades() {
        DefaultTableModel modelo = (DefaultTableModel) jtUnidades.getModel();
        UnidadDaoImp unidadControler = UnidadDaoImp.getInstance();
        String[] fila = new String[1];
        modelo.setNumRows(0);
        try {
            for (Integer idCurso : idsCursos) {
                List<Unidad> lst = unidadControler.getByCursoAca(idCurso);
                for (Unidad uni : lst) {

                    fila[0] = "" + uni.getCodigo();

                    modelo.addRow(fila);
                }
            }
            // Seleccionar la primera fila de la tabla
            if (modelo.getRowCount() > 0) {
                jtUnidades.setRowSelectionInterval(0, 0);
                setCamposUnidades();
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }

    }

    private void mostrarValoresEnTablaAlumnos() {
        DefaultTableModel modelo = (DefaultTableModel) jtAlumnos.getModel();

        AlumnoDaoImp alumControler = AlumnoDaoImp.getInstance();
        String[] fila = new String[2];

        modelo.setNumRows(0);
        try {
            List<Alumno> lst = alumControler.getAll();

            for (Alumno alum : lst) {

                fila[0] = "" + alum.getDni();
                fila[1] = "" + alum.getNombre();

                modelo.addRow(fila);
            }
            //selecciono la primera fila
            if (modelo.getRowCount() > 0) {
                jtAlumnos.setRowSelectionInterval(0, 0);
                setCamposAlumnos();
            }

        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
    
    
    private void mostrarValoresEnTablaVerMatriculados() {
        DefaultTableModel modelo = (DefaultTableModel) jtVerMatriculados.getModel();

        AlumnoDaoImp alumControler = AlumnoDaoImp.getInstance();
        UnidadDaoImp unidadControler = UnidadDaoImp.getInstance();
        String[] fila = new String[3];

        modelo.setNumRows(0);
        try {           
            List<Matricula> lst = matriculaControler.getAll();

            for (Matricula mat : lst) {
                Alumno alum = alumControler.getById(mat.getIdalumno());
                Unidad uni = unidadControler.getById(mat.getIdunidad());

                fila[0] = alum.getNombre();
                fila[1] = alum.getDni();
                fila[2] = uni.getCodigo();

                modelo.addRow(fila);
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void setCamposUnidades() {

        int filaSeleccionada = jtUnidades.getSelectedRow();
        if (filaSeleccionada >= 0) {

            txtCodigo.setText(jtUnidades.getValueAt(filaSeleccionada, 0).toString());

        }
    }

    private void setCamposAlumnos() {

        txtDni.setText(jtAlumnos.getValueAt(jtAlumnos.getSelectedRow(), 0).toString());
        txtNombre.setText(jtAlumnos.getValueAt(jtAlumnos.getSelectedRow(), 1).toString());
    }
    
    private Matricula getCamposAdd(){
        Matricula matri = new Matricula();
        
        matri.setCodUnidad(txtCodigo.getText());
        matri.setDniAlumno(txtDni.getText());
        matri.setDescripcion(txtDescripcion.getText());
        
        return matri;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jtVerMatriculados = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtUnidades = new javax.swing.JTable();
        txtCodigo = new javax.swing.JTextField();
        btnMatricular = new javax.swing.JButton();
        txtDescripcion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAlumnos = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jtVerMatriculados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jtVerMatriculados);

        jtUnidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtUnidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtUnidadesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtUnidades);

        btnMatricular.setText("Matricular a");
        btnMatricular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatricularActionPerformed(evt);
            }
        });

        jLabel2.setText("Escribe una descripcion de la matricula");

        jLabel1.setText("con DNI :");

        jtAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtAlumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtAlumnos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(40, 40, 40)
                                .addComponent(btnMatricular)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtDni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnMatricular)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(243, 243, 243))))
        );

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarnone(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 821, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 18, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(316, 316, 316)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtAlumnosMouseClicked
        setCamposAlumnos();
    }//GEN-LAST:event_jtAlumnosMouseClicked

    private void jtUnidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtUnidadesMouseClicked
        setCamposUnidades();
    }//GEN-LAST:event_jtUnidadesMouseClicked

    private void btnMatricularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatricularActionPerformed
        MatriculaDaoImp matri = MatriculaDaoImp.getInstance();
        
        try {
            matri.add(getCamposAdd());
            JOptionPane.showMessageDialog(this, "Matricula agregada correctamente");
            mostrarValoresEnTablaVerMatriculados();
            
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }//GEN-LAST:event_btnMatricularActionPerformed

    private void txtBuscarnone(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarnone

    }//GEN-LAST:event_txtBuscarnone

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            DefaultTableModel modelo = (DefaultTableModel) jtVerMatriculados.getModel();
            TableRowSorter<TableModel> trSorter = new TableRowSorter<>(modelo);
            jtVerMatriculados.setRowSorter(trSorter);

            if (txtBuscar.getText().length() == 0) {
                trSorter.setRowFilter(null);
            } else {
                trSorter.setRowFilter(RowFilter.regexFilter(txtBuscar.getText().trim()));
            }
        }
    }//GEN-LAST:event_txtBuscarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMatricular;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jtAlumnos;
    private javax.swing.JTable jtUnidades;
    private javax.swing.JTable jtVerMatriculados;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
