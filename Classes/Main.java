import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Criando uma instância da classe Academia usando o método estático criarAcademia
        Academia minhaAcademia = Academia.criarAcademia(1, "Minha Academia", "Rua Principal", new Date(), new Date());
        
        // Permitindo que o usuário selecione uma opção
        minhaAcademia.selecioneOpc();
    }
}
