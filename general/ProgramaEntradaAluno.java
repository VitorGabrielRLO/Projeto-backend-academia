package general;

import java.util.Scanner;

import dao.EntradaAlunoDao;
import entities.EntradaAluno;

import java.util.Date;

public class ProgramaEntradaAluno{
    EntradaAlunoDao EntradaAlunoDao = new EntradaAlunoDao();
    Scanner s = new Scanner(System.in);

    public void mostrarMenu(){


        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                    EntradaAluno j = criaTreino();

                    boolean pessoaFoiInserida = EntradaAlunoDao.adiciona(j);
                    if (pessoaFoiInserida) {
                        System.out.println("Pessoa inserida com sucesso");
                    } else {
                        System.out.println("Pessoa nao inserida");

                    }

                    break;
                case 2:
                  EntradaAlunoDao.mostrarTodos();
                    break;
                case 4:
                    System.out.println("Id da movimentaçao financeira a ser deletada:");
                    long idExclusao = s.nextLong();

                    if (EntradaAlunoDao.remover(idExclusao)) {
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
    
    private EntradaAluno criaTreino() {
        EntradaAluno j = new EntradaAluno();
        Date dataAtual = new Date();

        System.out.print("\nValor: ");
        double valor = s.nextDouble();
        j.setValor(valor);
        System.out.print("\nDescriçao: ");
        String descricao = s.nextLine();
        j.setDescricao(descricao);
        System.out.print("\n Tipo (1 - entrada / 0 - saida): ");
        int tipo = s.nextInt();
        j.setTipo(tipo);
        MovFinanceiraDao.movimentacaoFin(valor, tipo);
        

        return j;
    }

    private int pegaOpcaoUsuario() {

        System.out.println("1 cadastrar");
        System.out.println("2 mostrar todos");
        System.out.println("3 alterar o nome da pessoa");
        System.out.println("4 excluir pelo id");
        System.out.println("5 sair");
        System.out.print("Qual sua opcao ?R: ");
        return Integer.parseInt(s.nextLine());

    }
    
}