/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import BD.Proveedores;
import Controller.CProveedores;
import Controller.CUsuarios;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author najera10
 */
public class pnlproveedores extends javax.swing.JInternalFrame {
DefaultTableModel modelotablaProveedores = new DefaultTableModel(){

  public boolean isCellEditable(int filas, int columnas){
            if(columnas==4){
                return true;
            }else{
                return false;
            }
    }


};
Proveedores  bdprv = new Proveedores();
CProveedores  proveedorselecionado = null ;

    public pnlproveedores() {
        initComponents();
        CargarColunmas();
        CargarModeloTabla();
    }
    
        private  void CargarColunmas(){
        modelotablaProveedores.addColumn("Nombre");
        modelotablaProveedores.addColumn("Dirección");
        modelotablaProveedores.addColumn("Telefono");
        modelotablaProveedores.addColumn("Email");
    }

    public void CargarModeloTabla(){
      
       limpiarTabla();
       ArrayList<CProveedores>ListarProveedores = bdprv.ObtenerProveedores();
      int numerosProveedpres = ListarProveedores.size();
      modelotablaProveedores.setNumRows(numerosProveedpres);
        for (int i = 0; i < numerosProveedpres; i++) {
            CProveedores proveedor = ListarProveedores.get(i);
            String nombre = proveedor.getNombre();
            String email = proveedor.getEmail();
            String direccion = proveedor.getDireccion();
            String telefono = proveedor.getTelefono();
            
            
            modelotablaProveedores.setValueAt(proveedor, i, 0);
            modelotablaProveedores.setValueAt(direccion, i, 1);
            modelotablaProveedores.setValueAt(telefono, i, 2);
            modelotablaProveedores.setValueAt(email, i, 3);
        }
         
    }
//    public void filtroBusqueda(JTextField txt) {
//        trsFiltro.setRowFilter(RowFilter.regexFilter(txt.getText()));
//    }
//
//   
    
    public void limpiar(){
        txtnombre.setText("");
        txtdireccion.setText("");
        txttelefono.setText("");
        txtemail.setText("");
    }
        public  void limpiarTabla(){
        int numFilas = modelotablaProveedores.getRowCount();
        if(numFilas > 0){
            for(int i = numFilas - 1; i >= 0; i--){
                modelotablaProveedores.removeRow(i);
            }
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        btnagregar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProveedores = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        bUSCAR = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Proveedores");
        jLabel1.setAlignmentX(0.5F);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1080, 43);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(51, 255, 255))); // NOI18N

        jLabel2.setText("Nombre:");

        jLabel3.setText("Direccion:");

        jLabel4.setText("Telenono:");

        jLabel5.setText("Email:");

        btnagregar.setBackground(new java.awt.Color(0, 102, 255));
        btnagregar.setText("Agregar");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        btneliminar.setBackground(new java.awt.Color(255, 0, 51));
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addComponent(btnagregar)
                        .addGap(33, 33, 33)
                        .addComponent(btneliminar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtnombre)))
                        .addGap(25, 25, 25)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(264, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnagregar, btneliminar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnagregar)
                    .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnagregar, btneliminar});

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 49, 1080, 150);

        tablaProveedores.setModel(modelotablaProveedores);
        tablaProveedores.setRowHeight(25);
        tablaProveedores.setRowMargin(0);
        tablaProveedores.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tablaProveedores.getSelectionModel().addListSelectionListener(
            new ListSelectionListener(){
                public void valueChanged(ListSelectionEvent event){
                    if(!event.getValueIsAdjusting() && (tablaProveedores.getSelectedRow()>= 0) ){
                        int filaseleccionada = tablaProveedores.getSelectedRow();
                        CProveedores proveedor = (CProveedores) modelotablaProveedores.getValueAt(filaseleccionada, 0);
                        txtnombre.setText(proveedor.getNombre());
                        txtdireccion.setText(proveedor.getDireccion());
                        txtemail.setText(proveedor.getEmail());
                        txttelefono.setText(proveedor.getTelefono());
                        proveedorselecionado = proveedor;

                    }
                }
            }   
        );
        jScrollPane1.setViewportView(tablaProveedores);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 236, 1080, 220);

        jScrollPane2.setViewportView(jTextPane1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(80, 202, 141, 30);

        bUSCAR.setText("Buscar:");
        getContentPane().add(bUSCAR);
        bUSCAR.setBounds(30, 200, 50, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
    try {
        String nombre = txtnombre.getText();
        String telefono = txttelefono.getText();
        String email = txtemail.getText();
        String  direccion = txtdireccion.getText();
        
             int cuentaFilasSeleccionadas = tablaProveedores.getSelectedRowCount(); 
           

        if (cuentaFilasSeleccionadas == 1) { 
         
             bdprv.actualizarProveedor(proveedorselecionado, nombre, telefono, email,direccion);
            JOptionPane.showMessageDialog(null, "Proveedor Actualizado");
            limpiar();
            CargarModeloTabla();
        }else if(cuentaFilasSeleccionadas == 0){
               CProveedores prove = new CProveedores(0,nombre,"","",direccion,telefono,email);
        bdprv.registrar_Proveedor(prove);
        CargarModeloTabla();
        limpiar();
        JOptionPane.showMessageDialog(null, "Registro Realizado");
            
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(pnlproveedores.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnagregarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
 try {
            
             int cuentaFilasSeleccionadas = tablaProveedores.getSelectedRowCount();
            if (cuentaFilasSeleccionadas == 0) {
                JOptionPane.showMessageDialog(null, "Debe serleccionar alguna fila");
            }else{
                bdprv.EliminiarProveedor(proveedorselecionado);
                JOptionPane.showMessageDialog(null, "Proveedor eliminado");
                limpiar();
                CargarModeloTabla();
            }
            
          
        } catch (SQLException ex) {
            Logger.getLogger(pnlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btneliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bUSCAR;
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTable tablaProveedores;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
