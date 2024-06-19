package entities;

import java.time.LocalDate;
import java.util.Date;

public class AlunoPagamento {
    private static long serial;
    private long id;
    private MensalidadeVigente mensalidade;
    private Date data;
    private double valor;
    private String plano;
    private Pessoa aluno;
    private int modalidade;
    private Date dataCriacao;
    private LocalDate dataModificacao;
    private LocalDate vencimento;
    private LocalDate dataPagamento;

    // Getters e Setters
    public AlunoPagamento() { 
        id = AlunoPagamento.serial++;
    }
    public long getId() {
        return id;
    }


    public double getValor(){
        return valor;
    }

    public void setValor(double valor){
        this.valor = valor;
    }

    public String getPlano(){
        return plano;
    }
    public void setPlano(String plano)
    {
        this.plano = plano;
    }

    public MensalidadeVigente getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(MensalidadeVigente mensalidade) {
        this.mensalidade = mensalidade;
    }

    public void setVencimento(LocalDate vencimento)
    {
        this.vencimento = vencimento;
    }

    public LocalDate  getVencimento(){
        return vencimento;
    }


    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
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
                ", mensalidade=" + mensalidade +
                ", data=" + data +
                ", aluno=" + aluno +
                ", modalidade=" + modalidade +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                '}';
    }

}
