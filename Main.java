
import dao.*;
import front.*;


public class Main {
    
    public static void main(String[] args) {
        var pessoaDao = new PessoaDao();
        // var menuSelecao = new MenuSelecao(); // Cria uma instância de MenuSelecao, que cria uma instância de Academia
         var Login = new Login(pessoaDao);
         Login.selecioneOpc();
        // menuSelecao.selecioneOpc();
    }
}
