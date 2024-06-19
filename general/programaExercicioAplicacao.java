package general;

import java.util.Scanner;

import dao.ExercicioAplicacaoDao;
import entities.ExercicioAplicacao;

import java.util.Date;

public class programaExercicioAplicacao{
    private ExercicioAplicacaoDao exercicioAplicacaoDao;
    public programaExercicioAplicacao(ExercicioAplicacaoDao exercicioAplicacaoDao){
        this.exercicioAplicacaoDao = exercicioAplicacaoDao;
    }

    Scanner s = new Scanner(System.in);

    public void mostrarMenu(){

        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                    ExercicioAplicacao j = criaExercicio();

                    boolean pessoaFoiInserida = exercicioAplicacaoDao.adiciona(j);
                    if (pessoaFoiInserida) {
                        System.out.println("Pessoa inserida com sucesso");
                    } else {
                        System.out.println("Pessoa nao inserida");

                    }

                    break;
                case 2:
                    exercicioAplicacaoDao.mostrarTodos();
                    break;
                case 3:
                    System.out.println("ID do exercício a ser procurado:");
                    int idProcurado = Integer.parseInt(s.nextLine());
                    System.out.println("Nova descrição:");
                    String novaDescricao = s.nextLine();
                    if (exercicioAplicacaoDao.alterarDescricao(idProcurado, novaDescricao)) {
                        System.out.println("Descrição alterada com sucesso");
                    } else {
                        System.out.println("Exercício não encontrado");
                    }

                    break;
                case 4:
                    System.out.println("ID do exercício a ser excluído:");
                    int idExclusao = Integer.parseInt(s.nextLine());

                    if (exercicioAplicacaoDao.remover(idExclusao)) {
                        System.out.println("Exercício excluído com sucesso");
                    } else {
                        System.out.println("Exercício não encontrado");
                    }

                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;

            }
        } while (opcaoUsuario != 5);
    }
    
    private ExercicioAplicacao criaExercicio() {
        ExercicioAplicacao j = new ExercicioAplicacao();
        Date dataAtual = new Date();
        
        System.out.print("\nDescricao: ");
        String descricao = s.nextLine();
        j.setDescricao(descricao);
        j.setDataCriacao(dataAtual);


        return j;
    }

    private int pegaOpcaoUsuario() {
        int opc;
        System.out.println("1 - Cadastrar exercicio aplicação");
        System.out.println("2 - Mostrar todos exercicios aplicação");
        System.out.println("3 - Alterar o nome do exercicio aplicação");
        System.out.println("4 - Excluir pelo id");
        System.out.println("5 - Voltar");
        System.out.print("Qual sua opcao? R: ");
        opc = s.nextInt();
        return opc;

    }
}
