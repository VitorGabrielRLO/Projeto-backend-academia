package general;

import java.util.Scanner;
import java.time.LocalDate;

import dao.MensalidadeAlunoDao;
import entities.MensalidadeAluno;
import dao.MovFinanceiraDao;
import entities.MovFinanceira;

public class programaMensalidadeAluno{
    MensalidadeAlunoDao MensalidadeAlunoDao = new MensalidadeAlunoDao();
    MovFinanceiraDao MovFinanceiraDao = new MovFinanceiraDao();
    Scanner s = new Scanner(System.in);

    public void mostrarMenu(){


        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                    MensalidadeAluno j = registraMensalidade();

                    boolean pessoaFoiInserida = MensalidadeAlunoDao.adiciona(j);
                    if (pessoaFoiInserida) {
                        System.out.println("Exercicio inserido com sucesso");
                    } else {
                        System.out.println("Exercicio nao inserido");

                    }

                    break;
                case 2:
                    MensalidadeAlunoDao.mostrarTodos();
                    break;
                case 3:
                    // System.out.println("Exercicio a ser procurado:");
                    // String procurado = s.nextLine();
                    // System.out.println("Novo nome:");
                    // String novoNome = s.nextLine();
                    // if (MensalidadeAlunoDao.alterarNome(procurado, novoNome)) {
                    //     System.out.println("Exercicio alterado");
                    // } else {
                    //     System.out.println("Exercicio não encontrado");
                    // }

                    break;
                case 4:


                    break;
                case 5:
                    System.out.println("5");

                    break;

                default:
                    System.out.println("sair");

                    break;

            }
        }while (opcaoUsuario != 5);
    }
    
    private MensalidadeAluno registraMensalidade() {
        MensalidadeAluno j = new MensalidadeAluno();
        // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        MovFinanceira mov = new MovFinanceira();
        LocalDate dataAtual = LocalDate.now();


        System.out.print("\nEscolha seu plano: ");
        System.out.print("\n1-Planos 1 Mes ");
        System.out.print("\n2-Planos 3 Meses ");
        System.out.print("\n3-Planos 6 Meses ");
        int plano = s.nextInt();

        double valor = 100;
        if(plano == 1)
        {
            
            LocalDate dataVencimento = dataAtual.plusDays(30);
            j.setValor(valor);
            j.setPlano(plano);
            j.setVencimento(dataVencimento);
            mov.setValor(valor);
            mov.setTipo(1);
            mov.setDescricao("Mensalidade");
            mov.setDataCriacao(dataAtual);
        }

        if(plano == 2)
        {
            LocalDate dataVencimento = dataAtual.plusDays(90);
            valor = (valor*3)*0.9; //Aplicando desconto de 10% no plano de 3 meses
            j.setValor(valor);
            j.setDataPagamento(dataAtual);
            j.setVencimento(dataVencimento);
            mov.setValor(valor);
            mov.setTipo(1);
            mov.setDescricao("Mensalidade plano 3 meses");
            mov.setDataCriacao(dataAtual);
        }
        if(plano == 3)
        {
            LocalDate dataVencimento = dataAtual.plusDays(180);
            valor = (valor*6)*0.8; //Aplicando desconto de 20% no plano de 6 meses
            j.setValor(valor);
            j.setDataPagamento(dataAtual);
            j.setVencimento(dataVencimento);
            mov.setValor(valor);
            mov.setTipo(1);
            mov.setDescricao("Mensalidade plano 6 meses");
            mov.setDataCriacao(dataAtual);
        }
        MovFinanceiraDao.adiciona(mov);
        return j;
    }

    private int pegaOpcaoUsuario() {
        int opc;

        System.out.println("\n\n");
        System.out.println("----------------------------------");
        System.out.println("1 - Escolha um plano");
        System.out.println("2 - Mostrar todos exercicios");
        System.out.println("3 - Alterar o nome do exercicio");
        System.out.println("4 - Excluir exercicio pelo id");
        System.out.println("5 sair");
        System.out.print("Qual sua opcao ?R: ");

        opc = s.nextInt();
        return opc;

    }
    
}