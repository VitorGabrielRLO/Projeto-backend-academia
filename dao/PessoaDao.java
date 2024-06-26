package dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import entities.Pessoa;

public class PessoaDao {

    Pessoa[] pessoa = new Pessoa[1000];

    public boolean adiciona(Pessoa p) {
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
    public Pessoa buscaLogin(String login){
        for(var pessoas : pessoa){
            if (pessoas.getLoginPessoa().equals(login) ) {
                return pessoas;   
            }
        }
        return null;
    }

    public void mostrarTodos() {
        boolean temJogador = false;
        for (Pessoa pessoas : pessoa) {
            if (pessoas != null) {
                System.out.println(pessoas);
                System.out.println("-------------\n");
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
                Date dataAtual = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                pessoas.setDataModificacaoPessoa(sdf.format(dataAtual));

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

    public Pessoa selecionarPorId(Long id) {
        for (Pessoa divisoes : pessoa) {
            if (divisoes != null && divisoes.getId() == id) {
                return divisoes;
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
        pessoa1.setLoginPessoa("Virginia");
        pessoa1.setSenhaPessoa("Virginia");
        pessoa1.setTipoUsuarioPessoa(1);

        pessoa2.setNomePessoa("Maicon");
        pessoa2.setSexoPessoa("Homem");
        pessoa2.setLoginPessoa("Maiquim");
        pessoa2.setSenhaPessoa("321");
        pessoa2.setTipoUsuarioPessoa(2);

        pessoa3.setNomePessoa("James");
        pessoa3.setSexoPessoa("Homem");
        pessoa3.setLoginPessoa("Professor");
        pessoa3.setSenhaPessoa("Professor");
        pessoa3.setTipoUsuarioPessoa(2);

        pessoa4.setNomePessoa("admin");
        pessoa4.setSexoPessoa("admin");
        pessoa4.setLoginPessoa("admin");
        pessoa4.setSenhaPessoa("admin");
        pessoa4.setTipoUsuarioPessoa(3);


        adiciona(pessoa1);
        adiciona(pessoa2);
        adiciona(pessoa3);
        adiciona(pessoa4);

    }
}
