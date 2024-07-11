package general;

import dao.*;
import entities.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Scanner;

public class programaFichaTreino {

    private DivisaoTreinoDao divisaoTreinoDao;
    private PessoaDao pessoaDao;
    private TreinoDao treinoDao;
    private AcademiaDAO academiaDAO;
    private TreinoAplicacaoDao treinoAplicacaoDao;

    public programaFichaTreino() {
        this.divisaoTreinoDao = new DivisaoTreinoDao();
        this.pessoaDao = new PessoaDao();
        this.treinoDao = new TreinoDao();
        this.academiaDAO = new AcademiaDAO();
        this.treinoAplicacaoDao = new TreinoAplicacaoDao();
    }

    Scanner s = new Scanner(System.in);

    public void mostrarMenu() {
        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                    criarFicha();
                    break;
                case 2:
                    // System.out.println("Salvar a ficha em pdf");
                    break;
                case 3:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcaoUsuario != 3);
    }

    private int pegaOpcaoUsuario() {
        System.out.println("1 - Montar Ficha de Treino");
        System.out.println("2 - Mostrar todas as Fichas de Treino");
        System.out.println("3 - Voltar");
        System.out.print("Qual sua opção? R: ");
        return Integer.parseInt(s.nextLine());
    }

    private void criarFicha() {

        System.out.println("Escolha a academia por id: ");
        long idAcademiaBusca = s.nextLong();
        s.nextLine(); // Consumir a nova linha após nextLong()
        Academia academia = academiaDAO.buscaPorId(idAcademiaBusca);
        String nomeAcademia = academia != null ? academia.getNome() : "Academia não encontrada";

        System.out.println("Escolha um aluno pelo nome: ");
        String nomeAlunoBuscado = s.nextLine();
        Pessoa aluno = pessoaDao.buscaPorNome(nomeAlunoBuscado);
        String nomeAluno = aluno != null ? aluno.getNomePessoa() : "Aluno não encontrado";

        System.out.println("Escolha uma divisão de treino pelo nome: ");
        String opcDivisao = s.nextLine();
        DivisaoTreino divisaoTreino = divisaoTreinoDao.buscaPorNome(opcDivisao);
        String divisaoSel = divisaoTreino != null ? divisaoTreino.getNome() : "Divisão de treino não encontrada";

        System.out.println("Data de inicio (AAAA-MM-DD): ");
        String dataInicio = s.nextLine();
        System.out.println("Data de termino (AAAA-MM-DD): ");
        String dataTermino = s.nextLine();
        String grupoDia;
        int numDias = divisaoSel.length();
        List<String> treinos = new ArrayList<>();
        for (int cont = 1; cont <= numDias; cont++) {
            System.out.println("Digite o grupo do " + cont + "º dia:");
            grupoDia = s.nextLine();
            System.out.println("Quantos treinos irá fazer neste dia: ");
            int numTreinos = s.nextInt();
            s.nextLine(); // Consumir a nova linha após nextInt()
            treinos.add(grupoDia);
            for (int contTreino = 1; contTreino <= numTreinos; contTreino++) {
                System.out.println("Escolha o Treino Aplicação por ID");
                Long idBuscado = s.nextLong();
                s.nextLine(); // Consumir a nova linha após nextLong()
                TreinoAplicacao treinoAplicacao = treinoAplicacaoDao.buscaPorId(idBuscado);
                if (treinoAplicacao != null) {
                    treinos.add(treinoAplicacao.toString());
                }
            }
        }

        String treinoTotal = String.join("\n", treinos);

        // Aqui você pode criar um objeto de Ficha de Treino com os dados coletados e salvar no banco de dados

        System.out.println("Ficha de Treino!");
        System.out.println(nomeAcademia);
        System.out.println(nomeAluno);
        System.out.println(divisaoSel);
        System.out.println("Data Inico: " + dataInicio + "     Data Fim: " + dataTermino);
        System.out.println(treinoTotal);

        // Chamar a função criaPDF para gerar o arquivo
        try {
            criaPDF(nomeAcademia, nomeAluno, divisaoSel, dataInicio, dataTermino, treinoTotal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void criaPDF(String nomeAcademia, String nomeAluno, String divisaoSel, String dataInicio, String dataTermino, String treinoTotal) throws IOException {
        Path path = Paths.get("C:\\Users\\leona\\OneDrive\\Documentos\\Portifolio\\Projeto-backend-academia\\pdfs\\TreinoDo" + nomeAluno + ".txt");
        Files.createDirectories(path.getParent()); // Criar diretórios se não existirem

        List<String> lines = Arrays.asList(
                "Ficha de Treino!",
                "Academia: " + nomeAcademia,
                "-----------------------",
                "Aluno: " + nomeAluno,
                "Divisão: " + divisaoSel,
                "Data Início: " + dataInicio,
                "Data Fim: " + dataTermino + "\n",
                treinoTotal
        );

        Files.write(path, lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        System.out.println("TXT criado com sucesso!");
    }
}