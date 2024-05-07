import java.util.Date;
import java.util.Scanner;

public class MenuSelecao {
    private Academia academia;
    private Pessoa pessoa;

    public MenuSelecao() {
        this.academia = new Academia(); // Instanciando um objeto da classe Academia
        this.pessoa = new Pessoa();
    }

    public void selecioneOpc() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("");
            System.out.println("1. Acessar Area da Academia");
            System.out.println("2. Acessar informações do Aluno");
            System.out.println("3. Sair");
            System.out.print("Selecione a opção desejada: ");

            int opc = scanner.nextInt();

            switch (opc) {
                case 1:
                    academia.selecionarOpc(); // Chama o método para adicionar informações
                    break;

                case 2:
                    pessoa.selecionarOpc(); // Chama o método para exibir informações
                    break;

                case 3:
                    System.out.println("Encerrando o programa...");
                    return; // Encerra o método e o loop while

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
