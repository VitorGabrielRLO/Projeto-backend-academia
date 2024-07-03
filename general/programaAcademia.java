package general;

import dao.AcademiaDAO;
import entities.Academia;
import java.time.LocalDate;
import java.util.Scanner;

public class programaAcademia {
    private AcademiaDAO academiaDAO;

    public programaAcademia() {
        this.academiaDAO = new AcademiaDAO();
    }

    Scanner s = new Scanner(System.in);

    public void mostrarMenu() {
        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                    Academia academia = criaAcademia();

                    boolean academiaFoiInserida = academiaDAO.adiciona(academia);
                    if (academiaFoiInserida) {
                        System.out.println("Academia inserida com sucesso");
                    } else {
                        System.out.println("Erro ao inserir academia");
                    }
                    break;

                case 2:
                    academiaDAO.mostrarTodasAcademias();
                    break;

                case 3:
                    System.out.println("Digite o nome da academia a ser alterada:");
                    String procurado = s.nextLine();
                    System.out.println("Digite o novo nome:");
                    String novoNome = s.nextLine();

                    if (academiaDAO.alterarNome(procurado, novoNome)) {
                        System.out.println("Nome da academia alterado com sucesso");
                    } else {
                        System.out.println("Academia não encontrada");
                    }
                    break;

                case 4:
                    System.out.println("Digite o nome da academia a ser removida:");
                    String nomeExclusao = s.nextLine();

                    if (academiaDAO.remover(nomeExclusao)) {
                        System.out.println("Academia excluída com sucesso");
                    } else {
                        System.out.println("Erro ao excluir academia");
                    }
                    break;

                case 5:
                    System.out.println("Encerrando programa...");
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcaoUsuario != 5);
    }

    private Academia criaAcademia() {
        LocalDate dataCriacao = LocalDate.now();
        Academia academia = new Academia();

        System.out.print("\nNome: ");
        String nome = s.nextLine();
        academia.setNome(nome);

        System.out.print("\nEndereco: ");
        String endereco = s.nextLine();
        academia.setEndereco(endereco);

        academia.setDataCriacao(dataCriacao);

        return academia;
    }

    private int pegaOpcaoUsuario() {
        System.out.println("\n=== Menu ===");
        System.out.println("1 - Cadastrar Academia");
        System.out.println("2 - Mostrar todas as Academias");
        System.out.println("3 - Alterar o nome da Academia");
        System.out.println("4 - Excluir Academia pelo nome");
        System.out.println("5 - Sair");
        System.out.print("Escolha uma opção: ");
        
        int opcao = Integer.parseInt(s.nextLine());
        System.out.println();
        return opcao;
    }
}