package entities;


import java.util.Date;

public class MovFinanceira {
    private static long serial;
    private long id;
    private double valor;
    private int tipo;
    private String descricao;
    private Date dataCriacao;
    private Date dataModificacao;

    // Getters e Setters
    public MovFinanceira() { 
        id = MovFinanceira.serial++;
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        return "MovFinanceira{" +
                "id=" + id +
                ", valor=" + valor +
                ", tipo=" + tipo +
                ", descricao='" + descricao + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                '}';
    }
}
