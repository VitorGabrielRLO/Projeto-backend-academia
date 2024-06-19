
package entities;

import java.time.LocalDate;

public class MensalidadeAluno {
    private static long serial;
    private long id;
    private String plano;
    private double valor;
    private String descricao;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public MensalidadeAluno() { 
        id = MensalidadeAluno.serial++;
    }
    public long getId() {
        return id;
    }

    public void setPlano(String plano)
    {
        this.plano = plano;
    }
    
    

    public String getPlano()
    {
        return plano;
    }
    public void setValor(Double valor)
    {
        this.valor = valor;
    }

    public double getValor(){
        return valor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

     public String getDescricao()
    {
        return descricao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }


    @Override
    public String toString() {
        return "MensalidadeAluno{" +
                "id=" + id +
                ", Plano=" + plano +
                ", valor=" + valor +
                ", Descrição=" + descricao +
                ", Data criação plano=" + dataCriacao +
                ", Data modificaçao plano=" + dataModificacao +
                '}';
    }
}
