/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author alexandre.yoshimura
 */
public class Conexao {
    static private Connection conn;
    
    public static Connection conectar() throws SQLException{
        
        if (conn == null || conn.isClosed()) {
            //Apenas trocar o driver e a string de conexão;
            String driver = "com.mysql.jdbc.Driver";
            //String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            try {
                Class.forName(driver);
                //conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_massa_teste", "root", "");             
                String url = "jdbc:mysql://localhost:3306/AppBrejas";
                String usuario = "root";
                String senha = "";
                
                conn = DriverManager.getConnection(url,usuario,senha);
                //JOptionPane.showMessageDialog(null, "Conectado com sucesso");
            } catch (ClassNotFoundException | SQLException sqle) {
                
            }
        }
        
        return conn;
    }
    
}
