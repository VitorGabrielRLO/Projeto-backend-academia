package dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import entities.Exercicio;
public class ExercicioDao {

    Exercicio[] exercicio = new Exercicio[100];

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
                System.out.println("Area Afetada: " + exercicios.getAreaAfetada());
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
                Date dataAtual = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                exercicios.setDataModificacao(sdf.format(dataAtual));
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
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Exercicio exercicio1 = new Exercicio();
        Exercicio exercicio2 = new Exercicio();
        Exercicio exercicio3 = new Exercicio();
        Exercicio exercicio4 = new Exercicio();

        
        exercicio1.setNomeExercicio("Supino");
        exercicio1.setDescricaoFoto("Foto");
        exercicio1.setAreaAfetada("Peito");
        exercicio1.setDataCriacao(sdf.format(dataAtual));

        
        exercicio2.setNomeExercicio("Rosca");
        exercicio2.setDescricaoFoto("Foto");
        exercicio2.setAreaAfetada("Biceps");
        exercicio2.setDataCriacao(sdf.format(dataAtual));

        
        exercicio3.setNomeExercicio("Agachamento");
        exercicio3.setDescricaoFoto("Foto");
        exercicio3.setAreaAfetada("Perna");
        exercicio3.setDataCriacao(sdf.format(dataAtual));

        
        exercicio4.setNomeExercicio("Elevacao lateral ");
        exercicio4.setDescricaoFoto("Foto");
        exercicio4.setAreaAfetada("Triceps");
        exercicio4.setDataCriacao(sdf.format(dataAtual));

        adiciona(exercicio1);
        adiciona(exercicio2);
        adiciona(exercicio3);
        adiciona(exercicio4);
    }

}
