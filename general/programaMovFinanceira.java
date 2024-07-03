package general;

import dao.MovFinanceiraDao;
import entities.*;
import java.util.List;
import java.util.Scanner;

public class programaMovFinanceira{

    
    private MovFinanceiraDao MovFinanceiraDao;
    public programaMovFinanceira(){
        this.MovFinanceiraDao = new MovFinanceiraDao();
    }

    Scanner s = new Scanner(System.in);

    public void mostrarMenu(){


        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                    MovFinanceira j = criaMovimentacao();

                    boolean pessoaFoiInserida = MovFinanceiraDao.adiciona(j);
                    if (pessoaFoiInserida) {
                        System.out.println("Movimentaçao inserida inserida com sucesso");
                    } else {
                        System.out.println("Movimentação nao inserida");

                    }

                    break;
                case 2:
                  List<MovFinanceira> movFinanceiras = MovFinanceiraDao.mostrarTodos();
                    if (movFinanceiras.isEmpty()) {
                        System.out.println("Nenhuma movimentação encontrada.");
                    } else {
                        for (MovFinanceira movFinanceira : movFinanceiras) {
                            System.out.println(movFinanceira);
                        }
                    }
                    double gastoTotal = MovFinanceiraDao.valorTotal();
                    System.out.println("Soma de todos valores: "+ gastoTotal);
                    break;
                case 3:
                    System.out.println("Ano da pesquisa: ");
                    Long ano = s.nextLong();
                    System.out.println("Mês da pesquisa: ");
                    Long mes = s.nextLong();
                  List<MovFinanceira> movFinanceirasMes = MovFinanceiraDao.mostrarTodosPorMes(ano, mes);
                    if (movFinanceirasMes.isEmpty()) {
                        System.out.println("Nenhuma movimentação encontrada.");
                    } else {
                        for (MovFinanceira movFinanceira : movFinanceirasMes) {
                            System.out.println(movFinanceira);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Id da movimentaçao financeira a ser deletada:");
                    long idExclusao = s.nextLong();

                    if (MovFinanceiraDao.remover(idExclusao)) {
                        System.out.println("Movimentacao excluída");
                    } else {
                        System.out.println("Movimentacao excluída");
                    }

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
    
    private MovFinanceira criaMovimentacao() {
        MovFinanceira j = new MovFinanceira();

        
        System.out.print("\nValor: ");
        double valor = s.nextDouble();
        
        System.out.print("\nDescriçao: ");
        String descricao = s.next();

        System.out.print("\n Tipo (1 - entrada / 0 - saida): ");
        int tipo = s.nextInt();
        
        if(tipo == 0)
            valor = valor *(-1);
            
        j.setDescricao(descricao);
        j.setValor(valor);
        j.setTipo(tipo);
        // MovFinanceiraDao.movimentacaoFin(valor, tipo);


        return j;
    }

    private int pegaOpcaoUsuario() {

        int opc;
        System.out.println("1 cadastrar movimentacao");
        System.out.println("2 mostrar todos");
        System.out.println("3 mostrar todos por mes");
        System.out.println("4 excluir pelo id");
        System.out.println("5 sair");
        System.out.print("Qual sua opcao ?R: ");
        
        opc = s.nextInt();
        return opc;


    }
    
}