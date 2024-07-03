package general;

import dao.*;
import entities.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class programaExercicioAplicacao {

    private ExercicioAplicacaoDao exercicioAplicacaoDao;
    private Scanner scanner;

    public programaExercicioAplicacao() {
        this.exercicioAplicacaoDao = new ExercicioAplicacaoDao();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                    ExercicioAplicacao novoExercicio = criaExercicio();
                    boolean exercicioFoiInserido = exercicioAplicacaoDao.adiciona(novoExercicio);
                    if (exercicioFoiInserido) {
                        System.out.println("Exercício inserido com sucesso");
                    } else {
                        System.out.println("Exercício não inserido");
                    }
                    break;
                case 2:
                    List<ExercicioAplicacao> exercicioAplicacoes = exercicioAplicacaoDao.mostrarTodos();
                    if (exercicioAplicacoes.isEmpty()) {
                        System.out.println("Nenhum exercício encontrado.");
                    } else {
                        for (ExercicioAplicacao exercicio : exercicioAplicacoes) {
                            System.out.println(exercicio);
                        }
                    }
                    break;
                case 3:
                    System.out.print("ID do exercício a ser procurado: ");
                    int idProcurado = lerInteiro();
                    System.out.print("Nova descrição: ");
                    String novaDescricao = scanner.nextLine();
                    if (exercicioAplicacaoDao.alterarDescricao(idProcurado, novaDescricao)) {
                        System.out.println("Descrição alterada com sucesso");
                    } else {
                        System.out.println("Exercício não encontrado");
                    }
                    break;
                case 4:
                    System.out.print("ID do exercício a ser excluído: ");
                    int idExclusao = lerInteiro();
                    if (exercicioAplicacaoDao.remover(idExclusao)) {
                        System.out.println("Exercício excluído com sucesso");
                    } else {
                        System.out.println("Exercício não encontrado");
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcaoUsuario != 5);

        scanner.close(); // Fechar o scanner após o uso completo
    }

    private ExercicioAplicacao criaExercicio() {
        ExercicioAplicacao exercicio = new ExercicioAplicacao();
        System.out.print("\nDescrição: ");
        String descricao = scanner.nextLine();
        exercicio.setDescricao(descricao);
        return exercicio;
    }

    private int pegaOpcaoUsuario() {
        int opc = 0;
        boolean opcaoValida = false;
        while (!opcaoValida) {
            try {
                System.out.println("1 - Cadastrar exercício aplicação");
                System.out.println("2 - Mostrar todos exercícios aplicação");
                System.out.println("3 - Alterar a descrição do exercício aplicação");
                System.out.println("4 - Excluir pelo ID");
                System.out.println("5 - Voltar");
                System.out.print("Qual sua opção? R: ");
                opc = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer
                if (opc >= 1 && opc <= 5) {
                    opcaoValida = true;
                } else {
                    System.out.println("Opção inválida. Por favor, escolha um número entre 1 e 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine(); // Limpar o buffer
            }
        }
        return opc;
    }

    private int lerInteiro() {
        int numero = 0;
        boolean valido = false;
        while (!valido) {
            try {
                numero = Integer.parseInt(scanner.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
            }
        }
        return numero;
    }
}
