package front;

import java.util.Scanner;
import dao.PessoaDao;

public class Login {
    private PessoaDao pessoaDao;
    private MenuAdmin menuAdmin;
    // private MenuAluno menuAluno;
    private MenuProfessor menuProfessor;

    public Login(PessoaDao pessoaDao){
        this.pessoaDao = pessoaDao;
        this.menuAdmin = new MenuAdmin();
        this.menuProfessor = new MenuProfessor();
        // this.menuAdmin = new MenuAluno();
    }


    //Serão criados 3 tipos de usuario, cada um com tipos de acessos diferentes
 public void selecioneOpc() {
        

        while (true) {
            Scanner scanner = new Scanner(System.in);
            int condicao = 0;
            while (condicao == 0) {
                System.out.println("Digite seu login: ");    
                String login = scanner.nextLine();
                System.out.println("Digite sua senha");
                String senha = scanner.nextLine();
                int qualquerMerda = login(login, senha);
                switch (qualquerMerda) {
                    case 1:
                    //Aluno 
                    // menuAluno.selecioneOpc();

                    condicao = 1;
                    break;
                    
                    case 2:
                    //Professor
                    menuProfessor.menuProfessor();

                    condicao = 1;
                    break;
                    
                    case 3:
                    //Adm
                    menuAdmin.selecioneOpc();
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
