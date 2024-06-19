package general;

import java.util.Scanner;

import entities.Pessoa;

import java.text.SimpleDateFormat;
import java.util.Date;
import dao.PessoaDao;

public class programaPessoaAdmin{
    private PessoaDao PessoaDao;
    public programaPessoaAdmin(PessoaDao PessoaDao){
        this.PessoaDao = PessoaDao;
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
                    PessoaDao.mostrarTodos();
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
        Date dataAtual = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("\nNome: ");
        String nome = s.next();
        j.setNomePessoa(nome);
        System.out.print("\nSexo: ");
        String sexo = s.next();
        j.setSexoPessoa(sexo);
        System.out.print("\nData Nascimento: ");
        String dataNascimento = s.next();
        j.setDataNascimento(dataNascimento);
        System.out.print("\nLogin: ");
        String login = s.next();
        j.setLoginPessoa(login);
        System.out.print("\nSenha: ");
        String senha = s.next();
        j.setSenhaPessoa(senha);
        
        System.out.print("\nTipo Usuario (1- Aluno / 2- Professor / 3- Novo ADMIN): ");
        int tipo = s.nextInt();
        if(tipo != 1 && tipo != 2 && tipo != 3){
            while(tipo != 1 && tipo != 2 && tipo != 3){
                System.out.print("\nTipo Invalido\nTipo Usuario (1- Aluno / 2- Professor / 3- Novo ADMIN): ");
                tipo = s.nextInt();
            }
        }
        j.setTipoUsuarioPessoa(tipo);
        j.setDataCriacao(sdf.format(dataAtual));

        return j;
    }

    private int pegaOpcaoUsuario() {
        int opc;
        System.out.println("1. Cadastrar Pessoa");
        System.out.println("2. Mostrar todas as pessoas");
        System.out.println("3. Alterar o nome da pessoa");
        System.out.println("4. Excluir pelo id");
        System.out.println("5. Sair");
        System.out.print("Qual sua opcao ?R: ");

        opc = s.nextInt();
        return opc;

    }
    
}