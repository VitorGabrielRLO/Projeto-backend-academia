
import dao.*;
import entities.*;
import front.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var pessoaDao = new PessoaDao();
        var menuSelecao = new MenuSelecao(); // Cria uma instância de MenuSelecao, que cria uma instância de Academia
        var Login = new Login(pessoaDao);
        menuSelecao.selecioneOpc();
    }
}
