package general;

import java.util.Scanner;
import java.util.Date;

import dao.ExercicioDao;
import entities.Exercicio;

public class programaExercicio{
    ExercicioDao ExercicioDao = new ExercicioDao();
    Scanner s = new Scanner(System.in);

    public void mostrarMenu(){


        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                    Exercicio j = criaExercicio();

                    boolean pessoaFoiInserida = ExercicioDao.adiciona(j);
                    if (pessoaFoiInserida) {
                        System.out.println("Pessoa inserida com sucesso");
                    } else {
                        System.out.println("Pessoa nao inserida");

                    }

                    break;
                case 2:
                    ExercicioDao.mostrarTodos();
                    break;
                case 3:
                    System.out.println("Pessoa a procurada:");
                    String procurado = s.nextLine();
                    System.out.println("Novo nome:");
                    String novoNome = s.nextLine();
                    if (ExercicioDao.alterarNome(procurado, novoNome)) {
                        System.out.println("Pessoa alterado");
                    } else {
                        System.out.println("Pessoa não encontrado");
                    }

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
    
    private Exercicio criaExercicio() {
        Exercicio j = new Exercicio();
        Date dataAtual = new Date();

        System.out.print("\nNome: ");
        String nome = s.nextLine();
        j.setNomeExercicio(nome);
        System.out.print("\nDescriçao: ");
        String descricao = s.nextLine();
        j.setDescricaoFoto(descricao);
        j.setDataCriacao(dataAtual);


        return j;
    }

    private int pegaOpcaoUsuario() {

        System.out.println("\n\n");
        System.out.println("----------------------------------");
        System.out.println("1 cadastrar");
        System.out.println("2 mostrar todos");
        System.out.println("3 alterar o nome da pessoa");
        System.out.println("4 excluir pelo id");
        System.out.println("5 sair");
        System.out.print("Qual sua opcao ?R: ");

        return Integer.parseInt(s.nextLine());

    }
    
}