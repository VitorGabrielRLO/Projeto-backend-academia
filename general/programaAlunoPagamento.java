package general;

import dao.AlunoPagamentoDao;
import entities.AlunoPagamento;
import entities.MensalidadeVigente;

import java.util.Scanner;
import java.util.Date;

public class programaAlunoPagamento{
    AlunoPagamentoDao AlunoPagamentoDao = new AlunoPagamentoDao();
    Scanner s = new Scanner(System.in);

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
                    // System.out.println("Divisao a procurada:");
                    // String procurado = s.nextLine();
                    // System.out.println("Novo nome:");
                    // String novoNome = s.nextLine();
                    // if (AvaliacaoFisicaDao.alterarNome(procurado, novoNome)) {
                    //     System.out.println("Divisao alterado");
                    // } else {
                    //     System.out.println("Divisao não encontrado");
                    // }

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
        Date dataAtual = new Date();
        //     //Resolver o que fazer
        
        //     // AlunoPagamento j = new AlunoPagamento();
        
        //     // System.out.print("\nPeso: ");
        //     // MensalidadeVigente mensalidade = s.nextDouble();
        //     // j.setMensalidade(mensalidade);
        
        j.setDataCriacao(dataAtual);

        
         return j;
     }

    private int pegaOpcaoUsuario() {

        System.out.println("1 - Registrar Pagamento");
        System.out.println("2 - Mostrar todas as avaliacoes");
        System.out.println("3 - Atualizar avaliacao");
        System.out.println("4 - Excluir avaliacao pelo id");
        System.out.println("5 - Voltar");
        System.out.print("Qual sua opcao ?R: ");
        return Integer.parseInt(s.nextLine());

    }
    


}