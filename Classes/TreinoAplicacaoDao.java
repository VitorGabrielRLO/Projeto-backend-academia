
public class TreinoAplicacaoDao {

    TreinoAplicacao[] treinoAplicacao = new TreinoAplicacao[10];

    boolean adiciona(TreinoAplicacao p) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            treinoAplicacao[proximaPosicaoLivre] = p;
            return true;
        } else {
            return false;
        }

    }

    public boolean ehVazio() {
        for (TreinoAplicacao treinoAplicacaos : treinoAplicacao) {
            if (treinoAplicacaos != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos() {
        boolean temExercicio = false;
        for (TreinoAplicacao treinoAplicacaos : treinoAplicacao) {
            if (treinoAplicacaos != null) {
                System.out.println(treinoAplicacaos);
                temExercicio = true;
            }
        }
        if (!temExercicio) {
            System.out.println("Não existe pessoa cadastrada");
        }
    }

    public boolean alterarNome(String nome, String novoNome) {
        for (TreinoAplicacao treinoAplicacaos : treinoAplicacao) {
            if (treinoAplicacaos != null && treinoAplicacaos.getNome().equals(nome)) {
                treinoAplicacaos.setNome(novoNome);
                return true;
            }
        }
        return false;

    }

    TreinoAplicacao buscaPorNome(String nome) {
        for (TreinoAplicacao treinoAplicacaos : treinoAplicacao) {
            if (treinoAplicacaos != null && treinoAplicacaos.getNome().equals(nome)) {
                return treinoAplicacaos;
            }
        }
        return null;

    }

    public boolean remover(String nome) {
        for (int i = 0; i < treinoAplicacao.length; i++) {
            if (treinoAplicacao[i] != null && treinoAplicacao[i].getNome().equals(nome)) {
                treinoAplicacao[i] = null;
                return true;
            }
        }
        return false;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < treinoAplicacao.length; i++) {
            if (treinoAplicacao[i] == null) {
                return i;
            }

        }
        return -1;

    }

}
