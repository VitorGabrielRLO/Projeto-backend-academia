package entities;

import java.time.LocalDate;

public class AlunoPagamento {
    private long id;
    private double valor;
    private MensalidadeAluno plano;
    private Pessoa aluno;
    private int modalidade;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    private LocalDate vencimento;
    private LocalDate dataPagamento;

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public double getValor(){
        return valor;
    }

    public void setValor(double valor){
        this.valor = valor;
    }

    public MensalidadeAluno getPlano(){
        return plano;
    }
    public void setPlano(MensalidadeAluno plano)
    {
        this.plano = plano;
    }


    public void setVencimento(LocalDate vencimento)
    {
        this.vencimento = vencimento;
    }

    public LocalDate  getVencimento(){
        return vencimento;
    }


   
    public Pessoa getAluno() {
        return aluno;
    }

    public void setAluno(Pessoa aluno) {
        this.aluno = aluno;
    }

    public int getModalidade() {
        return modalidade;
    }

    public void setModalidade(int modalidade) {
        this.modalidade = modalidade;
    }

    public void setDataPagamento(LocalDate dataPagamento){
        this.dataPagamento = dataPagamento;
    }

    public LocalDate getDataPagamento()
    {
        return dataPagamento;
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
        return "AlunoPagamento{" +
                "id=" + id +
                ", aluno=" + aluno.getNomePessoa() +
                ", modalidade=" + modalidade +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                '}';
    }

}
