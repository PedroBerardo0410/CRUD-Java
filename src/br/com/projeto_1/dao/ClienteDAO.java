/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_1.dao;

import java.sql.*;
import br.com.projeto_1.dto.ClienteDTO;

/**
 *
 * @author Dell
 */

public class ClienteDAO {

    private ResultSet rs = null;
    private Statement stmt = null;

    public boolean inserirCliente(ClienteDTO clienteDTO) {
        try {
            ConexaoDAO.connectionDB();
            stmt = ConexaoDAO.conn.createStatement();

            String comando = "Insert into cliente(nome_cli, logradouro_cli, numero_cli,"
                    + "bairro_Cli, cidade_cli, estado_cli, cep_cli, cpf_cli, rg_cli)values("
                    + "'" + clienteDTO.getNome_cli() + "', "
                    + "'" + clienteDTO.getLogradouro_cli() + "', "
                    + clienteDTO.getNumero_cli() + ", "
                    + "'" + clienteDTO.getBairro_cli() + "', "
                    + "'" + clienteDTO.getCidade_cli() + "', "
                    + "'" + clienteDTO.getEstado_cli() + "', "
                    + "'" + clienteDTO.getCep_cli() + "', "
                    + "'" + clienteDTO.getCpf_cli() + "', "
                    + "'" + clienteDTO.getRg_cli() + "')";

            stmt.execute(comando.toUpperCase());
            ConexaoDAO.conn.commit();
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConexaoDAO.closeDB();
        }
    }
   
    public ResultSet consultarCliente(ClienteDTO clienteDTO, int opcao){
        try{
            ConexaoDAO.connectionDB();
            stmt = ConexaoDAO.conn.createStatement();
            String comando="";
            
            switch(opcao){
                case 1:
                    comando = "Select c.* "+
                            "from cliente c "+
                            "where nome_cli like '"+ clienteDTO.getNome_cli()+ "%' "+
                            "order by c.nome_cli";
                    break;
                case 2:
                    comando = "Select c.* "+
                            "from cliente c "+
                            "where c.id_cli = "+clienteDTO.getId_cli();
                    break;
                case 3:
                    comando = "Select c.id_cli, c.nome_cli "+
                            "from cliente c ";
                    break;
            }
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
        }
    }
    
   

}
