package general;

import dao.*;
import entities.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class programaDivisaoTreino {
    private DivisaoTreinoDao divisaoTreinoDao;
    private Scanner scanner;

    public programaDivisaoTreino() {
        this.divisaoTreinoDao = new DivisaoTreinoDao();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                    DivisaoTreino j = criaTreino();
                    boolean divisaoFoiInserida = divisaoTreinoDao.adiciona(j);
                    if (divisaoFoiInserida) {
                        System.out.println("Divisão inserida com sucesso");
                    } else {
                        System.out.println("Divisão não inserida");
                    }
                    break;
                case 2:
                    List<DivisaoTreino> divisaoTreinos = divisaoTreinoDao.mostrarTodos();
                    for (DivisaoTreino a : divisaoTreinos) {
                        System.out.println(a);
                    }
                    break;
                case 3:
                    System.out.print("Divisão a ser procurada: ");
                    String procurado = scanner.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();
                    if (divisaoTreinoDao.alterarNome(procurado, novoNome)) {
                        System.out.println("Divisão alterada");
                    } else {
                        System.out.println("Divisão não encontrada");
                    }
                    break;
                case 4:
                    System.out.print("Divisão a ser excluída: ");
                    String nomeExclusao = scanner.nextLine();
                    if (divisaoTreinoDao.remover(nomeExclusao)) {
                        System.out.println("Divisão excluída");
                    } else {
                        System.out.println("Divisão não excluída");
                    }
                    break;
                case 5:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcaoUsuario != 5);
        
        // Fechar o scanner ao sair do loop
        scanner.close();
    }

    private DivisaoTreino criaTreino() {
        DivisaoTreino j = new DivisaoTreino();
        // Solicita e lê o nome do usuário
        System.out.print("\nNome: ");
        String nome = scanner.nextLine();
        j.setNome(nome);

        // Solicita e lê o nome detalhado do usuário
        System.out.print("\nNome Detalhado: ");
        String nomeDet = scanner.nextLine();
        j.setNomeDetalhado(nomeDet);

        return j; // Retorna o objeto DivisaoTreino criado e preenchido
    }

    private int pegaOpcaoUsuario() {
        int opc = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.println("1 - Cadastrar divisão de treino");
                System.out.println("2 - Mostrar todas as divisões");
                System.out.println("3 - Alterar o nome da divisão");
                System.out.println("4 - Excluir divisão pelo nome");
                System.out.println("5 - Voltar");
                System.out.print("Qual sua opção? R: ");
                opc = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner

                if (opc >= 1 && opc <= 5) {
                    valid = true; // Entrada válida
                } else {
                    System.out.println("Opção inválida. Por favor, escolha um número entre 1 e 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine(); // Limpar o buffer do scanner após InputMismatchException
            }
        }

        return opc;
    }
}
