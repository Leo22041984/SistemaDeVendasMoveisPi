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
public class Funcionario {

    private int idFuncionario;
    private String nomeFuncionario;
    private String endereco;
    private String cpf;
    private String telefone;
    private int usuarioIdUsuario;
    private int cargoIdCargo;
    private Connection con;

    /**
     *
     */
    public Funcionario() {
        // Conectar ao banco de dados ao instanciar um Funcionario
        conectar();

    }

    /**
     *
     * @return
     */
    public int getIdFuncionario() {
        return idFuncionario;
    }

    /**
     *
     * @param idFuncionario
     */
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     *
     * @return
     */
    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    /**
     *
     * @param nomeFuncionario
     */
    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    /**
     *
     * @return
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     *
     * @param endereco
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     *
     * @return
     */
    public String getCpf() {
        return cpf;
    }

    /**
     *
     * @param cpf
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     *
     * @return
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     *
     * @param telefone
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     *
     * @return
     */
    public int getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    /**
     *
     * @param usuarioIdUsuario
     */
    public void setUsuarioIdUsuario(int usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    /**
     *
     * @return
     */
    public int getCargoIdCargo() {
        return cargoIdCargo;
    }

    /**
     *
     * @param cargoIdCargo
     */
    public void setCargoIdCargo(int cargoIdCargo) {
        this.cargoIdCargo = cargoIdCargo;
    }

    public boolean conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sistema_de_venda_moveis_db_PI", "root", "227442");
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar: " + ex.getMessage());
            return false;
        }
    }

    public boolean cadastrarFuncionario() {
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM funcionario WHERE CPF = ?");
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "CPF já cadastrado.");
                return false;
            }

            stmt = con.prepareStatement("SELECT * FROM usuario WHERE idUsuario = ?");
            stmt.setInt(1, usuarioIdUsuario);
            rs = stmt.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "ID de usuário inválido.");
                return false;
            }

            stmt = con.prepareStatement("SELECT * FROM cargo WHERE idCargo = ?");
            stmt.setInt(1, cargoIdCargo);
            rs = stmt.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "ID de cargo inválido.");
                return false;
            }

            stmt = con.prepareStatement("INSERT INTO funcionario (Nome_Funcionario, Endereco, CPF, Telefone, Usuario_idUsuario, Cargo_idCargo) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, nomeFuncionario);
            stmt.setString(2, endereco);
            stmt.setString(3, cpf);
            stmt.setString(4, telefone);
            stmt.setInt(5, usuarioIdUsuario);
            stmt.setInt(6, cargoIdCargo);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso.");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao cadastrar funcionário.");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionário: " + ex.getMessage());
            return false;
        }
    }

    public boolean excluirFuncionario(int idFuncionario) {
        try {
            PreparedStatement stmt = con.prepareStatement("DELETE FROM funcionario WHERE idFuncionario = ?");
            stmt.setInt(1, idFuncionario);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Funcionário excluído com sucesso.");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Funcionário não encontrado.");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir funcionário: " + ex.getMessage());
            return false;
        }
    }

    public Funcionario consultarFuncionario(int idFuncionario) {
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM funcionario WHERE idFuncionario = ?");
            stmt.setInt(1, idFuncionario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
                funcionario.setNomeFuncionario(rs.getString("Nome_Funcionario"));
                funcionario.setEndereco(rs.getString("Endereco"));
                funcionario.setCpf(rs.getString("CPF"));
                funcionario.setTelefone(rs.getString("Telefone"));
                funcionario.setUsuarioIdUsuario(rs.getInt("Usuario_idUsuario"));
                funcionario.setCargoIdCargo(rs.getInt("Cargo_idCargo"));
                return funcionario;
            } else {
                JOptionPane.showMessageDialog(null, "Funcionário não encontrado.");
                return null;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar funcionário: " + ex.getMessage());
            return null;
        }
    }

}
