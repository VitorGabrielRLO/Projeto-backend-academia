package general;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import dao.MensalidadeAlunoDao;
import entities.MensalidadeAluno;

public class programaMensalidadeAluno{
    MensalidadeAlunoDao MensalidadeAlunoDao = new MensalidadeAlunoDao();
    Scanner s = new Scanner(System.in);

    public void mostrarMenu(){


        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                    MensalidadeAluno j = registraMensalidade();

                    // boolean pessoaFoiInserida = MensalidadeAlunoDao.setAluno();
                    // if (pessoaFoiInserida) {
                    //     System.out.println("Exercicio inserido com sucesso");
                    // } else {
                    //     System.out.println("Exercicio nao inserido");

                    // }

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

        Date dataAtual = new Date();

        System.out.print("\nEscolha seu plano: ");
        System.out.print("\n1-Planot 1 Mes ");
        System.out.print("\n1-Planot 3 Meses ");
        System.out.print("\n1-Planot 6 Meses ");
        int plano = s.nextInt();

        double valor = 90;
        if(plano == 1)
        {
            valor=90;
        // Somar 30 dias à data atual para definir a data de vencimento
        // Calendar cal = Calendar.getInstance();
        // cal.setTime(dataAtual);
        // cal.add(Calendar.DAY_OF_MONTH, 30);
        // Date dataPagamento = cal.getTime();
        // j.setDataPagamento(dataPagamento);

            j.setValor(valor);
            j.setPlano(plano);
            // j.setDataPagamento(dataPagamento);
            
        }

        if(plano == 2)
        {
            valor = (valor*valor)/0.9; //Aplicando desconto de 10% no plano de 3 meses
            j.setValor(valor);
            j.setDataPagamento(dataAtual);
            
        }
        if(plano == 3)
        {
            valor = (valor*valor)/0.8; //Aplicando desconto de 20% no plano de 3 meses
            j.setValor(valor);
            j.setDataPagamento(dataAtual);
            
        }






        return j;
    }

    private int pegaOpcaoUsuario() {
        int opc;

        System.out.println("\n\n");
        System.out.println("----------------------------------");
        System.out.println("1 - Cadastrar exercicio");
        System.out.println("2 - Mostrar todos exercicios");
        System.out.println("3 - Alterar o nome do exercicio");
        System.out.println("4 - Excluir exercicio pelo id");
        System.out.println("5 sair");
        System.out.print("Qual sua opcao ?R: ");

        opc = s.nextInt();
        return opc;

    }
    
}