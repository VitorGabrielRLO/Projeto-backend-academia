package general;

import dao.*;
import entities.*;

import java.util.Scanner;
import java.util.Date;
import java.time.LocalDate;

public class programaAvaliacaoFisica{
    private AvaliacaoFisicaDao AvaliacaoFisicaDao;
    private MovFinanceiraDao MovFinanceiraDao;

    public programaAvaliacaoFisica(AvaliacaoFisicaDao AvaliacaoFisicaDao, MovFinanceiraDao MovFinanceiraDao){
        this.AvaliacaoFisicaDao = AvaliacaoFisicaDao;
        this.MovFinanceiraDao = MovFinanceiraDao;
    }
    Scanner s = new Scanner(System.in);

    /**
     * 
     */
    public void mostrarMenu(){
        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                    AvaliacaoFisica j = avaliaFisico();

                    boolean pessoaFoiInserida = AvaliacaoFisicaDao.adiciona(j);
                    if (pessoaFoiInserida) {
                        System.out.println("Divisao inserida com sucesso");
                    } else {
                        System.out.println("Divisao nao inserida");

                    }

                    break;
                case 2:
                    AvaliacaoFisicaDao.mostrarTodos();
                    break;
                case 3:
                    // System.out.println("Divisao a procurada:");
                    // String procurado = s.nextLine();
                    // System.out.println("Novo nome:");
                    // String novoNome = s.nextLine();
                    // if (AvaliacaoFisicaDao.alterarNome(procurado, novoNome)) {
                    //     System.out.println("Divisao alterado");
                    // } else {
                    //     System.out.println("Divisao não encontrado");
                    // }

                    break;
                case 4:
                // System.out.print("Digite o peso: ");
                // double peso = s.nextDouble();
                // System.out.print("Digite a altura: ");
                // double altura = s.nextDouble();
                // s.nextLine(); // Consumir a nova linha após nextDouble
                // System.out.println("IMC calculado: " + imc);
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
    
    private AvaliacaoFisica avaliaFisico() {
        Date dataCriacao = new Date();
        AvaliacaoFisica j = new AvaliacaoFisica();
        MovFinanceira mov = new MovFinanceira();
        LocalDate dataAtual = LocalDate.now();

        System.out.print("\nPeso: ");
        double peso = s.nextDouble();
        j.setPeso(peso);
        System.out.print("\nAltura em cm: ");
        double altura = s.nextDouble()/100;//Passando de cm para metros
        j.setAltura(altura);
        j.setDataCriacao(dataCriacao);

         double imc = peso/(altura*altura);
         j.setIMC(imc);

            mov.setValor(20);
            mov.setTipo(1);
            mov.setDescricao("Avaliaçao fisica");
            mov.setDataCriacao(dataAtual);
            MovFinanceiraDao.adiciona(mov);
         
         //Quando gerar avaliação, aumentar R$20 no valor a ser pago pelo aluno

        System.out.printf("Seu imc: %.2f \n",imc);
        return j;
    }

    private int pegaOpcaoUsuario() {

        int opc;

        System.out.println("1 - Cadastrar avaliacao fisica");
        System.out.println("2 - Mostrar todas as avaliacoes");
        System.out.println("3 - Atualizar avaliacao");
        System.out.println("4 - Excluir avaliacao pelo id");
        System.out.println("5 - Voltar");
        System.out.print("Qual sua opcao ?R: ");
        opc = s.nextInt();
        return opc;


    }
    




}