
import java.util.Scanner;
import java.util.Date;

public class programaPessoa {
    private PessoaDao pessoaDao = new PessoaDao();
    private Scanner s = new Scanner(System.in);

    public programaPessoa() {
        // Construtor vazio ou outras inicializações se necessário
    }

    public void mostrarMenu() {
        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                    Pessoa j = criaPessoa();
                    boolean pessoaFoiInserida = pessoaDao.adiciona(j);
                    if (pessoaFoiInserida) {
                        System.out.println("Pessoa inserida com sucesso");
                    } else {
                        System.out.println("Pessoa não inserida");
                    }
                    break;

                case 2:
                    pessoaDao.mostrarTodos();
                    break;

                case 3:
                    System.out.println("Pessoa a procurar:");
                    String procurado = s.nextLine();
                    System.out.println("Novo nome:");
                    String novoNome = s.nextLine();
                    if (pessoaDao.alterarNome(procurado, novoNome)) {
                        System.out.println("Pessoa alterada");
                    } else {
                        System.out.println("Pessoa não encontrada");
                    }
                    break;

                case 4:
                    System.out.println("Pessoa a procurar:");
                    String nomeExclusao = s.nextLine();
                    if (pessoaDao.remover(nomeExclusao)) {
                        System.out.println("Pessoa excluída");
                    } else {
                        System.out.println("Pessoa não excluída");
                    }
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcaoUsuario != 5);
    }

    private Pessoa criaPessoa() {
        Pessoa j = new Pessoa();
        System.out.print("\nNome: ");
        String nome = s.nextLine();
        j.setNomePessoa(nome);
        System.out.print("\nSexo: ");
        String sexo = s.nextLine();
        j.setSexoPessoa(sexo);
        System.out.print("\nLogin: ");
        String login = s.nextLine();
        j.setLoginPessoa(login);
        System.out.print("\nSenha: ");
        String senha = s.nextLine();
        j.setSenhaPessoa(senha);
        return j;
    }

    private int pegaOpcaoUsuario() {
        System.out.println("1. Cadastrar");
        System.out.println("2. Mostrar todos");
        System.out.println("3. Alterar o nome da pessoa");
        System.out.println("4. Excluir pelo nome");
        System.out.println("5. Sair");
        System.out.print("Qual sua opção? R: ");
        return Integer.parseInt(s.nextLine());
    }
}
