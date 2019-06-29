/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import BD.Producto;
import Controller.CProductos;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RojeruSan
 */
public class pnlPunto extends javax.swing.JPanel {

    DefaultTableModel modeloTabla = new DefaultTableModel(){
         @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    DefaultListModel<CProductos> modeloListaProductos= new DefaultListModel<CProductos>();
    Producto producto = new Producto();
    
    public pnlPunto() {
        initComponents();
        cargarColumnasTabla();
        cargarListenerModeloTabla();
    }

    private void cargarListenerModeloTabla(){
        
        modeloTabla.addTableModelListener(new TableModelListener(){
            @Override
            public void tableChanged(TableModelEvent e) {
             int numFilas = modeloTabla.getRowCount();
             double sumatoria  = 0;
                for (int i = 0; i < numFilas; i++) {
                    String importe = (String) modeloTabla.getValueAt(i, 4);
                    sumatoria += Double.parseDouble(importe);
                }
                lblsumatoria.setText(String.valueOf(sumatoria));
            }
        });
    }
    
    
    
    private void cargarColumnasTabla(){
        modeloTabla.addColumn("Codigo");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Precio Venta");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Importe");

    
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblventas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblsumatoria = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnventas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtpago = new javax.swing.JTextField();
        btnquitar = new javax.swing.JToggleButton();
        btncancelar = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ltproductos = new javax.swing.JList<CProductos>();
        btncorte = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblimagen = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img1/point.png"))); // NOI18N
        jLabel7.setText("Punto de Venta");
        add(jLabel7);
        jLabel7.setBounds(0, 0, 924, 83);

        tblventas.setModel(modeloTabla);
        tblventas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblventasKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblventas);

        add(jScrollPane1);
        jScrollPane1.setBounds(20, 308, 578, 159);

