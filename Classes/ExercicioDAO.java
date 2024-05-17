
public class ExercicioDao {

    Exercicio[] exercicio = new Exercicio[10];

    boolean adiciona(Exercicio p) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            exercicio[proximaPosicaoLivre] = p;
            return true;
        } else {
            return false;
        }

    }

    public boolean ehVazio() {
        for (Exercicio exercicios : exercicio) {
            if (exercicios != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos() {
        boolean temExercicio = false;
        for (Exercicio exercicios : exercicio) {
            if (exercicios != null) {
                System.out.println(exercicios);
                temExercicio = true;
            }
        }
        if (!temExercicio) {
            System.out.println("Não existe pessoa cadastrada");
        }
    }

    public boolean alterarNome(String nome, String novoNome) {
        for (Exercicio exercicios : exercicio) {
            if (exercicios != null && exercicios.getNome().equals(nome)) {
                exercicios.setNome(novoNome);
                return true;
            }
        }
        return false;

    }

    Exercicio buscaPorNome(String nome) {
        for (Exercicio exercicios : exercicio) {
            if (exercicios != null && exercicios.getNome().equals(nome)) {
                return exercicios;
            }
        }
        return null;

    }

    public boolean remover(String nome) {
        for (int i = 0; i < exercicio.length; i++) {
            if (exercicio[i] != null && exercicio[i].getNome().equals(nome)) {
                exercicio[i] = null;
                return true;
            }
        }
        return false;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < exercicio.length; i++) {
            if (exercicio[i] == null) {
                return i;
            }

        }
        return -1;

    }

}
