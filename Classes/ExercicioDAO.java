import java.util.ArrayList;
import java.util.List;

public class ExercicioDAO {
    private List<Exercicio> exercicios;

    // Construtor
    public ExercicioDAO() {
        this.exercicios = new ArrayList<>();
    }

    // Método para adicionar um exercício
    public boolean adicionarExercicio(Exercicio exercicio) {
        return exercicios.add(exercicio);
    }

    // Método para remover um exercício pelo ID
    public boolean removerExercicio(int id) {
        for (Exercicio exercicio : exercicios) {
            if (exercicio.getId() == id) {
                return exercicios.remove(exercicio);
            }
        }
        return false;
    }

    // Método para obter todos os exercícios
    public List<Exercicio> obterTodosExercicios() {
        return new ArrayList<>(exercicios); // Retorna uma cópia da lista para evitar a modificação direta da lista original
    }
    
    // Método para obter um exercício pelo índice
    public Exercicio obterExercicioPorIndice(int indice) {
        if (indice >= 0 && indice < exercicios.size()) {
            return exercicios.get(indice);
        }
        return null;
    }
}
