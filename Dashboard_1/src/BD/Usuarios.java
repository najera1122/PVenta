/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Controller.CUsuarios;
import javax.swing.JOptionPane;
import paneles.pnlUsuarios;

/**
 *
 * @author najera10
 */
public class Usuarios {
    
    private Connection userConn;
    
    private final String SQL_SELECT = "SELECT * FROM usuario";
    private final String SQL_INSERT = "INSERT INTO usuario  values(?,?,?,?,?,?,?,?,?,?,?)";
    private final String SQL_DELETE = "DELETE usuario  WHERE idusuario=?";


    
    public Usuarios(Connection conn) {
        this.userConn = conn;
    }

    public Usuarios() {
       
    }
    
     public ArrayList<CUsuarios> ObtenerUsuarios() {
        ArrayList<CUsuarios> ListarUsuarios = new ArrayList<CUsuarios>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idusuario");
                String nombre = rs.getString("nombre");
                String tipo_documento = rs.getString("tipo_documento");
                String num_documento= rs.getString("num_documento");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                String cargo = rs.getString("cargo");
                String usuario = rs.getString("login");
                String clave = rs.getString("clave");
                String imagen  = rs.getString("imagen");
                String condicion = rs.getString("condicion");
                
                CUsuarios emp = new CUsuarios(id, nombre,tipo_documento,num_documento,direccion,telefono,email,cargo, usuario,clave,imagen,condicion);
                ListarUsuarios.add(emp);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
        }
        return ListarUsuarios;
    }

    
     
     public  int   insert(CUsuarios usuario) throws SQLException  {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
          
        try {
           conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
           stmt = conn.prepareStatement(SQL_INSERT);
            
           
            stmt.setString(1,usuario.getNombre());
            stmt.setString(2,usuario.getTipo_documento());
            stmt.setString(3,usuario.getNum_documento());
            stmt.setString(4,usuario.getDireccion());
            stmt.setString(5,usuario.getTelefono());
            stmt.setString(6,usuario.getEmail());
            stmt.setString(7,usuario.getCargo());
            stmt.setString(8,usuario.getLogin());
            stmt.setString(9,usuario.getClave());
            stmt.setString(10,usuario.getImagen());
            stmt.setString(11,usuario.getCodicion());

             System.out.println("Ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
            
           
            
            
           
        } finally {
            Conexion.close(stmt);
            if (this.userConn == null) {
                Conexion.close(conn);
            }
        }
        
        return rows;

    }
     
     public int  actualizarUsuario(CUsuarios usuario,String nombre,String direccion,String telefono,String email,String login,String clave) throws SQLException{
         
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            System.out.println("Ejecutando query:" + "Actualizacion");
            stmt = conn.prepareStatement("update  usuario set nombre='"+nombre+"',direccion='"+direccion+"',telefono='"+telefono+"'"
                    + ",email='"+email+"',login='"+login+"',clave='"+clave+"' where idusuario='"+usuario.getId_usuario()+"' ");
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados:" + rows);
        } finally {
            Conexion.close(stmt);
            if (this.userConn == null) {
                Conexion.close(conn);
            }
        }
        return rows;
}
     
     
     public int eliminarusuario(CUsuarios usuario) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
          
        try {
           conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
           stmt = conn.prepareStatement(SQL_DELETE);
           stmt.setInt(1,usuario.getId_usuario());
             System.out.println("Ejecutando query:" + SQL_DELETE);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
            
           
            
            
           
        } finally {
            Conexion.close(stmt);
            if (this.userConn == null) {
                Conexion.close(conn);
            }
     }
        return rows;
     }
     
}