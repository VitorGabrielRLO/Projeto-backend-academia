import java.util.Date;
import java.util.Scanner;

public class Academia {
    private static int proximoId = 0;
    private int id;
    private String nome;
    private String endereco;
    private Date dataCriacao;
    private Date dataModificacao;
    private AcademiaDAO academiaDAO;

    public Academia() {
        this.id = proximoId++;
        this.nome = "";
        this.endereco = "";
        this.dataCriacao = new Date();
        this.dataModificacao = new Date();
        this.academiaDAO = new AcademiaDAO(100); // Cada Academia tem seu próprio AcademiaDAO
    }

    public void adicionarInformacoes(String nome, String endereco, Date dataCriacao, Date dataModificacao) {
        Academia novaAcademia = new Academia(); // Criar uma nova instância de Academia
        novaAcademia.id = proximoId++; // Definir o ID da nova academia
        novaAcademia.nome = nome;
        novaAcademia.endereco = endereco;
        novaAcademia.dataCriacao = dataCriacao;
        novaAcademia.dataModificacao = dataModificacao;
        academiaDAO.adicionarAcademia(novaAcademia); // Adicionar a nova academia ao DAO
    }

    public void exibirInformacoes() {
        System.out.println("\nID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Endereço: " + endereco);
        System.out.println("Data de Criação: " + dataCriacao);
        System.out.println("Data de Modificação: " + dataModificacao);
    }

    public void selecionarOpc() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("");
            System.out.println("Selecione a operação desejada:");
            System.out.println("1. Adicionar informações da academia");
            System.out.println("2. Exibir informações da academia");
            System.out.println("3. Exibir todas as academias");
            System.out.println("4. Voltar");
            System.out.print("Opção: ");

            int opc = scanner.nextInt();

            switch (opc) {
                case 1:
                    adicionarInformacoesDoUsuario();
                    break;

                case 2:
                    exibirInformacoes();
                    break;

                case 3:
                    academiaDAO.exibirTodasAsAcademias();
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    public void adicionarInformacoesDoUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nPor favor, insira o nome da academia: ");
        String nome = scanner.nextLine();

        System.out.print("\nPor favor, insira o endereço da academia: ");
        String endereco = scanner.nextLine();

        Date dataAtual = new Date();

        adicionarInformacoes(nome, endereco, dataAtual, dataAtual);

        System.out.println("\nInformações da academia adicionadas com sucesso!\n");
    }
}
