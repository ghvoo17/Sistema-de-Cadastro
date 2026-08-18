package DAO;
//Aqui é onde fica o código do CRUD, q permite o desacoplamento e a mudança de BD.

import Model.Pessoa;
import Repository.ConnectionDerbyBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAOImpl implements PessoaDAO {


    @Override //Manter os métodos identicos ao da classe Pai
    public void inserir(Pessoa pessoa) {

        //String sql é criado dentro de cada metodo de acordo com a função
        String sql = "INSERT INTO pessoa (nome, idade, cep) VALUES (?, ?, ?)";

        try(    Connection conn = ConnectionDerbyBD.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setString(1, pessoa.getNome());
            pstmt.setInt(2, pessoa.getIdade());
            pstmt.setInt(3, pessoa.getCEP());

            pstmt.executeUpdate();
            System.out.println("Pessoa: " + pessoa.getNome() + " Cadastrada");
            pstmt.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Pessoa> listar() {

        // 1. Criamos a lista CORRETA de objetos Pessoa
        List<Pessoa> listPessoas = new ArrayList<>();

        String sql = "SELECT * FROM PESSOA";
        //String sql = "SELECT * FROM PESSOA WHERE ID = ?";

        try (Connection conn = ConnectionDerbyBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Percorre cada linha retornada do banco de dados
            while (rs.next()) {
                // 2. Criamos um objeto Pessoa para cada linha do banco
                Pessoa p = new Pessoa();

                // 3. Pegamos os dados das colunas e guardamos no objeto
                p.setId(rs.getInt("id"));       // Ajuste se o nome da coluna de ID for diferente
                p.setNome(rs.getString("nome")); // Copia o nome do banco para a Pessoa
                p.setIdade(rs.getInt("idade"));
                p.setCEP(rs.getInt("cep"));

                // 4. Adicionamos o objeto Pessoa completo na lista
                listPessoas.add(p);
            }

            // Exibe a lista preenchida para teste (opcional)
            System.out.println("--- Lista de Pessoas Encontradas ---");
            listPessoas.forEach(p -> {
                                                                                                                    //Usar chaves para mais códigos no metodo .forEach
                System.out.print(p.getId() + " - ");
                System.out.print(p.getNome() + " - ");
                System.out.print(p.getIdade() + " - ");
                System.out.println(p.getCEP());
        });

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 5. OBRIGATÓRIO: Retorna a lista populada para quem chamou o metodo
        return listPessoas;
    }

        //FAZER ESTA PARTE DE ATUALIZAR DADOS DO USUÁRIO
    @Override
    public void atualizar(int idAtualizar, int novaIdade, int novoCEP){

        //String sql é criado dentro de cada metodo de acordo com a função
        String sql = "UPDATE PESSOA SET idade = ?, cep = ? WHERE id = ?";

        try(    Connection conn = ConnectionDerbyBD.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setInt(1, novaIdade);
            pstmt.setInt(2, novoCEP);
            pstmt.setInt(3, idAtualizar);

            pstmt.executeUpdate();
            System.out.println("Usuário atualizado, idade: " + novaIdade + ", CEP: " + novoCEP);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deletar(int id){//Pessoa pessoa

        //String sql é criado dentro de cada metodo de acordo com a função
        String sql = "DELETE FROM PESSOA WHERE id = ?";

        try(    Connection conn = ConnectionDerbyBD.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setInt(1, id);

            pstmt.executeUpdate();
            System.out.println("Usuário deletado, id: " + id);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }



}
