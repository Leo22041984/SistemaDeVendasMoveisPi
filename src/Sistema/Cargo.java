/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.JTextField;

/**
 *
 * @author PC
 */
public class Cargo {

    private int idCargo;
    private String descricaoCargo;
    private Double salarioCargo;
    private int comissao;

    /**
     *
     */
    public Cargo() {

    }

    /**
     *
     * @return
     */
    public int getIdCargo() {
        return idCargo;
    }

    /**
     *
     * @param idCargo
     */
    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    /**
     *
     * @return
     */
    public String getDescricaoCargo() {
        return descricaoCargo;
    }

    /**
     *
     * @param descricaoCargo
     */
    public void setDescricaoCargo(String descricaoCargo) {
        this.descricaoCargo = descricaoCargo;
    }

    /**
     *
     * @return
     */
    public Double getSalarioCargo() {
        return salarioCargo;
    }

    /**
     *
     * @param salarioCargo
     */
    public void setSalarioCargo(Double salarioCargo) {
        this.salarioCargo = salarioCargo;
    }

    /**
     *
     * @return
     */
    public int getComissao() {
        return comissao;
    }

    /**
     *
     * @param comissao
     */
    public void setComissao(int comissao) {
        this.comissao = comissao;
    }

    /**
     *
     */
    public void cadastrarCargo() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sistema_de_venda_moveis_db_PI", "root", "227442");
            String query = "INSERT INTO cargo (Descricao_Cargo, Salario_Cargo, Comissao_Cargo) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, descricaoCargo);
            pstmt.setDouble(2, salarioCargo);
            pstmt.setInt(3, comissao);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cargo cadastrado com sucesso!");
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cargo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     *
     * @param idCargo
     */
    public void excluirCargo(int idCargo) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sistema_de_venda_moveis_db_PI", "root", "227442");
            String query = "DELETE FROM cargo WHERE idCargo = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, idCargo);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Cargo excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Cargo com id " + idCargo + " não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir cargo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     *
     * @param idCargo
     * @param txtDescricao
     * @param txtSalario
     * @param txtComissao
     */
    public void consultarCargo(int idCargo, JTextField txtDescricao, JTextField txtSalario, JTextField txtComissao) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sistema_de_venda_moveis_db_PI", "root", "227442");
            String query = "SELECT Descricao_Cargo, Salario_Cargo, Comissao_Cargo FROM cargo WHERE idCargo = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, idCargo);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                txtDescricao.setText(rs.getString("Descricao_Cargo"));
                txtSalario.setText(String.valueOf(rs.getDouble("Salario_Cargo")));
                txtComissao.setText(String.valueOf(rs.getInt("Comissao_Cargo")));
            } else {
                JOptionPane.showMessageDialog(null, "Cargo com id " + idCargo + " não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar cargo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}
