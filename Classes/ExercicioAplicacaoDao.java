import java.util.Date;
public class ExercicioAplicacaoDao {

    ExercicioAplicacao[] exercicioAplicacao = new ExercicioAplicacao[10];

    boolean adiciona(ExercicioAplicacao p) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            exercicioAplicacao[proximaPosicaoLivre] = p;
            return true;
        } else {
            return false;
        }

    }

    public boolean ehVazio() {
        for (ExercicioAplicacao exercicioAplicacaos : exercicioAplicacao) {
            if (exercicioAplicacaos != null) {
                return false;
            }
        }
        return true;

    }
    public void mostrarTodos() {
        boolean temExercicio = false;
        for (ExercicioAplicacao exercicioAplicacaos : exercicioAplicacao) {
            if (exercicioAplicacaos != null) {
                System.out.println("ID: " + exercicioAplicacaos.getId());
                System.out.println("Descrição: " + exercicioAplicacaos.getDescricao());
                System.out.println("Data de Criação: " + exercicioAplicacaos.getDataCriacao());
                System.out.println("Data de Modificação: " + exercicioAplicacaos.getDataModificacao());
                System.out.println("--------------------------");
                temExercicio = true;
            }
        }
        if (!temExercicio) {
            System.out.println("Não existem exercícios cadastrados.");
        }
    }



public boolean alterarDescricao(int id, String novaDescricao) {
    for (ExercicioAplicacao exercicioAplicacaos : exercicioAplicacao) {
        if (exercicioAplicacaos != null && exercicioAplicacaos.getId() == id) {
            exercicioAplicacaos.setDescricao(novaDescricao);
            return true;
        }
    }
    return false;
}


    ExercicioAplicacao buscaPorId(int id) {
        for (ExercicioAplicacao exercicioAplicacaos : exercicioAplicacao) {
            if (exercicioAplicacaos != null && exercicioAplicacaos.getId() == id) {
                return exercicioAplicacaos;
            }
        }
        
        return null;

    }

    public boolean remover(int id) {
        for (int i = 0; i < exercicioAplicacao.length; i++) {
            if (exercicioAplicacao[i] != null && exercicioAplicacao[i].getId() == id) {
                exercicioAplicacao[i] = null;
                return true;
            }
        }
        return false;
    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < exercicioAplicacao.length; i++) {
            if (exercicioAplicacao[i] == null) {
                return i;
            }

        }
        return -1;

    }

    public ExercicioAplicacaoDao() {
        ExercicioAplicacao exApli1 = new ExercicioAplicacao();
        ExercicioAplicacao exApli2 = new ExercicioAplicacao();
        ExercicioAplicacao exApli3 = new ExercicioAplicacao();
        ExercicioAplicacao exApli4 = new ExercicioAplicacao();


        exApli1.setDescricao("4x12");
        exApli1.setDataCriacao(new Date());
        exApli1.setDataModificacao(new Date());


        exApli2.setDescricao("4x10");
        exApli2.setDataCriacao(new Date());
        exApli2.setDataModificacao(new Date());


        exApli3.setDescricao("5x5");
        exApli3.setDataCriacao(new Date());
        exApli3.setDataModificacao(new Date());


        exApli4.setDescricao("123");
        exApli4.setDataCriacao(new Date());
        exApli4.setDataModificacao(new Date());

        adiciona(exApli1);
        adiciona(exApli2);
        adiciona(exApli3);
        adiciona(exApli4);
    }
}
