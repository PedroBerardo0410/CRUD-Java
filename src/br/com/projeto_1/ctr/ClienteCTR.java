/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_1.ctr;
import java.sql.ResultSet;
import br.com.projeto_1.dto.ClienteDTO;
import br.com.projeto_1.dao.ClienteDAO;
import br.com.projeto_1.dao.ConexaoDAO;

/**
 *
 * @author Dell
 */
public class ClienteCTR {
    ClienteDAO clienteDAO = new ClienteDAO();
    public ClienteCTR(){
    }
    
    public String inserirCliente(ClienteDTO clienteDTO){
        try{
            if(clienteDAO.inserirCliente(clienteDTO)){
                return "Cliente cadastrado com sucesso";
            }else{
                return "Cliente Nao cadastrado";
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Cliente NAO cadastrado";
        }
    }
        
        
        public ResultSet consultarCliente(ClienteDTO clienteDTO, int opcao){
            ResultSet rs = null;
            rs = clienteDAO.consultarCliente(clienteDTO, opcao);
             return rs;
        }


    
        public void CloseDB(){
            ConexaoDAO.closeDB();
        }
}



