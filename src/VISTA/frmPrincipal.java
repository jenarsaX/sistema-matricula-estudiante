package VISTA;

import CONTROLADOR.ControladorPrincipal;
import MODELO.Proceso;

public class frmPrincipal extends javax.swing.JFrame {

    private final ControladorPrincipal controlador;

    public frmPrincipal() {
        initComponents();
        controlador = new ControladorPrincipal(this);
        controlador.initDiseño();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new COMPONET.Panel();
        barraTitulo = new COMPONET.Panel();
        moduloMatricula = new COMPONET.Panel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        moduloSalones = new COMPONET.Panel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        moduloDocentes = new COMPONET.Panel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        moduloAlumnos = new COMPONET.Panel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        imagen1 = new COMPONET.Imagen();
        jScrollPane1 = new COMPONET.ScrollPaneWin11();
        CONTENEDOR = new COMPONET.Panel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Colegio la Catolica");
        setBackground(new java.awt.Color(111, 165, 214));

        panelRound1.setBackground(new java.awt.Color(0, 50, 70));

        barraTitulo.setBackground(new java.awt.Color(255, 255, 255));
        barraTitulo.setPreferredSize(new java.awt.Dimension(1038, 75));
        barraTitulo.setRoundBottomLeft(20);
        barraTitulo.setRoundBottomRight(20);
        barraTitulo.setRoundTopLeft(20);
        barraTitulo.setRoundTopRight(20);

        moduloMatricula.setBackground(new java.awt.Color(255, 255, 255));
        moduloMatricula.setCustomCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        moduloMatricula.setRoundBottomLeft(10);
        moduloMatricula.setRoundBottomRight(10);
        moduloMatricula.setRoundTopLeft(10);
        moduloMatricula.setRoundTopRight(10);
        moduloMatricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                moduloMatriculaMouseClicked(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/libro.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("ISOCTEUR", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(40, 48, 68));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Matricula");

        javax.swing.GroupLayout moduloMatriculaLayout = new javax.swing.GroupLayout(moduloMatricula);
        moduloMatricula.setLayout(moduloMatriculaLayout);
        moduloMatriculaLayout.setHorizontalGroup(
            moduloMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moduloMatriculaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        moduloMatriculaLayout.setVerticalGroup(
            moduloMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moduloMatriculaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        moduloSalones.setBackground(new java.awt.Color(255, 255, 255));
        moduloSalones.setCustomCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        moduloSalones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                moduloSalonesMouseClicked(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/regla.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("ISOCTEUR", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(40, 48, 68));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Secciones");

        javax.swing.GroupLayout moduloSalonesLayout = new javax.swing.GroupLayout(moduloSalones);
        moduloSalones.setLayout(moduloSalonesLayout);
        moduloSalonesLayout.setHorizontalGroup(
            moduloSalonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moduloSalonesLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        moduloSalonesLayout.setVerticalGroup(
            moduloSalonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moduloSalonesLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        moduloDocentes.setBackground(new java.awt.Color(255, 255, 255));
        moduloDocentes.setCustomCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        moduloDocentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                moduloDocentesMouseClicked(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/docente.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("ISOCTEUR", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(40, 48, 68));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Docentes");

        javax.swing.GroupLayout moduloDocentesLayout = new javax.swing.GroupLayout(moduloDocentes);
        moduloDocentes.setLayout(moduloDocentesLayout);
        moduloDocentesLayout.setHorizontalGroup(
            moduloDocentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moduloDocentesLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        moduloDocentesLayout.setVerticalGroup(
            moduloDocentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moduloDocentesLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        moduloAlumnos.setBackground(new java.awt.Color(255, 255, 255));
        moduloAlumnos.setCustomCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        moduloAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                moduloAlumnosMouseClicked(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/alumno.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("ISOCTEUR", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(40, 48, 68));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Alumnos");

        javax.swing.GroupLayout moduloAlumnosLayout = new javax.swing.GroupLayout(moduloAlumnos);
        moduloAlumnos.setLayout(moduloAlumnosLayout);
        moduloAlumnosLayout.setHorizontalGroup(
            moduloAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moduloAlumnosLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        moduloAlumnosLayout.setVerticalGroup(
            moduloAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moduloAlumnosLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        imagen1.setImage(new javax.swing.ImageIcon(getClass().getResource("/IMG/icono.png"))); // NOI18N

        javax.swing.GroupLayout barraTituloLayout = new javax.swing.GroupLayout(barraTitulo);
        barraTitulo.setLayout(barraTituloLayout);
        barraTituloLayout.setHorizontalGroup(
            barraTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraTituloLayout.createSequentialGroup()
                .addContainerGap(283, Short.MAX_VALUE)
                .addComponent(moduloMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(moduloSalones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(moduloDocentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(moduloAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 275, Short.MAX_VALUE)
                .addComponent(imagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        barraTituloLayout.setVerticalGroup(
            barraTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraTituloLayout.createSequentialGroup()
                .addGroup(barraTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(barraTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(moduloSalones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(moduloMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(barraTituloLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(moduloDocentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(moduloAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(barraTituloLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jScrollPane1.setBackground(new java.awt.Color(110, 166, 208));

        CONTENEDOR.setBackground(new java.awt.Color(0, 50, 70));
        CONTENEDOR.setLayout(new java.awt.CardLayout());
        jScrollPane1.setViewportView(CONTENEDOR);

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(barraTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 1164, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(20, 20, 20))))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(barraTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void moduloMatriculaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moduloMatriculaMouseClicked
        Proceso.MostrarPanel(CONTENEDOR, new moduloMatricula());
    }//GEN-LAST:event_moduloMatriculaMouseClicked

    private void moduloSalonesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moduloSalonesMouseClicked
        Proceso.MostrarPanel(CONTENEDOR, new moduloSeccion());
    }//GEN-LAST:event_moduloSalonesMouseClicked

    private void moduloDocentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moduloDocentesMouseClicked
        Proceso.MostrarPanel(CONTENEDOR, new moduloDocente());
    }//GEN-LAST:event_moduloDocentesMouseClicked

    private void moduloAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moduloAlumnosMouseClicked
        Proceso.MostrarPanel(CONTENEDOR, new moduloAlumnoApoderado());
    }//GEN-LAST:event_moduloAlumnosMouseClicked

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new frmPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static COMPONET.Panel CONTENEDOR;
    public COMPONET.Panel barraTitulo;
    public COMPONET.Imagen imagen1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JScrollPane jScrollPane1;
    public COMPONET.Panel moduloAlumnos;
    public COMPONET.Panel moduloDocentes;
    public COMPONET.Panel moduloMatricula;
    public COMPONET.Panel moduloSalones;
    public COMPONET.Panel panelRound1;
    // End of variables declaration//GEN-END:variables
}
