// package dao;
// import entities.Treino;
// import entities.PagamentoRecorrente;

// public class PagamentoRecorrenteDao {

//     PagamentoRecorrente[] treinoAplicacao = new PagamentoRecorrente[10];

//     public boolean adiciona(PagamentoRecorrente p) {
//         int proximaPosicaoLivre = this.proximaPosicaoLivre();
//         if (proximaPosicaoLivre != -1) {
//             PagamentoRecorrente[proximaPosicaoLivre] = p;
//             return true;
//         } else {
//             return false;
//         }

//     }

//     public boolean ehVazio() {
//         for (PagamentoRecorrente treinoAplicacaos : treinoAplicacao) {
//             if (treinoAplicacaos != null) {
//                 return false;
//             }
//         }
//         return true;

//     }

//     public void mostrarTodos() {
//         boolean temExercicio = false;
//         for (TreinoAplicacao treinoAplicacaos : treinoAplicacao) {
//             if (treinoAplicacaos != null) {
//                 System.out.println(treinoAplicacaos);
//                 temExercicio = true;
//             }
//         }
//         if (!temExercicio) {
//             System.out.println("Não existe pessoa cadastrada");
//         }
//     }

//     public boolean alterarTreino(Treino treino, String novoTreino) {
//         for (TreinoAplicacao treinoAplicacaos : treinoAplicacao) {
//             if (treinoAplicacaos != null && treinoAplicacaos.getTreino().equals(novoTreino)) {
//                 treinoAplicacaos.setTreino(treino);
//                 return true;
//             }
//         }
//         return false;

//     }

//     @SuppressWarnings("unlikely-arg-type")
//     TreinoAplicacao buscaPorNome(String treino) {
//         for (TreinoAplicacao treinoAplicacaos : treinoAplicacao) {
//             if (treinoAplicacaos != null && treinoAplicacaos.getTreino().equals(treino)) {
//                 return treinoAplicacaos;
//             }
//         }
//         return null;

//     }

//     public boolean remover(String nome) {
//         for (int i = 0; i < treinoAplicacao.length; i++) {
//             if (treinoAplicacao[i] != null && treinoAplicacao[i].getTreino().equals(nome)) {
//                 treinoAplicacao[i] = null;
//                 return true;
//             }
//         }
//         return false;

//     }

//     private int proximaPosicaoLivre() {
//         for (int i = 0; i < treinoAplicacao.length; i++) {
//             if (treinoAplicacao[i] == null) {
//                 return i;
//             }

//         }
//         return -1;

//     }

// }
