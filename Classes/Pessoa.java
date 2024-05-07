import java.util.Date;

public class Pessoa {
<<<<<<< HEAD
    private int id;
    private String nome;
    private String sexo;
    private Date nascimento;
    private String login;
    private String senha;
    private int tipoUsuario;
    private Date dataCriacao;
    private Date dataModificacao;

    // Construtor
    public Pessoa(int id, String nome, String sexo, Date nascimento, String login, String senha, int tipoUsuario, Date dataCriacao, Date dataModificacao) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.nascimento = nascimento;
        this.login = login;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    // Método toString para representação da Pessoa em String
    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                ", nascimento=" + nascimento +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                '}';
    }
}
=======
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
>>>>>>> vitor
