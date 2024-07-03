package entities;

import java.time.LocalDate;

public class Pessoa {
    private long idPessoa;
    private String nomePessoa;
    private String sexoPessoa;
    private LocalDate dataNascimento;
    private String loginPessoa;
    private String senhaPessoa;
    private int tipoUsuarioPessoa;
    private LocalDate dataCriacao;
    private LocalDate dataModificacaoPessoa;

    // Construtor

    // Getters e Setters
    public long getId() {
        return idPessoa;
    }

    public void setId(long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nome) {
        this.nomePessoa = nome;
    }

    public LocalDate getdataCriacao()
    {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao)
    {
        this.dataCriacao = dataCriacao;
    }

    public String getSexoPessoa() {
        return sexoPessoa;
    }

    public void setSexoPessoa(String sexo) {
        this.sexoPessoa = sexo;
    }

    public String getLoginPessoa() {
        return loginPessoa;
    }

    public void setLoginPessoa(String login) {
        this.loginPessoa = login;
    }

    public String getSenhaPessoa() {
        return senhaPessoa;
    }

    public void setSenhaPessoa(String senha) {
        this.senhaPessoa = senha;
    }

    public int getTipoUsuarioPessoa(){
        return tipoUsuarioPessoa;
    }

    public void setTipoUsuarioPessoa(int tipo){
        this.tipoUsuarioPessoa = tipo;
    }

    public LocalDate getDataModificacaoPessoa() {
        return dataModificacaoPessoa;
    }

    public void setDataModificacaoPessoa(LocalDate dataNascimento) {
        this.dataModificacaoPessoa = dataNascimento;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    
    @Override
    public String toString() {
        return "\n\nID: " + this.idPessoa + "\nNome: " 
        + this.nomePessoa + "\nSexo: " + this.sexoPessoa + "\nLogin: " + this.loginPessoa 
        + "\nData de nascimento: " + this.dataNascimento + "\nData Criação Perfil: " + this.dataCriacao +
        "\nData modificação: " + this.dataModificacaoPessoa;
    }

}