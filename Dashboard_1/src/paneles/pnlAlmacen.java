/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import javax.swing.UIManager;

public class pnlAlmacen extends javax.swing.JPanel {

    /**
     * Creates new form pnlHome
     */
    public pnlAlmacen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        contenedorModulosAlmacen = new javax.swing.JDesktopPane();
        jButton2 = new javax.swing.JButton();
        brnCategorias = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(128, 128, 131));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ALMACEN");
        add(jLabel7);
        jLabel7.setBounds(10, 1, 1110, 60);

        javax.swing.GroupLayout contenedorModulosAlmacenLayout = new javax.swing.GroupLayout(contenedorModulosAlmacen);
        contenedorModulosAlmacen.setLayout(contenedorModulosAlmacenLayout);
        contenedorModulosAlmacenLayout.setHorizontalGroup(
            contenedorModulosAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1120, Short.MAX_VALUE)
        );
        contenedorModulosAlmacenLayout.setVerticalGroup(
            contenedorModulosAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        add(contenedorModulosAlmacen);
        contenedorModulosAlmacen.setBounds(0, 114, 1120, 520);

        jButton2.setBackground(new java.awt.Color(255, 124, 31));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img1/product.png"))); // NOI18N
        jButton2.setText("Articulos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(690, 60, 130, 50);

        brnCategorias.setBackground(new java.awt.Color(144, 209, 0));
        brnCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img1/maintenance.png"))); // NOI18N
        brnCategorias.setText("Categorias");
        brnCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnCategoriasActionPerformed(evt);
            }
        });
        add(brnCategorias);
        brnCategorias.setBounds(280, 60, 130, 50);
    }// </editor-fold>//GEN-END:initComponents
pnlCategorias  pnlCategorias;
    private void brnCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnCategoriasActionPerformed
        if(pnlCategorias == null){  
        pnlCategorias = new pnlCategorias();
            contenedorModulosAlmacen.add(pnlCategorias);
            contenedorModulosAlmacen.getDesktopManager().maximizeFrame(pnlCategorias);
            pnlCategorias.setVisible(true);
        }
        else{
            contenedorModulosAlmacen.getDesktopManager().maximizeFrame(pnlCategorias);
        }
    }//GEN-LAST:event_brnCategoriasActionPerformed
pnlProductos pnlArticulos;
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      if(pnlArticulos == null){  
        pnlArticulos = new pnlProductos();
            contenedorModulosAlmacen.add(pnlArticulos);
            contenedorModulosAlmacen.getDesktopManager().maximizeFrame(pnlArticulos);
            pnlArticulos.setVisible(true);
        }
        else{
            contenedorModulosAlmacen.getDesktopManager().maximizeFrame(pnlArticulos);
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnCategorias;
    private javax.swing.JDesktopPane contenedorModulosAlmacen;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}