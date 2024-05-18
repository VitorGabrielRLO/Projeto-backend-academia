package general;


import java.util.Date;

import entities.Pessoa;
import entities.Treino;

public class AvaliacaoFisica {
    private int id;
    private Pessoa pessoa;
    private Treino ultimoTreino;
    private double peso;
    private double altura;
    private double IMC;
    private double indiceSatisfacao;
    private Date dataCriacao;
    private Date dataModificacao;

    // Construtor
    public AvaliacaoFisica(int id, Pessoa pessoa, Treino ultimoTreino, double peso, double altura, double IMC, double indiceSatisfacao, Date dataCriacao, Date dataModificacao) {
        this.id = id;
        this.pessoa = pessoa;
        this.ultimoTreino = ultimoTreino;
        this.peso = peso;
        this.altura = altura;
        this.IMC = IMC;
        this.indiceSatisfacao = indiceSatisfacao;
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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Treino getUltimoTreino() {
        return ultimoTreino;
    }

    public void setUltimoTreino(Treino ultimoTreino) {
        this.ultimoTreino = ultimoTreino;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getIMC() {
        return IMC;
    }

    public void setIMC(double IMC) {
        this.IMC = IMC;
    }

    public double getIndiceSatisfacao() {
        return indiceSatisfacao;
    }

    public void setIndiceSatisfacao(double indiceSatisfacao) {
        this.indiceSatisfacao = indiceSatisfacao;
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
        return "AvaliacaoFisica{" +
                "id=" + id +
                ", pessoa=" + pessoa +
                ", ultimoTreino=" + ultimoTreino +
                ", peso=" + peso +
                ", altura=" + altura +
                ", IMC=" + IMC +
                ", indiceSatisfacao=" + indiceSatisfacao +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                '}';
    }
}
