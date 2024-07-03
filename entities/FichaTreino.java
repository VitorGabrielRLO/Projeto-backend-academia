package entities;
import java.time.LocalDate;

public class FichaTreino {
    private long id;
    private Pessoa pessoa;
    private DivisaoTreino divisao;
    private Treino treino;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public long getId() {
        return id;
    }
	public void setId(long id) {
        this.id = id;
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

	@Override
    public String toString() {
        return "Ficha De Treino{\n" +
                "---------------------------------\nNome: " + pessoa.getNomePessoa() +
                "Divsao do Treino: " + divisao.getNome() +
                "\nDescrição: " + divisao.getNomeDetalhado() +
                "\nData Inicio: " + dataInicio +
                "\nData Fim: " + dataFim +
                "\n------------------------------\n" + 
				"Exercicios: " + treino.getExercicio() +
				"}";
    }
}