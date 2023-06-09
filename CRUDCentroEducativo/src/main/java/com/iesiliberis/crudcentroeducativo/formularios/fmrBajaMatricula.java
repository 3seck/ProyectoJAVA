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
import java.text.SimpleDateFormat;

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
public class fmrBajaMatricula extends javax.swing.JInternalFrame {

    /**
     * Creates new form fmrBajaMatricula
     */
    int cursoAca;
    private List<Integer> idsCursos;
    MatriculaDaoImp matriculaControler = MatriculaDaoImp.getInstance();

    public fmrBajaMatricula(List<Integer> idsCursos, int cursoAca) {
        initComponents();
        this.idsCursos = idsCursos;
        this.cursoAca = cursoAca;
        configTablaVerMatriculados();
        mostrarValoresEnTablaVerMatriculados();
        setCampos();

    }

    private void configTablaVerMatriculados() {
        String col[] = {"id", "nombre", "dni", "codigo","descripcion", "fAlta"};
        DefaultTableModel modelo = new DefaultTableModel(col, 0);
        jtVerMatriculados.setModel(modelo);
        jtVerMatriculados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void mostrarValoresEnTablaVerMatriculados() {
        DefaultTableModel modelo = (DefaultTableModel) jtVerMatriculados.getModel();

        AlumnoDaoImp alumControler = AlumnoDaoImp.getInstance();
        UnidadDaoImp unidadControler = UnidadDaoImp.getInstance();
        String[] fila = new String[6];

        modelo.setNumRows(0);
        try {
            List<Matricula> lst = matriculaControler.getMatriculaByCursoAca(cursoAca);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            for (Matricula mat : lst) {
                Alumno alum = alumControler.getById(mat.getIdalumno());
                Unidad uni = unidadControler.getById(mat.getIdunidad());

                fila[0] = String.valueOf(mat.getIdmatricula());
                fila[1] = alum.getNombre();
                fila[2] = alum.getDni();
                fila[3] = uni.getCodigo();
                fila[4] = mat.getDescripcion();
                fila[5] = dateFormat.format(mat.getfMatricula());

                modelo.addRow(fila);
            }

            //selecciono la primera fila
            if (modelo.getRowCount() > 0) {
                jtVerMatriculados.setRowSelectionInterval(0, 0);
                setCampos();
            }

        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

    private void setCampos() {
    int filaSeleccionada = jtVerMatriculados.getSelectedRow();
    if (filaSeleccionada >= 0) {
        txtNombre.setText(jtVerMatriculados.getValueAt(filaSeleccionada, 0).toString());
        txtDni.setText(jtVerMatriculados.getValueAt(filaSeleccionada, 1).toString());
        txtCodigo.setText(jtVerMatriculados.getValueAt(filaSeleccionada, 2).toString());
        txtfMatricula.setText(jtVerMatriculados.getValueAt(filaSeleccionada, 3).toString());
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jtVerMatriculados = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        btnDarBaja = new javax.swing.JButton();
        pnlDelete = new javax.swing.JPanel();
        btnConfirmarDelete = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtfMatricula = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

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
        jtVerMatriculados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtVerMatriculadosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtVerMatriculados);

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

        txtDni.setText("jTextField1");

        txtNombre.setText("jTextField2");

        txtCodigo.setText("jTextField3");

        btnDarBaja.setText("Dar de Baja");
        btnDarBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDarBajaActionPerformed(evt);
            }
        });

        pnlDelete.setVisible(false);
        pnlDelete.setBackground(new java.awt.Color(255, 0, 0));
        pnlDelete.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btnConfirmarDelete.setBackground(new java.awt.Color(255, 153, 153));
        btnConfirmarDelete.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnConfirmarDelete.setText("Confirmar");
        btnConfirmarDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarDeleteActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel10.setText("El alumno seleccionado sera dado de baja de la unidad que se muestra");

        javax.swing.GroupLayout pnlDeleteLayout = new javax.swing.GroupLayout(pnlDelete);
        pnlDelete.setLayout(pnlDeleteLayout);
        pnlDeleteLayout.setHorizontalGroup(
            pnlDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDeleteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDeleteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfirmarDelete)
                .addGap(29, 29, 29))
        );
        pnlDeleteLayout.setVerticalGroup(
            pnlDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDeleteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(17, 17, 17)
                .addComponent(btnConfirmarDelete)
                .addContainerGap())
        );

        txtfMatricula.setText("b");

        jLabel1.setText("Nombre");

        jLabel2.setText("Dni");

        jLabel3.setText("Unidad");

        jLabel4.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(304, 304, 304)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 821, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(21, 21, 21))
                            .addComponent(txtDni, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDarBaja))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(384, 384, 384)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDarBaja)
                    .addComponent(txtfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnlDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jtVerMatriculadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtVerMatriculadosMouseClicked
        setCampos();
    }//GEN-LAST:event_jtVerMatriculadosMouseClicked

    private void btnConfirmarDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarDeleteActionPerformed
        pnlDelete.setVisible(false);

        try {
            int filaSeleccionada = jtVerMatriculados.getSelectedRow();
            int idMatricula = Integer.parseInt((String) jtVerMatriculados.getValueAt(filaSeleccionada, 0));
            matriculaControler.darBaja(idMatricula);
            matriculaControler.delete(idMatricula);
            JOptionPane.showMessageDialog(null, "Matricula dada de baja");
        } catch (Exception e) {
            System.out.println("error aqui" + e.getMessage());
        }
        mostrarValoresEnTablaVerMatriculados();
    }//GEN-LAST:event_btnConfirmarDeleteActionPerformed

    private void btnDarBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarBajaActionPerformed
        JOptionPane.showMessageDialog(null, "SELECCIONE UNA FILA PARA DAR DE BAJA");
        pnlDelete.setVisible(true);
    }//GEN-LAST:event_btnDarBajaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmarDelete;
    private javax.swing.JButton btnDarBaja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jtVerMatriculados;
    private javax.swing.JPanel pnlDelete;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtfMatricula;
    // End of variables declaration//GEN-END:variables
}
