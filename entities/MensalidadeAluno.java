
package entities;

import java.time.LocalDate;

public class MensalidadeAluno {
    private static long serial;
    private long id;
    private Pessoa aluno;
    private double valor;
    private int plano;
    private LocalDate dataPagamento;
    private MensalidadeVigente mensalidade;
    private LocalDate dataVencimento;
    private LocalDate dataModificacao;

    // Getters e Setters
    public void MensalidadeVigente(double valor, LocalDate dataVencimento) {
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

    public LocalDate getVencimento() {
        return dataVencimento;
    }

    public void setValor(Double valor)
    {
        this.valor = valor;
    }

    public double getValor(){
        return valor;
    }

    public void setVencimento(LocalDate vencimento) {
        this.dataVencimento = vencimento;
    }

    public MensalidadeVigente getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(MensalidadeVigente mensalidade) {
        this.mensalidade = mensalidade;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    
    @Override
    public String toString() {
        return "MensalidadeAluno{" +
                "id=" + id +
                ", aluno=" + aluno +
                ", dataVencimento=" + dataVencimento +
                ", valor=" + valor +
                ", mensalidade=" + mensalidade +
                ", dataPagamento=" + dataPagamento +
                ", dataModificacao=" + dataModificacao +
                '}';
    }
}
