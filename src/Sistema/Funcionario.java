/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

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

    /**
     *
     */
    public Funcionario() {

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

}
