package Sistema;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author PC
 */
public class Cliente {

    /**
     *
     * @param cpf
     * @return
     */
    private int idCliente;
    private String nome;
    private String endereco;
    private String telefone;
    private String cpf;
    private String rg;
    private String uf;
    private String cidade;
    private String data;
    private String email;

    public Cliente() {

    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static boolean validarNome(String nome) {
        return !nome.isEmpty();
    }

    public static boolean validarData(String data) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
            dateFormat.setLenient(false);
            Date parsedDate = dateFormat.parse(data);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }

    public static boolean validarEndereco(String endereco) {
        return !endereco.isEmpty();
    }

    public static boolean validarTelefone(String telefone) {
        return !telefone.isEmpty();
    }

    public static boolean validarCpf(String cpf) {
        return !cpf.isEmpty() && cpf.matches("\\d{11}");
    }

    public static boolean validarRg(String rg) {
        return !rg.isEmpty();
    }

    public static boolean validarUf(String uf) {
        return !uf.isEmpty() && uf.length() == 2;
    }

    public static boolean validarCidade(String cidade) {
        return !cidade.isEmpty();
    }

    public static boolean validarEmail(String email) {
        return !email.isEmpty() && email.matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$");
    }

}
