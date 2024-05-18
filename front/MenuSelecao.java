package front;


import java.util.Scanner;

import entities.*;
import general.*;

public class MenuSelecao {
    private programaAcademia programaAcademia;
    private programaPessoa programaPessoa; // Mantém uma única instância
    private programaExercicio programaExercicio;
    private programaDivisaoTreino programaDivisaoTreino;
    private programaExercicioAplicacao programaExercicioAplicacao;
    
    //private Treino treino;

    public MenuSelecao() {
        this.programaPessoa = new programaPessoa(); // Inicializa a instância de programaPessoa
        this.programaExercicio = new programaExercicio();
        this.programaDivisaoTreino = new programaDivisaoTreino();
        this.programaExercicioAplicacao = new programaExercicioAplicacao();
        this.programaAcademia = new programaAcademia();
       // this.treino = new Treino();
        // Inicialize outras variáveis se necessário
    }

    public void selecioneOpc() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("");
            System.out.println("1. Acessar Área da Academia");
            System.out.println("2. Acessar informações do Aluno");
            System.out.println("3. Mostrar Exercícios");
            System.out.println("4. Mostrar divisoes de treino");
            System.out.println("5. Acessar Exercicios Aplicação");
            System.out.println("6. Sair");
            System.out.print("Selecione a opção desejada: ");

            int opc = scanner.nextInt();
            scanner.nextLine(); // Consome o caractere de nova linha

            switch (opc) {
                case 1:
                    programaAcademia.mostrarMenu(); // Chama o método para adicionar informações
                    break;

                case 2:
                    programaPessoa.mostrarMenu(); // Chama o método para exibir o menu de programaPessoa
                    break;

                case 3:
                    programaExercicio.mostrarMenu(); // Chama o menu de opções do Treino para mostrar exercícios
                    break;

                case 4:
                    programaDivisaoTreino.mostrarMenu();
                    break;

                case 5:
                    programaExercicioAplicacao.mostrarMenu();
                    break;
                case 6:
                System.out.println("Encerrando o programa...");
                return;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}