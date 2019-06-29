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
import javax.swing.JOptionPane;
import principal.Login;
import principal.Principal;

public class login {
    
    private Connection userConn;
    
     public login() {

    }
    
    public login(Connection conn) {
        this.userConn = conn;
    }
    
       public boolean validar_ingreso(String usuario, String pass) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int resultado = 0;
        String SSQL = "SELECT * FROM usuario WHERE login='" + usuario + "' AND clave='" + pass + "' ";
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SSQL);
            rs = stmt.executeQuery();
            if (rs.next() == false) {
            JOptionPane.showMessageDialog(null, "El Usuario no Existe", "", JOptionPane.ERROR_MESSAGE);
            Login usl = new Login();
            usl.setVisible(true);
            } else {
            JOptionPane.showMessageDialog(null, "Bienvenido", "", JOptionPane.INFORMATION_MESSAGE);
            Principal prin = new Principal();
            prin.setVisible(true);    
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error de conexión", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return true;
    }
}
