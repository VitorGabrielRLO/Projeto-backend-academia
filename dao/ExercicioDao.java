package dao;

import java.util.Date;
import entities.Exercicio;
public class ExercicioDao {

    Exercicio[] exercicio = new Exercicio[10];

    public boolean adiciona(Exercicio p) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            exercicio[proximaPosicaoLivre] = p;
            return true;
        } else {
            return false;
        }
    }

    public boolean ehVazio() {
        for (Exercicio exercicios : exercicio) {
            if (exercicios != null) {
                return false;
            }
        }
        return true;
    }

    public void mostrarTodos() {
        boolean temExercicio = false;
        for (Exercicio exercicios : exercicio) {
            if (exercicios != null) {
                System.out.println("ID: " + exercicios.getId());
                System.out.println("Nome: " + exercicios.getNomeExercicio());
                System.out.println("Descricao: " + exercicios.getDescricaoFoto());
                System.out.println("Data de Criação: " + exercicios.getDataCriacao());
                System.out.println("Data de Modificação: " + exercicios.getDataModificacao());
                System.out.println("--------------------------");
                temExercicio = true;
            }
        }
        if (!temExercicio) {
            System.out.println("Não existem exercícios cadastrados.");
        }
    }

    public boolean alterarNome(String nome, String novoNome) {
        for (Exercicio exercicios : exercicio) {
            if (exercicios != null && exercicios.getNomeExercicio().equals(nome)) {
                exercicios.setNomeExercicio(novoNome);
                return true;
            }
        }
        return false;
    }

    Exercicio buscaPorNome(String nome) {
        for (Exercicio exercicios : exercicio) {
            if (exercicios != null && exercicios.getNomeExercicio().equals(nome)) {
                return exercicios;
            }
        }
        return null;
    }

    public boolean remover(String nome) {
        for (int i = 0; i < exercicio.length; i++) {
            if (exercicio[i] != null && exercicio[i].getNomeExercicio().equals(nome)) {
                exercicio[i] = null;
                return true;
            }
        }
        return false;
    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < exercicio.length; i++) {
            if (exercicio[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public ExercicioDao() {
        Date dataAtual = new Date();
        Exercicio exercicio1 = new Exercicio();
        Exercicio exercicio2 = new Exercicio();
        Exercicio exercicio3 = new Exercicio();
        Exercicio exercicio4 = new Exercicio();

        
        exercicio1.setNomeExercicio("Supino");
        exercicio1.setDescricaoFoto("Peito");
        exercicio1.setDataCriacao(dataAtual);

        
        exercicio2.setNomeExercicio("Rosca");
        exercicio2.setDescricaoFoto("Biceps");
        exercicio2.setDataCriacao(dataAtual);

        
        exercicio3.setNomeExercicio("Agachamento");
        exercicio3.setDescricaoFoto("Perna");
        exercicio3.setDataCriacao(dataAtual);

        
        exercicio4.setNomeExercicio("Elevacao lateral ");
        exercicio4.setDescricaoFoto("Triceps");
        exercicio4.setDataCriacao(dataAtual);

        adiciona(exercicio1);
        adiciona(exercicio2);
        adiciona(exercicio3);
        adiciona(exercicio4);
    }

}
