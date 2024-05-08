import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Treino {
    private int id;
    private Date dataInicio;
    private Date dataTermino;
    private List<Exercicio> exercicios;
    private DivisaoTreino divisaoTreino;
    private Date dataCriacao;
    private Date dataModificacao;
    private ExercicioDAO exercicioDAO;

    // Construtor
    public Treino(int id, Date dataInicio, Date dataTermino, DivisaoTreino divisaoTreino, Date dataCriacao, Date dataModificacao, ExercicioDAO exercicioDAO) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.exercicios = new ArrayList<>();
        this.divisaoTreino = divisaoTreino;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
        this.exercicioDAO = exercicioDAO;
    }

    // Método para adicionar exercício
    public void adicionarExercicio(Exercicio exercicio) {
        exercicios.add(exercicio);
    }

    // Método para adicionar exercícios do exemplo
    public void adicionarExerciciosExemplo() {
        Exercicio supino = new Exercicio(1, "Supino Reto", "foto_supino.jpg", new Date(), new Date());
        Exercicio agachamento = new Exercicio(2, "Agachamento Livre", "foto_agachamento.jpg", new Date(), new Date());
        exercicios.add(supino);
        exercicios.add(agachamento);
    }

    // Método para exibir o menu de opções
    public void menuOpcoes() {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\nMenu de Opções:");
            System.out.println("1. Adicionar Exercícios");
            System.out.println("2. Mostrar Todos Exercícios");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    adicionarExerciciosUsuario();
                    break;
                case 2:
                    mostrarExerciciosDAO();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);
        scanner.close(); // Fechando o objeto Scanner
    }

    // Método para mostrar exercícios salvos na ExercicioDAO
    public void mostrarExerciciosDAO() {
        int indice = 0;
        Exercicio exercicio = exercicioDAO.obterExercicioPorIndice(indice);
        while (exercicio != null) {
            System.out.println(exercicio);
            indice++;
            exercicio = exercicioDAO.obterExercicioPorIndice(indice);
        }
    }

    // Método para adicionar exercícios pelo usuário
    public void adicionarExerciciosUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quantos exercícios deseja adicionar? ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        for (int i = 0; i < quantidade; i++) {
            System.out.println("Exercício " + (i + 1) + ":");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Descrição/Foto: ");
            String descricaoFoto = scanner.nextLine();
            Exercicio exercicio = new Exercicio(i + 3, nome, descricaoFoto, new Date(), new Date()); // ID começa em 3 para evitar conflitos com os exemplos
            exercicios.add(exercicio);
        }
    }

    // Getters e Setters
    // toString() para representação textual do objeto
}
