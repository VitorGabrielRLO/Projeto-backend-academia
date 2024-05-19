package front;

import java.util.Scanner;
import dao.PessoaDao;

public class Login {
    private PessoaDao pessoaDao;
    public Login(PessoaDao pessoaDao){
        this.pessoaDao = pessoaDao;
    }

    //Serão criados 3 tipos de usuario, cada um com tipos de acessos diferentes
 public void selecioneOpc() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            scanner.nextLine(); // Consome o caractere de nova linha
            int condicao = 0;
            while (condicao == 0) {
                System.out.println("Digite seu login: ");    
                String login = scanner.nextLine();
                System.out.println("Digite sua senha");
                String senha = scanner.nextLine();
                
                switch (login(login, senha)) {
                    case 1:
                    //Aluno 
                    
                    condicao = 1;
                    break;
                    
                    case 2:
                    //Professor
                    
                    condicao = 1;
                    break;
                    
                    case 3:
                    //Adm
                    
                    condicao = 1;
                    break;
                    default:
                    System.out.println("Login inválida.");
                    condicao = 0;
                    break;
                }
            }
        }
    }
    
    private int login(String login, String senha)
    {   

        var pessoa = this.pessoaDao.buscaLogin(login);
        if (pessoa == null) {
            return 0;
        }
        if(!pessoa.getSenhaPessoa().equals(senha)){
            return 0;
        }
        return pessoa.getTipoUsuarioPessoa();
    }


    
}
