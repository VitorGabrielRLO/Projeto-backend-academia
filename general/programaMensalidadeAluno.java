package general;

import java.util.Scanner;
import java.time.LocalDate;

import dao.MensalidadeAlunoDao;
import entities.MensalidadeAluno;
import dao.MovFinanceiraDao;
import entities.MovFinanceira;

public class programaMensalidadeAluno{
    private MensalidadeAlunoDao MensalidadeAlunoDao;
    private MovFinanceiraDao MovFinanceiraDao;
    public programaMensalidadeAluno(MensalidadeAlunoDao MensalidadeAlunoDao, MovFinanceiraDao MovFinanceiraDao){
        this.MensalidadeAlunoDao = MensalidadeAlunoDao;
        this.MovFinanceiraDao = MovFinanceiraDao;
    }

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
                        System.out.println("Plano inserido com sucesso");
                    } else {
                        System.out.println("Plano nao inserido");

                    }

                    break;
                case 2:
                    MensalidadeAlunoDao.mostrarTodos();
                    break;
                case 3:
                    System.out.println("Id do plano a ser alterado:");
                    Long Idprocurado = s.nextLong();
                    System.out.println("Novo plano:");
                    String novoNome = s.next();
                    System.out.println("Novo descrição:");
                    String novaDescricao = s.next();
                    System.out.println("Novo Valor:");
                    double novoValor = s.nextDouble();

                    if (MensalidadeAlunoDao.alterarDescricao(Idprocurado, novoNome, novaDescricao, novoValor)) {
                        System.out.println("Plano alterado");
                    } else {
                        System.out.println("Plano não encontrado");
                    }

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
        LocalDate dataAtual = LocalDate.now();

        System.out.print("\nPlano: ");
        String plano = s.next();
        
        System.out.print("\nDescricao: ");
        String descricao = s.next();

        System.out.print("\nValor: ");
        double valor = s.nextDouble();

        j.setPlano(plano);
        j.setDescricao(descricao);
        j.setValor(valor);
        j.setDataCriacao(dataAtual);
        return j;
    }

    private int pegaOpcaoUsuario() {
        int opc;

        System.out.println("\n\n");
        System.out.println("----------------------------------");
        System.out.println("1 - Crie um plano");
        System.out.println("2 - Mostrar todos os planos");
        System.out.println("3 - Alterar plano pelo id");
        System.out.println("4 - Excluir plano pelo id");
        System.out.println("5 sair");
        System.out.print("Qual sua opcao ?R: ");

        opc = s.nextInt();
        return opc;

    }
    
}