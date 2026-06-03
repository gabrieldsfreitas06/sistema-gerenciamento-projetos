package service;

import model.Projeto;

import java.util.ArrayList;
import java.util.List;

public class ProjetoService {

    private List<Projeto> projetos;

    public ProjetoService() {
        projetos = new ArrayList<>();
    }

    public void cadastrarProjeto(Projeto projeto) {
        projetos.add(projeto);
    }

    public List<Projeto> listarProjetos() {
        return projetos;
    }

    public Projeto buscarProjeto(String nome) {

        for (Projeto projeto : projetos) {

            if (projeto.getNome().equalsIgnoreCase(nome)) {
                return projeto;
            }

        }

        return null;
    }
}