package general;

import dao.*;
import entities.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class programaAlunoPagamento {
    private AlunoPagamentoDao alunoPagamentoDao;
    private PessoaDao pessoaDao;
    private MensalidadeAlunoDao mensalidadeAlunoDao;
    private MovFinanceiraDao movFinanceiraDao;

    public programaAlunoPagamento() {
        this.alunoPagamentoDao = new AlunoPagamentoDao();
        this.pessoaDao = new PessoaDao();
        this.mensalidadeAlunoDao = new MensalidadeAlunoDao();
        this.movFinanceiraDao = new MovFinanceiraDao();
    }

    Scanner s = new Scanner(System.in);

    public void mostrarMenu() {
        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                    AlunoPagamento pagamento = registrarPagamento();
                    if (pagamento != null) {
                        boolean pagamentoFoiInserido = alunoPagamentoDao.adiciona(pagamento);
                        if (pagamentoFoiInserido) {
                            System.out.println("Pagamento registrado com sucesso");
                        } else {
                            System.out.println("Falha ao registrar pagamento");
                        }
                    }
                    break;

                case 2:
                    mostrarTodosPagamentos();
                    break;
                case 3:
                    // Implementar atualização de pagamento se necessário
                    break;
                case 4:
                    // Implementar exclusão de pagamento se necessário
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcaoUsuario != 5);
    }

    private AlunoPagamento registrarPagamento() {
        AlunoPagamento pagamento = new AlunoPagamento();
        MovFinanceira mov = new MovFinanceira();
        LocalDate dataAtual = LocalDate.now();

        System.out.println("Escolha um aluno pelo nome:");
        pessoaDao.mostrarTodos();
        System.out.print("Nome do Aluno: ");
        String nome = s.nextLine();
        Pessoa aluno = pessoaDao.buscaPorNome(nome);
        if (aluno == null) {
            System.out.println("Aluno não encontrado!");
            return null;
        }
        pagamento.setAluno(aluno);

        mensalidadeAlunoDao.mostrarTodos();
        System.out.print("Escolha um plano pelo ID: ");
        Long planoId = Long.parseLong(s.nextLine());
        MensalidadeAluno plano = mensalidadeAlunoDao.buscaPorId(planoId);
        if (plano == null) {
            System.out.println("Plano não encontrado!");
            return null;
        }

        LocalDate dataVencimento = dataAtual.plusDays(30);
        pagamento.setValor(plano.getValor());
        pagamento.setPlano(plano);
        pagamento.setVencimento(dataVencimento);
        pagamento.setDataCriacao(dataAtual);
        pagamento.setModalidade(1); // Supondo que modalidade é 1 para mensalidade

        mov.setValor(plano.getValor());
        mov.setTipo(1); // Supondo que 1 é o tipo para pagamento de mensalidade
        mov.setDescricao("Mensalidade");
        mov.setDataCriacao(dataAtual);

        movFinanceiraDao.adiciona(mov);

        return pagamento;
    }

    public void mostrarTodosPagamentos() {
        List<AlunoPagamento> pagamentos = alunoPagamentoDao.mostrarTodos();
        for (AlunoPagamento pagamento : pagamentos) {
            System.out.println(pagamento);
        }
    }

    private int pegaOpcaoUsuario() {
        System.out.println("1 - Registrar Pagamento");
        System.out.println("2 - Mostrar todos os pagamentos");
        System.out.println("3 - Atualizar pagamento");
        System.out.println("4 - Excluir pagamento pelo ID");
        System.out.println("5 - Voltar");
        System.out.print("Qual sua opção? R: ");
        return Integer.parseInt(s.nextLine());
    }
}
