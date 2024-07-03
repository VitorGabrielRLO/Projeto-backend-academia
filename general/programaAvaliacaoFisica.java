package general;

import dao.AvaliacaoFisicaDao;
import dao.MovFinanceiraDao;
import dao.PessoaDao;
import dao.TreinoDao;
import entities.AvaliacaoFisica;
import entities.MovFinanceira;
import entities.Pessoa;
import entities.Treino;
import java.util.List;
import java.util.Scanner;

public class programaAvaliacaoFisica {
    private AvaliacaoFisicaDao avaliacaoFisicaDao;
    private MovFinanceiraDao movFinanceiraDao;
    private PessoaDao pessoaDao;
    private TreinoDao treinoDao;
    private Scanner scanner;

    public programaAvaliacaoFisica() {
        this.avaliacaoFisicaDao = new AvaliacaoFisicaDao();
        this.movFinanceiraDao = new MovFinanceiraDao();
        this.pessoaDao = new PessoaDao();
        this.treinoDao = new TreinoDao();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcaoUsuario;

        do {
            opcaoUsuario = getUsuarioOption();
            switch (opcaoUsuario) {
                case 1:
                    AvaliacaoFisica avaliacao = realizaAvaliacaoFisica();

                    boolean avaliacaoInserida = avaliacaoFisicaDao.adiciona(avaliacao);
                    if (avaliacaoInserida) {
                        System.out.println("Avaliação física inserida com sucesso");
                    } else {
                        System.out.println("Falha ao inserir avaliação física");
                    }
                    break;
                case 2:
                    List<AvaliacaoFisica> avaliacoes = avaliacaoFisicaDao.mostrarTodos();
                    if (avaliacoes.isEmpty()) {
                        System.out.println("Não há avaliações físicas cadastradas");
                    } else {
                        for (AvaliacaoFisica a : avaliacoes) {
                            System.out.println(a);
                        }
                    }
                    break;
                case 3:
                    System.out.print("ID da Avaliação a ser deletada: ");
                    long id = scanner.nextLong();
                    if (avaliacaoFisicaDao.remover(id)) {
                        System.out.println("Avaliação física removida com sucesso");
                    } else {
                        System.out.println("Falha ao remover avaliação física");
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcaoUsuario != 4);
    }

    private AvaliacaoFisica realizaAvaliacaoFisica() {
        AvaliacaoFisica avaliacao = new AvaliacaoFisica();
        MovFinanceira mov = new MovFinanceira();

        System.out.print("Nome do aluno: ");
        scanner.nextLine(); // Limpar o buffer do Scanner
        String nomeAluno = scanner.nextLine();
        Pessoa pessoa = pessoaDao.buscaPorNome(nomeAluno);
        avaliacao.setPessoa(pessoa);

        System.out.print("\nPeso: ");
        double peso = scanner.nextDouble();
        avaliacao.setPeso(peso);

        System.out.print("\nAltura em cm: ");
        double altura = scanner.nextDouble() / 100; // Convertendo para metros
        avaliacao.setAltura(altura);

        double imc = peso / (altura * altura);
        avaliacao.setIMC(imc);

        // Defina ultimoTreino se estiver disponível
        System.out.print("\nQual o ultimo treino (id): ");
        long ultimoTreinoId = scanner.nextLong();
        Treino ultimoTreino = treinoDao.buscaPorId(ultimoTreinoId);
        avaliacao.setUltimoTreino(ultimoTreino);

        mov.setValor(20);
        mov.setTipo(1);
        mov.setDescricao("Avaliação física");
        movFinanceiraDao.adiciona(mov);

        // Aumenta R$20 no valor a ser pago pelo aluno ao gerar avaliação
        System.out.printf("Seu IMC: %.2f \n", imc);
        System.out.print("\nQual seu indice de satisfaçao (0 - 10): ");
        double satisfaction = scanner.nextDouble();
        avaliacao.setIndiceSatisfacao(satisfaction);

        return avaliacao;
    }

    private int getUsuarioOption() {
        int opc;

        System.out.println("\n1 - Cadastrar avaliação física");
        System.out.println("2 - Mostrar todas as avaliações");
        System.out.println("3 - Excluir avaliação pelo ID");
        System.out.println("4 - Sair");
        System.out.print("Qual sua opção? ");
        opc = scanner.nextInt();

        return opc;
    }
}
