package general;

import java.util.Scanner;

import dao.*;
import entities.*;

import java.util.Date;

public class programaTreinoAplicacao{
    private TreinoAplicacaoDao TreinoAplicacaoDao;

    public programaTreinoAplicacao(){
        this.TreinoAplicacaoDao = new TreinoAplicacaoDao();
    }

    Scanner s = new Scanner(System.in);

    public void mostrarMenu(){


        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                    TreinoAplicacao j = criaTreinoApp();

                    boolean pessoaFoiInserida = TreinoAplicacaoDao.adiciona(j);
                    if (pessoaFoiInserida) {
                        System.out.println("Pessoa inserida com sucesso");
                    } else {
                        System.out.println("Pessoa nao inserida");

                    }

                    break;
                case 2:
                TreinoAplicacaoDao.mostrarTodos();
                    break;
                case 3:


                    break;
                case 4:
                    System.out.println("Pessoa procurada:");
                    String nomeExclusao = s.nextLine();

                    if (TreinoAplicacaoDao.remover(nomeExclusao)) {
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
    

    private TreinoAplicacao criaTreinoApp() {
        TreinoAplicacao j = new TreinoAplicacao();
        Date dataAtual = new Date();

        j.setDataCriacao(dataAtual);

    //     System.out.print("\nNome: ");
    //     String nome = s.nextLine();
    //    // j.setNome(nome);
    //     System.out.print("\nDescriçao: ");
    //     String descricao = s.nextLine();
    //    // j.setDescricaoFoto(descricao);

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