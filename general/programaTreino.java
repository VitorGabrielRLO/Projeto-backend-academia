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

        Date dataAtual = new Date();
        j.setDataCriacao(dataAtual);


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