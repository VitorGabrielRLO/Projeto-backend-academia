package front;

import general.*;
import java.util.Scanner;

public class MenuAdmin {
    private programaAcademia programaAcademia;
    private programaPessoaAdmin programaPessoaAdmin;
    private programaExercicio programaExercicio;
    private programaDivisaoTreino programaDivisaoTreino;
    private programaExercicioAplicacao programaExercicioAplicacao;
    private programaAvaliacaoFisica programaAvaliacaoFisica;
    private programaMensalidadeAluno programaMensalidadeAluno;
    private programaMovFinanceira programaMovFinanceira;
    private programaMensalidadeVigente programaMensalidadeVigente;
    private programaPagamentoRecorrente programaPagamentoRecorrente;
    private programaTreino programaTreino;
    private programaAlunoPagamento programaAlunoPagamento;
    private programaTreinoAplicacao programaTreinoAplicacao;
    private programaFichaTreino programaFichaTreino;

    public MenuAdmin() {
        this.programaAcademia = new programaAcademia();
        this.programaPessoaAdmin = new programaPessoaAdmin();
        this.programaAvaliacaoFisica = new programaAvaliacaoFisica();
        this.programaMovFinanceira = new programaMovFinanceira();
        this.programaDivisaoTreino = new programaDivisaoTreino();
        this.programaExercicio = new programaExercicio();
        this.programaExercicioAplicacao = new programaExercicioAplicacao();
        this.programaMensalidadeAluno = new programaMensalidadeAluno();
        this.programaMensalidadeVigente = new programaMensalidadeVigente();
        this.programaPagamentoRecorrente = new programaPagamentoRecorrente();
        this.programaAlunoPagamento = new programaAlunoPagamento();
        this.programaTreino = new programaTreino();
        this.programaTreinoAplicacao = new programaTreinoAplicacao();
        this.programaFichaTreino = new programaFichaTreino();
    }

    public void selecioneOpc() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("");
            System.out.println("1. Acessar Área da Academia");
            System.out.println("2. Acessar informações do Aluno");
            System.out.println("3. Mostrar Exercícios");
            System.out.println("4. Mostrar divisões de treino");
            System.out.println("5. Acessar Exercícios Aplicação");
            System.out.println("6. Avaliação Física");
            System.out.println("7. Mensalidade");
            System.out.println("8. Movimentação financeira");
            System.out.println("9. Planos da Academia");
            System.out.println("10. Pagamento Mensalidade Aluno");
            System.out.println("11. Pagamento Recorrente");
            System.out.println("12. Acessar Treino");
            System.out.println("13. Acessar Treino Aplicação");
            System.out.println("14. Acessar Ficha treino");
            System.out.println("15. Sair");
            System.out.print("Selecione a opção desejada: ");

            int opc = scanner.nextInt();
            scanner.nextLine(); // Consome o caractere de nova linha

            switch (opc) {
                case 1:
                    programaAcademia.mostrarMenu();
                    break;
                case 2:
                    programaPessoaAdmin.mostrarMenu();
                    break;
                case 3:
                    programaExercicio.mostrarMenu();
                    break;
                case 4:
                    programaDivisaoTreino.mostrarMenu();
                    break;
                case 5:
                    programaExercicioAplicacao.mostrarMenu();
                    break;
                case 6:
                    programaAvaliacaoFisica.mostrarMenu();
                    break;
                case 7:
                    programaMensalidadeAluno.mostrarMenu();
                    break;
                case 8:
                    programaMovFinanceira.mostrarMenu();
                    break;
                case 9:
                    programaMensalidadeVigente.mostrarMenu();
                    break;
                case 10:
                    programaAlunoPagamento.mostrarMenu();
                    break;
                case 11:
                    programaPagamentoRecorrente.mostrarMenu();
                    break;
                case 12:
                    programaTreino.mostrarMenu();
                    break;
                case 13:
                    programaTreinoAplicacao.mostrarMenu();
                    break;
                case 14:
                    programaFichaTreino.mostrarMenu();
                    break;
                case 15:
                    System.out.println("Encerrando o programa...");
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
