package general;

import java.util.Scanner;

import dao.*;
import entities.*;
import java.util.Scanner;
import java.time.LocalDate;

public class programaFichaTreino {

    private DivisaoTreinoDao divisaoTreinoDao;
    private PessoaDao pessoaDao;
    private TreinoDao treinoDao ;
    private FichaTreinoDao FichaTreinoDao;
    
    public programaFichaTreino(DivisaoTreinoDao divisaoTreinoDao, PessoaDao pessoaDao,
    TreinoDao treinoDao, FichaTreinoDao FichaTreinoDao){
        this.divisaoTreinoDao = divisaoTreinoDao;
        this.pessoaDao = pessoaDao;
        this.treinoDao = treinoDao;
        this.FichaTreinoDao = FichaTreinoDao;
    }

    Scanner s = new Scanner(System.in);

    public void mostrarMenu(){
        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                    criaFicha();

                    break;
                case 2:
                    FichaTreinoDao.mostrarTodos();
                    break;
                case 3:
                    System.out.println("5");

                    break;

                default:
                    System.out.println("sair");

                    break;

            }
        }while (opcaoUsuario != 5);
    }

    private int pegaOpcaoUsuario() {

        System.out.println("1 - Cadastrar Ficha");
        System.out.println("2 - Mostrar todas as Ficha");
        System.out.println("3 - Voltar");
        System.out.print("Qual sua opcao ?R: ");
        return Integer.parseInt(s.nextLine());

    }

    private FichaTreino criaFicha(){

        FichaTreino fichaTreino = new FichaTreino();
        
        System.out.println("Escolha uma pessoa pelo Id: ");
        pessoaDao.mostrarTodos();
        long opcPessoa = s.nextLong();
        Pessoa pessoaSel = pessoaDao.selecionarPorId(opcPessoa);
        fichaTreino.setPessoa(pessoaSel);

        System.out.println("Escolha uma divisao pelo Id: ");
        divisaoTreinoDao.mostrarTodos();
        long opcDivisao = s.nextLong();
        DivisaoTreino divisaoSel = divisaoTreinoDao.selecionarPorId(opcDivisao);
        fichaTreino.setDivisao(divisaoSel);

        System.out.println("Escolha o treino pelo Id: ");
        treinoDao.mostrarTodos();
        long opcTreino = s.nextLong();
        Treino treinoSel = treinoDao.selecionarPorId(opcTreino);
        fichaTreino.setTreino(treinoSel);
        
        LocalDate dataAtual = LocalDate.now();
        fichaTreino.setDataInicio(dataAtual);

        System.out.println("Quantas semanas de duração: ");
        int numSemanas = s.nextInt();
        LocalDate dataFim = dataAtual.plusWeeks(numSemanas);
        fichaTreino.setDataFim(dataFim);
        return fichaTreino;
    }
    
}
