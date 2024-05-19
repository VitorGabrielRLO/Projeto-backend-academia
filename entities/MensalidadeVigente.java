package entities;


import java.util.Date;

public class MensalidadeVigente {
    private static long serial;
    private long id;
    private double valor;
    private Date inicio;
    private Date termino;
    private Date dataCriacao;
    private Date dataModificacao;

    // Getters e Setters
    public MensalidadeVigente() { 
        id = MensalidadeVigente.serial++;
    }
    public long getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
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
        return "MensalidadeVigente{" +
                "id=" + id +
                ", valor=" + valor +
                ", inicio=" + inicio +
                ", termino=" + termino +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                '}';
    }
}
