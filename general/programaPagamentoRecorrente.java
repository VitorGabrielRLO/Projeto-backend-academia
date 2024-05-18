package general;

import java.util.Scanner;

import dao.PagamentoRecorrenteDao;
import entities.PagamentoRecorrente;

import java.util.Date;

public class programaPagamentoRecorrente{
    PagamentoRecorrenteDao PagamentoRecorrenteDao = new PagamentoRecorrenteDao();
    Scanner s = new Scanner(System.in);

    public void mostrarMenu(){


        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                    PagamentoRecorrente j = criaExercicio();

                    boolean pessoaFoiInserida = PagamentoRecorrenteDao.adiciona(j);
                    if (pessoaFoiInserida) {
                        System.out.println("Pessoa inserida com sucesso");
                    } else {
                        System.out.println("Pessoa nao inserida");

                    }

                    break;
                case 2:
                PagamentoRecorrenteDao.mostrarTodos();
                    break;
                case 3:
                    System.out.println("Pessoa a procurada:");
                    String procurado = s.nextLine();
                    System.out.println("Novo nome:");
                    String novoNome = s.nextLine();
                    if (PagamentoRecorrenteDao.alterarNome(procurado, novoNome)) {
                        System.out.println("Pessoa alterado");
                    } else {
                        System.out.println("Pessoa não encontrado");
                    }

                    break;
                case 4:
                    System.out.println("Pessoa procurada:");
                    String nomeExclusao = s.nextLine();

                    if (PagamentoRecorrenteDao.remover(nomeExclusao)) {
                        System.out.println("Pessoa excluída");
                    } else {
                        System.out.println("Pessoa não excluída");
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
    
    private PagamentoRecorrente criaExercicio() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'criaExercicio'");
    }

    private PagamentoRecorrente criaAcademia() {
        PagamentoRecorrente j = new PagamentoRecorrente();

        System.out.print("\nNome: ");
        String nome = s.nextLine();
       // j.setNome(nome);
        System.out.print("\nDescriçao: ");
        String descricao = s.nextLine();
       // j.setDescricaoFoto(descricao);

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