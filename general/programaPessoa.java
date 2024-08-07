package general;

import dao.PessoaDao;
import entities.Pessoa;
import java.time.LocalDate;
import java.util.Scanner;

public class programaPessoa{
    private PessoaDao PessoaDao;
    public programaPessoa(){
        this.PessoaDao = new PessoaDao();
    }
    Scanner s = new Scanner(System.in);

    public void mostrarMenu(){
        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                    Pessoa j = criaPessoa();

                    boolean pessoaFoiInserida = PessoaDao.adiciona(j);
                    if (pessoaFoiInserida) {
                        System.out.println("Pessoa inserida com sucesso");
                    } else {
                        System.out.println("Pessoa nao inserida");

                    }

                    break;
                case 2:
                    PessoaDao.mostrarTodasPessoas();
                    break;
                case 3:
                    System.out.println("Pessoa a procurada:");
                    String procurado = s.nextLine();
                    System.out.println("Novo nome:");
                    String novoNome = s.nextLine();
                    if (PessoaDao.alterarNome(procurado, novoNome)) {
                        System.out.println("Pessoa alterado");
                    } else {
                        System.out.println("Pessoa não encontrado");
                    }

                    break;
                case 4:
                    System.out.println("Pessoa procurada:");
                    String nomeExclusao = s.nextLine();

                    if (PessoaDao.remover(nomeExclusao)) {
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
    
    private Pessoa criaPessoa() {
        Pessoa j = new Pessoa();
        LocalDate data = LocalDate.now();
        
        System.out.print("\nNome: ");
        String nome = s.next();
        j.setNomePessoa(nome);
        System.out.print("\nSexo: ");
        String sexo = s.next();
        j.setSexoPessoa(sexo);
        System.out.print("\nData Nascimento: ");
        String dataNascimento1 = s.next();
        LocalDate dt = LocalDate.parse(dataNascimento1);
        j.setDataNascimento(dt);
        System.out.print("\nLogin: ");
        String login = s.next();
        j.setLoginPessoa(login);
        System.out.print("\nSenha: ");
        String senha = s.next();
        j.setSenhaPessoa(senha);
        j.setDataCriacao(data);
        j.setTipoUsuarioPessoa(1);

        return j;
    }

    private int pegaOpcaoUsuario() {

        System.out.println("1 cadastrar");
        System.out.println("2 mostrar todos");
        System.out.println("3 buscar pessoa");
        System.out.println("4 alterar o nome da pessoa");
        System.out.println("5 excluir pelo id");
        System.out.println("6 sair");
        System.out.print("Qual sua opcao ?R: ");
        return Integer.parseInt(s.nextLine());

    }
    
}