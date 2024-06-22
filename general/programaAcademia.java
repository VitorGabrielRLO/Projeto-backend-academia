package general;

import dao.AcademiaDAO;
import entities.Academia;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class programaAcademia{
    private AcademiaDAO AcademiaDAO;

    public programaAcademia(AcademiaDAO AcademiaDAO){
        this.AcademiaDAO = AcademiaDAO;
    }

    Scanner s = new Scanner(System.in);

    public void mostrarMenu(){
        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                Academia j = criaAcademia();

                    boolean pessoaFoiInserida = AcademiaDAO.adiciona(j);
                    if (pessoaFoiInserida) {
                        System.out.println("Academia inserida com sucesso");
                    } else {
                        System.out.println("Academia nao inserida");

                    }

                    break;
                case 2:
                List<Academia> academias = AcademiaDAO.mostrarTodos();
                for (Academia a : academias) {
                    System.out.println(a);
                    
    
            }
                    break;
                case 3:
                    System.out.println("Academia a procurada:");
                    String procurado = s.nextLine();
                    System.out.println("Novo nome:");
                    String novoNome = s.nextLine();
                    // System.out.println("Novo Endereco: ");
                    // String novoEndereco = s.nextLine();
                    if (AcademiaDAO.alterarNome(procurado, novoNome)) {
                        System.out.println("Academia alterado");
                        
                    } else {
                        System.out.println("Academia não encontrado");
                    }

                    break;
                case 4:
                    System.out.println("Academia procurada:");
                    String nomeExclusao = s.nextLine();

                    if (AcademiaDAO.remover(nomeExclusao)) {
                        System.out.println("Academia excluída");
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
    
    private Academia criaAcademia() {

        LocalDate dataCriacao =  LocalDate.now();
        
        Academia j = new Academia();

        System.out.print("\nNome: ");
        String nome = s.nextLine();
        j.setNome(nome);
        System.out.print("\nEndereco: ");
        String endereco = s.nextLine();
        j.setEndereco(endereco);
        j.setDataCriacao(dataCriacao);


        return j;
    }

    private int pegaOpcaoUsuario() {

        System.out.println("1 - Cadastrar Academia");
        System.out.println("2 - Mostrar todas as Academias");
        System.out.println("3 - Alterar o nome da Academia");
        System.out.println("4 - Excluir Academia pelo nome");
        System.out.println("5 - Voltar");
        System.out.print("Qual sua opcao ?R: ");
        return Integer.parseInt(s.nextLine());

    }
    
}