package general;

import java.util.Scanner;
import java.util.Date;

import dao.MensalidadeAlunoDao;
import entities.MensalidadeAluno;

public class programaMensalidadeAluno{
    MensalidadeAlunoDao MensalidadeAlunoDao = new MensalidadeAlunoDao();
    Scanner s = new Scanner(System.in);

    public void mostrarMenu(){


        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                    MensalidadeAluno j = criaExercicio();

                    boolean pessoaFoiInserida = MensalidadeAlunoDao.adiciona(j);
                    if (pessoaFoiInserida) {
                        System.out.println("Exercicio inserido com sucesso");
                    } else {
                        System.out.println("Exercicio nao inserido");

                    }

                    break;
                case 2:
                    MensalidadeAlunoDao.mostrarTodos();
                    break;
                case 3:
                    System.out.println("Exercicio a ser procurado:");
                    String procurado = s.nextLine();
                    System.out.println("Novo nome:");
                    String novoNome = s.nextLine();
                    if (MensalidadeAlunoDao.alterarNome(procurado, novoNome)) {
                        System.out.println("Exercicio alterado");
                    } else {
                        System.out.println("Exercicio não encontrado");
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
    
    private MensalidadeAluno criaExercicio() {
        MensalidadeAluno j = new MensalidadeAluno();
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
        System.out.println("1 - Cadastrar exercicio");
        System.out.println("2 - Mostrar todos exercicios");
        System.out.println("3 - Alterar o nome do exercicio");
        System.out.println("4 - Excluir exercicio pelo id");
        System.out.println("5 sair");
        System.out.print("Qual sua opcao ?R: ");

        return Integer.parseInt(s.nextLine());

    }
    
}