/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author PC
 */
public class Usuario {
    
    private int idUsuario;
    private String login;
    private String senha;
    
    
    public Usuario() {
        
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
   public class ConexaoBD {
    private static final String URL = "jdbc:mysql://localhost:3306/Sistema_de_venda_moveis_db_PI";
    private static final String USUARIO = "root";
    private static final String SENHA = "227442";

    public static Connection obterConexao() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
   
 public boolean salvar() {
        if (login == null || senha == null || login.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Login e senha são obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try (Connection conn = ConexaoBD.obterConexao()) {
            // Verifica se já existe um usuário com o mesmo login
            if (usuarioExistente(conn)) {
                JOptionPane.showMessageDialog(null, "Login já existe. Escolha outro login.", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            String sql = "INSERT INTO usuario (Login, Senha) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, login);
                stmt.setString(2, senha);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

       

    private boolean usuarioExistente(Connection conn) throws SQLException {
        String sql = "SELECT idUsuario FROM usuario WHERE Login = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, login);
            try (ResultSet resultSet = stmt.executeQuery()) {
                return resultSet.next();
            }
        }
    }
    public boolean excluirUsuario(int idUsuario) {
    try (Connection conn = ConexaoBD.obterConexao()) {
        // Verifica se o usuário existe antes de excluir
        if (!usuarioExistente(conn, idUsuario)) {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String sql = "DELETE FROM usuario WHERE idUsuario = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao excluir usuário.", "Erro", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}

private boolean usuarioExistente(Connection conn, int idUsuario) throws SQLException {
    String sql = "SELECT idUsuario FROM usuario WHERE idUsuario = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, idUsuario);
        try (ResultSet resultSet = stmt.executeQuery()) {
            return resultSet.next();
        }
    }
}

public boolean consultarUsuario(int idUsuario) {
    try (Connection conn = ConexaoBD.obterConexao()) {
        String sql = "SELECT * FROM usuario WHERE idUsuario = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    // Preencher as informações do usuário na classe
                    setIdUsuario(resultSet.getInt("idUsuario"));
                    setLogin(resultSet.getString("Login"));
                    setSenha(resultSet.getString("Senha"));
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao consultar usuário.", "Erro", JOptionPane.ERROR_MESSAGE);
        return false;
    }
  }
}
