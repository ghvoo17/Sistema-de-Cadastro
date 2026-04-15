package DAO;

import Model.Pessoa;
import java.util.List;

//Aqui diz oq vai ter no CRUD
public interface PessoaDAO {

    void inserir(Pessoa pessoa);

    List<Pessoa> listar();
}
