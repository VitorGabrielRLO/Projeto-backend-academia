package general;

import java.util.Scanner;

import dao.MensalidadeVigenteDao;
import entities.MensalidadeVigente;

import java.util.Date;

public class programaMensalidadeVigente{
    MensalidadeVigenteDao MensalidadeVigenteDao = new MensalidadeVigenteDao();
    Scanner s = new Scanner(System.in);

    public void mostrarMenu(){


        int opcaoUsuario;

        do {
            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                    MensalidadeVigente j = mensalidadeVigente();

                    boolean pessoaFoiInserida = MensalidadeVigenteDao.adiciona(j);
                    if (pessoaFoiInserida) {
                        System.out.println("Mensalidade vigente inserida com sucesso");
                    } else {
                        System.out.println("Mensalidade vigente nao inserida");

                    }

                    break;
                case 2:
                    MensalidadeVigenteDao.mostrarTodos();
                    break;
                case 3:
                    System.out.println("ID da Mensalidade a ser excluida");
                    long id = s.nextLong();
                    MensalidadeVigenteDao.remover(id);

                    break;
                case 4:
                    System.out.println("4");
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
    
    private MensalidadeVigente mensalidadeVigente() {
        MensalidadeVigente j = new MensalidadeVigente();
        Date dataAtual = new Date();
        j.setDataCriacao(dataAtual);




        return j;
    }

    private int pegaOpcaoUsuario() {

        System.out.println("1. Cadastrar mensalidade vigente");
        System.out.println("2. Mostrar todas as mensalidades vigentes");
        System.out.println("3. Excluir pelo id");
        System.out.println("4. Sair");
        System.out.print("Qual sua opcao ?R: ");
        return Integer.parseInt(s.nextLine());

    }
    
}