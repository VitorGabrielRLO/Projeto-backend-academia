import java.util.Date;
import java.util.Scanner;

public class Pessoa {
    private int id;
    private String nome;
    private String sexo;
    private Date nascimento;
    private String login;
    private String senha;
    private int tipoUsuario;
    private Date dataCriacao;
    private Date dataModificacao;

    // Construtor

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    // Método para permitir que o usuário adicione informações do aluno
    protected void adicionaInfoPessoa() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nPor favor, insira o ID do Aluno: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer de entrada

        System.out.print("\nPor favor, insira o nome do Aluno: ");
        String nome = scanner.nextLine();

        System.out.print("\nPor favor, insira o sexo do Aluno: ");
        String sexo = scanner.nextLine();

        // Adicionar mais campos aqui, como data de nascimento, login, senha, etc.

        setId(id);
        setNome(nome);
        setSexo(sexo);

        // Atualizar a data de modificação
        setDataModificacao(new Date());

        System.out.println("\nInformações do Aluno adicionadas com sucesso!\n");
    }

    // Método para exibir as informações do aluno
    public void exibeInfoPessoa() {
        System.out.println("\nInformações do Aluno:");
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Sexo: " + getSexo());
        // Adicione mais campos conforme necessário
    }

    // Método para selecionar operação (adicionar ou exibir informações do aluno)
    public void selecionarOpc() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("");
            System.out.println("Selecione a operação desejada:");
            System.out.println("1. Adicionar informações do Aluno");
            System.out.println("2. Exibir informações do Aluno");
            System.out.println("3. Sair");
            System.out.print("Opção: ");

            int opc = scanner.nextInt();

            switch (opc) {
                case 1:
                    adicionaInfoPessoa();
                    break;

                case 2:
                    exibeInfoPessoa();
                    break;

                case 3:
                    System.out.println("Encerrando o programa...");
                    return;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    // Outros métodos da classe...

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                ", nascimento=" + nascimento +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                '}';
    }
}
