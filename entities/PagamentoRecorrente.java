package entities;


import java.time.LocalDate;

public class PagamentoRecorrente {
    private long id;
    private Pessoa aluno;
    private LocalDate data;
    private String cartaoDeCredito;
    private Double valor;
    private LocalDate dataInicio;
    private int numeroMeses;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    // Getters e Setters

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Pessoa getAluno() {
        return aluno;
    }

    public void setAluno(Pessoa aluno) {
        this.aluno = aluno;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getCartaoDeCredito() {
        return cartaoDeCredito;
    }

    public void setCartaoDeCredito(String cartaoDeCredito) {
        this.cartaoDeCredito = cartaoDeCredito;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public int getNumeroMeses() {
        return numeroMeses;
    }

    public void setNumeroMeses(int numeroMeses) {
        this.numeroMeses = numeroMeses;
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
        return "PagamentoRecorrente{" +
                "id=" + id +
                ", aluno=" + aluno +
                ", data=" + data +
                ", cartaoDeCredito='" + cartaoDeCredito + '\'' +
                ", valor=" + valor +
                ", dataInicio=" + dataInicio +
                ", numeroMeses=" + numeroMeses +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                '}';
    }
}
