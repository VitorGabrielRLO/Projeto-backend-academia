package entities;

import java.util.Date;

public class DivisaoTreino {
    private static long serial;
    private long id;
    private String nome;
    private String nomeDetalhado;
    private String dataCriacao;
    private String dataModificacao;

    // Getters e Setters
    public DivisaoTreino() { 
        id = DivisaoTreino.serial++;
    }
    public long getId() {
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

    public String getNomeDetalhado() {
        return nomeDetalhado;
    }

    public void setNomeDetalhado(String nomeDetalhado) {
        this.nomeDetalhado = nomeDetalhado;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
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
        return "DivisaoTreino{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nomeDetalhado='" + nomeDetalhado + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                '}';
    }
}
