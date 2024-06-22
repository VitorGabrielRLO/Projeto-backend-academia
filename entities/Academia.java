package entities;

import java.time.LocalDate;

public class Academia {
    private static long serial;
    private long id;
    private String nome;
    private String endereco;
    private LocalDate dataCriacao;
    private String dataModificacao;

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
    public LocalDate getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    public String getDataModificacao() {
        return dataModificacao;
    }
    public void setDataModificacao(String dataModificacao) {
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
