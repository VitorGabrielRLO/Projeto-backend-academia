package entities;

import java.util.Date;

public class TreinoAplicacao {
    private long id;
    private Treino treino;
    private Exercicio exercicio;
    private ExercicioAplicacao exercicioAplicacao;
    private DivisaoTreino divisaoTreino;
    private Date dataCriacao;
    private Date dataModificacao;

    // Construtores
    public TreinoAplicacao() {
    }

    public TreinoAplicacao(long id, Treino treino, Exercicio exercicio, ExercicioAplicacao exercicioAplicacao, DivisaoTreino divisaoTreino, Date dataCriacao, Date dataModificacao) {
        this.id = id;
        this.treino = treino;
        this.exercicio = exercicio;
        this.exercicioAplicacao = exercicioAplicacao;
        this.divisaoTreino = divisaoTreino;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }

    // Getters e Setters
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public Treino getTreino() {
        return treino;
    }

    public void setTreino(Treino treino) {
        this.treino = treino;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    public ExercicioAplicacao getExercicioAplicacao() {
        return exercicioAplicacao;
    }

    public void setExercicioAplicacao(ExercicioAplicacao exercicioAplicacao) {
        this.exercicioAplicacao = exercicioAplicacao;
    }

    public DivisaoTreino getDivisaoTreino() {
        return divisaoTreino;
    }

    public void setDivisaoTreino(DivisaoTreino divisaoTreino) {
        this.divisaoTreino = divisaoTreino;
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
        return  "\n"+ exercicio.getNomeExercicio() + 
                "    " + exercicioAplicacao.getDescricao() +
                "\n\n";
    }
}
