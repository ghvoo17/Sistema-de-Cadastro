package DAO.src.Repository;

import java.sql.Connection;
import java.sql.Statement;

public class dbtable {
    public static void criarTabelaPessoa() {

        String sql = """
            CREATE TABLE pessoa (
                id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                nome VARCHAR(100),
                idade INT,
                cep INT
            )
        """;

        try (
                Connection conn = ConnectionDerbyBD.getConnection();
                Statement stmt = conn.createStatement();
        ) {

            stmt.executeUpdate(sql);
            System.out.println("Tabela criada!");

        } catch (Exception e) {
            System.out.println("Tabela já existe.");
        }
    }
}
