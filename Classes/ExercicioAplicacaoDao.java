
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
        boolean temJogador = false;
        for (ExercicioAplicacao exercicioAplicacaos : exercicioAplicacao) {
            if (exercicioAplicacaos != null) {
                System.out.println(exercicioAplicacaos);
                temJogador = true;
            }
        }
        if (!temJogador) {
            System.out.println("Não existe pessoa cadastrada");
        }
    }

    public boolean alterarNome(String nome, String novoNome) {
        for (ExercicioAplicacao exercicioAplicacaos : exercicioAplicacao) {
            if (exercicioAplicacaos != null && exercicioAplicacaos.getNome().equals(nome)) {
                exercicioAplicacaos.setNome(novoNome);
                return true;
            }
        }
        return false;

    }

    ExercicioAplicacao buscaPorNome(String nome) {
        for (ExercicioAplicacao exercicioAplicacaos : exercicioAplicacao) {
            if (exercicioAplicacaos != null && exercicioAplicacaos.getNome().equals(nome)) {
                return exercicioAplicacaos;
            }
        }
        return null;

    }

    public boolean remover(String nome) {
        for (int i = 0; i < exercicioAplicacao.length; i++) {
            if (exercicioAplicacao[i] != null && exercicioAplicacao[i].getNome().equals(nome)) {
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
        /* 
        exApli1.setNomePessoa("Virginia");
        exApli1.setSexoPessoa("Mulher");
        exApli1.setLoginPessoa("Virg");
        exApli1.setSenhaPessoa("123");

        exApli2.setNomePessoa("Maicon");
        exApli2.setSexoPessoa("Homem");
        exApli2.setLoginPessoa("Maiquim");
        exApli2.setSenhaPessoa("321");

        exApli3.setNomePessoa("James");
        exApli3.setSexoPessoa("Homem");
        exApli3.setLoginPessoa("Salada");
        exApli3.setSenhaPessoa("299");

        exApli4.setNomePessoa("Louders");
        exApli4.setSexoPessoa("Mulher");
        exApli4.setLoginPessoa("Lou");
        exApli4.setSenhaPessoa("2222");
        */

        adiciona(exApli1);
        adiciona(exApli2);
        adiciona(exApli3);
        adiciona(exApli4);

    }
}
