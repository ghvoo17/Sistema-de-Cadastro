package DAO.src.DAO;
//Aqui é onde fica o código do CRUD, q permite o desacoplamento e a mudança de BD.

import DAO.src.Model.Pessoa;
import DAO.src.Repository.ConnectionDerbyBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class PessoaDAOImpl implements PessoaDAO {


    @Override //Manter os métodos identicos ao da classe Pai
    public void inserir(Pessoa pessoa) {
        //String sql é criado dentro de cada método de acordo com a função
        String sql = "INSERT INTO pessoa (nome, idade, cep) VALUES (?, ?, ?)";

        try(Connection conn = ConnectionDerbyBD.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setString(1, pessoa.getNome());
            pstmt.setInt(2, pessoa.getIdade());
            pstmt.setInt(3, pessoa.getCEP());

            pstmt.execute();
            System.out.println("Pessoa: " + pessoa.getNome() + " Cadastrada");
            pstmt.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Pessoa> listar() {
        return List.of();
    }


}
