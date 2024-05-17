import java.util.Date;

public class Exercicio {
    private int id;
    private String nomeExercicio;
    private String descricaoFoto;
    private Date dataCriacao;

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
