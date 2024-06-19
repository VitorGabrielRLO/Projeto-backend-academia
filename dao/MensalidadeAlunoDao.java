package dao;
import entities.MensalidadeAluno;
// import entities.Pessoa;
import java.time.LocalDate;

public class MensalidadeAlunoDao {
     MensalidadeAluno[] mensalidadeVigente = new MensalidadeAluno[100];

    public boolean adiciona(MensalidadeAluno p) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            mensalidadeVigente[proximaPosicaoLivre] = p;
            return true;
        } else {
            return false;
        }

    }

    public boolean ehVazio() {
        for (MensalidadeAluno mensalidadeVigentes : mensalidadeVigente) {
            if (mensalidadeVigentes != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos() {
        boolean temMensalidade = false;
        for (MensalidadeAluno mensalidades : mensalidadeVigente) {
            if (mensalidades != null) {
                System.out.println(mensalidades);
                System.out.println("--------------------------");
                temMensalidade = true;
            }
        }
        if (!temMensalidade) {
            System.out.println("Não existem planos cadastrados.");
        }
    }

    public boolean alterarDescricao(Long id, String novoPlano, String novaDescricao, double novoValor) {
        for (MensalidadeAluno mensalidadeVigentes : mensalidadeVigente) {
            if (mensalidadeVigentes != null && mensalidadeVigentes.getId() == id){
                LocalDate dataAtual = LocalDate.now();
                mensalidadeVigentes.setPlano(novoPlano);
                mensalidadeVigentes.setValor(novoValor);
                mensalidadeVigentes.setDescricao(novaDescricao);
                mensalidadeVigentes.setDataModificacao(dataAtual);
                return true;
            }
        }
        return false;

    }

    public double escolherId(Long id) {
        for (MensalidadeAluno mensalidadeVigentes : mensalidadeVigente) {
            if (mensalidadeVigentes != null && mensalidadeVigentes.getId() == id){
                return mensalidadeVigentes.getValor();
            }
        }
        return 0;
    }
    public String pegaPlano(Long id) {
        for (MensalidadeAluno mensalidadeVigentes : mensalidadeVigente) {
            if (mensalidadeVigentes != null && mensalidadeVigentes.getId() == id){
                return mensalidadeVigentes.getPlano();
            }
        }
        return null;
    }

    MensalidadeAluno buscaPorId(long id) {
        for (MensalidadeAluno mensalidadeVigentes : mensalidadeVigente) {
            if (mensalidadeVigentes != null && mensalidadeVigentes.getId()==id) {
                return mensalidadeVigentes;
            }
        }
        return null;

    }

    public boolean remover(long id) {
        for (int i = 0; i < mensalidadeVigente.length; i++) {
            if (mensalidadeVigente[i] != null && mensalidadeVigente[i].getId()==id) {
                mensalidadeVigente[i] = null;
                return true;
            }
        }
        return false;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < mensalidadeVigente.length; i++) {
            if (mensalidadeVigente[i] == null) {
                return i;
            }

        }
        return -1;

    }
    
    public MensalidadeAlunoDao() {
        LocalDate dataAtual = LocalDate.now();
        MensalidadeAluno mensalidade1 = new MensalidadeAluno();
        MensalidadeAluno mensalidade2 = new MensalidadeAluno();
        MensalidadeAluno mensalidade3 = new MensalidadeAluno();
        MensalidadeAluno mensalidade4 = new MensalidadeAluno();

        mensalidade1.setPlano("Mensal");
        mensalidade1.setDescricao("Plano mensal sem desconto");
        mensalidade1.setValor(100.00);
        mensalidade1.setDataCriacao(dataAtual);

        mensalidade2.setPlano("Bimestral");
        mensalidade2.setDescricao("Plano 2 meses 10% desconto por mês");
        mensalidade2.setValor(90.00 * 2);
        mensalidade2.setDataCriacao(dataAtual);

        mensalidade3.setPlano("Semestral");
        mensalidade3.setDescricao("Plano 6 meses 25% desconto por mês");
        mensalidade3.setValor(75.00 * 6);
        mensalidade3.setDataCriacao(dataAtual);

        mensalidade4.setPlano("Anual");
        mensalidade4.setDescricao("Plano anual 35% desconto por mês");
        mensalidade4.setValor(65.00 * 12);
        mensalidade4.setDataCriacao(dataAtual);


        adiciona(mensalidade1);
        adiciona(mensalidade2);
        adiciona(mensalidade3);
        adiciona(mensalidade4);

    }
}
