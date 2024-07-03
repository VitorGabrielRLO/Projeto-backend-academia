package general;

import dao.ExercicioDao;
import entities.Exercicio;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class programaExercicio {
    private ExercicioDao ExercicioDao;
    private Scanner s;

    public programaExercicio() {
        this.ExercicioDao = new ExercicioDao();
        this.s = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                    Exercicio exercicio = criaExercicio();

                    boolean exercicioInserido = ExercicioDao.adiciona(exercicio);
                    if (exercicioInserido) {
                        System.out.println("Exercício inserido com sucesso");
                    } else {
                        System.out.println("Falha ao inserir exercício");
                    }
                    break;
                case 2:
                    List<Exercicio> exercicios = ExercicioDao.mostrarTodos();
                    for (Exercicio e : exercicios) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    System.out.print("Exercício a ser procurado: ");
                    String procurado = s.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = s.nextLine();
                    if (ExercicioDao.alterarNome(procurado, novoNome)) {
                        System.out.println("Exercício alterado com sucesso");
                    } else {
                        System.out.println("Exercício não encontrado");
                    }
                    break;
                case 4:
                    System.out.print("Nome do exercício a ser excluído: ");
                    String nomeExclusao = s.nextLine();
                    if (ExercicioDao.remover(nomeExclusao)) {
                        System.out.println("Exercício excluído com sucesso");
                    } else {
                        System.out.println("Exercício não encontrado ou não pôde ser excluído");
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

    private Exercicio criaExercicio() {
        Exercicio exercicio = new Exercicio();
        exercicio.setDataCriacao(LocalDate.now());

        System.out.print("Nome: ");
        exercicio.setNomeExercicio(s.nextLine());

        System.out.print("Descrição: ");
        exercicio.setDescricaoFoto(s.nextLine());

        System.out.print("Área Afetada: ");
        exercicio.setAreaAfetada(s.nextLine());

        return exercicio;
    }

    private int pegaOpcaoUsuario() {
        int opcao = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.println("\n\n");
                System.out.println("----------------------------------");
                System.out.println("1 - Cadastrar exercício");
                System.out.println("2 - Mostrar todos exercícios");
                System.out.println("3 - Alterar o nome do exercício");
                System.out.println("4 - Excluir exercício pelo nome");
                System.out.println("5 - Sair");
                System.out.print("Qual sua opção? R: ");

                opcao = Integer.parseInt(s.nextLine());
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Digite novamente.");
            }
        }

        return opcao;
    }
}