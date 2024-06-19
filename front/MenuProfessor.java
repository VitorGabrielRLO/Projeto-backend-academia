package front;

import java.util.Scanner;
import general.*;
import entities.*;
import dao.*;

public class MenuProfessor{

    private programaAcademia programaAcademia;
    private programaPessoaAdmin programaPessoaAdmin; // Mantém uma única instância
    private programaExercicio programaExercicio;
    private programaDivisaoTreino programaDivisaoTreino;
    private programaExercicioAplicacao programaExercicioAplicacao;
    private programaAvaliacaoFisica programaAvaliacaoFisica;
    private programaMensalidadeAluno programaMensalidadeAluno;
    private programaMovFinanceira programaMovFinanceira;
    private programaTreino programaTreino;
    private AcademiaDAO academiaDAO;
    private AlunoPagamentoDao alunoPagamentoDao;
    private AvaliacaoFisicaDao  avaliacaoFisicaDao;
    private DivisaoTreinoDao divisaoTreinoDao;
    private EntradaAlunoDao entradaAlunoDao;
    private ExercicioAplicacaoDao exercicioAplicacaoDao;
    private ExercicioDao exercicioDao;
    private FichaTreinoDao fichaTreinoDao;
    private MovFinanceiraDao movFinanceiraDao;
    private PagamentoRecorrenteDao pagamentoRecorrenteDao;
    private PessoaDao pessoaDao;
    private TreinoDao treinoDao;
    private TreinoAplicacaoDao treinoAplicacaoDao;
    private programaAlunoPagamento programaAlunoPagamento;
    private MensalidadeAlunoDao mensalidadeAlunoDao;
    private ProgramaEntradaAluno programaEntradaAluno;
    private programaFichaTreino programaFichaTreino;
    private programaPessoa programaPessoa;
    
    //private Treino treino;

    public MenuProfessor(AcademiaDAO academiaDAO, AlunoPagamentoDao alunoPagamentoDao, 
    AvaliacaoFisicaDao avaliacaoFisicaDao, DivisaoTreinoDao divisaoTreinoDao,
        EntradaAlunoDao entradaAlunoDao,ExercicioAplicacaoDao exercicioAplicacaoDao,
        ExercicioDao exercicioDao,FichaTreinoDao fichaTreinoDao,MovFinanceiraDao movFinanceiraDao,
        PagamentoRecorrenteDao pagamentoRecorrenteDao,PessoaDao pessoaDao, 
        TreinoDao treinoDao, TreinoAplicacaoDao treinoAplicacaoDao, MensalidadeAlunoDao mensalidadeAlunoDao){
        this.academiaDAO = academiaDAO;
        this.alunoPagamentoDao= alunoPagamentoDao;
        this.avaliacaoFisicaDao=avaliacaoFisicaDao ;
        this.divisaoTreinoDao= divisaoTreinoDao;
        this.entradaAlunoDao=entradaAlunoDao ;
        this.exercicioAplicacaoDao= exercicioAplicacaoDao;
        this.exercicioDao= exercicioDao;
        this.fichaTreinoDao=fichaTreinoDao ;
        this.movFinanceiraDao=movFinanceiraDao ;
        this.pagamentoRecorrenteDao=pagamentoRecorrenteDao ;
        this.pessoaDao= pessoaDao;
        this.treinoDao= treinoDao;
        this.treinoAplicacaoDao= treinoAplicacaoDao;
        this.pessoaDao = pessoaDao;
        this.mensalidadeAlunoDao = mensalidadeAlunoDao;
        
        this.programaPessoa = new programaPessoa(pessoaDao); // Inicializa a instância de programaPessoa
        this.programaExercicio = new programaExercicio(exercicioDao);
        this.programaDivisaoTreino = new programaDivisaoTreino(divisaoTreinoDao);
        this.programaExercicioAplicacao = new programaExercicioAplicacao(exercicioAplicacaoDao);
        this.programaAcademia = new programaAcademia(academiaDAO);
        this.programaAvaliacaoFisica = new programaAvaliacaoFisica(avaliacaoFisicaDao, movFinanceiraDao);
        this.programaMensalidadeAluno = new programaMensalidadeAluno(mensalidadeAlunoDao, movFinanceiraDao);
        this.programaMovFinanceira = new programaMovFinanceira(movFinanceiraDao);
        this.programaTreino = new programaTreino(treinoDao);
        this.programaAlunoPagamento = new programaAlunoPagamento(alunoPagamentoDao, movFinanceiraDao);
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
                    programaExercicio.mostrarMenu(); // Chama o menu de opções do Treino para mostrar exercícios
                    break;

                case 3:
                    programaDivisaoTreino.mostrarMenu();
                    break;

                case 4:
                    programaExercicioAplicacao.mostrarMenu();
                    break;

                case 5:
                    programaAvaliacaoFisica.mostrarMenu();
                    break;
                
                case 6:
                    programaMensalidadeAluno.mostrarMenu();
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