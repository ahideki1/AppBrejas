/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import BEAN.GetSetProdutor;
import DAO.ProdutorDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.jasper.tagplugins.jstl.core.Catch;

/**
 *
 * @author alexandre.yoshimura
 */
public class Crud extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        GetSetProdutor dadosProd = new GetSetProdutor();
        ProdutorDAO funcProDao = new ProdutorDAO();
        
        String acao = request.getParameter("hdnAction");
        String retorno = "";
        ArrayList arrayRetorno;

        switch(acao){
            case "CAD_PRODUTOR":
                String produtor  = request.getParameter("txtProdutor");
                dadosProd.setProdutor(produtor);
                
                try{
                   retorno = funcProDao.CadastrarProdutor(dadosProd);
                }catch(SQLException e){
                   retorno = "Falha ao inserir produtor";
                }
                response.getWriter().write(retorno);
                
                break;
            
            case "BUSCA_PRODUTOR":
                try{
                    arrayRetorno = funcProDao.BuscarProdutor();
                    //request.setAttribute("ListaProdutor", arrayRetorno);
                    //request.getRequestDispatcher("/retornaDados.jsp").forward(request, response);
                     response.getWriter().println(arrayRetorno);
                }catch(SQLException e){
                    retorno = "Falha ao buscar produtor 2"; 
                }

                break;
            default:
            response.getWriter().println("Ação incorreta");
        }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
