package general;

import dao.*;
import entities.EntradaAluno;
import java.time.LocalDate;
import java.util.Scanner;

public class ProgramaEntradaAluno {
    private EntradaAlunoDao entradaAlunoDao;
    private AlunoPagamentoDao alunoPagamentoDao;
    private Scanner s;

    public ProgramaEntradaAluno() {
        this.entradaAlunoDao = new EntradaAlunoDao();
        this.alunoPagamentoDao = new AlunoPagamentoDao();
        this.s = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                    EntradaAluno entrada = entradaAluno();
                    LocalDate agora = LocalDate.now();

                    if (agora.isBefore(alunoPagamentoDao.buscaPorNomePessoa(entrada.getNome()))) {
                        entradaAlunoDao.adiciona(entrada);
                        System.out.println("\nEntrada registrada, Bem vindo\n");
                    } else {
                        System.out.println("\nEntrada não inserida, consulte a recepção\n");
                    }
                    break;
                case 2:
                    entradaAlunoDao.mostrarTodos();
                    break;
                case 3:
                    System.out.println("Saindo do menu de entrada de alunos...\n");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcaoUsuario != 3);
    }

    private EntradaAluno entradaAluno() {
        EntradaAluno entrada = new EntradaAluno();
        System.out.print("\nNome: ");
        String nome = s.nextLine();
        entrada.setNome(nome);
        return entrada;
    }

    private int pegaOpcaoUsuario() {
        System.out.println("1 - Registrar entrada");
        System.out.println("2 - Mostrar todos os registros de entrada");
        System.out.println("3 - Sair");
        System.out.print("Qual sua opção? R: ");
        return Integer.parseInt(s.nextLine());
    }
}
