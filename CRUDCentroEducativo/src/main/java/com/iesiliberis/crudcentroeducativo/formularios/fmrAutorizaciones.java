/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.formularios;

import com.iesiliberis.crudcentroeducativo.controladorDAO.AlumnoDaoImp;
import com.iesiliberis.crudcentroeducativo.controladorDAO.AutorizadosDaoImp;
import com.iesiliberis.crudcentroeducativo.controladorDAO.FamiliaresAutorizadosDaoImp;
import com.iesiliberis.crudcentroeducativo.entidades.Alumno;
import com.iesiliberis.crudcentroeducativo.entidades.Autorizados;
import com.iesiliberis.crudcentroeducativo.entidades.FamiliaresAutorizados;
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
public class fmrAutorizaciones extends javax.swing.JInternalFrame {

    /**
     * Creates new form fmrAutorizaciones
     */
    public fmrAutorizaciones() {
        initComponents();
        configTablaAlumnos();
        configTablaAutorizados();
        configTablaAutorizaciones();
        mostrarValoresEnTablaAutorizaciones();
        cargaTablaAlumnos();
        cargaTablaAutorizados();
        
        
    }

    private void configTablaAutorizaciones() {

        String col[] = {"DNIAlumno","NombreAlumno", "DNIAutorizado","NombreAutorizado", "Parentesco"};

        DefaultTableModel modelo = new DefaultTableModel(col, 0);
        jtAutorizaciones.setModel(modelo);
        jtAutorizaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    private void configTablaAlumnos() {

        String col[] = {"DNI", "NOMBRE"};

        DefaultTableModel modelo = new DefaultTableModel(col, 0);
        jtAlumnos.setModel(modelo);
        jtAlumnos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    private void configTablaAutorizados() {

        String col[] = {"DNI", "NOMBRE", "PARENTESCO"};

        DefaultTableModel modelo = new DefaultTableModel(col, 0);
        jtAutorizados.setModel(modelo);
        jtAutorizados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    private void cargaTablaAlumnos() {
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

    private void cargaTablaAutorizados() {
        DefaultTableModel modelo = (DefaultTableModel) jtAutorizados.getModel();

        AutorizadosDaoImp autoControler = AutorizadosDaoImp.getInstance();
        String[] fila = new String[3];

        modelo.setNumRows(0);
        try {
            List<Autorizados> lst = autoControler.getAll();

            for (Autorizados auto : lst) {

                fila[0] = "" + auto.getDni();
                fila[1] = "" + auto.getNombre();
                fila[2] = "" + auto.getParentesco();

                modelo.addRow(fila);
            }
            //selecciono la primera fila
            if (modelo.getRowCount() > 0) {
                jtAutorizados.setRowSelectionInterval(0, 0);
                setCamposAutorizado();
            }
            mostrarValoresEnTablaAutorizaciones();

        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
    
    
    private void mostrarValoresEnTablaAutorizaciones() {
        DefaultTableModel modelo = (DefaultTableModel) jtAutorizaciones.getModel();
        
        FamiliaresAutorizadosDaoImp fami = FamiliaresAutorizadosDaoImp.getInstance();
        AlumnoDaoImp alumc = AlumnoDaoImp.getInstance();
        AutorizadosDaoImp autorizadoController = AutorizadosDaoImp.getInstance();
        String[] fila = new String[5];

        modelo.setNumRows(0);
        try {    
            
            // Se ordena la lista por curso academico por consulta sql no por lista de id de cursos
            List<FamiliaresAutorizados> lst = fami.getAll();

            for (FamiliaresAutorizados f : lst) {
                Alumno alum = alumc.getById(f.getIdalumno());
                Autorizados auto = autorizadoController.getById(f.getIdautorizado());
                
                fila[0] = "" + alum.getDni();
                fila[1] = "" + alum.getNombre();
                
                fila[2] = "" +  auto.getDni();
                fila[3] = "" +  auto.getNombre();
                fila[4] = "" +  auto.getParentesco();
                

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
    private void setCamposAlumnos() {

        txtDniAlumno.setText(jtAlumnos.getValueAt(jtAlumnos.getSelectedRow(), 0).toString());
        txtNombreAlumno.setText(jtAlumnos.getValueAt(jtAlumnos.getSelectedRow(), 1).toString());

    }

    private void setCamposAutorizado() {

        txtDniAutorizado.setText(jtAutorizados.getValueAt(jtAutorizados.getSelectedRow(), 0).toString());
        txtNombreAutorizado.setText(jtAutorizados.getValueAt(jtAutorizados.getSelectedRow(), 1).toString());
        txtParentesco.setText(jtAutorizados.getValueAt(jtAutorizados.getSelectedRow(), 2).toString());

    }
    
    private FamiliaresAutorizados getCamposAdd(){
        FamiliaresAutorizados fami = new FamiliaresAutorizados();
        
        fami.setDniAlumno(txtDniAlumno.getText());
        fami.setDniAutorizado(txtDniAutorizado.getText());
        
        
        return fami;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtAlumnos = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAutorizados = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtDniAlumno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNombreAlumno = new javax.swing.JTextField();
        btnacpetarParentesco = new javax.swing.JButton();
        txtNombreAutorizado = new javax.swing.JTextField();
        txtDniAutorizado = new javax.swing.JTextField();
        txtParentesco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtBuscarAlumnos = new javax.swing.JTextField();
        txtBuscarAutorizados = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtAutorizaciones = new javax.swing.JTable();
        txtBuscarAutorizaciones = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtAlumnosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtAlumnos);

        jtAutorizados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtAutorizados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtAutorizadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtAutorizados);

        jLabel2.setText("Dni");

        txtDniAlumno.setText("jTextField1");

        jLabel1.setText("Nombre");

        txtNombreAlumno.setText("jTextField1");

        btnacpetarParentesco.setText("Establecer parentesco con");
        btnacpetarParentesco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnacpetarParentescoActionPerformed(evt);
            }
        });

        txtNombreAutorizado.setText("jTextField1");
        txtNombreAutorizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreAutorizadoActionPerformed(evt);
            }
        });

        txtDniAutorizado.setText("jTextField1");

        txtParentesco.setText("jTextField1");

        jLabel3.setText("Nombre");

        jLabel4.setText("Dni");

        jLabel5.setText("Parentesco");

        txtBuscarAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarAlumnosActionPerformed(evt);
            }
        });
        txtBuscarAlumnos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarAlumnosKeyPressed(evt);
            }
        });

        txtBuscarAutorizados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarAutorizadosActionPerformed(evt);
            }
        });
        txtBuscarAutorizados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarAutorizadosKeyPressed(evt);
            }
        });

        jLabel6.setText("Buscar");

        jLabel7.setText("Buscar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel1)
                .addGap(72, 72, 72)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(95, 95, 95)
                .addComponent(jLabel4)
                .addGap(156, 156, 156))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(txtNombreAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDniAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnacpetarParentesco)
                        .addGap(18, 19, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(207, 207, 207)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNombreAutorizado, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDniAutorizado, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(13, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(txtBuscarAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBuscarAutorizados, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscarAlumnos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarAutorizados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnacpetarParentesco)
                    .addComponent(txtDniAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreAutorizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDniAutorizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jtAutorizaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtAutorizaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtAutorizacionesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtAutorizaciones);

        txtBuscarAutorizaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarAutorizacionesActionPerformed(evt);
            }
        });
        txtBuscarAutorizaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarAutorizacionesKeyPressed(evt);
            }
        });

        jLabel8.setText("Buscar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarAutorizaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarAutorizaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtAutorizadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtAutorizadosMouseClicked
        setCamposAutorizado();
    }//GEN-LAST:event_jtAutorizadosMouseClicked

    private void jtAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtAlumnosMouseClicked
        setCamposAlumnos();
    }//GEN-LAST:event_jtAlumnosMouseClicked

    private void txtNombreAutorizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreAutorizadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreAutorizadoActionPerformed

    private void txtBuscarAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarAlumnosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarAlumnosActionPerformed

    private void txtBuscarAlumnosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarAlumnosKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            DefaultTableModel modelo = (DefaultTableModel) jtAlumnos.getModel();
            TableRowSorter<TableModel> trSorter = new TableRowSorter<>(modelo);
            jtAlumnos.setRowSorter(trSorter);

            if (txtBuscarAlumnos.getText().length() == 0) {
                trSorter.setRowFilter(null);
            } else {
                trSorter.setRowFilter(RowFilter.regexFilter(txtBuscarAlumnos.getText().trim()));
            }
        }
    }//GEN-LAST:event_txtBuscarAlumnosKeyPressed

    private void txtBuscarAutorizadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarAutorizadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarAutorizadosActionPerformed

    private void txtBuscarAutorizadosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarAutorizadosKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            DefaultTableModel modelo = (DefaultTableModel) jtAutorizados.getModel();
            TableRowSorter<TableModel> trSorter = new TableRowSorter<>(modelo);
            jtAutorizados.setRowSorter(trSorter);

            if (txtBuscarAlumnos.getText().length() == 0) {
                trSorter.setRowFilter(null);
            } else {
                trSorter.setRowFilter(RowFilter.regexFilter(txtBuscarAlumnos.getText().trim()));
            }
        }
    }//GEN-LAST:event_txtBuscarAutorizadosKeyPressed

    private void jtAutorizacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtAutorizacionesMouseClicked

    }//GEN-LAST:event_jtAutorizacionesMouseClicked

    private void btnacpetarParentescoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnacpetarParentescoActionPerformed
        FamiliaresAutorizadosDaoImp fami = FamiliaresAutorizadosDaoImp.getInstance();
        
        try {
            fami.add(getCamposAdd());
            JOptionPane.showMessageDialog(this, "Autorizado agragado correctamente");
            mostrarValoresEnTablaAutorizaciones();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnacpetarParentescoActionPerformed

    private void txtBuscarAutorizacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarAutorizacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarAutorizacionesActionPerformed

    private void txtBuscarAutorizacionesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarAutorizacionesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            DefaultTableModel modelo = (DefaultTableModel) jtAutorizaciones.getModel();
            TableRowSorter<TableModel> trSorter = new TableRowSorter<>(modelo);
            jtAutorizaciones.setRowSorter(trSorter);

            if (txtBuscarAutorizaciones.getText().length() == 0) {
                trSorter.setRowFilter(null);
            } else {
                trSorter.setRowFilter(RowFilter.regexFilter(txtBuscarAutorizaciones.getText().trim()));
            }
        }
    }//GEN-LAST:event_txtBuscarAutorizacionesKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnacpetarParentesco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jtAlumnos;
    private javax.swing.JTable jtAutorizaciones;
    private javax.swing.JTable jtAutorizados;
    private javax.swing.JTextField txtBuscarAlumnos;
    private javax.swing.JTextField txtBuscarAutorizaciones;
    private javax.swing.JTextField txtBuscarAutorizados;
    private javax.swing.JTextField txtDniAlumno;
    private javax.swing.JTextField txtDniAutorizado;
    private javax.swing.JTextField txtNombreAlumno;
    private javax.swing.JTextField txtNombreAutorizado;
    private javax.swing.JTextField txtParentesco;
    // End of variables declaration//GEN-END:variables
}
