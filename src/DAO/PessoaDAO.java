package DAO;

import Model.Pessoa;
import java.util.List;

//Aqui diz oq vai ter no CRUD
public interface PessoaDAO {

    void inserir(Pessoa pessoa);

    List<Pessoa> listar();

    void deletar(int id);

    void atualizar(int idAtualizar, int novaIdade, int novoCEP);
}
