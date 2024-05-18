package general;

import java.util.Date;

import entities.Pessoa;

public class AlunoPagamento {
    private int id;
    private MensalidadeVigente mensalidade;
    private Date data;
    private Pessoa aluno;
    private int modalidade;
    private Date dataCriacao;
    private Date dataModificacao;

    
    public AlunoPagamento(int id, MensalidadeVigente mensalidade, Date data, Pessoa aluno, int modalidade, Date dataCriacao, Date dataModificacao) {
        this.id = id;
        this.mensalidade = mensalidade;
        this.data = data;
        this.aluno = aluno;
        this.modalidade = modalidade;
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

    public MensalidadeVigente getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(MensalidadeVigente mensalidade) {
        this.mensalidade = mensalidade;
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
