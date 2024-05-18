package entities;

import java.util.Date;

public class Exercicio {
    private static long serial;
    private long id;
    private String nomeExercicio;
    private String descricaoFoto;
    private Date dataCriacao;
    private Date dataModificacao;

    // Getters e Setters
    public Exercicio() { 
        id = Exercicio.serial++;
    }
    public long getId() {
        return id;
    }

    public String getNomeExercicio() {
        return nomeExercicio;
    }

    public void setNomeExercicio(String nomeExercicio) {
        this.nomeExercicio = nomeExercicio;
    }

    public String getDescricaoFoto() {
        return descricaoFoto;
    }

    public void setDescricaoFoto(String descricaoFoto) {
        this.descricaoFoto = descricaoFoto;
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

    @Override
    public String toString() {
        return "Exercicio{" +
                "id=" + id +
                ", nomeExercicio='" + nomeExercicio + '\'' +
                ", descricaoFoto='" + descricaoFoto + '\'' +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}
