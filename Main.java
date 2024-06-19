
import dao.TesteAcademiaDAO;
import entities.*;


public class Main {

    
    
    
    
    
    
    public static void main(String[] args) throws Exception {
         Academia a = new Academia();
     
         a.setNome("Vitor Gabirl");
         a.setEndereco("Rua num sei o que");

         new TesteAcademiaDAO().cadastrarAcademia(a);

    //     var academiaDAO = new AcademiaDAO();
    //     var alunoPagamentoDao = new AlunoPagamentoDao();
    //     var avaliacaoFisicaDao = new AvaliacaoFisicaDao();
    //     var divisaoTreinoDao = new DivisaoTreinoDao();
    //     var entradaAlunoDao = new EntradaAlunoDao();
    //     var exercicioAplicacaoDao = new ExercicioAplicacaoDao();
    //     var exercicioDao = new ExercicioDao();
    //     var fichaTreinoDao = new FichaTreinoDao();
    //     var movFinanceiraDao = new MovFinanceiraDao();
    //     var pagamentoRecorrenteDao = new PagamentoRecorrenteDao();
    //     var pessoaDao = new PessoaDao();
    //     var treinoDao = new TreinoDao();
    //     var treinoAplicacaoDao = new TreinoAplicacaoDao();
    //     var mensalidadeAlunoDao = new MensalidadeAlunoDao();

    //      var Login = new Login(academiaDAO, alunoPagamentoDao, avaliacaoFisicaDao, divisaoTreinoDao,
    //      entradaAlunoDao, exercicioAplicacaoDao, exercicioDao, fichaTreinoDao, movFinanceiraDao,
    //      pagamentoRecorrenteDao, pessoaDao, treinoDao, treinoAplicacaoDao,mensalidadeAlunoDao);
    //      Login.selecioneOpc();
    //     // menuSelecao.selecioneOpc();
     }


    //LOGIN PARA ACESSAR FUNÇOES ADMIN
    //Login: Admin
    //Senha: Admin

    //LOGIN PARA ACESSAR FUNÇOES Professor
    //Login: Professor
    //Senha: Professor

    //LOGIN PARA ACESSAR FUNÇOES Aluno
    //Login: Virginia
    //Senha: Virginia
}
