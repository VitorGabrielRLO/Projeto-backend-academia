
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
            if (pessoas != null && pessoas.getNomePessoa().equals(nome)) {
                pessoas.setNomePessoa(novoNome);
                return true;
            }
        }
        return false;

    }

    Pessoa buscaPorNome(String nome) {
        for (Pessoa pessoas : pessoa) {
            if (pessoas != null && pessoas.getNomePessoa().equals(nome)) {
                return pessoas;
            }
        }
        return null;

    }

    public boolean remover(String nome) {
        for (int i = 0; i < pessoa.length; i++) {
            if (pessoa[i] != null && pessoa[i].getNomePessoa().equals(nome)) {
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

    }
}
