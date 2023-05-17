/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/MDIApplication.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.formularios;

import com.iesiliberis.crudcentroeducativo.controladorDAO.CursoAcademicoDaoImp;
import com.iesiliberis.crudcentroeducativo.entidades.CursoAcademico;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JRadioButtonMenuItem;

/**
 *
 * @author alvar
 */
public class frmMain extends javax.swing.JFrame {

    public int idCursoAcademico = 0;
    

    /**
     * Creates new form frmMain
     */
    public frmMain() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        generaMenuCursosAcademicos();
       
    }

    /*Genera y selecciona en el menu el año de forma desc, y se puede selecionar el resto de año, devuelve el 
    del año academico*/
    private void generaMenuCursosAcademicos() {

        CursoAcademicoDaoImp cursoAca = CursoAcademicoDaoImp.getInstance();

        try {
            List<CursoAcademico> lista = cursoAca.getAll();
            JRadioButtonMenuItem jrCurso;
            ButtonGroup brgCursoAcademico = new ButtonGroup();

            for (CursoAcademico cursoAcademico : lista) {
                jrCurso = new JRadioButtonMenuItem(cursoAcademico.getDescripcion(), true);
                jrCurso.setName(String.valueOf(cursoAcademico.getId()));

                if (idCursoAcademico == 0) {
                    idCursoAcademico = cursoAcademico.getId();
                }

                jmCursoAcademico.add(jrCurso);
                brgCursoAcademico.add(jrCurso);

                jrCurso.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                        JRadioButtonMenuItem jrbSelected = (JRadioButtonMenuItem) e.getItem();
                        int idCursoAcademicoSeleccionado = Integer.parseInt(jrbSelected.getName());
                        idCursoAcademico = idCursoAcademicoSeleccionado;
                        System.out.println("" + jrbSelected.getName());
                    }

                });

            }

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

    }
    
    
    

    /* hace que solo se pueda abrir una venta, en la opcion de menu hay que añadir este metodo */
    public void mostrarIFrame(JDesktopPane pnl, JInternalFrame ji) {

        JInternalFrame[] frames = pnl.getAllFrames();
        boolean seVe = false;

        for (JInternalFrame frame : frames) {
            if (frame.getClass().equals(ji.getClass())) {
                seVe = true;
                try {
                    frame.setSelected(true);
                } catch (PropertyVetoException e) {
                    System.out.println("" + e.getMessage());
                }
                break;
            }
        }

        if (!seVe) {

            pnl.add(ji);
            ji.show();
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

        pndEscritorio = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        optmCursoAcademico = new javax.swing.JMenuItem();
        menuCurso = new javax.swing.JMenuItem();
        optmAlumno = new javax.swing.JMenuItem();
        optmAula = new javax.swing.JMenuItem();
        menuPersonal = new javax.swing.JMenu();
        PersonalActual = new javax.swing.JMenuItem();
        PersonalAntiguo = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmCursoAcademico = new javax.swing.JMenu();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        optmAcerca = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Parametrizacion");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Mantenimientos");

        optmCursoAcademico.setMnemonic('t');
        optmCursoAcademico.setText("CursoAcademico");
        optmCursoAcademico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optmCursoAcademicoActionPerformed(evt);
            }
        });
        editMenu.add(optmCursoAcademico);

        menuCurso.setMnemonic('y');
        menuCurso.setText("Curso");
        menuCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCursoActionPerformed(evt);
            }
        });
        editMenu.add(menuCurso);

        optmAlumno.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        optmAlumno.setMnemonic('p');
        optmAlumno.setText("Alumnos");
        optmAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optmAlumnoActionPerformed(evt);
            }
        });
        editMenu.add(optmAlumno);

        optmAula.setText("Aula");
        optmAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optmAulaActionPerformed(evt);
            }
        });
        editMenu.add(optmAula);

        menuPersonal.setText("Personal");

        PersonalActual.setText("PersonalActual");
        PersonalActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PersonalActualActionPerformed(evt);
            }
        });
        menuPersonal.add(PersonalActual);

        PersonalAntiguo.setText("PersonalAntiguo");
        PersonalAntiguo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PersonalAntiguoActionPerformed(evt);
            }
        });
        menuPersonal.add(PersonalAntiguo);

        editMenu.add(menuPersonal);

        jMenuItem1.setText("Unidades");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        editMenu.add(jMenuItem1);

        menuBar.add(editMenu);

        jmCursoAcademico.setText("Año Academico");
        menuBar.add(jmCursoAcademico);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Ayuda");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Contents");
        helpMenu.add(contentMenuItem);

        optmAcerca.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        optmAcerca.setMnemonic('a');
        optmAcerca.setText("Acerca de");
        optmAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optmAcercaActionPerformed(evt);
            }
        });
        helpMenu.add(optmAcerca);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pndEscritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pndEscritorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void optmAcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optmAcercaActionPerformed
        frmAcercaDeDialogo frmAcerca = new frmAcercaDeDialogo(this, rootPaneCheckingEnabled);
        frmAcerca.setVisible(true);
    }//GEN-LAST:event_optmAcercaActionPerformed

    private void menuCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCursoActionPerformed
     
    fmrCurso cur;
        try {
            cur = new fmrCurso(idCursoAcademico);
            mostrarIFrame(pndEscritorio, cur);
        } catch (SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
    }//GEN-LAST:event_menuCursoActionPerformed

    private void optmAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optmAlumnoActionPerformed

        frmIAlumnos alumnos = new frmIAlumnos();

        mostrarIFrame(pndEscritorio, alumnos);

        //pndEscritorio.add(alumnos);
        //pndEscritorio.getAllFrames();
        //alumnos.show();

    }//GEN-LAST:event_optmAlumnoActionPerformed

    private void optmCursoAcademicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optmCursoAcademicoActionPerformed
        frmCursoAcademico frmcursoaca = new frmCursoAcademico();
        frmcursoaca.setVisible(true);
    }//GEN-LAST:event_optmCursoAcademicoActionPerformed

    private void optmAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optmAulaActionPerformed
        
        frIAula aula = new frIAula();
        mostrarIFrame(pndEscritorio, aula);
        
    }//GEN-LAST:event_optmAulaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        fmrUnidades uni = new fmrUnidades();
        mostrarIFrame(pndEscritorio, uni);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void PersonalActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PersonalActualActionPerformed
        frmPersonal personal = new frmPersonal();
        mostrarIFrame(pndEscritorio, personal);
    }//GEN-LAST:event_PersonalActualActionPerformed

    private void PersonalAntiguoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PersonalAntiguoActionPerformed
       frmPersonalAntiguo personal = new frmPersonalAntiguo();
        mostrarIFrame(pndEscritorio, personal);
    }//GEN-LAST:event_PersonalAntiguoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem PersonalActual;
    private javax.swing.JMenuItem PersonalAntiguo;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jmCursoAcademico;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuCurso;
    private javax.swing.JMenu menuPersonal;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem optmAcerca;
    private javax.swing.JMenuItem optmAlumno;
    private javax.swing.JMenuItem optmAula;
    private javax.swing.JMenuItem optmCursoAcademico;
    private javax.swing.JDesktopPane pndEscritorio;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

}