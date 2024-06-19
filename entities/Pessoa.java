package entities;


public class Pessoa {
    private static long serial;
    private long idPessoa;
    private String nomePessoa;
    private String sexoPessoa;
    private String dataNascimento;
    private String loginPessoa;
    private String senhaPessoa;
    private int tipoUsuarioPessoa;
    private String dataCriacao;
    private String dataModificacaoPessoa;

    // Construtor

    // Getters e Setters
    public Pessoa() { 
        idPessoa = Pessoa.serial++;
    }
    public long getId() {
        return idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nome) {
        this.nomePessoa = nome;
    }

    public String getdataCriacao()
    {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao)
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

    public String getDataModificacaoPessoa() {
        return dataModificacaoPessoa;
    }

    public void setDataModificacaoPessoa(String dataNascimento) {
        this.dataModificacaoPessoa = dataNascimento;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
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