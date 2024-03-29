/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import BD.Usuarios;
import Controller.CUsuarios;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.table.TableRowSorter;

/**
 *
 * @author RojeruSan
 */
public class pnlUsuarios extends javax.swing.JPanel {

    DefaultTableModel modeloTabla = new DefaultTableModel(){
    
      public boolean isCellEditable(int filas, int columnas){
            if(columnas == 4){
                return true;
            }else{
                return false;
            }
    }
    
    };
    CUsuarios  usuarioseleccionado = null ;
    Usuarios  bdusr = new Usuarios();
    private TableRowSorter trsFiltro;
     
     
    public pnlUsuarios() {
        initComponents();
        CargarColunmas();
        CargarModeloTabla();
    }
    
    private  void CargarColunmas(){
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Email");
        modeloTabla.addColumn("Usuario");
        modeloTabla.addColumn("Estado");
    }

    public void CargarModeloTabla(){
      
       limpiarTabla();
       ArrayList<CUsuarios>ListarUsuarios = bdusr.ObtenerUsuarios();
      int numerosUsusarios = ListarUsuarios.size();
      modeloTabla.setNumRows(numerosUsusarios);
        for (int i = 0; i < numerosUsusarios; i++) {
            CUsuarios usuarios = ListarUsuarios.get(i);
            String nombre = usuarios.getNombre();
            String email = usuarios.getEmail();
            String usuario = usuarios.getLogin();
            String estatus = usuarios.getCodicion();
            
            if(estatus.equals("1")){
                estatus = "Activo";
            }else{
                estatus = "Inactivo";
            }
            modeloTabla.setValueAt(usuarios, i, 0);
            modeloTabla.setValueAt(email, i, 1);
            modeloTabla.setValueAt(usuario, i, 2);
            modeloTabla.setValueAt(estatus, i, 3);
        }
         
    }
    public void filtroBusqueda(JTextField txt) {
        trsFiltro.setRowFilter(RowFilter.regexFilter(txt.getText()));
    }

   
        public  void limpiarTabla(){
        int numFilas = modeloTabla.getRowCount();
        if(numFilas > 0){
            for(int i = numFilas - 1; i >= 0; i--){
                modeloTabla.removeRow(i);
            }
        }
    }
    
     
     
     public void limpiar(){
         txtusuario.setText("");
         txttelefono.setText("");
         txtcorreo.setText("");
         txtcargo.setText("");
         txtnombre.setText("");
         txtcontrasena.setText("");
         txtdireccion.setText("");
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
        tablaUsuario = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtbusuario = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtcorreo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtcargo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtcontrasena = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtdireccion = new javax.swing.JTextField();
        btneliminar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(128, 128, 131));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("USUARIOS");

        tablaUsuario.setModel(modeloTabla);
        tablaUsuario.setFocusable(false);
        tablaUsuario.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tablaUsuario.setRowHeight(25);
        tablaUsuario.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tablaUsuario.setShowVerticalLines(false);
        tablaUsuario.getTableHeader().setReorderingAllowed(false);
        tablaUsuario.getSelectionModel().addListSelectionListener(
            new ListSelectionListener(){
                public void valueChanged(ListSelectionEvent event){
                    if(!event.getValueIsAdjusting() && (tablaUsuario.getSelectedRow()>= 0) ){
                        int filaseleccionada = tablaUsuario.getSelectedRow();
                        CUsuarios usuario = (CUsuarios) modeloTabla.getValueAt(filaseleccionada, 0);
                        txtnombre.setText(usuario.getNombre());
                        txttelefono.setText(usuario.getTelefono());
                        txtcorreo.setText(usuario.getEmail());
                        txtusuario.setText(usuario.getLogin());
                        txtcontrasena.setText(usuario.getClave());
                        txtdireccion.setText(usuario.getDireccion());
                        usuarioseleccionado = usuario;
                    }
                }
            }   
        );

        jScrollPane1.setViewportView(tablaUsuario);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Buscar Usuario:");

        txtbusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbusuarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbusuarioKeyTyped(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(239, 238, 244));
        jPanel1.setLayout(null);

        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(190, 20, 60, 14);
        jPanel1.add(txtnombre);
        txtnombre.setBounds(240, 10, 160, 30);

        jLabel3.setText("Telefono:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(190, 60, 70, 14);
        jPanel1.add(txttelefono);
        txttelefono.setBounds(240, 50, 160, 30);

        jLabel4.setText("Dirección:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 220, 60, 30);

        jLabel5.setText("Email");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(190, 100, 60, 14);
        jPanel1.add(txtcorreo);
        txtcorreo.setBounds(240, 90, 160, 30);

        jLabel6.setText("Cargo");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(190, 140, 60, 14);
        jPanel1.add(txtcargo);
        txtcargo.setBounds(240, 130, 160, 30);

        jLabel8.setText("Usuario");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(20, 180, 60, 20);

        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });
        jPanel1.add(txtusuario);
        txtusuario.setBounds(70, 170, 110, 30);

