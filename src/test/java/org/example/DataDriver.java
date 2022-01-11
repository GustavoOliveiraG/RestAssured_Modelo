package org.example;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataDriver {
    ConexaoMySQL conexaoMySQL;

    @Test
    public void TesteDataDriver() throws SQLException {
        conexaoMySQL = new ConexaoMySQL();
        conexaoMySQL.getConexaoMySQL();
        System.out.println(ConexaoMySQL.statusConection());

        Connection conexao = conexaoMySQL.getConexaoMySQL();
        PreparedStatement stmt = null;

        stmt = conexao.prepareStatement("DELETE FROM mantis_user_table WHERE id = 128");
        stmt.executeUpdate();

    }


}
