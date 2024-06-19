package front;

import java.util.Scanner;

import dao.AcademiaDAO;
import dao.AlunoPagamentoDao;
import dao.AvaliacaoFisicaDao;
import dao.DivisaoTreinoDao;
import dao.EntradaAlunoDao;
import dao.ExercicioAplicacaoDao;
import dao.ExercicioDao;
import dao.FichaTreinoDao;
import dao.MensalidadeAlunoDao;
import dao.MovFinanceiraDao;
import dao.PagamentoRecorrenteDao;
import dao.PessoaDao;
import dao.TreinoAplicacaoDao;
import dao.TreinoDao;


public class Login {
    private MenuAdmin menuAdmin;
    private MenuAluno menuAluno;
    private AcademiaDAO academiaDAO;
    private AlunoPagamentoDao alunoPagamentoDao ;
    private AvaliacaoFisicaDao  avaliacaoFisicaDao ;
    private DivisaoTreinoDao divisaoTreinoDao ;
    private EntradaAlunoDao entradaAlunoDao ;
    private ExercicioAplicacaoDao exercicioAplicacaoDao;
    private ExercicioDao exercicioDao;
    private FichaTreinoDao fichaTreinoDao;
    private MovFinanceiraDao movFinanceiraDao;
    private PagamentoRecorrenteDao pagamentoRecorrenteDao;
    private PessoaDao pessoaDao;
    private TreinoDao treinoDao;
    private TreinoAplicacaoDao treinoAplicacaoDao;
    private MensalidadeAlunoDao mensalidadeAlunoDao;





    private MenuProfessor menuProfessor;

    public Login(AcademiaDAO academiaDAO, AlunoPagamentoDao alunoPagamentoDao, 
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
        
        this.menuAdmin = new MenuAdmin(academiaDAO, alunoPagamentoDao, avaliacaoFisicaDao, divisaoTreinoDao, entradaAlunoDao, exercicioAplicacaoDao, exercicioDao, fichaTreinoDao, movFinanceiraDao, pagamentoRecorrenteDao, pessoaDao, treinoDao, treinoAplicacaoDao, mensalidadeAlunoDao);
        this.menuProfessor = new MenuProfessor(academiaDAO, alunoPagamentoDao, avaliacaoFisicaDao, divisaoTreinoDao, entradaAlunoDao, exercicioAplicacaoDao, exercicioDao, fichaTreinoDao, movFinanceiraDao, pagamentoRecorrenteDao, pessoaDao, treinoDao, treinoAplicacaoDao, mensalidadeAlunoDao);
        this.menuAluno = new MenuAluno(academiaDAO, alunoPagamentoDao, avaliacaoFisicaDao, divisaoTreinoDao, entradaAlunoDao, exercicioAplicacaoDao, exercicioDao, fichaTreinoDao, movFinanceiraDao, pagamentoRecorrenteDao, pessoaDao, treinoDao, treinoAplicacaoDao, mensalidadeAlunoDao);
    }


    //Serão criados 3 tipos de usuario, cada um com tipos de acessos diferentes
 public void selecioneOpc() {
        

     Scanner scanner = new Scanner(System.in);
        while (true) {
            int condicao = 0;
            while (condicao == 0) {
                System.out.println("Digite seu login: ");    
                String login = scanner.nextLine();
                System.out.println("Digite sua senha");
                String senha = scanner.nextLine();
                int qualquerMerda = login(login, senha);
                switch (qualquerMerda) {
                    case 1:
                    //Aluno 
                    menuAluno.selecioneOpc();

                    condicao = 1;
                    break;
                    
                    case 2:
                    //Professor
                    menuProfessor.menuProfessor();

                    condicao = 1;
                    break;
                    
                    case 3:
                    //Adm
                    menuAdmin.selecioneOpc();
                    condicao = 1;
                    break;
                    default:
                    // scanner.close();
                    System.out.println("Login inválida.");
                    condicao = 0;
                    break;

             }
            }
        }
    }
    
    private int login(String login, String senha)
    {   

        var pessoa = this.pessoaDao.buscaLogin(login);
        if (pessoa == null) {
            return 0;
        }
        if(!pessoa.getSenhaPessoa().equals(senha)){
            return 0;
            
        }
        return pessoa.getTipoUsuarioPessoa();
    }

}
