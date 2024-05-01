public class PessoaDao {

    Pessoa[] pessoa = new Pessoa[10];

    boolean adiciona(Pessoa p) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            pessoa[proximaPosicaoLivre] = p;
            return true;
        } else {
            return false;
        }

    }

    public boolean ehVazio() {
        for (Pessoa pessoas : pessoa) {
            if (pessoas != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos() {
        boolean temJogador = false;
        for (Pessoa pessoas : pessoa) {
            if (pessoas != null) {
                System.out.println(pessoas);
                temJogador = true;
            }
        }
        if (!temJogador) {
            System.out.println("Não existe pessoa cadastrada");
        }
    }

    public boolean alterarNome(String nome, String novoNome) {
        for (Pessoa pessoas : pessoa) {
            if (pessoas != null && pessoas.getNome().equals(nome)) {
                pessoas.setNome(novoNome);
                return true;
            }
        }
        return false;

    }

    Pessoa buscaPorNome(String nome) {
        for (Pessoa pessoas : pessoa) {
            if (pessoas != null && pessoas.getNome().equals(nome)) {
                return pessoas;
            }
        }
        return null;

    }

    public boolean remover(String nome) {
        for (int i = 0; i < pessoa.length; i++) {
            if (pessoa[i] != null && pessoa[i].getNome().equals(nome)) {
                pessoa[i] = null;
                return true;
            }
        }
        return false;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < pessoa.length; i++) {
            if (pessoa[i] == null) {
                return i;
            }

        }
        return -1;

    }

}
