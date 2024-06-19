package general;

import java.util.Scanner;

import dao.EntradaAlunoDao;
import entities.EntradaAluno;

import java.util.Date;

public class ProgramaEntradaAluno{
    private EntradaAlunoDao EntradaAlunoDao;
    public ProgramaEntradaAluno(EntradaAlunoDao EntradaAlunoDao){
        this.EntradaAlunoDao= EntradaAlunoDao;
    }

    Scanner s = new Scanner(System.in);

    public void mostrarMenu(){


        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                    EntradaAluno j = entradaAluno();

                    boolean entradaAluno = EntradaAlunoDao.adiciona(j);
                    if (entradaAluno) {
                        System.out.println("\nEntrada registrada\n");
                    } else {
                        System.out.println("\nEntrada nao inserida\n");

                    }

                    break;
                case 2:
                  EntradaAlunoDao.mostrarTodos();
                    break;
                case 3:
                System.out.println("Saindo...\n");


                    break;

                default:
                    System.out.println("sair");

                    return;

            }
        }while (opcaoUsuario != 5);
    }
    
    private EntradaAluno entradaAluno() {
        EntradaAluno j = new EntradaAluno();
        Date dataAtual = new Date();
        System.out.print("\nSeja Bem vindo ");
        j.setDataCriacao(dataAtual);

        

        return j;
    }

    private int pegaOpcaoUsuario() {

        int sla;

        System.out.println("1 - Entrar");
        System.out.println("2 - Mostrar Registro");
        System.out.println("3 - sair");
        System.out.print("Qual sua opcao ?R: ");
        
        
        sla = s.nextInt();
        return sla;
    }
    
}