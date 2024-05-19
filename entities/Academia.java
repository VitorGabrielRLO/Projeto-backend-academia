package entities;

import java.util.Date;

public class Academia {
    private static long serial;
    private long id;
    private String nome;
    private String endereco;
    private String dataCriacao;
    private Date dataModificacao;

    public Academia() { 
        id = Academia.serial++;
    }
    public long getId() {
        return id;
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
    public String getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    public Date getDataModificacao() {
        return dataModificacao;
    }
    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    @Override
    public String toString() {
        return "Academia{" +
                "id=" + id +
                ", Nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}
