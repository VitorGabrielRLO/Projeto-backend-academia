package general;


import java.util.Date;

public class MovFinanceira {
    private int id;
    private double valor;
    private int tipo;
    private String descricao;
    private Date dataCriacao;
    private Date dataModificacao;

    // Construtor
    public MovFinanceira(int id, double valor, int tipo, String descricao, Date dataCriacao, Date dataModificacao) {
        this.id = id;
        this.valor = valor;
        this.tipo = tipo;
        this.descricao = descricao;
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
