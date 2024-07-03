package general;

import dao.PessoaDao;
import entities.Pessoa;
import java.time.LocalDate;
import java.util.Scanner;

public class programaPessoaAdmin {
    private PessoaDao PessoaDao;
    private Scanner s;

    public programaPessoaAdmin() {
        this.PessoaDao = new PessoaDao();
        this.s = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();

            switch (opcaoUsuario) {
                case 1:
                    Pessoa pessoa = criaPessoa();

                    boolean pessoaFoiInserida = PessoaDao.adiciona(pessoa);
                    if (pessoaFoiInserida) {
                        System.out.println("Pessoa inserida com sucesso");
                    } else {
                        System.out.println("Pessoa não inserida");
                    }
                    break;

                case 2:
                    PessoaDao.mostrarTodasPessoas();
                    break;

                case 3:
                    System.out.println("Digite o nome da pessoa:");
                    String nomeBusca = s.nextLine();
                    Pessoa pessoaBuscada = PessoaDao.buscaPorNome(nomeBusca);
                    if (pessoaBuscada != null) {
                        System.out.println(pessoaBuscada);
                    } else {
                        System.out.println("Pessoa não encontrada");
                    }
                    break;

                case 4:
                    System.out.println("Digite o nome da pessoa a ser alterado:");
                    String nomeAlteracao = s.nextLine();
                    System.out.println("Digite o novo nome:");
                    String novoNome = s.nextLine();
                    if (PessoaDao.alterarNome(nomeAlteracao, novoNome)) {
                        System.out.println("Nome da pessoa alterado com sucesso");
                    } else {
                        System.out.println("Pessoa não encontrada");
                    }
                    break;

                case 5:
                    System.out.println("Digite o nome da pessoa a ser removida:");
                    String nomeExclusao = s.nextLine();
                    if (PessoaDao.remover(nomeExclusao)) {
                        System.out.println("Pessoa excluída com sucesso");
                    } else {
                        System.out.println("Pessoa não encontrada ou não pôde ser removida");
                    }
                    break;

                case 6:
                    System.out.println("Encerrando o programa");
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
                    break;
            }

        } while (opcaoUsuario != 6);
    }

    private Pessoa criaPessoa() {
        Pessoa pessoa = new Pessoa();
        LocalDate data = LocalDate.now();

        System.out.print("\nNome: ");
        String nome = s.nextLine();
        pessoa.setNomePessoa(nome);

        System.out.print("Sexo: ");
        String sexo = s.nextLine();
        pessoa.setSexoPessoa(sexo);

        System.out.print("Data de Nascimento (AAAA-MM-DD): ");
        String dataNascimentoStr = s.nextLine();
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr);
        pessoa.setDataNascimento(dataNascimento);

        System.out.print("Login: ");
        String login = s.nextLine();
        pessoa.setLoginPessoa(login);

        System.out.print("Senha: ");
        String senha = s.nextLine();
        pessoa.setSenhaPessoa(senha);

        pessoa.setDataCriacao(data);
        pessoa.setTipoUsuarioPessoa(1); // Exemplo de tipo de usuário fixo (1 para Aluno)

        return pessoa;
    }

    private int pegaOpcaoUsuario() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Cadastrar Pessoa");
        System.out.println("2. Mostrar todas as pessoas");
        System.out.println("3. Buscar pessoa por nome");
        System.out.println("4. Alterar o nome de uma pessoa");
        System.out.println("5. Excluir pessoa pelo nome");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
        
        int opcao = s.nextInt();
        s.nextLine(); // Limpar o buffer após ler o número inteiro

        return opcao;
    }
}
