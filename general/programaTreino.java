package general;


import java.util.Scanner;

import entities.Treino;
import dao.TreinoDao;

import java.util.Date;

public class programaTreino{
    TreinoDao TreinoDao = new TreinoDao();
    Scanner s = new Scanner(System.in);

    public void mostrarMenu(){


        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                    Treino j = criaTreino();

                    boolean pessoaFoiInserida = TreinoDao.adiciona(j);
                    if (pessoaFoiInserida) {
                        System.out.println("Pessoa inserida com sucesso");
                    } else {
                        System.out.println("Pessoa nao inserida");

                    }

                    break;
                case 2:
                    TreinoDao.mostrarTodos();
                    break;
                case 3:
                    System.out.println("Pessoa a procurada:");
                    String procurado = s.nextLine();
                    System.out.println("Novo nome:");
                    String novoNome = s.nextLine();
                    // if (TreinoDao.alterarNome(procurado, novoNome)) {
                    //     System.out.println("Pessoa alterado");
                    // } else {
                    //     System.out.println("Pessoa não encontrado");
                    // }

                    break;
                case 4:
                    System.out.println("Pessoa procurada:");
                    int id = s.nextInt();

                    if (TreinoDao.remover(id)) {
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
    
    private Treino criaTreino() {
        Treino j = new Treino();

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