/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import BD.Categorias;
import BD.Producto;
import BD.Unidades;
import Controller.CCategorias;
import Controller.CProductos;
import Controller.CUnidades;
import com.placeholder.PlaceHolder;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author najera10
 */
public class pnlProductos extends javax.swing.JInternalFrame {

    DefaultComboBoxModel <CCategorias> modeloCategorias;
    DefaultComboBoxModel <CUnidades> modeloUnidades;
    CProductos   productoseleccionado = null ;
     
    DefaultTableModel modeloTablaProductos = new DefaultTableModel(){
           public boolean isCellEditable(int filas, int columnas){
            if(columnas==3){
                return true;
            }else{
                return false;
            }
    }
        
        
        
    };
    Categorias categoria = new Categorias();
    Unidades unidad = new Unidades();
    Producto product = new Producto();
    
    
    
    public pnlProductos() {
         modeloCategorias = new DefaultComboBoxModel<CCategorias>();
         modeloUnidades = new DefaultComboBoxModel<CUnidades>(); 
        initComponents();
        cargarModeloCat();
        cargarModeloUni();
        CargarColunmas();
        CargarModeloTabla();
        
  
        
    }
    
    
      private void cargarModeloCat(){
            ArrayList<CCategorias> listaCategorias;
        listaCategorias = categoria.ObtenerCategorias();
        modeloCategorias.addElement(new CCategorias("0", "Selecciona opcion","",1));

        for(CCategorias categoria : listaCategorias){
            modeloCategorias.addElement(categoria);
        }
    }
      
       private void cargarModeloUni(){
            ArrayList<CUnidades> listarUnidades;
        listarUnidades = unidad.obtenerUnidad();
        modeloUnidades.addElement(new CUnidades(0, "Selecciona opcion"));
        for(CUnidades unidades : listarUnidades){
            modeloUnidades.addElement(unidades);
    }
       }
       
        private void cargarProducto(ImageIcon icono){
        
        //Redimensión de imagen para ajustarla al tamaño del JLabel.
        Image imgProd = icono.getImage();
        int anchoEtiqueta = lblImagenArticulo.getWidth(); //Obtiene ancho de la imagen
        int altoEtiqueta = lblImagenArticulo.getHeight(); //Obtiene alto de la imagen
                
        //Se crea un nuevo objeto Image con la imagen redimensionada.
        Image imgRedimensionada = imgProd.getScaledInstance(anchoEtiqueta, altoEtiqueta, Image.SCALE_DEFAULT);
               
        //Se crea un nuevo objeto ImageIcon a partir de la imagen redimensionada.
        ImageIcon iconRedimensionado = new ImageIcon(imgRedimensionada);
        
        lblImagenArticulo.setIcon(iconRedimensionado);
//        String clave = producto.getIdProducto();
//        String nombre = producto.getNomProducto();
//        String descripcion = producto.getDescProducto();
//        double stockRequerido = producto.getStockProducto();
//        String unidad = producto.getUnidadProducto();
//        double precioCompra = producto.getPrecioCompraProducto();
//        double precioVenta = producto.getPrecioVentaProducto();
        
//        campoClave.setText(clave);
//        campoNombre.setText(nombre);
//        campoDesc.setText(descripcion);
//        campoStock.setText(String.valueOf(stockRequerido));
//        comboUnidades.setSelectedItem(unidad);
//        campoPrecioCompra.setText(String.valueOf(precioCompra));
//        campoPrecioVenta.setText(String.valueOf(precioVenta));
//        
//        campoClave.setEnabled(false);
//        campoNombre.setEnabled(false);
    }
        
     private  void CargarColunmas(){
        modeloTablaProductos.addColumn("Nombre");
        modeloTablaProductos.addColumn("Descripcion");
        modeloTablaProductos.addColumn("Stock");
        modeloTablaProductos.addColumn("Descripcion");
    
        

        
        }
        
