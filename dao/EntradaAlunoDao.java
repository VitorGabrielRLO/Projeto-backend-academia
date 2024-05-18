package dao;

import entities.EntradaAluno;

public class EntradaAlunoDao {

    EntradaAluno[] divisao = new EntradaAluno[10];

    public boolean adiciona(EntradaAluno p) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            divisao[proximaPosicaoLivre] = p;
            return true;
        } else {
            return false;
        }

    }

    public boolean ehVazio() {
        for (EntradaAluno divisoes : divisao) {
            if (divisoes != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos() {
        boolean temJogador = false;
        for (EntradaAluno divisoes : divisao) {
            if (divisoes != null) {
                System.out.println(divisoes);
                temJogador = true;
            }
        }
        if (!temJogador) {
            System.out.println("Não existe divisao cadastrada");
        }
    }

    public boolean alterarNome(String nome, String novoNome) {
        for (EntradaAluno divisoes : divisao) {
            if (divisoes != null && divisoes.getNome().equals(nome)) {
                divisoes.setNome(novoNome);
                return true;
            }
        }
        return false;

    }

    EntradaAluno buscaPorNome(String nome) {
        for (EntradaAluno divisoes : divisao) {
            if (divisoes != null && divisoes.getNome().equals(nome)) {
                return divisoes;
            }
        }
        return null;

    }

    public boolean remover(String nome) {
        for (int i = 0; i < divisao.length; i++) {
            if (divisao[i] != null && divisao[i].getNome().equals(nome)) {
                divisao[i] = null;
                return true;
            }
        }
        return false;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < divisao.length; i++) {
            if (divisao[i] == null) {
                return i;
            }

        }
        return -1;

    }

    // public DivisaoTreinoDao() {
    //     DivisaoTreino divisao1 = new DivisaoTreino();
    //     DivisaoTreino divisao2 = new DivisaoTreino();
    //     DivisaoTreino divisao3 = new DivisaoTreino();
    //     DivisaoTreino divisao4 = new DivisaoTreino();

    //     divisao1.setNome("Virginia");
    //     divisao1.setNomeDetalhado("Mulher");

    //     divisao1.setNome("Virginia");
    //     divisao1.setNomeDetalhado("Mulher");

    //     divisao1.setNome("Virginia");
    //     divisao1.setNomeDetalhado("Mulher");

    //     divisao1.setNome("Virginia");
    //     divisao1.setNomeDetalhado("Mulher");

    //     adiciona(divisao1);
    //     adiciona(divisao2);
    //     adiciona(divisao3);
    //     adiciona(divisao4);

    //}
}
