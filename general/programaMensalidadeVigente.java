package general;

import dao.MensalidadeVigenteDao;
import entities.MensalidadeVigente;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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
                    List<MensalidadeVigente> mensalidadeVigentes = MensalidadeVigenteDao.mostrarTodos();
                for (MensalidadeVigente a : mensalidadeVigentes) {
                    System.out.println(a);
                    
    
            }
                    break;
                case 3:
                    System.out.println("Id da mensalidade a ser alterada:");
                    Long procurado = s.nextLong();
                    System.out.println("Novo Valor:");
                    double novoValor = s.nextDouble();
                    s.nextLine(); // Limpa o buffer do scanner
                    if (MensalidadeVigenteDao.alterarValor(procurado, novoValor)) {
                        System.out.println("Mensalidade Vigente alterada com sucesso");
                    } else {
                        System.out.println("Mensalidade Vigente não encontrada");
}

                    break;
                case 4:
                    System.out.println("Id da mensalidade a ser excluida:");
                    Long idExclusao = s.nextLong();

                    if (MensalidadeVigenteDao.remover(idExclusao)) {
                        System.out.println("Mensalidade Vigente excluída");
                    } else {
                        System.out.println("Mensalidade Vigente não excluída");
                    }

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

        System.out.print("Valor: ");
        while (true) {
            try {
                double valor = s.nextDouble();
                j.setValor(valor);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Por favor, insira um número.");
                s.next(); 
            }
        }
        s.nextLine();
        System.out.print("Data Início (yyyy-mm-dd): ");
        while (true) {
            try {
                String dataInicio = s.nextLine();
                LocalDate dt = LocalDate.parse(dataInicio);
                j.setInicio(dt);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Por favor, insira no formato yyyy-mm-dd.");
            }
        }

        // Ler e validar a data de término
        System.out.print("Data Término (yyyy-mm-dd): ");
        while (true) {
            try {
                String dataTermino = s.nextLine();
                LocalDate dat = LocalDate.parse(dataTermino);
                j.setTermino(dat);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Por favor, insira no formato yyyy-mm-dd.");
            }
        }

        return j;
    }

    private int pegaOpcaoUsuario() {
        int opcao = -1;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.println("1 - Cadastrar Mensalidade Vigente");
                System.out.println("2 - Mostrar Todas Mensalidades Vigentes");
                System.out.println("3 - Alterar Valor da Mensalidade Vigente");
                System.out.println("4 - Excluir pelo id");
                System.out.println("5 - sair");
                System.out.print("Qual sua opcao ?R: ");
                opcao = Integer.parseInt(s.nextLine().trim());
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número de 1 a 5.");
            }
        }
        return opcao;
    }
    
    
}