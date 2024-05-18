package general;

import java.util.Date;

public class EntradaAluno {
    private int id;
    private Date dataHora;
    private Date dataCriacao;
    private Date dataModificacao;

    // Construtor
    public EntradaAluno(int id, Date dataHora, Date dataCriacao, Date dataModificacao) {
        this.id = id;
        this.dataHora = dataHora;
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
