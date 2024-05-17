
public class TreinoDao {

    Treino[] treino = new Treino[10];

    boolean adiciona(Treino p) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            treino[proximaPosicaoLivre] = p;
            return true;
        } else {
            return false;
        }

    }

    public boolean ehVazio() {
        for (Treino treinos : treino) {
            if (treinos != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos() {
        boolean temJogador = false;
        for (Treino treinos : treino) {
            if (treinos != null) {
                System.out.println(treinos);
                temJogador = true;
            }
        }
        if (!temJogador) {
            System.out.println("Não existe pessoa cadastrada");
        }
    }

    public boolean alterarNome(String nome, String novoNome) {
        for (Treino treinos : treino) {
            if (treinos != null && treinos.getNomePessoa().equals(nome)) {
                treinos.setNomePessoa(novoNome);
                return true;
            }
        }
        return false;

    }

    Treino buscaPorNome(String nome) {
        for (Treino treinos : treino) {
            if (treinos != null && treinos.getNomePessoa().equals(nome)) {
                return treinos;
            }
        }
        return null;

    }

    public boolean remover(String nome) {
        for (int i = 0; i < treino.length; i++) {
            if (treino[i] != null && treino[i].getNomePessoa().equals(nome)) {
                treino[i] = null;
                return true;
            }
        }
        return false;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < treino.length; i++) {
            if (treino[i] == null) {
                return i;
            }

        }
        return -1;

    }

    public TreinoDao() {
        Treino treino1 = new Treino();
        Treino treino2 = new Treino();
        Treino treino3 = new Treino();
        Treino treino4 = new Treino();

        /* 
        pessoa1.setNomePessoa("Virginia");
        pessoa1.setSexoPessoa("Mulher");
        pessoa1.setLoginPessoa("Virg");
        pessoa1.setSenhaPessoa("123");

        pessoa2.setNomePessoa("Maicon");
        pessoa2.setSexoPessoa("Homem");
        pessoa2.setLoginPessoa("Maiquim");
        pessoa2.setSenhaPessoa("321");

        pessoa3.setNomePessoa("James");
        pessoa3.setSexoPessoa("Homem");
        pessoa3.setLoginPessoa("Salada");
        pessoa3.setSenhaPessoa("299");

        pessoa4.setNomePessoa("Louders");
        pessoa4.setSexoPessoa("Mulher");
        pessoa4.setLoginPessoa("Lou");
        pessoa4.setSenhaPessoa("2222");
        */

        adiciona(treino1);
        adiciona(treino2);
        adiciona(treino3);
        adiciona(treino4);

    }
}
