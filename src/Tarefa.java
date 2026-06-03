package model;
public class Tarefa {

    private String titulo;
    private String descricao;
    private String status;
    private model.Colaborador responsavel;

    public Tarefa(String titulo,
                  String descricao,
                  model.Colaborador responsavel) {

        this.titulo = titulo;
        this.descricao = descricao;
        this.responsavel = responsavel;
        this.status = "Pendente";
    }


    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getStatus() {
        return status;
    }

    public model.Colaborador getResponsavel() {
        return responsavel;
    }

    public void atualizarStatus(String status) {
        this.status = status;
    }
}