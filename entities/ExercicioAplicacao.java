package entities;


import java.util.Date;

public class ExercicioAplicacao {
    private static long serial;
    private long id;
    private String descricao;
    private Date dataCriacao;
    private Date dataModificacao;

    // Getters e Setters
    public ExercicioAplicacao() { 
        id = ExercicioAplicacao.serial++;
    }
    public long getId() {
        return id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
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
        return "ExercicioAplicacao{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                '}';
    }
}
