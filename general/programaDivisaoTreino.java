package general;

import dao.DivisaoTreinoDao;
import entities.DivisaoTreino;

import java.util.Scanner;
import java.util.Date;

public class programaDivisaoTreino{
    DivisaoTreinoDao DivisaoTreinoDao = new DivisaoTreinoDao();
    Scanner s = new Scanner(System.in);

    public void mostrarMenu(){
        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                    DivisaoTreino j = criaTreino();

                    boolean pessoaFoiInserida = DivisaoTreinoDao.adiciona(j);
                    if (pessoaFoiInserida) {
                        System.out.println("Divisao inserida com sucesso");
                    } else {
                        System.out.println("Divisao nao inserida");

                    }

                    break;
                case 2:
                    DivisaoTreinoDao.mostrarTodos();
                    break;
                case 3:
                    System.out.println("Divisao a procurada:");
                    String procurado = s.nextLine();
                    System.out.println("Novo nome:");
                    String novoNome = s.nextLine();
                    if (DivisaoTreinoDao.alterarNome(procurado, novoNome)) {
                        System.out.println("Divisao alterado");
                    } else {
                        System.out.println("Divisao não encontrado");
                    }

                    break;
                case 4:
                    System.out.println("Pessoa procurada:");
                    String nomeExclusao = s.nextLine();

                    if (DivisaoTreinoDao.remover(nomeExclusao)) {
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
    
    private DivisaoTreino criaTreino() {
        DivisaoTreino j = new DivisaoTreino();

        System.out.print("\nNome: ");
        String nome = s.nextLine();
        j.setNome(nome);
        System.out.print("\nNome Detalhado: ");
        String nomeDet = s.nextLine();
        j.setNomeDetalhado(nomeDet);

        return j;
    }

    private int pegaOpcaoUsuario() {

        System.out.println("1 - Cadastrar divisao de treino");
        System.out.println("2 - Mostrar todas as divisoes");
        System.out.println("3 - Alterar o nome da divisao");
        System.out.println("4 - Excluir divisao pelo nome");
        System.out.println("5 - Voltar");
        System.out.print("Qual sua opcao ?R: ");
        return Integer.parseInt(s.nextLine());

    }
    
}