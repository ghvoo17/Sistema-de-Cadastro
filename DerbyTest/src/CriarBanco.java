import java.sql.Connection;
import java.sql.DriverManager;

public class CriarBanco {

    public static void main(String[] args){

        String url = "jdbc:derby:meuBanco;create=true"; // URL que é o caminho onde esta o BD

        try { //Tentar
            Connection conn = DriverManager.getConnection(url); // Cria uma conexão com o DM e seu método para a classe Connection
            System.out.println("Banco criado com sucesso!");
            conn.close();
        } catch (Exception e) { //Lançar uma excessão
            e.printStackTrace();
        }
    }



    }
