import java.util.Date;
import java.util.Scanner;

public class Academia {
    private int id;
    private String nome;
    private String endereco;
    private Date dataCriacao;
    private Date dataModificacao;


    // Método para adicionar informações da academia
    private void adicionarInformacoes(int id, String nome, String endereco, Date dataCriacao, Date dataModificacao) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }

    // Método para exibir informações da academia
    protected void exibirInformacoes() {
        System.out.println("\nID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Endereço: " + endereco);
        System.out.println("Data de Criação: " + dataCriacao);
        System.out.println("Data de Modificação: " + dataModificacao);
    }

    // Método para permitir que o usuário escolha entre exibir e adicionar informações da academia
    public void selecionarOpc() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("");
            System.out.println("Selecione a operação desejada:");
            System.out.println("1. Adicionar informações da academia");
            System.out.println("2. Exibir informações da academia");
            System.out.println("3. Voltar");
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
                
                    // System.out.println("Encerrando o programa...");
                    return ;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    // Método para permitir que o usuário insira informações da academia
    protected void adicionarInformacoesDoUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nPor favor, insira o ID da academia: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer de entrada

        System.out.print("\nPor favor, insira o nome da academia: ");
        String nome = scanner.nextLine();

        System.out.print("\nPor favor, insira o endereço da academia: ");
        String endereco = scanner.nextLine();

        // data atual
        Date dataAtual = new Date();

        // Chamando o método para adicionar as informações inseridas pelo usuário
        adicionarInformacoes(id, nome, endereco, dataAtual, dataAtual);

        System.out.println("\nInformações da academia adicionadas com sucesso!\n");
    }
}
