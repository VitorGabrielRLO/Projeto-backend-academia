package entities;

import java.util.Date;

public class EntradaAluno {
    private static long serial;
    private long id;
    private Date dataHora;
    private Date dataCriacao;
    private Date dataModificacao;

    // Getters e Setters
    public EntradaAluno() { 
        id = EntradaAluno.serial++;
    }
    public long getId() {
        return id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
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

    
    @Override
    public String toString() {
        return "EntradaAluno{" +
                "id=" + id +
                ", dataHora=" + dataHora +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                '}';
    }
}
