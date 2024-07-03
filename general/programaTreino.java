package general;

import dao.*;
import entities.*;
import java.time.LocalDate;
import java.util.Scanner;

public class programaTreino {
    private TreinoDao treinoDao;
    private ExercicioDao exercicioDao;
    private DivisaoTreinoDao divisaoTreinoDao;

    public programaTreino() {
        this.treinoDao = new TreinoDao();
        this.exercicioDao = new ExercicioDao();
        this.divisaoTreinoDao = new DivisaoTreinoDao();
    }

    Scanner s = new Scanner(System.in);

    public void mostrarMenu() {
        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                    Treino treino = criaTreino();
                    boolean treinoFoiInserido = treinoDao.adiciona(treino);
                    if (treinoFoiInserido) {
                        System.out.println("Treino cadastrado com sucesso");
                    } else {
                        System.out.println("Falha ao cadastrar treino");
                    }
                    break;
                case 2:
                    treinoDao.mostrarTodasTreinos();
                    break;
                case 3:
                    System.out.print("ID do treino a ser buscado: ");
                    int id = Integer.parseInt(s.nextLine());
                    Treino buscado = treinoDao.buscaPorId(id);
                    if (buscado != null) {
                        System.out.println(buscado);
                    } else {
                        System.out.println("Treino não encontrado");
                    }
                    break;
                case 4:
                    System.out.print("ID do treino a ser excluído: ");
                    int id1 = Integer.parseInt(s.nextLine());
                    boolean treinoFoiRemovido = treinoDao.remover(id1);
                    if (treinoFoiRemovido) {
                        System.out.println("Treino removido com sucesso");
                    } else {
                        System.out.println("Falha ao remover treino");
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcaoUsuario != 5);
    }

    private Treino criaTreino() {
        Treino treino = new Treino();

        System.out.print("Data de Início (AAAA-MM-DD): ");
        String dataInicioStr = s.nextLine();
        LocalDate dataInicio = LocalDate.parse(dataInicioStr);
        treino.setDataInicio(dataInicio);

        System.out.print("Data de Término (AAAA-MM-DD): ");
        String dataTerminoStr = s.nextLine();
        LocalDate dataTermino = LocalDate.parse(dataTerminoStr);
        treino.setDataTermino(dataTermino);

        System.out.print("Exercício por nome: ");
        String exercicioStr = s.nextLine();
        Exercicio exercicio = exercicioDao.buscaPorNome(exercicioStr);
        if (exercicio == null) {
            System.out.println("Exercício não encontrado");
            return null;
        }
        treino.setExercicio(exercicio);

        System.out.print("Divisão de Treino por nome: ");
        String divisaoTreinoStr = s.nextLine();
        DivisaoTreino divisaoTreino = divisaoTreinoDao.buscaPorNome(divisaoTreinoStr);
        if (divisaoTreino == null) {
            System.out.println("Divisão de Treino não encontrada");
            return null;
        }
        treino.setDivisaoTreino(divisaoTreino);

        return treino;
    }

      
    private int pegaOpcaoUsuario() {
        System.out.println("1 - Cadastrar treino");
        System.out.println("2 - Mostrar todos os treinos");
        System.out.println("3 - Buscar por ID");
        System.out.println("4 - Excluir treino pelo ID");
        System.out.println("5 - Sair");
        System.out.print("Qual sua opção? R: ");
        return Integer.parseInt(s.nextLine());
    }
}
