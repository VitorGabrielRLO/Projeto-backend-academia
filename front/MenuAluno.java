package front;

import general.*;
import java.util.Scanner;

public class MenuAluno {
    private ProgramaEntradaAluno programaEntradaAluno;
    private Scanner scanner;

    public MenuAluno() {
        this.programaEntradaAluno = new ProgramaEntradaAluno();
        this.scanner = new Scanner(System.in);
    }

    public void selecioneOpc() {
        while (true) {
            System.out.println("");
            System.out.println("1. Entrada");
            System.out.println("2. Ficha Treino");
            System.out.println("3. Sair");
            System.out.print("Selecione a opção desejada: ");

            int opc = scanner.nextInt();
            scanner.nextLine(); // Consome o caractere de nova linha

            switch (opc) {
                case 1:
                    programaEntradaAluno.mostrarMenu();
                    break;

                case 2:
                    // Caso a ficha de treino não seja necessária, este case pode ser removido
                    System.out.println("Funcionalidade de Ficha Treino ainda não implementada.");
                    break;

                case 3:
                    System.out.println("Saindo...");
                    scanner.close(); // Fechar o scanner ao sair
                    return;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
