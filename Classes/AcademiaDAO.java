
public class AcademiaDAO {
    private Academia[] academias;
    private int count;

    public AcademiaDAO(int capacidade) {
        this.academias = new Academia[capacidade];
        this.count = 0;
    }

    public void adicionarAcademia(Academia academia) {
        if (count < academias.length) {
            academias[count] = academia;
            count++;
        } else {
            System.out.println("Capacidade máxima alcançada. Não é possível adicionar mais academias.");
        }
    }

    public void exibirTodasAsAcademias() {
        System.out.println("\n--- Todas as Academias ---");
        for (int i = 0; i < count; i++) {
            academias[i].exibirInformacoes();
        }
        System.out.println("--------------------------");
    }
}
