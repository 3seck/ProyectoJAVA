/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.formularios;

import com.iesiliberis.crudcentroeducativo.controladorDAO.PersonalDaoImp;
import com.iesiliberis.crudcentroeducativo.entidades.Personal;
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
public class frmPersonal extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmPersonal
     */
    public frmPersonal() {
        initComponents();
        configTabla();
        cargaTabla();
        setCampos();
        btnGuardar.setVisible(false);
    }
    
    private void configTabla(){
        String col[]= {"id", "dni", "nombre", "apellido1", "apellido2",  "direccion", "cp", "poblacion", "provincia", "telefono", "email", "tipo"};
    
        DefaultTableModel modelo = new DefaultTableModel(col, 0);
        jtPersonal.setModel(modelo);
        jtPersonal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
    }
    
    private void cargaTabla() {
        DefaultTableModel modelo = (DefaultTableModel) jtPersonal.getModel();

        PersonalDaoImp personalControler = PersonalDaoImp.getInstance();
        String[] fila = new String[12];

        modelo.setNumRows(0);
        try {
            List<Personal> lst = personalControler.getAll();

            for (Personal perso : lst) {
                fila[0] = "" + perso.getId();
                fila[1] = "" + perso.getDni();
                fila[2] = "" + perso.getNombre();
                fila[3] = "" + perso.getApellido1();
                fila[4] = "" + perso.getApellido2();
                fila[5] = "" + perso.getDireccion();
                fila[6] = "" + perso.getCp();
                fila[7] = "" + perso.getPoblacion();
                fila[8] = "" + perso.getProvincia();
                fila[9] = "" + perso.getTelefono();
                fila[10] = "" + perso.getEmail();
                fila[11] = "" + perso.getTipo();
                modelo.addRow(fila);
            }
            //selecciono la primera fila
            jtPersonal.setRowSelectionInterval(0, 0);

        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
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

        jpTablaCampos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jlTelfono = new javax.swing.JLabel();
        jlEmail = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido1 = new javax.swing.JTextField();
        txtApellido2 = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtCp = new javax.swing.JTextField();
        txtPoblacion = new javax.swing.JTextField();
        txtProvincia = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        jLId = new javax.swing.JLabel();
        btnAceptarEdit = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnAnadir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPersonal = new javax.swing.JTable();
        pnlDelete = new javax.swing.JPanel();
        btnConfirmarDelete = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jpTablaCampos.setVisible(false);

        jLabel2.setText("Dni");

        jLabel3.setText("Nombre");

        jLabel4.setText("Apellido1");

        jLabel5.setText("Apellido2");

        jLabel6.setText("Direccion");

        jLabel7.setText("Cp");

        jLabel8.setText("Poblacion");

        jLabel9.setText("Porvincia");

        jlTelfono.setText("Telefono");

        jlEmail.setText("Email");

        jLabel12.setText("Tipo");

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        jLId.setText("Id");

        btnAceptarEdit.setText("Aceptar");
        btnAceptarEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpTablaCamposLayout = new javax.swing.GroupLayout(jpTablaCampos);
        jpTablaCampos.setLayout(jpTablaCamposLayout);
        jpTablaCamposLayout.setHorizontalGroup(
            jpTablaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTablaCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpTablaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpTablaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTablaCamposLayout.createSequentialGroup()
                            .addGroup(jpTablaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jpTablaCamposLayout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(46, 46, 46))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpTablaCamposLayout.createSequentialGroup()
                                    .addComponent(jLId)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(jpTablaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jpTablaCamposLayout.createSequentialGroup()
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(8, 8, 8))
                                .addComponent(txtDni)))
                        .addGroup(jpTablaCamposLayout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtApellido2))
                        .addGroup(jpTablaCamposLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(txtNombre))
                        .addGroup(jpTablaCamposLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtApellido1)))
                    .addGroup(jpTablaCamposLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jpTablaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpTablaCamposLayout.createSequentialGroup()
                        .addGroup(jpTablaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpTablaCamposLayout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel12)
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTablaCamposLayout.createSequentialGroup()
                                .addComponent(jlEmail)
                                .addGap(18, 18, 18)))
                        .addGroup(jpTablaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpTablaCamposLayout.createSequentialGroup()
                                .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(134, 134, 134)
                                .addComponent(btnAceptarEdit))
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpTablaCamposLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jlTelfono)
                        .addGap(18, 18, 18)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpTablaCamposLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jpTablaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpTablaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCp, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpTablaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPoblacion, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                .addComponent(txtProvincia)))))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        jpTablaCamposLayout.setVerticalGroup(
            jpTablaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTablaCamposLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jpTablaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLId))
                .addGap(18, 18, 18)
                .addGroup(jpTablaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPoblacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpTablaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpTablaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jlTelfono)
                    .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpTablaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jlEmail)
                    .addComponent(txtApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpTablaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel12)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptarEdit)))
        );

        btnAnadir.setIcon(new javax.swing.ImageIcon("C:\\Users\\alvar\\Desktop\\imgJava\\add_FILL0_wght400_GRAD0_opsz48.png")); // NOI18N
        btnAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon("C:\\Users\\alvar\\Desktop\\imgJava\\edit_FILL0_wght400_GRAD0_opsz48.png")); // NOI18N
        btnEditar.setToolTipText("");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon("C:\\Users\\alvar\\Desktop\\imgJava\\save_FILL0_wght400_GRAD0_opsz48.png")); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon("C:\\Users\\alvar\\Desktop\\imgJava\\delete.png")); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

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

        btnAtras.setIcon(new javax.swing.ImageIcon("C:\\Users\\alvar\\Desktop\\imgJava\\cancel_FILL0_wght400_GRAD0_opsz48.png")); // NOI18N
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jtPersonal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Dni", "Nombre", "Apellido1", "Apellido2", "Direccion", "Cp", "Poblacion", "Provincia", "Telefono", "Email", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPersonalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtPersonal);

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
        jLabel10.setText("El personal seleccionado se borrar permanentemente");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pnlDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jpTablaCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 100, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(pnlDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpTablaCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void jtPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPersonalMouseClicked
        setCampos();
    }//GEN-LAST:event_jtPersonalMouseClicked

    private void txtBuscarnone(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarnone

    }//GEN-LAST:event_txtBuscarnone

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            DefaultTableModel modelo = (DefaultTableModel) jtPersonal.getModel();
            TableRowSorter<TableModel> trSorter = new TableRowSorter<>(modelo);
            jtPersonal.setRowSorter(trSorter);

            if (txtBuscar.getText().length() == 0) {
                trSorter.setRowFilter(null);
            } else {
                trSorter.setRowFilter(RowFilter.regexFilter(txtBuscar.getText().trim()));
            }
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        txtId.setVisible(false);
        jpTablaCampos.setVisible(true);
        btnAceptarEdit.setVisible(true);
        btnGuardar.setVisible(false);

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirActionPerformed
        txtId.setVisible(false);
        btnAceptarEdit.setVisible(false);
        jpTablaCampos.setVisible(true);
        btnGuardar.setVisible(true);
    }//GEN-LAST:event_btnAnadirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        btnGuardar.setVisible(false);
        jpTablaCampos.setVisible(false);
        PersonalDaoImp perso = PersonalDaoImp.getInstance();
        
        try {
            perso.add(getCampos());
            JOptionPane.showMessageDialog(this, "Personal agregado correctamente");
            cargaTabla();
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAceptarEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarEditActionPerformed
       
        btnAceptarEdit.setVisible(false);
        PersonalDaoImp perso = PersonalDaoImp.getInstance();
        try{
            perso.update(getCampos());
            JOptionPane.showMessageDialog(this, "Aula actualizado correctamente");
            int fila=jtPersonal.getSelectedRow();
            cargaTabla();
            jtPersonal.setRowSelectionInterval(fila,fila); 
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
         }
        jpTablaCampos.setVisible(false);
    
        
    }//GEN-LAST:event_btnAceptarEditActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        JOptionPane.showMessageDialog(null, "SELECCIONE UNA FILA PARA BORRAR");
        pnlDelete.setVisible(true);
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnConfirmarDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarDeleteActionPerformed
        pnlDelete.setVisible(false);
        PersonalDaoImp perso=PersonalDaoImp.getInstance();
        int id=Integer.parseInt(txtId.getText());
        try {
            Personal p = perso.getById(id);
            perso.moverAntiguo(p);
            perso.delete(id);
            JOptionPane.showMessageDialog(null, "Personal eliminado correctamente");
        } catch (Exception e) {
            System.out.println(""+e.getMessage());
        }
        cargaTabla();
    }//GEN-LAST:event_btnConfirmarDeleteActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        jpTablaCampos.setVisible(false);
        btnGuardar.setVisible(false);
        pnlDelete.setVisible(false);
        btnAceptarEdit.setVisible(false);
    }//GEN-LAST:event_btnAtrasActionPerformed

    private Personal getCampos(){
        Personal p = new Personal();
        
        p.setId(Integer.parseInt(txtId.getText()));
        p.setDni(txtDni.getText());
        p.setNombre(txtNombre.getText());
        p.setApellido1(txtApellido1.getText());
        p.setApellido2(txtApellido2.getText());
        p.setDireccion(txtDireccion.getText());
        p.setCp(txtCp.getText());
        p.setPoblacion(txtPoblacion.getText());
        p.setProvincia(txtProvincia.getText());
        p.setTelefono(txtTelefono.getText());
        p.setEmail(txtEmail.getText());
        if (!txtTipo.getText().isEmpty()) {
    p.setTipo(Integer.parseInt(txtTipo.getText()));
}
        return p; 
    }
    
    
    private void setCampos(){
        
         
    txtId.setText(jtPersonal.getValueAt(jtPersonal.getSelectedRow(),0).toString());
    txtDni.setText(jtPersonal.getValueAt(jtPersonal.getSelectedRow(), 1).toString());
    txtNombre.setText(jtPersonal.getValueAt(jtPersonal.getSelectedRow(), 2).toString());
    txtApellido1.setText(jtPersonal.getValueAt(jtPersonal.getSelectedRow(), 3).toString());
    txtApellido2.setText(jtPersonal.getValueAt(jtPersonal.getSelectedRow(), 4).toString());
    txtDireccion.setText(jtPersonal.getValueAt(jtPersonal.getSelectedRow(), 5).toString());
    txtCp.setText(jtPersonal.getValueAt(jtPersonal.getSelectedRow(), 6).toString());
    txtPoblacion.setText(jtPersonal.getValueAt(jtPersonal.getSelectedRow(), 7).toString());
    txtProvincia.setText(jtPersonal.getValueAt(jtPersonal.getSelectedRow(), 8).toString());
    txtTelefono.setText(jtPersonal.getValueAt(jtPersonal.getSelectedRow(), 9).toString());
    txtEmail.setText(jtPersonal.getValueAt(jtPersonal.getSelectedRow(), 10).toString());
    txtTipo.setText(jtPersonal.getValueAt(jtPersonal.getSelectedRow(),11).toString());

          
      
    }     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarEdit;
    private javax.swing.JButton btnAnadir;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnConfirmarDelete;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlTelfono;
    private javax.swing.JPanel jpTablaCampos;
    private javax.swing.JTable jtPersonal;
    private javax.swing.JPanel pnlDelete;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCp;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPoblacion;
    private javax.swing.JTextField txtProvincia;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
