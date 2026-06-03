package model;

import java.time.LocalDate;

public class Projeto {

    private String nome;
    private String descricao;
    private LocalDate prazo;
    private String status;
    private String equipe;

    public Projeto(String nome,
                   String descricao,
                   LocalDate prazo,
                   String  equipe) {

        this.nome = nome;
        this.descricao = descricao;
        this.prazo = prazo;
        this.equipe = equipe;
        this.status = "Em andamento";
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public String getStatus() {
        return status;
    }

    public String getEquipe() {
        return equipe;
    }

    public void atualizarStatus(String status) {
        this.status = status;
    }
}