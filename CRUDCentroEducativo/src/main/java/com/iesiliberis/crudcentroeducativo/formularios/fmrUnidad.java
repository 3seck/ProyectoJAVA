/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.formularios;

import com.iesiliberis.crudcentroeducativo.controladorDAO.AulaDaoImp;
import com.iesiliberis.crudcentroeducativo.controladorDAO.CursoDaoImp;
import com.iesiliberis.crudcentroeducativo.controladorDAO.PersonalDaoImp;
import com.iesiliberis.crudcentroeducativo.controladorDAO.UnidadDaoImp;
import com.iesiliberis.crudcentroeducativo.entidades.Aula;
import com.iesiliberis.crudcentroeducativo.entidades.Curso;
import com.iesiliberis.crudcentroeducativo.entidades.Personal;
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
public class fmrUnidad extends javax.swing.JInternalFrame {

    /**
     * Creates new form fmrUnidad
     */
    private List<Integer> idsCursos;

    public fmrUnidad(List<Integer> idsCursos) {
        initComponents();
        this.idsCursos = idsCursos;
        configTabla();
        mostrarValoresEnTabla();
        setCampos();
        btnGuardar.setVisible(false);
    }

    private void configTabla() {
        String col[] = {"Id", "Codigo", "Nombre", "Observaciones", "idcurso", "idtutor", "idaula"};
        DefaultTableModel modelo = new DefaultTableModel(col, 0);
        jtUnidad.setModel(modelo);
        jtUnidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void mostrarValoresEnTabla() {
        DefaultTableModel modelo = (DefaultTableModel) jtUnidad.getModel();
        UnidadDaoImp unidadControler = UnidadDaoImp.getInstance();
        String[] fila = new String[7];
        modelo.setNumRows(0);
        try {
            for (Integer idCurso : idsCursos) {
                List<Unidad> lst = unidadControler.getByCursoAca(idCurso);
                for (Unidad uni : lst) {
                    fila[0] = "" + uni.getId();
                    fila[1] = "" + uni.getCodigo();
                    fila[2] = "" + uni.getNombre();
                    fila[3] = "" + uni.getObservaciones();

                    // Obtener el codigo del curso
                    CursoDaoImp cursoDao = CursoDaoImp.getInstance();
                    int idCurso1 = uni.getIdcurso();
                    Curso curso = cursoDao.getById(idCurso1);
                    fila[4] = "" + curso.getCodigo();

                    // Obtener el dni del profe
                    PersonalDaoImp tutorDao = PersonalDaoImp.getInstance();
                    int idTutor = uni.getIdtutor();
                    Personal tutor = tutorDao.getById(idTutor);
                    fila[5] = "" + tutor.getDni();

                    // Obtener el cod del aula
                    AulaDaoImp aul = AulaDaoImp.getInstance();
                    int idAula = uni.getIdaula();
                    Aula aula = aul.getById(idAula);
                    fila[6] = "" + aula.getCodigo();

                    modelo.addRow(fila);
                }
            }
            // Seleccionar la primera fila de la tabla
            if (modelo.getRowCount() > 0) {
                jtUnidad.setRowSelectionInterval(0, 0);
                setCampos();
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtUnidad = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        pnlCampos = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtObservaciones = new javax.swing.JTextField();
        txtIdcurso = new javax.swing.JTextField();
        txtIdtutor = new javax.swing.JTextField();
        txtIdaula = new javax.swing.JTextField();
        btnConfirmarEdit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnAnadir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        pnlDelete = new javax.swing.JPanel();
        btnConfirmarDelete = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jtUnidad.setModel(new javax.swing.table.DefaultTableModel(
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
        jtUnidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtUnidadMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtUnidad);

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

        jLabel1.setText("Buscar");

        pnlCampos.setVisible(false);

        jLabel3.setText("Codigo");

        jLabel4.setText("Nombre");

        jLabel5.setText("Observaciones");

        jLabel6.setText("Idcurso");

        jLabel7.setText("idtutos");

        jLabel8.setText("idaula");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        btnConfirmarEdit.setText("Aceptar");
        btnConfirmarEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCamposLayout = new javax.swing.GroupLayout(pnlCampos);
        pnlCampos.setLayout(pnlCamposLayout);
        pnlCamposLayout.setHorizontalGroup(
            pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCamposLayout.createSequentialGroup()
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCamposLayout.createSequentialGroup()
                        .addContainerGap(17, Short.MAX_VALUE)
                        .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(148, 148, 148))
                    .addGroup(pnlCamposLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCamposLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(49, 49, 49)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtIdcurso, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                        .addComponent(txtIdtutor)
                        .addComponent(txtIdaula))
                    .addComponent(btnConfirmarEdit))
                .addGap(29, 29, 29))
        );
        pnlCamposLayout.setVerticalGroup(
            pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtIdcurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtIdtutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdaula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(btnConfirmarEdit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAnadir.setIcon(new javax.swing.ImageIcon("C:\\Users\\alvar\\Desktop\\imgJava\\add_FILL0_wght400_GRAD0_opsz48.png")); // NOI18N
        btnAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon("C:\\Users\\alvar\\Desktop\\imgJava\\save_FILL0_wght400_GRAD0_opsz48.png")); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnAtras.setIcon(new javax.swing.ImageIcon("C:\\Users\\alvar\\Desktop\\imgJava\\cancel_FILL0_wght400_GRAD0_opsz48.png")); // NOI18N
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon("C:\\Users\\alvar\\Desktop\\imgJava\\delete.png")); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon("C:\\Users\\alvar\\Desktop\\imgJava\\edit_FILL0_wght400_GRAD0_opsz48.png")); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAnadir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 378, Short.MAX_VALUE)
                .addComponent(btnAtras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAtras)
                    .addComponent(btnEditar)
                    .addComponent(btnAnadir)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
        jLabel10.setText("La Unidad seleccionada se borrar permanentemente");

