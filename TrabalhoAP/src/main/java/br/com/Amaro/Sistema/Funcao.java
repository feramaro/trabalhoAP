package br.com.Amaro.Sistema;

import br.com.Amaro.DB.ContatoDAO;
import br.com.Amaro.Entidade.Contato;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Luis Amaro
 */
public class Funcao extends ContatoDAO {

    Scanner tc = new Scanner(System.in);

    public void menu() {
        Scanner tc = new Scanner(System.in);
        int opcao = 0;
        while (opcao != 5) {
            System.out.println("---- BEM VINDO ----");
            System.out.println("1. Adicionar Contato ");
            System.out.println("2. Buscar Contato");
            System.out.println("3. Listar Contatos");
            System.out.println("4. Editar Contato");
            System.out.println("5. Apagar Contato");
            System.out.println("6. Sair");
            System.out.println("----- AGENDA ------");
            System.out.print("Selecione a opção: ");
            opcao = tc.nextInt();
            switch (opcao) {
                case 1:
                    grava(adicionaContato());
                    System.out.println("OK! Contato adicionado a agenda :)");
                    break;
                case 2:
                    for (Contato c : buscarContato()) {
                        System.out.println(c);
                    }
                    break;
                case 3:
                    for (Contato c : busca()){
                        System.out.println(c);
                    }
                    break;
                case 4:
                    AtualizaContato();
                    System.out.println("OK! Feito");
                    break;
                case 5:
                    System.out.print("ID para deletar: ");
                    int id = tc.nextInt();
                    System.out.println(deleta(id));
                    
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("OPÇÃO INVÁLIDA");
                    menu();

            }
        }

    }

    public Contato adicionaContato() {
        System.out.print("Nome: ");
        String nome = tc.nextLine();
        System.out.print("Telefone: ");
        String telefone = tc.nextLine();
        System.out.println("Endereco: ");
        String endereco = tc.nextLine();
        System.out.print("Deseja Adicionar uma Anotação? ");
        String respostaAnotacao = tc.nextLine();
        switch (respostaAnotacao.toUpperCase()) {
            case "NAO":
                return new Contato(nome, telefone, endereco);
            case "SIM":
                System.out.print("Insira a Anotação: ");
                String anotacao = tc.nextLine();
                return new Contato(nome, telefone, endereco, anotacao);
            default:
                return new Contato(nome, telefone, endereco);
        }
    }

    public List<Contato> buscarContato() {
        System.out.println("Insira o que quer buscar: ");
        String strBusca = tc.nextLine();
        return busca(strBusca);
    }
    
    public void AtualizaContato(){
        System.out.print("Insira o ID do Contato: ");
        int id = Integer.parseInt(tc.nextLine());
        System.out.print("Insira o novo nome: ");
        String nome = tc.nextLine();
        System.out.print("Insira o novo telefone: ");
        String telefone = tc.nextLine();
        System.out.print("Insira o novo endereço: ");
        String endereco = tc.nextLine();
        System.out.print("Insira a nova anotação: ");
        String anotacao = tc.nextLine();
        if(nome.isEmpty() || telefone.isEmpty() || endereco.isEmpty()){
            System.out.println("Somente o campo anotacao pode ser nulo");
        } else {
            Contato c = new Contato(id, nome, telefone, endereco, anotacao);
            atualiza(c);
            System.out.println("Contato Atualizado:");
            System.out.println(c.toString());
        }
    }
}
