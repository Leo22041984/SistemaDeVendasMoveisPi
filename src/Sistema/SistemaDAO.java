/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;

/**
 *
 * @author PC
 */
public class SistemaDAO {

    Connection con;

    PreparedStatement st;

    public boolean conectar() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sistema_de_venda_moveis_db_PI", "root", "227442");
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return false;
        }
    }

    public int Salvar(Cliente cl) {

        int Status;

        try {
            // Convertendo a string da data para o formato 'yyyy-MM-dd'
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
            java.util.Date parsedDate = dateFormat.parse(cl.getData());
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());

            st = con.prepareStatement("INSERT INTO Cliente VALUES (?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, cl.getIdCliente());
            st.setString(2, cl.getNome());
            st.setString(3, cl.getEndereco());
            st.setString(4, cl.getTelefone());
            st.setString(5, cl.getCpf());
            st.setString(6, cl.getRg());
            st.setString(7, cl.getUf());
            st.setString(8, cl.getCidade());
            st.setDate(9, sqlDate);
            st.setString(10, cl.getEmail());

            int status = st.executeUpdate();
            return status;
        } catch (SQLException | ParseException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return ex instanceof SQLException ? ((SQLException) ex).getErrorCode() : 0;
        }
    }

    public Cliente consultarClientePorId(int idCliente) {
        try {
            st = con.prepareStatement("SELECT * FROM Cliente WHERE idCliente = ?");
            st.setInt(1, idCliente);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return criarClienteAPartirResultSet(rs);
                // Preencher os dados do cliente

            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar cliente: " + ex.getMessage());
            return null;
        }
    }

    public int excluirClientePorId(int id) {
        try {
            st = con.prepareStatement("DELETE FROM Cliente WHERE idCliente = ?");
            st.setInt(1, id);

            return st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir cliente por ID: " + ex.getMessage());
            return -1;
        }
    }

    private Cliente criarClienteAPartirResultSet(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(rs.getInt("idCliente"));
        cliente.setNome(rs.getString("nome"));
        cliente.setEndereco(rs.getString("endereco"));
        cliente.setTelefone(rs.getString("telefone"));
        cliente.setCpf(rs.getString("cpf"));
        cliente.setRg(rs.getString("rg"));
        cliente.setUf(rs.getString("uf"));
        cliente.setCidade(rs.getString("cidade"));

        // Formatando a data de nascimento
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dataFormatada = sdf.format(rs.getDate("Data_de_nacimento"));

        cliente.setData(dataFormatada);

        cliente.setEmail(rs.getString("email"));

        return cliente;
    }

    public void desconectar() {
        try {
            con.close();
        } catch (SQLException ex) {

        }
    }

}
