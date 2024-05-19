package general;

import java.util.Scanner;

import dao.EntradaAlunoDao;
import entities.EntradaAluno;

import java.util.Date;

public class ProgramaEntradaAluno{
    EntradaAlunoDao EntradaAlunoDao = new EntradaAlunoDao();
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
                        System.out.println("Entrada registrada");
                    } else {
                        System.out.println("Entraada nao inserida");

                    }

                    break;
                case 2:
                  EntradaAlunoDao.mostrarTodos();
                    break;
                case 4:
                System.out.println("Saindo...");


                    break;

                default:
                    System.out.println("sair");

                    break;

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

        System.out.println("1 Entrar");
        System.out.println("2 Sair");
        System.out.println("3 Mostrar Registro");
        System.out.println("4 sair");
        System.out.print("Qual sua opcao ?R: ");
        return Integer.parseInt(s.nextLine());

    }
    
}