package dao;

import entities.Academia;

public class AcademiaDAO {

    Academia[] divisao = new Academia[10];

    public boolean adiciona(Academia p) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            divisao[proximaPosicaoLivre] = p;
            return true;
        } else {
            return false;
        }

    }

    public boolean ehVazio() {
        for (Academia divisoes : divisao) {
            if (divisoes != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos() {
        boolean temJogador = false;
        for (Academia divisoes : divisao) {
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
        for (Academia divisoes : divisao) {
            if (divisoes != null && divisoes.getNome().equals(nome)) {
                divisoes.setNome(novoNome);
                return true;
            }
        }
        return false;

    }

    Academia buscaPorNome(String nome) {
        for (Academia divisoes : divisao) {
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

    public AcademiaDAO() {
        Academia divisao1 = new Academia();
        Academia divisao2 = new Academia();
        Academia divisao3 = new Academia();
        Academia divisao4 = new Academia();

        // divisao1.setNome("Virginia");
        // divisao1.setNomeDetalhado("Mulher");

        // divisao1.setNome("Virginia");
        // divisao1.setNomeDetalhado("Mulher");

        // divisao1.setNome("Virginia");
        // divisao1.setNomeDetalhado("Mulher");

        // divisao1.setNome("Virginia");
        // divisao1.setNomeDetalhado("Mulher");

        // adiciona(divisao1);
        // adiciona(divisao2);
        // adiciona(divisao3);
        // adiciona(divisao4);

    }
}
