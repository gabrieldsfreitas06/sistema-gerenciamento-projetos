package model;

import java.util.ArrayList;
import java.util.List;

public class Equipe {

    private String nome;
    private List<model.Colaborador> colaboradores;

    public Equipe(String nome) {

        this.nome = nome;
        this.colaboradores = new ArrayList<>();
    }

    public void adicionarColaborador(model.Colaborador colaborador) {

        colaboradores.add(colaborador);
    }

    public String getNome() {
        return nome;
    }

    public List<model.Colaborador> getColaboradores() {
        return colaboradores;
    }
}