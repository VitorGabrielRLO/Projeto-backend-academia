public class DivisaoTreino {
    private String nomeDivisao;
    private String descricao;

    // Construtor padrão
    public DivisaoTreino() {
        this.nomeDivisao = "Divisão Padrão";
        this.descricao = "Descrição Padrão";
    }

    // Construtor com parâmetros
    public DivisaoTreino(String nomeDivisao, String descricao) {
        this.nomeDivisao = nomeDivisao;
        this.descricao = descricao;
    }

    // Getters e Setters
    public String getNomeDivisao() {
        return nomeDivisao;
    }

    public void setNomeDivisao(String nomeDivisao) {
        this.nomeDivisao = nomeDivisao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "DivisaoTreino{" +
                "nomeDivisao='" + nomeDivisao + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
