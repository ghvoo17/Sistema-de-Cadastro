package Model;

public class Pessoa {
//Atributos
    private Integer id;
    private String nome;
    private Integer idade;
    private Integer CEP;

//Constructor
    public Pessoa(Integer id,String nome, Integer idade, Integer CEP){
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.CEP = CEP;
    }

    public Pessoa(String nome, Integer idade, Integer CEP){
        this.nome = nome;
        this.idade = idade;
        this.CEP = CEP;
    }

    public Pessoa() {

    }

    //Getters e Setters
    public  Integer getId(){
        return id;
    }
    public Integer getIdade() {
        return idade;
    }
    public Integer getCEP(){
        return CEP;
    }
    public String getNome(){
        return nome;
    }

    public void setCEP(Integer novoCEP){
        if (novoCEP != null){
            this.CEP = novoCEP;
        }

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
}
