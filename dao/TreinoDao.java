package dao;


import entities.Treino;

public class TreinoDao {

    Treino[] treino = new Treino[10];

    public boolean adiciona(Treino p) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            treino[proximaPosicaoLivre] = p;
            return true;
        } else {
            return false;
        }
    }

    public boolean ehVazio() {
        for (Treino treinos : treino) {
            if (treinos != null) {
                return false;
            }
        }
        return true;
    }

    public void mostrarTodos() {
        boolean temTreino = false;
        for (Treino treinos : treino) {
            if (treinos != null) {
                System.out.println(treinos);
                System.out.println("-------------\n");
                temTreino = true;
            }
        }
        if (!temTreino) {
            System.out.println("Não existe treino cadastrado");
        }
    }

    Treino buscaPorId(int id) {
        for (Treino treinos : treino) {
            if (treinos != null && treinos.getId() == id) {
                return treinos;
            }
        }
        return null;
    }

    public boolean remover(int id) {
        for (int i = 0; i < treino.length; i++) {
            if (treino[i] != null && treino[i].getId() == id) {
                treino[i] = null;
                return true;
            }
        }
        return false;
    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < treino.length; i++) {
            if (treino[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public Treino selecionarPorId(Long id) {
        for (Treino divisoes : treino) {
            if (divisoes != null && divisoes.getId() == id) {
                return divisoes;
            }
        }
        return null;

    }

    public TreinoDao() {
        Treino treino1 = new Treino();
        Treino treino2 = new Treino();
        Treino treino3 = new Treino();
        Treino treino4 = new Treino();
        
        adiciona(treino1);
        adiciona(treino2);
        adiciona(treino3);
        adiciona(treino4);
    }
}
