import java.util.Date;

public class PagamentoRecorrente {
    private int id;
    private Pessoa aluno;
    private Date data;
    private String cartaoDeCredito;
    private Double valor;
    private Date dataInicio;
    private int numeroMeses;
    private Date dataCriacao;
    private Date dataModificacao;

    
    public PagamentoRecorrente(int id, Pessoa aluno, Date data, String cartaoDeCredito, Double valor, Date dataInicio, int numeroMeses, Date dataCriacao, Date dataModificacao) {
        this.id = id;
        this.aluno = aluno;
        this.data = data;
        this.cartaoDeCredito = cartaoDeCredito;
        this.valor = valor;
        this.dataInicio = dataInicio;
        this.numeroMeses = numeroMeses;
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

    public Pessoa getAluno() {
        return aluno;
    }

    public void setAluno(Pessoa aluno) {
        this.aluno = aluno;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
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

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public int getNumeroMeses() {
        return numeroMeses;
    }

    public void setNumeroMeses(int numeroMeses) {
        this.numeroMeses = numeroMeses;
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
