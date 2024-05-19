package dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import entities.Academia;


// import entities.Exercicio;

public class AcademiaDAO {

    Academia[] academia = new Academia[10];

    public boolean adiciona(Academia p) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            academia[proximaPosicaoLivre] = p;
            return true;
        } else {
            return false;
        }

    }

    public boolean ehVazio() {
        for (Academia academias : academia) {
            if (academias != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos() {
        boolean temAcademia = false;
        for (Academia academias : academia) {
            if (academias != null) {
                System.out.println("ID: " + academias.getId());
                System.out.println("Nome: " + academias.getNome());
                System.out.println("Endereco: " + academias.getEndereco());
                System.out.println("Data de Criação: " + academias.getDataCriacao());
                System.out.println("Data de Modificação: " + academias.getDataModificacao());
                System.out.println("--------------------------");
                temAcademia = true;
            }
        }
        if (!temAcademia) {
            System.out.println("Não existem exercícios cadastrados.");
        }
    }

    public boolean alterarNome(String nome, String novoNome) {
        for (Academia academias : academia) {
            if (academias != null && academias.getNome().equals(nome)) {
                academias.setNome(novoNome);
                return true;
            }
        }
        return false;

    }

    Academia buscaPorNome(String nome) {
        for (Academia academias : academia) {
            if (academias != null && academias.getNome().equals(nome)) {
                return academias;
            }
        }
        return null;

    }

    public boolean remover(String nome) {
        for (int i = 0; i < academia.length; i++) {
            if (academia[i] != null && academia[i].getNome().equals(nome)) {
                academia[i] = null;
                return true;
            }
        }
        return false;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < academia.length; i++) {
            if (academia[i] == null) {
                return i;
            }

        }
        return -1;

    }

    public AcademiaDAO() {
        Date dataAtual = new Date();
        Date dataCriacao = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Academia academia1 = new Academia();
        Academia academia2 = new Academia();
        Academia academia3 = new Academia();
        Academia academia4 = new Academia();

        academia1.setNome("Gym");
        academia1.setEndereco("Rua 123");
        academia1.setDataCriacao(sdf.format(dataAtual));
        
        academia2.setNome("treino");
        academia2.setEndereco("Rua 321");
        academia2.setDataCriacao(sdf.format(dataAtual));

        academia3.setNome("Fitcorps");
        academia3.setEndereco("Rua visconde");
        academia3.setDataCriacao(sdf.format(dataAtual));
        
        academia4.setNome("SmartFit");
        academia4.setEndereco("Rua Leopoldino");
        academia4.setDataCriacao(sdf.format(dataAtual));


        adiciona(academia1);
        adiciona(academia2);
        adiciona(academia3);
        adiciona(academia4);

    }
}