        javax.swing.GroupLayout pnlDeleteLayout = new javax.swing.GroupLayout(pnlDelete);
        pnlDelete.setLayout(pnlDeleteLayout);
        pnlDeleteLayout.setHorizontalGroup(
            pnlDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDeleteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDeleteLayout.createSequentialGroup()
                        .addComponent(btnConfirmarDelete)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDeleteLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(22, 22, 22))))
        );
        pnlDeleteLayout.setVerticalGroup(
            pnlDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDeleteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(btnConfirmarDelete)
                .addGap(23, 23, 23))
        );

        jLabel2.setText("Id");

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel9.setText("Unidades");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel2)
                .addGap(50, 50, 50)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(pnlCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        txtId.setVisible(false);
        jLabel2.setVisible(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarnone(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarnone

    }//GEN-LAST:event_txtBuscarnone

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            DefaultTableModel modelo = (DefaultTableModel) jtUnidad.getModel();
            TableRowSorter<TableModel> trSorter = new TableRowSorter<>(modelo);
            jtUnidad.setRowSorter(trSorter);

            if (txtBuscar.getText().length() == 0) {
                trSorter.setRowFilter(null);
            } else {
                trSorter.setRowFilter(RowFilter.regexFilter(txtBuscar.getText().trim()));
            }
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirActionPerformed
        btnGuardar.setVisible(true);
        btnConfirmarEdit.setVisible(false);
        pnlCampos.setVisible(true);
    }//GEN-LAST:event_btnAnadirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        pnlCampos.setVisible(true);
        btnConfirmarEdit.setVisible(true);
        btnGuardar.setVisible(false);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        btnGuardar.setVisible(false);
        pnlCampos.setVisible(false);

        UnidadDaoImp cur = UnidadDaoImp.getInstance();
        try {
            cur.add(getCamposAdd());
            JOptionPane.showMessageDialog(this, "Unidad agregada correctamente");
            mostrarValoresEnTabla();

        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnConfirmarEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarEditActionPerformed
        btnConfirmarEdit.setVisible(false);

        UnidadDaoImp cur = UnidadDaoImp.getInstance();
        try {
            cur.update(getCamposAdd());
            JOptionPane.showMessageDialog(this, "Unidad actualizada correctamente");
            int fila = jtUnidad.getSelectedRow();
            mostrarValoresEnTabla();
            jtUnidad.setRowSelectionInterval(fila, fila);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        pnlCampos.setVisible(false);
    }//GEN-LAST:event_btnConfirmarEditActionPerformed

    private void jtUnidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtUnidadMouseClicked
        setCampos();
    }//GEN-LAST:event_jtUnidadMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        JOptionPane.showMessageDialog(null, "SELECCIONE UNA FILA PARA BORRAR");
        pnlDelete.setVisible(true);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnConfirmarDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarDeleteActionPerformed
        pnlDelete.setVisible(false);
        UnidadDaoImp unidad = UnidadDaoImp.getInstance();
        int id = Integer.parseInt(txtId.getText());
        try {
            Unidad u = unidad.getById(id);
            unidad.unidadAntigua(u);
            unidad.delete(id);
            JOptionPane.showMessageDialog(null, "Unidad eliminada correctamente");
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
        mostrarValoresEnTabla();
    }//GEN-LAST:event_btnConfirmarDeleteActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        pnlCampos.setVisible(false);
        btnGuardar.setVisible(false);
    }//GEN-LAST:event_btnAtrasActionPerformed

    private Unidad getCamposAdd() {
        Unidad uni = new Unidad();

        uni.setId(Integer.parseInt(txtId.getText()));
        uni.setCodigo(txtCodigo.getText());
        uni.setNombre(txtNombre.getText());
        uni.setObservaciones(txtObservaciones.getText());
        uni.setCodCurso(txtIdcurso.getText());
        uni.setDniTutor(txtIdtutor.getText());
        uni.setCodAula(txtIdaula.getText());

        return uni;
    }

    private Unidad getCampos() {

        Unidad uni = new Unidad();

        uni.setId(Integer.parseInt(txtId.getText()));
        uni.setCodigo(txtCodigo.getText());
        uni.setNombre(txtNombre.getText());
        uni.setObservaciones(txtObservaciones.getText());
        uni.setIdcurso(Integer.parseInt(txtIdcurso.getText()));
        uni.setIdtutor(Integer.parseInt(txtIdtutor.getText()));
        uni.setIdaula(Integer.parseInt(txtIdaula.getText()));

        /*  
        uni.setCodCurso(txtIdcurso.getText());
        uni.setDniTutor(txtIdtutor.getText());
        uni.setCodAula(txtIdaula.getText());*/
        return uni;
    }

    private void setCampos() {

        int filaSeleccionada = jtUnidad.getSelectedRow();
        if (filaSeleccionada >= 0) {
            txtId.setText(jtUnidad.getValueAt(filaSeleccionada, 0).toString());
            txtCodigo.setText(jtUnidad.getValueAt(filaSeleccionada, 1).toString());
            txtNombre.setText(jtUnidad.getValueAt(filaSeleccionada, 2).toString());
            txtObservaciones.setText(jtUnidad.getValueAt(filaSeleccionada, 3).toString());
            txtIdcurso.setText(jtUnidad.getValueAt(filaSeleccionada, 4).toString());
            txtIdtutor.setText(jtUnidad.getValueAt(filaSeleccionada, 5).toString());
            txtIdaula.setText(jtUnidad.getValueAt(filaSeleccionada, 6).toString());
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnadir;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnConfirmarDelete;
    private javax.swing.JButton btnConfirmarEdit;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtUnidad;
    private javax.swing.JPanel pnlCampos;
    private javax.swing.JPanel pnlDelete;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdaula;
    private javax.swing.JTextField txtIdcurso;
    private javax.swing.JTextField txtIdtutor;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtObservaciones;
    // End of variables declaration//GEN-END:variables
}
