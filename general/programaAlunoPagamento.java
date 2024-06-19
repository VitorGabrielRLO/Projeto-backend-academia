package general;

import dao.AlunoPagamentoDao;
import entities.AlunoPagamento;
import entities.MensalidadeAluno;
import dao.MensalidadeAlunoDao;
import java.util.Scanner;
import java.util.Date;
import java.time.LocalDate;
// import entities.MensalidadeAluno;
import dao.MovFinanceiraDao;
import entities.MovFinanceira;

public class programaAlunoPagamento{
    
    
    private AlunoPagamentoDao AlunoPagamentoDao;
    private MovFinanceiraDao MovFinanceiraDao;
    Scanner s = new Scanner(System.in);

    public programaAlunoPagamento(AlunoPagamentoDao alunoPagamentoDao, MovFinanceiraDao MovFinanceiraDao){
        this.AlunoPagamentoDao = alunoPagamentoDao;
        this.MovFinanceiraDao = MovFinanceiraDao;
    }

    public void mostrarMenu(){
        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                    AlunoPagamento j = AlunoPagamento();

                    boolean pessoaFoiInserida = AlunoPagamentoDao.adiciona(j);
                    if (pessoaFoiInserida) {
                        System.out.println("Divisao inserida com sucesso");
                    } else {
                        System.out.println("Divisao nao inserida");

                    }

                    break;
                case 2:
                    AlunoPagamentoDao.mostrarTodos();
                    break;
                case 3:


                    break;
                case 4:
  

                    break;
                case 5:
                    System.out.println("5");

                    break;

                default:
                    System.out.println("sair");

                    break;

            }
        }while (opcaoUsuario != 5);
    }
    
    private AlunoPagamento AlunoPagamento() {
        AlunoPagamento j = new AlunoPagamento();
        MensalidadeAlunoDao MensalidadeAlunoDao = new MensalidadeAlunoDao();
        // Date dataAtual = new Date();
        // MensalidadeAluno j = new MensalidadeAluno();
        // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        MovFinanceira mov = new MovFinanceira();
        LocalDate dataAtual = LocalDate.now();


        
        MensalidadeAlunoDao.mostrarTodos();
        System.out.print("\nEscolha seu plano pelo id: ");
        Long plano = s.nextLong();

        double valor = MensalidadeAlunoDao.escolherId(plano);
        String nomePlano = MensalidadeAlunoDao.pegaPlano(plano);
            
            LocalDate dataVencimento = dataAtual.plusDays(30);
            j.setValor(valor);
            j.setPlano(nomePlano);
            j.setVencimento(dataVencimento);
            mov.setValor(valor);
            mov.setTipo(1);
            mov.setDescricao("Mensalidade");
            mov.setDataCriacao(dataAtual);
        
        MovFinanceiraDao.adiciona(mov);
        return j;
     }

    private int pegaOpcaoUsuario() {

        int opc;

        System.out.println("1 - Registrar Pagamento");
        System.out.println("2 - Mostrar todas as avaliacoes");
        System.out.println("3 - Atualizar avaliacao");
        System.out.println("4 - Excluir avaliacao pelo id");
        System.out.println("5 - Voltar");
        System.out.print("Qual sua opcao ?R: ");
        
        opc = s.nextInt();
        return opc;
    }
    


}