        jLabel3.setText("Buscar Producto");
        add(jLabel3);
        jLabel3.setBounds(20, 100, 91, 29);

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });
        add(txtbuscar);
        txtbuscar.setBounds(20, 130, 294, 30);

        lblsumatoria.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblsumatoria.setText("0.00");

        jLabel5.setText("Venta Total:");

        btnventas.setBackground(new java.awt.Color(51, 153, 255));
        btnventas.setText("Realizar Venta");

        jLabel1.setText("Pago Con:");

        txtpago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpagoActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnventas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtpago)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(lblsumatoria, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 54, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblsumatoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpago, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(btnventas, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        add(jPanel1);
        jPanel1.setBounds(620, 240, 310, 230);

        btnquitar.setBackground(new java.awt.Color(255, 178, 55));
        btnquitar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnquitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img1/delete.png"))); // NOI18N
        btnquitar.setText("Quitar Producto");
        btnquitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnquitarActionPerformed(evt);
            }
        });
        add(btnquitar);
        btnquitar.setBounds(50, 490, 200, 40);

        btncancelar.setBackground(new java.awt.Color(170, 7, 7));
        btncancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img1/sale-label.png"))); // NOI18N
        btncancelar.setText("Cancelar Venta");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        add(btncancelar);
        btncancelar.setBounds(260, 490, 210, 40);

        ltproductos.setModel(modeloListaProductos);
        ltproductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ltproductosMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(ltproductos);

        add(jScrollPane2);
        jScrollPane2.setBounds(20, 170, 294, 120);

        btncorte.setText("Corte del dia");
        add(btncorte);
        btncorte.setBounds(380, 120, 150, 70);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(null);
        jPanel2.add(lblimagen);
        lblimagen.setBounds(0, 0, 160, 160);

        add(jPanel2);
        jPanel2.setBounds(700, 60, 160, 160);
    }// </editor-fold>//GEN-END:initComponents

    private void txtpagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpagoActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
 
          limpiarListaProductos();
        String cadenaBusqueda = txtbuscar.getText();
        if(cadenaBusqueda.isEmpty()){
            limpiarListaProductos();
        }
        else{
            try {
                ArrayList<CProductos> listaProductos = producto.obtenerProductosPorCriterio(cadenaBusqueda);
                
                for(CProductos prod:listaProductos){
                    modeloListaProductos.addElement(prod);
                }
            } // TODO add your handling code here:
            catch (SQLException ex) {
                Logger.getLogger(pnlPunto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void ltproductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ltproductosMousePressed
 JList list = (JList)evt.getSource();
        if(evt.getClickCount() == 2){
            int index = list.locationToIndex(evt.getPoint());
            CProductos prod = (CProductos)list.getSelectedValue();
            anadirProductoAVenta(prod);
            
        desplegarFoto(prod);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_ltproductosMousePressed

    private void tblventasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblventasKeyReleased
    if(evt.getKeyCode()==KeyEvent.VK_F2){
            int filaSeleccionada = tblventas.getSelectedRow();
            String cantidad = JOptionPane.showInputDialog("Modificar cantidad:");
            String precioVenta = (String) modeloTabla.getValueAt(filaSeleccionada, 2);
            double importe = Double.parseDouble(cantidad) * Double.parseDouble(precioVenta);
            String importeString = String.valueOf(importe);
            modeloTabla.setValueAt(cantidad, filaSeleccionada, 3);
            modeloTabla.setValueAt(importeString, filaSeleccionada, 4);
        }
    }//GEN-LAST:event_tblventasKeyReleased

    private void btnquitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquitarActionPerformed
    int filaSeleccionada  = tblventas.getSelectedRow();
    int cantidadFilas = modeloTabla.getRowCount();
        if (cantidadFilas > 0 ) {
            
        int opcion = JOptionPane.showConfirmDialog(this, "¿Esta Seguro de borrar el producto?");
        if (opcion == 0) {
            modeloTabla.removeRow(filaSeleccionada);
        }
        }
    }//GEN-LAST:event_btnquitarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        int cantidadFilas = modeloTabla.getRowCount();
        
        if (cantidadFilas > 0 ) {
       int opcion =  JOptionPane.showConfirmDialog(this, "¿Esta seguro de cancelar la venta? ");
        
        if (opcion == 0) {   
            for (int i = cantidadFilas-1; i >= 0 ; i--) {
            modeloTabla.removeRow(i);
        }     
        }
       }
    }//GEN-LAST:event_btncancelarActionPerformed
private void desplegarFoto(CProductos prod){
       
   
        try {
            /*obtener imagen*/
            Blob is = producto.buscarFoto(prod);
            byte[]recuperar = is.getBytes(1, (int) is.length());
            BufferedImage img = ImageIO.read(new ByteArrayInputStream(recuperar));
            Image images = img.getScaledInstance(lblimagen.getWidth(), lblimagen.getHeight(), Image.SCALE_SMOOTH);
            lblimagen.setIcon(new ImageIcon(images));
        } catch (SQLException ex) {
            Logger.getLogger(pnlPunto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(pnlPunto.class.getName()).log(Level.SEVERE, null, ex);
        }
                
          
    }
    
    private void limpiarListaProductos(){
        modeloListaProductos.clear();
    }
 
    private void anadirProductoAVenta(CProductos prod){
        String claveProd =Integer.toString(prod.getIdProducto());
        String nombreProd = prod.getNomProducto();
        String precioVenta = String.valueOf(prod.getPrecioVentaProducto());
        String cantidad = "1";
       String importe = String.valueOf(prod.getPrecioVentaProducto());
        
        String [] datosProducto = {claveProd, nombreProd, precioVenta,cantidad,importe};
        modeloTabla.addRow(datosProducto);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btncancelar;
    private javax.swing.JButton btncorte;
    private javax.swing.JToggleButton btnquitar;
    private javax.swing.JButton btnventas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblimagen;
    private javax.swing.JLabel lblsumatoria;
    private javax.swing.JList<CProductos> ltproductos;
    private javax.swing.JTable tblventas;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtpago;
    // End of variables declaration//GEN-END:variables
}