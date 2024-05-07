import java.util.Date;

public class Pessoa {
    private static long serial;
    private long idPessoa;
    private String nomePessoa;
    private String sexoPessoa;
    private Date nascimentoPessoa;
    private String loginPessoa;
    private String senhaPessoa;
    private int tipoUsuarioPessoa;
    private Date dataCriacaoPessoa;
    private Date dataModificacaoPessoa;

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

    public Date getDataModificacaoPessoa() {
        return dataModificacaoPessoa;
    }

    public void setDataModificacaoPessoa(Date dataModificacao) {
        this.dataModificacaoPessoa = dataModificacao;
    }
    
    
    @Override
    public String toString() {
        return "ID: " + this.idPessoa + "\nNome: " + this.nomePessoa + "\nSexo: " + this.sexoPessoa + "\nLogin: " + this.loginPessoa + "\n";
    }

}