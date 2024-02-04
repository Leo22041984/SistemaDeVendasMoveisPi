/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author PC
 */
public class Produto {
    
    private int idProduto;
    private String nomeProduto;
    private String descricao;
    private int qtdEstoque;
    private String fabricacao;
    private Double valorUnitario;
    
    public Produto() {
        
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public String getFabricacao() {
        return fabricacao;
    }

    public void setFabricacao(String fabricacao) {
        this.fabricacao = fabricacao;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    
    // Métodos para manipulação do banco de dados
    public void cadastrarProduto() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sistema_de_venda_moveis_db_PI","root", "227442");
            String sql = "INSERT INTO produto (Nome_Produto, Descricao, Qtd_estoque, Fabricante, Valor_unitario) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, getNomeProduto());
            stmt.setString(2, getDescricao());
            stmt.setInt(3, getQtdEstoque());
            stmt.setString(4, getFabricacao());
            stmt.setDouble(5, getValorUnitario());

            stmt.executeUpdate();

            // Fechar recursos
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para limpar os campos
    public void limparCampos() {
        setIdProduto(0);
        setNomeProduto("");
        setDescricao("");
        setQtdEstoque(0);
        setFabricacao("");
        setValorUnitario(0.0);
    }

    // Método para excluir um produto
    public void excluirProduto(int idProduto) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sistema_de_venda_moveis_db_PI","root", "227442");
            String sql = "DELETE FROM produto WHERE idProduto = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idProduto);

            stmt.executeUpdate();

            // Fechar recursos
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean verificarExistenciaProduto(int idProduto) {
    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sistema_de_venda_moveis_db_PI","root", "227442");
        String sql = "SELECT COUNT(*) FROM produto WHERE idProduto = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idProduto);

        ResultSet rs = stmt.executeQuery();
        rs.next();

        int count = rs.getInt(1);

        // Se o count for maior que 0, o produto existe
        return count > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false; // Em caso de erro, assume-se que o produto não existe
    }
}
 
    
}
