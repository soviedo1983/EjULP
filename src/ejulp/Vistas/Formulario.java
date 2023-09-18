
package ejulp.Vistas;

import ejulp.Vistas.formAlumno;
import ejulp.Vistas.porMateria;
public class Formulario extends javax.swing.JFrame {
     
    public Formulario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu6 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        formAlumno = new javax.swing.JDesktopPane();
        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        llamada_FormularioAlumno = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMcons = new javax.swing.JMenu();
        jMAlumxmat = new javax.swing.JMenuItem();
        jMsalirform5 = new javax.swing.JMenu();

        jMenu6.setText("jMenu6");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setForeground(new java.awt.Color(255, 0, 255));
        escritorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 763, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );

        formAlumno.setLayer(escritorio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout formAlumnoLayout = new javax.swing.GroupLayout(formAlumno);
        formAlumno.setLayout(formAlumnoLayout);
        formAlumnoLayout.setHorizontalGroup(
            formAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        formAlumnoLayout.setVerticalGroup(
            formAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formAlumnoLayout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(formAlumno)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(formAlumno)
                .addContainerGap())
        );

        jMenu1.setText("Alumno");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        llamada_FormularioAlumno.setText("Formulario de Alumno");
        llamada_FormularioAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                llamada_FormularioAlumnoActionPerformed(evt);
            }
        });
        jMenu1.add(llamada_FormularioAlumno);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Materia");

        jMenuItem3.setText("Formulario de Materia ");
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Administracion");

        jMenuItem4.setText("Manejo de Inscripcion");
        jMenu3.add(jMenuItem4);

        jMenuItem5.setText("Manipulacion de Notas");
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        jMcons.setText("Consultas");

        jMAlumxmat.setText("Alumnos por Materia");
        jMAlumxmat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMAlumxmatActionPerformed(evt);
            }
        });
        jMcons.add(jMAlumxmat);

        jMenuBar1.add(jMcons);

        jMsalirform5.setText("Salir");
        jMsalirform5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMsalirform5ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMsalirform5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void llamada_FormularioAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_llamada_FormularioAlumnoActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        formAlumno formAlumno_open = new formAlumno();
        escritorio.add(formAlumno_open);
        formAlumno_open.setVisible(true);
    }//GEN-LAST:event_llamada_FormularioAlumnoActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMAlumxmatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMAlumxmatActionPerformed
        javax.swing.JDesktopPane escritorio;
        porMateria jMAlumxmat = new porMateria();
       
        jMAlumxmat.setVisible(true);
    }//GEN-LAST:event_jMAlumxmatActionPerformed

    private void jMsalirform5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMsalirform5ActionPerformed
         this.dispose();
    }//GEN-LAST:event_jMsalirform5ActionPerformed

    public static void main(String args[]) {
     javax.swing.JDesktopPane escritorio;
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario().setVisible(true);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JDesktopPane formAlumno;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JMenuItem jMAlumxmat;
    private javax.swing.JMenu jMcons;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenu jMsalirform5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem llamada_FormularioAlumno;
    // End of variables declaration//GEN-END:variables
}