        jLabel9.setText("Contraseña");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(190, 180, 80, 20);

        txtcontrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontrasenaActionPerformed(evt);
            }
        });
        jPanel1.add(txtcontrasena);
        txtcontrasena.setBounds(270, 170, 130, 30);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 10, 138, 130);

        jCheckBox1.setText("jCheckBox1");
        jPanel1.add(jCheckBox1);
        jCheckBox1.setBounds(100, 260, 81, 23);

        jCheckBox2.setText("jCheckBox2");
        jPanel1.add(jCheckBox2);
        jCheckBox2.setBounds(190, 260, 81, 23);

        jCheckBox3.setText("jCheckBox3");
        jPanel1.add(jCheckBox3);
        jCheckBox3.setBounds(100, 300, 81, 23);

        jCheckBox4.setText("jCheckBox4");
        jPanel1.add(jCheckBox4);
        jCheckBox4.setBounds(190, 300, 81, 23);

        jCheckBox5.setText("jCheckBox5");
        jPanel1.add(jCheckBox5);
        jCheckBox5.setBounds(280, 260, 81, 23);

        jCheckBox6.setText("jCheckBox6");
        jPanel1.add(jCheckBox6);
        jCheckBox6.setBounds(280, 300, 81, 23);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Permisos.");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(10, 280, 75, 22);

        jButton1.setBackground(new java.awt.Color(0, 51, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img1/diskette.png"))); // NOI18N
        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(30, 330, 160, 40);
        jPanel1.add(txtdireccion);
        txtdireccion.setBounds(80, 220, 320, 30);

        btneliminar.setBackground(new java.awt.Color(255, 0, 51));
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img1/garbage.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btneliminar);
        btneliminar.setBounds(220, 330, 160, 40);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setText("Datos de Usuario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(jLabel12))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtbusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 30, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtbusuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusuarioKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbusuarioKeyReleased

    private void txtbusuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusuarioKeyTyped
             txtbusuario.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (txtbusuario.getText());
                txtbusuario.setText(cadena);
                repaint();
                filtroBusqueda(txtbusuario);
            }
        });
        trsFiltro = new TableRowSorter(tablaUsuario.getModel());
        tablaUsuario.setRowSorter(trsFiltro);
    }//GEN-LAST:event_txtbusuarioKeyTyped

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

      try {
           
            
            
            String nombre = txtnombre.getText();
            String telefono = txttelefono.getText();
            String email = txtcorreo.getText();
            String cargo =txtcargo.getText();
            String usuario = txtusuario.getText();
            String contraseña = txtcontrasena.getText();
            String  direccion = txtdireccion.getText();
           
            int cuentaFilasSeleccionadas = tablaUsuario.getSelectedRowCount(); 
           

        if (cuentaFilasSeleccionadas == 1) { 
            
//            bdusr.actualizarUsuario(usuarioseleccionado, nombre, telefono, usuario, contraseña, direccion);
            bdusr.actualizarUsuario(usuarioseleccionado, nombre, direccion, telefono, email, usuario, contraseña);
            JOptionPane.showMessageDialog(null, "Usuario Actualizado");
            limpiar();
            CargarModeloTabla();
        } else if (cuentaFilasSeleccionadas == 0 ) { 
          CUsuarios usuarios  = new CUsuarios(0,nombre,"","",direccion,telefono,email,cargo,usuario,contraseña,"", "1");
          bdusr.insert(usuarios);
          CargarModeloTabla();
          limpiar();
          JOptionPane.showMessageDialog(null, "Registro Usuario Correcto");
         
        }

        } catch (SQLException ex) {
            Logger.getLogger(pnlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
      

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtcontrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontrasenaActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        try {
            
             int cuentaFilasSeleccionadas = tablaUsuario.getSelectedRowCount();
            if (cuentaFilasSeleccionadas == 0) {
                JOptionPane.showMessageDialog(null, "Debe serleccionar alguna fila");
            }else{
                bdusr.eliminarusuario(usuarioseleccionado);
                JOptionPane.showMessageDialog(null, "Usuario eliminado");
                limpiar();
                CargarModeloTabla();
            }
            
          
        } catch (SQLException ex) {
            Logger.getLogger(pnlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btneliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tablaUsuario;
    private javax.swing.JTextField txtbusuario;
    private javax.swing.JTextField txtcargo;
    private javax.swing.JPasswordField txtcontrasena;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables

   
}
