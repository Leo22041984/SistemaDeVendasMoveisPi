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

    /**
     *
     */
    public Cliente() {

    }

    /**
     *
     * @return
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     *
     * @param idCliente
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
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
    public String getRg() {
        return rg;
    }

    /**
     *
     * @param rg
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     *
     * @return
     */
    public String getUf() {
        return uf;
    }

    /**
     *
     * @param uf
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     *
     * @return
     */
    public String getCidade() {
        return cidade;
    }

    /**
     *
     * @param cidade
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     *
     * @return
     */
    public String getData() {
        return data;
    }

    /**
     *
     * @param data
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @param nome
     * @return
     */
    public static boolean validarNome(String nome) {
        return !nome.isEmpty();
    }

    /**
     *
     * @param data
     * @return
     */
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

    /**
     *
     * @param endereco
     * @return
     */
    public static boolean validarEndereco(String endereco) {
        return !endereco.isEmpty();
    }

    /**
     *
     * @param telefone
     * @return
     */
    public static boolean validarTelefone(String telefone) {
        return !telefone.isEmpty();
    }

    /**
     *
     * @param cpf
     * @return
     */
    public static boolean validarCpf(String cpf) {
        return !cpf.isEmpty() && cpf.matches("\\d{11}");
    }

    /**
     *
     * @param rg
     * @return
     */
    public static boolean validarRg(String rg) {
        return !rg.isEmpty();
    }

    /**
     *
     * @param uf
     * @return
     */
    public static boolean validarUf(String uf) {
        return !uf.isEmpty() && uf.length() == 2;
    }

    /**
     *
     * @param cidade
     * @return
     */
    public static boolean validarCidade(String cidade) {
        return !cidade.isEmpty();
    }

    /**
     *
     * @param email
     * @return
     */
    public static boolean validarEmail(String email) {
        return !email.isEmpty() && email.matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$");
    }

}
