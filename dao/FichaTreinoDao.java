package dao; // Definindo qual pacote esta classe pertence

import entities.FichaTreino;

public class FichaTreinoDao {

    FichaTreino[] exercicioAplicacao = new FichaTreino[1000];

    public boolean adiciona(FichaTreino p) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            exercicioAplicacao[proximaPosicaoLivre] = p;
            return true;
        } else {
            return false;
        }

    }

    public boolean ehVazio() {
        for (FichaTreino exercicioAplicacaos : exercicioAplicacao) {
            if (exercicioAplicacaos != null) {
                return false;
            }
        }
        return true;

    }
    public void mostrarTodos() {
        boolean temExercicio = false;
        for (FichaTreino exercicioAplicacaos : exercicioAplicacao) {
            if (exercicioAplicacaos != null) {
                System.out.println("ID: " + exercicioAplicacaos.getId());
                System.out.println("Aluno: " + exercicioAplicacaos.getPessoa());
                System.out.println("Data de Inicio: " + exercicioAplicacaos.getDataInicio());
                System.out.println("Data de Termino: " + exercicioAplicacaos.getDataFim());
                System.out.println("--------------------------");
                temExercicio = true;
            }
        }
        if (!temExercicio) {
            System.out.println("Não existem exercícios cadastrados.");
        }
    }



// public boolean alterarDescricao(int id, String novaDescricao) {
//     for (FichaTreino exercicioAplicacaos : exercicioAplicacao) {
//         if (exercicioAplicacaos != null && exercicioAplicacaos.getId() == id) {
//             exercicioAplicacaos.setDescricao(novaDescricao);
//             return true;
//         }
//     }
//     return false;
// }


    FichaTreino buscaPorId(int id) {
        for (FichaTreino exercicioAplicacaos : exercicioAplicacao) {
            if (exercicioAplicacaos != null && exercicioAplicacaos.getId() == id) {
                return exercicioAplicacaos;
            }
        }
        
        return null;

    }

    public boolean remover(int id) {
        for (int i = 0; i < exercicioAplicacao.length; i++) {
            if (exercicioAplicacao[i] != null && exercicioAplicacao[i].getId() == id) {
                exercicioAplicacao[i] = null;
                return true;
            }
        }
        return false;
    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < exercicioAplicacao.length; i++) {
            if (exercicioAplicacao[i] == null) {
                return i;
            }

        }
        return -1;

    }

    // public FichaTreinoDao() {
    //     FichaTreino exApli1 = new FichaTreino();
    //     FichaTreino exApli2 = new FichaTreino();
    //     FichaTreino exApli3 = new FichaTreino();
    //     FichaTreino exApli4 = new FichaTreino();


    //     exApli1.setDescricao("4x12");
    //     exApli1.setDataCriacao(new Date());
    //     exApli1.setDataModificacao(new Date());


    //     exApli2.setDescricao("4x10");
    //     exApli2.setDataCriacao(new Date());
    //     exApli2.setDataModificacao(new Date());


    //     exApli3.setDescricao("5x5");
    //     exApli3.setDataCriacao(new Date());
    //     exApli3.setDataModificacao(new Date());


    //     exApli4.setDescricao("123");
    //     exApli4.setDataCriacao(new Date());
    //     exApli4.setDataModificacao(new Date());

    //     adiciona(exApli1);
    //     adiciona(exApli2);
    //     adiciona(exApli3);
    //     adiciona(exApli4);
    // }
}
