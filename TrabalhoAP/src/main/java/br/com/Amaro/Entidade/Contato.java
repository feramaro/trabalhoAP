package br.com.Amaro.Entidade;

/**
 *
 * @author Luis Amaro
 */
public class Contato {
    private int id;
    private String nome;
    private String telefone;
    private String endereco;
    private String anotacao;
    
    public Contato(){
    
    }
    
    public Contato(String nome, String telefone, String endereco, String anotacao) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.anotacao = anotacao;
    }
      
    public Contato(String nome, String telefone, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.anotacao = "Sem Anotações";
    }

    public Contato(int id, String nome, String telefone, String endereco, String anotacao) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.anotacao = anotacao;
    }
 
    public String getNome() {
        return nome;
    }
    
    

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(String anotacao) {
        this.anotacao = anotacao;
    }
    
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("==================\n"
                + "ID: %d \n"
                + "Nome: %s \n"
                + "Telefone: %s \n"
                + "Endereço: %s \n"
                + "Anotação: %s \n"
                + "==================", this.id, this.nome, this.telefone, this.endereco, this.anotacao);
    }


    
    
}
