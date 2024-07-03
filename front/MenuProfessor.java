package front;

import general.*;
import java.util.Scanner;

public class MenuProfessor{

    private programaAcademia programaAcademia;
    private programaPessoaAdmin programaPessoaAdmin; // Mantém uma única instância
    // private programaExercicio programaExercicio;
    // private programaDivisaoTreino programaDivisaoTreino;
    // private programaExercicioAplicacao programaExercicioAplicacao;
    // private programaAvaliacaoFisica programaAvaliacaoFisica;
    // private programaMensalidadeAluno programaMensalidadeAluno;
    // private programaMovFinanceira programaMovFinanceira;
    // private programaTreino programaTreino;
    // private programaAlunoPagamento programaAlunoPagamento;
    // private ProgramaEntradaAluno programaEntradaAluno;
    // private programaFichaTreino programaFichaTreino;
    private programaPessoa programaPessoa;
    
    //private Treino treino;

    public MenuProfessor(){
       
        this.programaPessoa = new programaPessoa(); // Inicializa a instância de programaPessoa
        // this.programaExercicio = new programaExercicio();
        // this.programaDivisaoTreino = new programaDivisaoTreino();
        // this.programaExercicioAplicacao = new programaExercicioAplicacao();
        this.programaAcademia = new programaAcademia();
        // this.programaAvaliacaoFisica = new programaAvaliacaoFisica();
        // this.programaMensalidadeAluno = new programaMensalidadeAluno();
        // this.programaMovFinanceira = new programaMovFinanceira();
        // this.programaTreino = new programaTreino();
        // this.programaAlunoPagamento = new programaAlunoPagamento();
    }
    public void menuProfessor(){
    Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("");
            System.out.println("1. Informações do Aluno");
            System.out.println("2. Exercícios");
            System.out.println("3. Divisoes de treino");
            System.out.println("4. Exercicios Aplicação");
            System.out.println("5. Avaliacao Fisica");
            System.out.println("6. Mensalidade");
            System.out.println("7. Sair");
            System.out.print("Selecione a opção desejada: ");

            int opc = scanner.nextInt();
            scanner.nextLine(); // Consome o caractere de nova linha

            switch (opc) {
                case 1:
                    programaPessoa.mostrarMenu(); // Chama o método para exibir o menu de programaPessoa
                    break;

                case 2:
                    //programaExercicio.mostrarMenu(); // Chama o menu de opções do Treino para mostrar exercícios
                    break;

                case 3:
                    //programaDivisaoTreino.mostrarMenu();
                    break;

                case 4:
                    //programaExercicioAplicacao.mostrarMenu();
                    break;

                case 5:
                    //programaAvaliacaoFisica.mostrarMenu();
                    break;
                
                case 6:
                    //programaMensalidadeAluno.mostrarMenu();
                    break;
                case 7:
                    // scanner.close();
                    System.out.println("Saindo...");
                    
                return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}