package dao; // Definindo qual pacote esta classe pertence


import entities.AlunoPagamento;

public class AlunoPagamentoDao {

    AlunoPagamento[] avaliacaoFisica = new AlunoPagamento[10];

    public boolean adiciona(AlunoPagamento p) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            avaliacaoFisica[proximaPosicaoLivre] = p;
            return true;
        } else {
            return false;
        }

    }

    public boolean ehVazio() {
        for (AlunoPagamento avaliacaoFisicas : avaliacaoFisica) {
            if (avaliacaoFisicas != null) {
                return false;
            }
        }
        return true;

    }
    public void mostrarTodos() {
        boolean temExercicio = false;
        for (AlunoPagamento avaliacaoFisicas : avaliacaoFisica) {
            if (avaliacaoFisicas != null) {
                System.out.println("ID: " + avaliacaoFisicas.getId());
                System.out.println("IMC: " + avaliacaoFisicas.getIMC());
                System.out.println("Indice de satisfacao:" + avaliacaoFisicas.getIndiceSatisfacao());
                System.out.println("Data de Criação: " + avaliacaoFisicas.getDataCriacao());
                System.out.println("Data de Modificação: " + avaliacaoFisicas.getDataModificacao());
                System.out.println("--------------------------");
                temExercicio = true;
            }
        }
        if (!temExercicio) {
            System.out.println("Não existem IMCs cadastrados.");
        }
    }



    AlunoPagamento buscaPorId(int id) {
        for (AlunoPagamento avaliacaoFisicas : avaliacaoFisica) {
            if (avaliacaoFisicas != null && avaliacaoFisicas.getId() == id) {
                return avaliacaoFisicas;
            }
        }
        
        return null;

    }

    public boolean remover(int id) {
        for (int i = 0; i < avaliacaoFisica.length; i++) {
            if (avaliacaoFisica[i] != null && avaliacaoFisica[i].getId() == id) {
                avaliacaoFisica[i] = null;
                return true;
            }
        }
        return false;
    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < avaliacaoFisica.length; i++) {
            if (avaliacaoFisica[i] == null) {
                return i;
            }

        }
        return -1;

    }

    // public ExercicioAplicacaoDao() {
    //     ExercicioAplicacao exApli1 = new ExercicioAplicacao();
    //     ExercicioAplicacao exApli2 = new ExercicioAplicacao();
    //     ExercicioAplicacao exApli3 = new ExercicioAplicacao();
    //     ExercicioAplicacao exApli4 = new ExercicioAplicacao();


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