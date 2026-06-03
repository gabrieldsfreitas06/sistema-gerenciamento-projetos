import java.util.ArrayList;
import java.util.List;
import model.Tarefa;

public class TarefaService {

    private List<Tarefa> tarefas;

    public TarefaService() {
        tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    public List<model.Tarefa> listarTarefas() {
        return tarefas;
    }
}