package br.com.Amaro.DB;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public abstract class Conexao {
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost/agenda", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
