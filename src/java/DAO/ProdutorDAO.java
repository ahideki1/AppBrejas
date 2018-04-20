/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Conexao;
import BEAN.GetSetProdutor;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexandre.yoshimura
 */
public class ProdutorDAO {
    private static String status;
    ArrayList<GetSetProdutor> Produtor = new ArrayList();
    
    public String CadastrarProdutor(GetSetProdutor dadosProdutor) throws SQLException{
        Connection con = Conexao.conectar();
       
        String produtor = dadosProdutor.getProdutor();
        String query = "insert into tb_produtor(no_produtor) values(?)";
        
        PreparedStatement auxSql = null;
        
        auxSql = con.prepareStatement(query);
        auxSql.setString(1, produtor);
        
        try{
            auxSql.executeUpdate();
            status = "Cadastrado com sucesso !";
        }catch(SQLException e){
            status = e.getMessage();
        }
        con.close();
        return status;
    }
    
    public ArrayList BuscarProdutor() throws SQLException{
        Connection con = Conexao.conectar();
        PreparedStatement auxSql = null;
        GetSetProdutor prod;
        //ArrayList<GetSetProdutor> arrayProd = new ArrayList();
        ArrayList arrayProd = new ArrayList();
        
        String query = "select * from tb_produtor";
        auxSql = con.prepareStatement(query);
        
        ResultSet rs = auxSql.executeQuery();
        
        while(rs.next()){
            prod = new GetSetProdutor();
            //prod.setProdutor(rs.getString("no_produtor"));
            arrayProd.add(rs.getString("no_produtor"));
        }
        
        con.close();
        Produtor = arrayProd;
        return Produtor;
    }
    
}
