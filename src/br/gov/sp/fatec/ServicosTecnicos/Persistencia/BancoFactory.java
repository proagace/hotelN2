/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.ServicosTecnicos.Persistencia;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Thiago
 */
public class BancoFactory {
    private static String usuario, senha, servidor, banco, port;
    private static Connection conexao;
    private static Properties config;
    static {
        config = new Properties();
        try {
            config.load(Files.newInputStream(Paths.get(System.getProperty("user.dir") + File.separator + "database.properties")));
        } catch (IOException ex) {
            Messages.showError("Erro ao ler arquivo de configurações: " + ex.getMessage());
            System.exit(1);
        }
        usuario = config.getProperty("DB_USER");
        senha = config.getProperty("DB_PASSWORD");
        servidor = config.getProperty("DB_ADDRESS");
        banco = config.getProperty("DB_BASE");
        port = config.getProperty("DB_PORT");
    }
    
    public static Connection abreBanco() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(
                    "jdbc:mysql://" + servidor +
                    ":" + port + "/" + banco, usuario, senha
            );
        } catch (ClassNotFoundException e) {
            Messages.showError("Driver não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            Messages.showError("Erro de conexão no banco: " + e.getMessage());
            System.exit(0);
        }
        return conexao;
    }
    
    public static void fechaBanco() {
        try {
            if (conexao != null)
                conexao.close();
        } catch (SQLException ex) {
            Messages.showError("Erro ao fechar o banco: " + ex.getMessage());
        }
    }
}
