import java.util.Date;
import java.util.Scanner;

public class MenuSelecao {
    private Academia academia;
    private programaPessoa programaPessoa; // Mantém uma única instância
    private Treino treino;
    private Exercicio exercicio;

    public MenuSelecao() {
        this.academia = new Academia(); // Supondo que você tenha uma classe Academia
        this.programaPessoa = new programaPessoa(); // Inicializa a instância de programaPessoa
        // Inicialize outras variáveis se necessário
    }

    public void selecioneOpc() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("");
            System.out.println("1. Acessar Area da Academia");
            System.out.println("2. Acessar informações do Aluno");
            System.out.println("3. Adicionar Exercicios");
            System.out.println("4. Sair");
            System.out.print("Selecione a opção desejada: ");

            int opc = scanner.nextInt();
            scanner.nextLine(); // Consome o caractere de nova linha

            switch (opc) {
                case 1:
                    academia.selecionarOpc(); // Chama o método para adicionar informações
                    break;

                case 2:
                    programaPessoa.mostrarMenu(); // Chama o método para exibir o menu de programaPessoa
                    break;

                case 3:
                    // new programaExercicio(); // Supondo que esta seja outra classe que você tem
                    break;

                case 4:
                    System.out.println("Encerrando o programa...");
                    return; // Encerra o método e o loop while

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
