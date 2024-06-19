package entities;


import java.time.LocalDate;

public class MovFinanceira {
    private static long serial;
    private long id;
    private double valor;
    private int tipo;
    private String descricao;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

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

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
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
