
package general;

import java.util.Date;

import entities.Pessoa;

public class MensalidadeAluno {
    private int id;
    private Pessoa aluno;
    private Date vencimento;
    private MensalidadeVigente mensalidade;
    private Date dataCriacao;
    private Date dataModificacao;

    // Construtor
    public MensalidadeAluno(int id, Pessoa aluno, Date vencimento, MensalidadeVigente mensalidade, Date dataCriacao, Date dataModificacao) {
        this.id = id;
        this.aluno = aluno;
        this.vencimento = vencimento;
        this.mensalidade = mensalidade;
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

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public MensalidadeVigente getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(MensalidadeVigente mensalidade) {
        this.mensalidade = mensalidade;
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
        return "MensalidadeAluno{" +
                "id=" + id +
                ", aluno=" + aluno +
                ", vencimento=" + vencimento +
                ", mensalidade=" + mensalidade +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                '}';
    }
}
