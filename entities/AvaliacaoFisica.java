package entities;


import java.util.Date;

public class AvaliacaoFisica {
    private static long serial;
    private long id;
    private Pessoa pessoa;
    private Treino ultimoTreino;
    private double peso;
    private double altura;
    private double imc;
    private double indiceSatisfacao;
    private Date dataCriacao;
    private Date dataModificacao;

    // Getters e Setters
    public AvaliacaoFisica() { 
        id = AvaliacaoFisica.serial++;
    }
    public long getId() {
        return id;
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
        return imc;
    }

    public void setIMC(double IMC) {
        this.imc = IMC;
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
                ", imc=" + imc +
                ", indiceSatisfacao=" + indiceSatisfacao +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                '}';
    }
}
