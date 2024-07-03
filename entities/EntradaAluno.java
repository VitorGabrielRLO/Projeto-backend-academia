package entities;

import java.time.LocalDate;

public class EntradaAluno {
    private long id;
    private String nome; 
    private LocalDate dataHora;

    // Getters e Setters
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }


    
    @Override
    public String toString() {
        return "EntradaAluno{" +
                "id: " + id +
                "nome: " + nome +
                ", dataHora=" + dataHora +
                '}';
    }
}
