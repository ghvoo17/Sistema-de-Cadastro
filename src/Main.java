import DAO.PessoaDAOImpl;
import Model.Pessoa;
import Repository.dbtable;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       dbtable.criarTabelaPessoa();
        Scanner sc = new Scanner(System.in);
        PessoaDAOImpl dao = new PessoaDAOImpl();

        int opcao;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Inserir usuário");
            System.out.println("2 - Listar todos");
            System.out.println("3 - Deletar usuário");
            System.out.println("4 - Atualizar dados");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();


            switch (opcao) {
                case 1:
                    //Cadastro
                    System.out.print("Nome: ");
                    String nome = sc.next();

                    System.out.print("Idade: ");
                    int idadePessoa = sc.nextInt();

                    System.out.print("CEP: ");
                    int CEP = sc.nextInt();

                    Pessoa pessoa = new Pessoa(nome, idadePessoa, CEP);
                    dao.inserir(pessoa);
                    break;
                case 2:
                    dao.listar();
                    break;
                case 3:
                    System.out.print("Insira o ID que deseja deletar: ");
                    int id = sc.nextInt();

                    dao.deletar(id);

                    break;
                case 4:
                    //ATUALIZAR
                    System.out.println("Insira os novos dados a serem atualizados");

                    System.out.print("Digite seu ID: ");
                    int idAtualizar = sc.nextInt();

                    System.out.print("Digite sua nova idade: ");
                    int novaIdade = sc.nextInt();

                    System.out.print("Digite seu novo CEP: ");
                    int novoCEP = sc.nextInt();

                    dao.atualizar(idAtualizar, novaIdade, novoCEP);

                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);


        sc.close();
    }
}