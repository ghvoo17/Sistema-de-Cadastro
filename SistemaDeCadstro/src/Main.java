import DAO.PessoaDAOImpl;
import Model.Pessoa;
import Repository.dbtable;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        dbtable.criarTabelaPessoa();
        Scanner sc = new Scanner(System.in);
        PessoaDAOImpl dao = new PessoaDAOImpl();


        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Idade: ");
        int idadePessoa = sc.nextInt();

        System.out.print("CEP: ");
        int CEP = sc.nextInt();


        Pessoa pessoa = new Pessoa(nome, idadePessoa, CEP);

        dao.inserir(pessoa);


        sc.close();
    }
}