         public void CargarModeloTabla(){
      
//    limpiarTabla();
       ArrayList<CProductos>ListarProductos = product.ObtenerCategorias();
      int numerosProductos = ListarProductos.size();
      modeloTablaProductos.setNumRows(numerosProductos);
        for (int i = 0; i < numerosProductos; i++) {
            CProductos productos = ListarProductos.get(i);
            String nombre = productos.getNomProducto();
            String codigo = productos.getDescProducto();
            String descripcion = productos.getCodigo();
            double stock = productos.getStockProducto();
            
            
            modeloTablaProductos.setValueAt(productos, i, 0);
            modeloTablaProductos.setValueAt(codigo, i, 1);
            modeloTablaProductos.setValueAt(stock, i, 2);
            modeloTablaProductos.setValueAt(descripcion, i, 3);
           

            
        }
         
    }    
        public void limpiar(){
        txtnombre.setText("");
        txtdescripcion.setText("");
         }
        public  void limpiarTabla(){
        int numFilas = modeloTablaProductos.getRowCount();
        if(numFilas > 0){
            for(int i = numFilas - 1; i >= 0; i--){
                modeloTablaProductos.removeRow(i);
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

        jComboBox1 = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtstock = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblImagenArticulo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtcodigo = new javax.swing.JTextField();
        btneliminar = new javax.swing.JButton();
        cmbcategorias = new javax.swing.JComboBox();
        txtdescripcion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbunidades = new javax.swing.JComboBox();
        txtprecioventa = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtpreciocompra = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(239, 238, 244));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(180, 10, 90, 30);
        jPanel1.add(txtnombre);
        txtnombre.setBounds(260, 10, 280, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Categoria:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(170, 80, 90, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Código:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 210, 60, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Unidad");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(330, 210, 50, 30);

        txtstock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstockActionPerformed(evt);
            }
        });
        txtstock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtstockKeyTyped(evt);
            }
        });
        jPanel1.add(txtstock);
        txtstock.setBounds(480, 80, 60, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Descripcion:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 270, 90, 30);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        lblImagenArticulo.setBackground(new java.awt.Color(153, 153, 153));
        lblImagenArticulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblImagenArticulo.setMaximumSize(new java.awt.Dimension(50, 50));
        lblImagenArticulo.setMinimumSize(new java.awt.Dimension(50, 50));
        lblImagenArticulo.setName(""); // NOI18N
        lblImagenArticulo.setPreferredSize(new java.awt.Dimension(50, 50));
        lblImagenArticulo.setVerifyInputWhenFocusTarget(false);
        lblImagenArticulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblImagenArticuloMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagenArticulo, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagenArticulo, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 10, 138, 130);

        jButton1.setBackground(new java.awt.Color(0, 51, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img1/diskette.png"))); // NOI18N
        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(90, 330, 160, 40);

        txtcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoActionPerformed(evt);
            }
        });
        jPanel1.add(txtcodigo);
        txtcodigo.setBounds(100, 210, 220, 30);

        btneliminar.setBackground(new java.awt.Color(255, 0, 51));
        btneliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btneliminar.setForeground(new java.awt.Color(255, 255, 255));
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img1/garbage.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btneliminar);
        btneliminar.setBounds(270, 330, 160, 40);

        cmbcategorias.setModel(modeloCategorias);
        jPanel1.add(cmbcategorias);
        cmbcategorias.setBounds(260, 80, 160, 30);
        jPanel1.add(txtdescripcion);
        txtdescripcion.setBounds(110, 270, 440, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Stock");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(430, 80, 50, 30);

        cmbunidades.setModel(modeloUnidades);
        jPanel1.add(cmbunidades);
        cmbunidades.setBounds(400, 210, 150, 30);

        txtprecioventa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprecioventaKeyTyped(evt);
            }
        });
        jPanel1.add(txtprecioventa);
        txtprecioventa.setBounds(400, 150, 150, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Precio Compra");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 150, 120, 30);

        txtpreciocompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpreciocompraKeyTyped(evt);
            }
        });
        jPanel1.add(txtpreciocompra);
        txtpreciocompra.setBounds(140, 150, 140, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Precio Venta");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(290, 150, 100, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 100, 560, 400);

        tblProdutos.setModel(modeloTablaProductos);
        tblProdutos.getSelectionModel().addListSelectionListener(
            new ListSelectionListener(){
                public void valueChanged(ListSelectionEvent event){
                    if(!event.getValueIsAdjusting() && (tblProdutos.getSelectedRow()>= 0) ){
                        int filaseleccionada = tblProdutos.getSelectedRow();
                        CProductos producto = (CProductos) modeloTablaProductos.getValueAt(filaseleccionada, 0);
                        CCategorias categoria = (CCategorias)cmbcategorias.getSelectedItem();
                        String cadena = String.valueOf(producto.getPrecioCompraProducto());
                        String cadena1 = String.valueOf(producto.getPrecioVentaProducto());
                        String stok = String.valueOf(producto.getStockProducto());
                        txtnombre.setText(producto.getNomProducto());
                        txtdescripcion.setText(producto.getDescProducto());
                        txtpreciocompra.setText(cadena);
                        txtprecioventa.setText(cadena1);
                        txtcodigo.setText(producto.getCodigo());
                        txtstock.setText(stok);
                        productoseleccionado = producto;

                    }
                }
            }   
        );
        jScrollPane1.setViewportView(tblProdutos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(590, 200, 500, 295);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setText("Listado de Productos");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(770, 100, 241, 34);

        jLabel10.setText("Buscar");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(600, 160, 43, 29);
        getContentPane().add(txtbuscar);
        txtbuscar.setBounds(640, 160, 195, 29);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
        try {
            CCategorias categoria = (CCategorias)cmbcategorias.getSelectedItem();
            CUnidades unidad = (CUnidades)cmbunidades.getSelectedItem();
            double stock =Double.parseDouble(txtstock.getText());
            double previo_venta = Double.parseDouble(txtprecioventa.getText());
            double precio_compra = Double.parseDouble(txtpreciocompra.getText());
            String codigo = txtcodigo.getText();
            String descripcion  = txtdescripcion.getText();
            String nombre = txtnombre.getText();
            int idcategoria = Integer.parseInt(categoria.getIdcategoria());
        
              int cuentaFilasSeleccionadas = tblProdutos.getSelectedRowCount();
              
        if (cuentaFilasSeleccionadas == 1) {
                
           product.actualizar(productoseleccionado, nombre, descripcion, stock, imgArticleFile, unidad.getIdunidad(), precio_compra, previo_venta, idcategoria, codigo);
            
           
        }else{
         
           if (imgArticleFile == null){
            JOptionPane.showMessageDialog(null, "No haseleccionada una imagen");
            CProductos productos = new CProductos( 0,  nombre, descripcion,  stock, imgArticleFile ,unidad.getIdunidad(),  precio_compra, precio_compra,idcategoria,codigo);
            product.insertar(productos);
            JOptionPane.showMessageDialog(null, "Registro realizado");
            limpiar();
            } else{
            CProductos productos = new CProductos( 0,  nombre, descripcion,  stock,  imgArticleFile,unidad.getIdunidad(),  precio_compra, precio_compra,idcategoria,codigo);
            product.insertar(productos);
            JOptionPane.showMessageDialog(null, "Registro realizado");
            limpiar();
            }  
            
            
        }
            
           
            
            

        } catch (SQLException ex) {
            Logger.getLogger(pnlProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
try {
            
             int cuentaFilasSeleccionadas = tblProdutos.getSelectedRowCount();
            if (cuentaFilasSeleccionadas == 0) {
                JOptionPane.showMessageDialog(null, "Debe serleccionar alguna fila");
            }else{
                product.eliminar(productoseleccionado);
                JOptionPane.showMessageDialog(null, "Categoria  eliminada");
                limpiar();
                CargarModeloTabla();
            }
            
          
        } catch (SQLException ex) {
            Logger.getLogger(pnlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }//GEN-LAST:event_btneliminarActionPerformed

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MousePressed
File imgArticleFile;
    private void lblImagenArticuloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenArticuloMousePressed
        
       if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) {
           
           JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Archivos de imagen jpg, gif o png", "jpg", "gif", "png");
        chooser.setFileFilter(filter);

        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            int anchoImagen = lblImagenArticulo.getWidth();
            int altoImagen = lblImagenArticulo.getHeight();

            imgArticleFile = chooser.getSelectedFile();
           
            ImageIcon icono = new ImageIcon(imgArticleFile.getAbsolutePath());
            Image imagen = icono.getImage();
            Image imagenRedimensionada = imagen.getScaledInstance(anchoImagen, altoImagen, Image.SCALE_DEFAULT);

            ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);

            lblImagenArticulo.setIcon(iconoRedimensionado);
        }
         }else{
           imgArticleFile = null;
       }
        
    }//GEN-LAST:event_lblImagenArticuloMousePressed

    private void txtprecioventaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioventaKeyTyped
        char validar = evt.getKeyChar();
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresa Solo numeros");
        }
    }//GEN-LAST:event_txtprecioventaKeyTyped

    private void txtstockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtstockKeyTyped
        char validar = evt.getKeyChar();
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresa Solo numeros");
        }

      
    }//GEN-LAST:event_txtstockKeyTyped

    private void txtpreciocompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpreciocompraKeyTyped
      char validar = evt.getKeyChar();
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresa Solo numeros");
        }
    }//GEN-LAST:event_txtpreciocompraKeyTyped

    private void txtcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoActionPerformed

    private void txtstockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstockActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneliminar;
    private javax.swing.JComboBox cmbcategorias;
    private javax.swing.JComboBox cmbunidades;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImagenArticulo;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtpreciocompra;
    private javax.swing.JTextField txtprecioventa;
    private javax.swing.JTextField txtstock;
    // End of variables declaration//GEN-END:variables
}
