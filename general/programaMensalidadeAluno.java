package general;

import dao.*;
import entities.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class programaMensalidadeAluno {
    private MensalidadeAlunoDao mensalidadeAlunoDao;
    private MovFinanceiraDao movFinanceiraDao;
    private Scanner scanner;

    public programaMensalidadeAluno() {
        this.mensalidadeAlunoDao = new MensalidadeAlunoDao();
        this.movFinanceiraDao = new MovFinanceiraDao();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                    MensalidadeAluno novoPlano = registraMensalidade();

                    boolean planoInserido = mensalidadeAlunoDao.adiciona(novoPlano);
                    if (planoInserido) {
                        System.out.println("Plano inserido com sucesso");
                    } else {
                        System.out.println("Plano não inserido");
                    }
                    break;
                case 2:
                    List<MensalidadeAluno> planos = mensalidadeAlunoDao.mostrarTodos();
                    if (planos.isEmpty()) {
                        System.out.println("Nenhum plano encontrado.");
                    } else {
                        for (MensalidadeAluno plano : planos) {
                            System.out.println(plano);
                            System.out.println("----------------------------------");
                        }
                    }
                    break;
                case 3:
                System.out.println("Id do plano a ser alterado:");
                Long idProcurado = null;
                try {
                    idProcurado = scanner.nextLong();
                } catch (InputMismatchException e) {
                    System.out.println("Id inválido. Por favor, insira um número válido.");
                    scanner.nextLine(); // Limpa o buffer do scanner
                    break;
                }
            
                System.out.println("Novo Valor:");
                double novoValor = scanner.nextDouble();
            
                System.out.println("Novo Plano: ");
                String novoPlanoStr = scanner.next(); // Renomeando para novoPlanoStr
            
                if (mensalidadeAlunoDao.alterarValor(idProcurado, novoValor, novoPlanoStr)) {
                    System.out.println("Plano alterado com sucesso");
                } else {
                    System.out.println("Plano não encontrado");
                }
                break;
                case 4:
                System.out.println("Id do plano a ser excluído:");
                Long idExcluir = null;
                try {
                    idExcluir = scanner.nextLong();
                } catch (InputMismatchException e) {
                    System.out.println("Id inválido. Por favor, insira um número válido.");
                    scanner.nextLine(); // Limpa o buffer do scanner
                    break;
                }

                if (mensalidadeAlunoDao.remover(idExcluir)) {
                    System.out.println("Plano excluído com sucesso");
                } else {
                    System.out.println("Plano não encontrado");
                }
                break;
            }
        } while (opcaoUsuario != 5);

        scanner.close();
    }

    private MensalidadeAluno registraMensalidade() {
        MensalidadeAluno plano = new MensalidadeAluno();

        // Limpa o buffer de entrada antes de capturar a entrada do usuário
        scanner.nextLine();

        // Ler o plano do usuário
        System.out.print("\nPlano: ");
        String planoStr = scanner.nextLine();

        // Ler a descrição do usuário
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        // Ler o valor do usuário com validação
        double valor = 0;
        boolean valorValido = false;
        while (!valorValido) {
            try {
                System.out.print("Valor: ");
                valor = scanner.nextDouble();
                valorValido = true; // Se o valor for válido, sair do loop
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Por favor, insira um número.");
                scanner.next(); // Limpar a entrada inválida
            }
        }

        // Configurar os valores no objeto MensalidadeAluno
        plano.setPlano(planoStr);
        plano.setDescricao(descricao);
        plano.setValor(valor);

        return plano;
    }

    private int pegaOpcaoUsuario() {
        int opc = 0;
        boolean opcaoValida = false;
        while (!opcaoValida) {
            try {
                System.out.println("\n\n");
                System.out.println("----------------------------------");
                System.out.println("1 - Criar um plano");
                System.out.println("2 - Mostrar todos os planos");
                System.out.println("3 - Alterar plano pelo id");
                System.out.println("4 - Excluir plano pelo id");
                System.out.println("5 - Sair");
                System.out.print("Qual sua opção? R: ");

                opc = scanner.nextInt();
                opcaoValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida. Por favor, insira um número.");
                scanner.next(); // Limpar a entrada inválida
            }
        }
        return opc;
    }
}
