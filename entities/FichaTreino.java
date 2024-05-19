package entities;
import java.time.LocalDate;

import java.util.Date;

public class FichaTreino {
    private static long serial;
    private long id;
    private Academia academia;
    private Pessoa pessoa;
    private DivisaoTreino divisao;
    private Treino treino;
    private LocalDate dataInicio;
    private LocalDate dataFim;

	public FichaTreino() { 
        id = FichaTreino.serial++;
    }
    public long getId() {
        return id;
    }
	public Academia getAcademia() {
		return academia;
	}
	public void setAcademia(Academia academia) {
		this.academia = academia;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public DivisaoTreino getDivisao() {
		return divisao;
	}
	public void setDivisao(DivisaoTreino divisao) {
		this.divisao = divisao;
	}
	public Treino getTreino() {
		return treino;
	}
	public void setTreino(Treino treino) {
		this.treino = treino;
	}
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	public LocalDate getDataFim() {
		return dataFim;
	}
	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
}