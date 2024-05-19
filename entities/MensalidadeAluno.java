
package entities;

import java.util.Date;

public class MensalidadeAluno {
    private static long serial;
    private long id;
    private Pessoa aluno;
    private double valor;
    private int plano;
    private Date dataPagamento;
    private MensalidadeVigente mensalidade;
    private Date dataVencimento;
    private Date dataModificacao;

    // Getters e Setters
    public void MensalidadeVigente(double valor, Date dataVencimento) {
        this.valor = valor;
        this.dataVencimento = dataVencimento;
    }
    public long getId() {
        return id;
    }

    public void setPlano(int plano)
    {
        this.plano = plano;
    }

    public int  getPlano()
    {
        return plano;
    }

    // public Pessoa getAluno() {
    //     return aluno;
    // }

    // public void setAluno(Pessoa aluno) {
    //     this.aluno = aluno;
    // }

    public Date getVencimento() {
        return dataVencimento;
    }

    public void setValor(Double valor)
    {
        this.valor = valor;
    }

    public double getValor(){
        return valor;
    }

    public void setVencimento(Date vencimento) {
        this.dataVencimento = vencimento;
    }

    public MensalidadeVigente getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(MensalidadeVigente mensalidade) {
        this.mensalidade = mensalidade;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    
    @Override
    public String toString() {
        return "MensalidadeAluno{" +
                "id=" + id +
                ", aluno=" + aluno +
                ", dataVencimento=" + dataVencimento +
                ", mensalidade=" + mensalidade +
                ", dataPagamento=" + dataPagamento +
                ", dataModificacao=" + dataModificacao +
                '}';
    }
}
