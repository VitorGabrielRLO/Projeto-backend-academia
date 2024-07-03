package front;

import general.*;
import java.util.Scanner;

public class MenuAluno {
    private ProgramaEntradaAluno programaEntradaAluno;


    public MenuAluno(){
        this.programaEntradaAluno = new ProgramaEntradaAluno();
    }
    

    public void selecioneOpc() {
        Scanner scanner = new Scanner(System.in);
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
                    //programaFichaTreino.mostrarMenu();
                    break;
                
                case 3:
                    System.out.println("Saindo...");
                    return;


                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
