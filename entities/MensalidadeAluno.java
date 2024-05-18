
package entities;

import java.util.Date;

public class MensalidadeAluno {
    private static long serial;
    private long id;
    private Pessoa aluno;
    private Date vencimento;
    private MensalidadeVigente mensalidade;
    private Date dataCriacao;
    private Date dataModificacao;

    // Getters e Setters
    public MensalidadeAluno() { 
        id = MensalidadeAluno.serial++;
    }
    public long getId() {
        return id;
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
