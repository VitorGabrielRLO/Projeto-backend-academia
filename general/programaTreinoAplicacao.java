package general;

import java.util.Scanner;

import dao.TreinoAplicacaoDao;
import entities.TreinoAplicacao;

import java.util.Date;

public class programaTreinoAplicacao{
    TreinoAplicacaoDao TreinoAplicacaoDao = new TreinoAplicacaoDao();
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
                        System.out.println("Treino aplicaçao inserido com sucesso");
                    } else {
                        System.out.println("Treino aplicaçao nao inserido");

                    }

                    break;
                case 2:
                TreinoAplicacaoDao.mostrarTodos();
                    break;
                case 3:


                    break;
                case 4:
                    System.out.println("Treino aplicaçao procurada:");
                    String nomeExclusao = s.nextLine();

                    if (TreinoAplicacaoDao.remover(nomeExclusao)) {
                        System.out.println("Treino aplicaçao excluída");
                    } else {
                        System.out.println("Treino aplicaçao não excluída");
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

        System.out.println("1. Cadastrar Treino aplicaçao");
        System.out.println("2. mostrar todos");
        System.out.println("3. alterar o nome da pessoa");
        System.out.println("4. excluir pelo id");
        System.out.println("5. sair");
        System.out.print("Qual sua opcao ?R: ");
        return Integer.parseInt(s.nextLine());

    }
    
}