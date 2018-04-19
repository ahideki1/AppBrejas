package DAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.Conexao;
import BEAN.Login;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexandre.yoshimura
 */
public class LoginDAO {
    private static String lg;
    
    
    public String VerificarLogin(Login login) throws SQLException {
        Connection con = Conexao.conectar();
        
        String usuario = login.getUsuario();
        String senha = login.getSenha();
        int qtdLinhas;
        
        //String query = "select * from tb_usuario where username = " + "'"+ usuario +"'" +" and senha = " +"'"+ senha +"'";
        String query = "select * from tb_usuario where username = ? and senha = ?";
        //String query = "select * from tb_usuario";
        
        PreparedStatement auxSql = null;
        //Statement stmt = (Statement) con.createStatement();
        
        try {
            
            auxSql = con.prepareStatement(query);
            auxSql.setString(1, usuario);
            auxSql.setString(2, senha);
            ResultSet rs = auxSql.executeQuery();
            
            //ResultSet rs = stmt.executeQuery(auxSql);
    
            rs.last();
            qtdLinhas = rs.getRow();
            
            if(qtdLinhas > 0){
                lg = "OK";
            }else{
                lg = "FAIL";
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            lg = "FAIL 3";
        }finally {
            
            
            con.close(); 
         }
        
        
        return lg;
    }
}
