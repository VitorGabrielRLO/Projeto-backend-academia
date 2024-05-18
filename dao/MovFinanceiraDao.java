import entities.MovFinanceira;

package dao;
public class MovFinanceiraDao {
    MovFinanceira[] movFinanceira = new MovFinanceira[10];

    boolean adiciona(MovFinanceira p) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            movFinanceira[proximaPosicaoLivre] = p;
            return true;
        } else {
            return false;
        }

    }

    public boolean ehVazio() {
        for (MovFinanceira movFinanceiras : movFinanceira) {
            if (movFinanceiras != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos() {
        boolean temJogador = false;
        for (MovFinanceira movFinanceiras : movFinanceira) {
            if (movFinanceiras != null) {
                System.out.println(movFinanceiras);
                temJogador = true;
            }
        }
        if (!temJogador) {
            System.out.println("Não existe pessoa cadastrada");
        }
    }

    public boolean alterarNome(String nome, String novoNome) {
        for (MovFinanceira movFinanceiras : movFinanceira) {
            if (movFinanceiras != null && movFinanceiras.getNomePessoa().equals(nome)) {
                movFinanceiras.setNomePessoa(novoNome);
                return true;
            }
        }
        return false;

    }

    MovFinanceira buscaPorNome(String nome) {
        for (MovFinanceira movFinanceiras : movFinanceira) {
            if (movFinanceiras != null && movFinanceiras.getNomePessoa().equals(nome)) {
                return movFinanceiras;
            }
        }
        return null;

    }

    public boolean remover(String nome) {
        for (int i = 0; i < movFinanceira.length; i++) {
            if (movFinanceira[i] != null && movFinanceira[i].getNomePessoa().equals(nome)) {
                movFinanceira[i] = null;
                return true;
            }
        }
        return false;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < movFinanceira.length; i++) {
            if (movFinanceira[i] == null) {
                return i;
            }

        }
        return -1;

    }
    /* 
    public PessoaDao() {
        Pessoa pessoa1 = new Pessoa();
        Pessoa pessoa2 = new Pessoa();
        Pessoa pessoa3 = new Pessoa();
        Pessoa pessoa4 = new Pessoa();

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


        adiciona(pessoa1);
        adiciona(pessoa2);
        adiciona(pessoa3);
        adiciona(pessoa4);

    }*/
}
