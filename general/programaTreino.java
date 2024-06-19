package general;


import java.util.Scanner;

import entities.*;
import dao.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class programaTreino{
    private TreinoDao TreinoDao;

    public programaTreino(TreinoDao TreinoDao){
        this.TreinoDao = TreinoDao;
    }
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
                    System.out.println("Treino procurada:");
                    int id = s.nextInt();

                    if (TreinoDao.remover(id)) {
                        System.out.println("Treino excluído");
                    } else {
                        System.out.println("Treino não excluído");
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
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        j.setDataCriacao(sdf.format(dataAtual));


        return j;
    }

    private int pegaOpcaoUsuario() {

        System.out.println("1 - Cadastrar treino");
        System.out.println("2 - Mostrar todos");
        System.out.println("3 - Alterar o nome da pessoa");
        System.out.println("4 - Excluir pelo id");
        System.out.println("5 - Sair");
        System.out.print("Qual sua opcao ?R: ");
        return Integer.parseInt(s.nextLine());

    }
    
}