

import java.util.Scanner;

import dao.MovFinanceiraDao;
import entities.MovFinanceira;

import java.util.Date;

public class programaMovFinanceira{
    MovFinanceiraDao MovFinanceiraDao = new MovFinanceiraDao();
    Scanner s = new Scanner(System.in);

    public void mostrarMenu(){


        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                    MovFinanceira j = criaTreino();

                    boolean pessoaFoiInserida = MovFinanceiraDao.adiciona(j);
                    if (pessoaFoiInserida) {
                        System.out.println("Pessoa inserida com sucesso");
                    } else {
                        System.out.println("Pessoa nao inserida");

                    }

                    break;
                case 2:
                  MovFinanceiraDao.mostrarTodos();
                    break;
                case 3:
                    System.out.println("Pessoa a procurada:");
                    String procurado = s.nextLine();
                    System.out.println("Novo nome:");
                    String novoNome = s.nextLine();
                    if (MovFinanceiraDao.alterarNome(procurado, novoNome)) {
                        System.out.println("Pessoa alterado");
                    } else {
                        System.out.println("Pessoa não encontrado");
                    }

                    break;
                case 4:
                    System.out.println("Pessoa procurada:");
                    String nomeExclusao = s.nextLine();

                    if (MovFinanceiraDao.remover(nomeExclusao)) {
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
    
    private MovFinanceira criaTreino() {
        MovFinanceira j = new MovFinanceira();

        System.out.print("\nNome: ");
        String nome = s.nextLine();
        //j.setNome(nome);
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