package general;

import dao.*;
import entities.*;
import java.util.Scanner;

public class programaPagamentoRecorrente {
    private PagamentoRecorrenteDao pagamentoRecorrenteDao;
    private PessoaDao pessoaDao;
    private Scanner s;

    public programaPagamentoRecorrente() {
        this.pagamentoRecorrenteDao = new PagamentoRecorrenteDao();
        this.pessoaDao = new PessoaDao();
        this.s = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();

            switch (opcaoUsuario) {
                case 1:
                    PagamentoRecorrente pagamentoRecorrente = criarPagamentoRecorrente();

                    if (pagamentoRecorrente != null) {
                        boolean pagamentoInserido = pagamentoRecorrenteDao.adiciona(pagamentoRecorrente);
                        if (pagamentoInserido) {
                            System.out.println("Pagamento inserido com sucesso");
                        } else {
                            System.out.println("Pagamento não inserido");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Lista de Pagamentos Recorrentes:");
                    System.out.println(pagamentoRecorrenteDao.mostrarTodos());
                    break;
                case 3:
                    System.out.println("ID do Pagamento Recorrente a ser alterado:");
                    long id = Long.parseLong(s.nextLine());

                    System.out.println("Novo valor:");
                    double novoValor = Double.parseDouble(s.nextLine());

                    System.out.println("Novo Número de Meses:");
                    int novoNumeroMeses = Integer.parseInt(s.nextLine());

                    if (pagamentoRecorrenteDao.alterarInfos(id, novoValor, novoNumeroMeses)) {
                        System.out.println("Dados do Pagamento Recorrente alterados com sucesso");
                    } else {
                        System.out.println("Pagamento Recorrente não encontrado");
                    }
                    break;
                case 4:
                    System.out.println("Informe o ID do Pagamento Recorrente a ser excluído:");
                    long idExcluir = Long.parseLong(s.nextLine());

                    if (pagamentoRecorrenteDao.remover(idExcluir)) {
                        System.out.println("Pagamento Recorrente excluído com sucesso");
                    } else {
                        System.out.println("Pagamento Recorrente não encontrado");
                    }
                    break;
                case 5:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida, por favor escolha uma opção válida.");
                    break;
            }
        } while (opcaoUsuario != 5);
    }

    private PagamentoRecorrente criarPagamentoRecorrente() {
        PagamentoRecorrente pagamentoRecorrente = new PagamentoRecorrente();

        System.out.print("\nNome do aluno: ");
        String nome = s.nextLine();
        Pessoa pessoa = pessoaDao.buscaPorNome(nome);

        if (pessoa == null) {
            System.out.println("Aluno não encontrado.");
            return null; // ou lidere com isso conforme necessário
        }

        pagamentoRecorrente.setAluno(pessoa);

        System.out.print("\nCartão de crédito: ");
        String cartaoDeCredito = s.nextLine();
        pagamentoRecorrente.setCartaoDeCredito(cartaoDeCredito);

        System.out.print("\nValor: ");
        double valor = Double.parseDouble(s.nextLine());
        pagamentoRecorrente.setValor(valor);

        System.out.print("\nNúmero de meses: ");
        int numeroMeses = Integer.parseInt(s.nextLine());
        pagamentoRecorrente.setNumeroMeses(numeroMeses);

        return pagamentoRecorrente;
    }

    private int pegaOpcaoUsuario() {
        System.out.println("\n### Menu de Opções ###");
        System.out.println("1 - Cadastrar Pagamento Recorrente");
        System.out.println("2 - Mostrar Todos os Pagamentos Recorrentes");
        System.out.println("3 - Alterar Número de Meses e Valor de um Pagamento Recorrente");
        System.out.println("4 - Excluir Pagamento Recorrente");
        System.out.println("5 - Sair");
        System.out.print("Escolha a opção desejada: ");
        return Integer.parseInt(s.nextLine());
    }
}
