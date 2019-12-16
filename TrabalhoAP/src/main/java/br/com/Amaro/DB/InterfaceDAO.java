/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Amaro.DB;

import br.com.Amaro.Entidade.Contato;
import java.util.List;

/**
 *
 * @author Luis Amaro
 */
public interface InterfaceDAO {
    public void grava(Contato contato);
    public List busca(String pesquisa);
    public List busca();
    public void atualiza(Contato contato);
    public String deleta(int contato);
}
