package general;

import dao.*;
import entities.*;
import java.util.List;
import java.util.Scanner;

public class programaTreinoAplicacao {
    private TreinoAplicacaoDao treinoAplicacaoDao;
    private ExercicioDao exercicioDao;
    private DivisaoTreinoDao divisaoTreinoDao;
    private TreinoDao treinoDao;
    private ExercicioAplicacaoDao exercicioAplicacaoDao;

    public programaTreinoAplicacao() {
        this.treinoAplicacaoDao = new TreinoAplicacaoDao();
        this.treinoDao = new TreinoDao();
        this.divisaoTreinoDao = new DivisaoTreinoDao();
        this.exercicioDao = new ExercicioDao();
        this.exercicioAplicacaoDao = new ExercicioAplicacaoDao(); 
    }

    Scanner s = new Scanner(System.in);

    public void mostrarMenu() {
        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                    TreinoAplicacao treinoAplicacao = criaTreinoApp();
                    boolean treinoAplicacaoFoiInserida = treinoAplicacaoDao.adiciona(treinoAplicacao);
                    if (treinoAplicacaoFoiInserida) {
                        System.out.println("Treino Aplicação inserido com sucesso");
                    } else {
                        System.out.println("Treino Aplicação não inserido");
                    }
                    break;
                case 2:
                    List<TreinoAplicacao> lista = treinoAplicacaoDao.mostrarTodos();
                    for (TreinoAplicacao t : lista) {
                        System.out.println(t);
                    }
                    break;
                case 3:
                System.out.print("ID do treino aplicacao a ser buscado: ");
                long id = Integer.parseInt(s.nextLine());
                TreinoAplicacao buscado = treinoAplicacaoDao.buscaPorId(id);
                if (buscado != null) {
                    System.out.println(buscado);
                } else {
                    System.out.println("Treino Aplicacao não encontrado");
                }
                    break;
                case 4:
                    System.out.println("Pessoa procurada:");
                    String nomeExclusao = s.nextLine();
                    if (treinoAplicacaoDao.remover(nomeExclusao)) {
                        System.out.println("Pessoa excluída");
                    } else {
                        System.out.println("Pessoa não excluída");
                    }
                    break;
                case 5:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcaoUsuario != 5);
    }

    private TreinoAplicacao criaTreinoApp() {
        TreinoAplicacao treinoAplicacao = new TreinoAplicacao();


        // Solicita os atributos do TreinoAplicacao
        System.out.print("ID do Treino: ");
        long treinoId = Long.parseLong(s.nextLine());
        
        Treino treino = new Treino();
        treino = treinoDao.buscaPorId(treinoId);
        treinoAplicacao.setTreino(treino);

        System.out.print("Nome do Exercicio: ");
        String nomeExercicio = (s.nextLine());
        
        Exercicio exercicio = new Exercicio();
        exercicio = exercicioDao.buscaPorNome(nomeExercicio);
        treinoAplicacao.setExercicio(exercicio);

        System.out.print("ID do ExercicioAplicacao: ");
        long exercicioAplicacaoId = Long.parseLong(s.nextLine());

        ExercicioAplicacao exercicioAplicacao = new ExercicioAplicacao();
        exercicioAplicacao = exercicioAplicacaoDao.buscaPorId(exercicioAplicacaoId);
        treinoAplicacao.setExercicioAplicacao(exercicioAplicacao);


        System.out.print("Nome da Divisão de Treino: ");
        String nomeDivisaoTreino = (s.nextLine());

        DivisaoTreino divisaoTreino = new DivisaoTreino();
        divisaoTreino = divisaoTreinoDao.buscaPorNome(nomeDivisaoTreino);
        treinoAplicacao.setDivisaoTreino(divisaoTreino);
        

        return treinoAplicacao;
    }

    private int pegaOpcaoUsuario() {
        System.out.println("1 cadastrar");
        System.out.println("2 mostrar todos");
        System.out.println("3 buscar nome da pessoa");
        System.out.println("4 excluir pelo id");
        System.out.println("5 sair");
        System.out.print("Qual sua opção? R: ");
        return Integer.parseInt(s.nextLine());
    }
}
