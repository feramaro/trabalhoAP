/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Amaro.DB;

import br.com.Amaro.Entidade.Contato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis Amaro
 */
public class ContatoDAO extends Conexao implements InterfaceDAO {

    @Override
    public void grava(Contato contato) {
        String sql = "insert into contatos(nome, telefone, endereco, anotacao)"
                + " values (?, ?, ?, ?)";
        getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getTelefone());
            stmt.setString(3, contato.getEndereco());
            stmt.setString(4, contato.getAnotacao());
            stmt.execute();
            getConnection().close();
        } catch (SQLException ex) {
            System.out.println("Algo está errado");
        }

    }

    @Override
    public List<Contato> busca(String pesquisa) {
        List<Contato> contatos = new ArrayList<>();
        String sql = "select * from contatos where nome like ? or"
                + " telefone like ? or endereco like ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        getConnection();
        try {
            stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, pesquisa);
            stmt.setString(2, pesquisa);
            stmt.setString(3, pesquisa);
            rs = stmt.executeQuery();
            while(rs.next()){
                Contato buscaContato = new Contato();
                buscaContato.setNome(rs.getString("nome"));
                buscaContato.setEndereco(rs.getString("endereco"));
                buscaContato.setTelefone(rs.getString("telefone"));
                buscaContato.setAnotacao(rs.getString("anotacao"));
                contatos.add(buscaContato);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contatos;
    }
    
    @Override
    public List<Contato> busca() {
        String sql = "select * from contatos";
        getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Contato> contatos = new ArrayList<>();
        try {
            stmt = getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Contato criarContato = new Contato();
                criarContato.setNome(rs.getString("nome"));
                criarContato.setTelefone(rs.getString("telefone"));
                criarContato.setEndereco(rs.getString("endereco"));
                criarContato.setAnotacao(rs.getString("anotacao"));
                contatos.add(criarContato);
            }

            getConnection().close();

        } catch (SQLException ex) {
            System.out.println("Algo está errado");
        }
        return contatos;
    }

    @Override
    public void atualiza(Contato contato) {
        String sql = "update contatos set nome = ?, telefone = ?, endereco = ?, anotacao = ? where id = ?";
        getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getTelefone());
            stmt.setString(3, contato.getEndereco());
            stmt.setString(4, contato.getAnotacao());
            stmt.setInt(5, contato.getId());
            stmt.executeUpdate();
            getConnection().close();

        } catch (SQLException ex) {
            System.out.println("Talvez o ID inserido nao exista");
        }
    }

    @Override
    public void deleta(int contato) {
        String sql = "delete from contatos where id = ?";
        getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = getConnection().prepareStatement(sql);
            stmt.setInt(1, contato);
            stmt.execute();
            getConnection().close();

        } catch (SQLException ex) {
            System.out.println("Algo está errado");
        }
    }

    

}
