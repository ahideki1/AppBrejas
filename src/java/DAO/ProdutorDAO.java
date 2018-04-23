/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import BEAN.GetSetProdutor;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



/**
 *
 * @author alexandre.yoshimura
 */
public class ProdutorDAO {
    private static String status;
        
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
        ArrayList<GetSetProdutor> arrayProd = new ArrayList();
        
        String query = "select * from tb_produtor";
        auxSql = con.prepareStatement(query);
        
        ResultSet rs = auxSql.executeQuery();
        
        while(rs.next()){
            prod = new GetSetProdutor();
            prod.setProdutor(rs.getString("no_produtor"));
            arrayProd.add(prod);
        }
        
        con.close();

        return arrayProd;
    }
    
    public String GeraJsonProdutor() throws SQLException{
        Connection con = Conexao.conectar();
        PreparedStatement auxSql = null;
        GetSetProdutor prod;
        //ArrayList<GetSetProdutor> arrayProd = new ArrayList();
        ArrayList<GetSetProdutor> arrayProd = new ArrayList();
        String json;
        String virgula = "";
        int auxCont;
        int arrayQtd;
        
        String query = "select * from tb_produtor order by no_produtor asc";
        auxSql = con.prepareStatement(query);
        
        ResultSet rs = auxSql.executeQuery();
        
        while(rs.next()){
            prod = new GetSetProdutor();
            prod.setProdutor(rs.getString("no_produtor"));
            prod.setIdProdutor(rs.getInt("id_produtor"));
            arrayProd.add(prod);
        }
        
        arrayQtd = arrayProd.size();
        
        json = "{\"recordsTotal\":\""+arrayQtd+"\",";
        json = json + "\"recordsFiltered\":\""+arrayQtd+"\",";
        json = json + "\"produtor\":[";
        auxCont = 1;
        for(GetSetProdutor aux: arrayProd){
            
            if(auxCont != arrayQtd){
                virgula = ",";
            }else{
                virgula = "";
            }
            
            /*json = json + "{\"no_produtor\":\""+aux.getProdutor()+"\",\"id_produtor\":\""+aux.getIdProdutor()+"\"}"+virgula+"";*/
            json = json + "{";
            json = json + "\"no_produtor\":\""+aux.getProdutor()+"\",";
            json = json + "\"id_produtor\":\""+aux.getIdProdutor()+"\"";
            json = json + "}"+virgula+"";
            auxCont++;
        }
        json = json + "]}"; 
        
        return json;
    }
    
}
