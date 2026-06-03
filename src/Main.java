import model.Colaborador;
import model.Projeto;
import model.Tarefa;
import service.ProjetoService;
import model.Equipe;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    private static void menuGerente() {

        int opcao;

        do {

            System.out.println("\n===== GERENTE DE PROJETOS =====");

            System.out.println("1 - Criar Tarefa");
            System.out.println("2 - Atualizar Status do Projeto");
            System.out.println("3 - Acompanhar Prazo");
            System.out.println("4 - Visualizar Equipe");
            System.out.println("0 - Voltar");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    criarTarefa();
                    break;

                case 2:
                    atualizarStatusProjeto();
                    break;

                case 3:
                    acompanharPrazo();
                    break;

                case 4:
                    visualizarEquipe();
                    break;
            }

        } while (opcao != 0);
    }

    private static void criarTarefa() {

        System.out.println("\nTítulo da tarefa:");
        String titulo = sc.nextLine();

        System.out.println("Descrição:");
        String descricao = sc.nextLine();

        model.Colaborador colaborador =
                new Colaborador(
                        "João",
                        "joao@email.com",
                        "123"
                );

        model.Tarefa tarefas =
                new Tarefa(
                        titulo,
                        descricao,
                        colaborador
                );

        tarefaService.adicionarTarefa(tarefas);
        System.out.println("Tarefa criada com sucesso!");
    }

    private static void atualizarStatusProjeto() {

        System.out.println("\nNome do Projeto:");

        String nome = sc.nextLine();

        Projeto projeto =
                projetoService.buscarProjeto(nome);

        if (projeto == null) {

            System.out.println("Projeto não encontrado!");
            return;
        }

        System.out.println("Novo status:");

        String status = sc.nextLine();

        projeto.atualizarStatus(status);

        System.out.println("Status atualizado!");
    }

    private static void acompanharPrazo() {

        System.out.println("\nNome do Projeto:");

        String nome = sc.nextLine();

        Projeto projeto =
                projetoService.buscarProjeto(nome);

        if (projeto == null) {

            System.out.println("Projeto não encontrado!");
            return;
        }

        System.out.println("Projeto: "
                + projeto.getNome());

        System.out.println("Prazo: "
                + projeto.getPrazo());

    }

    private static void visualizarEquipe() {

        System.out.println("\nNome do Projeto:");

        String nome = sc.nextLine();

        Projeto projeto =
                projetoService.buscarProjeto(nome);

        if (projeto == null) {

            System.out.println("Projeto não encontrado!");
            return;
        }

        System.out.println("Equipe responsável:");

        System.out.println(
                projeto.getEquipe()
        );
    }

    private static void menuColaborador() {

        int opcao;

        do {

            System.out.println("\n===== MENU COLABORADOR =====");

            System.out.println("1 - Visualizar Tarefas");
            System.out.println("2 - Atualizar Andamento");
            System.out.println("3 - Consultar Projeto");
            System.out.println("0 - Voltar");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    visualizarTarefas();
                    break;

                case 2:
                    atualizarAndamento();
                    break;

                case 3:
                    consultarProjeto();
                    break;
            }

        } while(opcao != 0);
    }

    private static void visualizarTarefas() {

        System.out.println("\n===== TAREFAS =====");

        for (Tarefa tarefa : tarefaService.listarTarefas()) {

            System.out.println("Título: "
                    + tarefa.getTitulo());

            System.out.println("Descrição: "
                    + tarefa.getDescricao());

            System.out.println("Responsável: "
                    + tarefa.getResponsavel().getNome());

            System.out.println("Status: "
                    + tarefa.getStatus());

            System.out.println("----------------------");
        }
    }

    private static void atualizarAndamento() {

        System.out.println("\nNome da tarefa:");

        String titulo = sc.nextLine();

        Tarefa tarefaEncontrada = null;

        for (Tarefa tarefa : tarefaService.listarTarefas()) {

            if (tarefa.getTitulo().equalsIgnoreCase(titulo)) {

                tarefaEncontrada = tarefa;
                break;
            }
        }

        if (tarefaEncontrada == null) {

            System.out.println("Tarefa não encontrada!");
            return;
        }

        System.out.println("Novo status:");
        System.out.println("Exemplos:");
        System.out.println("- Em andamento");
        System.out.println("- Concluída");
        System.out.println("- Aguardando aprovação");

        String novoStatus = sc.nextLine();

        tarefaEncontrada.atualizarStatus(novoStatus);

        System.out.println("Status atualizado!");
    }

    private static void consultarProjeto() {

        System.out.println("\nNome do Projeto:");

        String nome = sc.nextLine();

        Projeto projeto =
                projetoService.buscarProjeto(nome);

        if (projeto == null) {

            System.out.println("Projeto não encontrado!");
            return;
        }

        System.out.println("\n===== DADOS DO PROJETO =====");

        System.out.println("Nome: "
                + projeto.getNome());

        System.out.println("Descrição: "
                + projeto.getDescricao());

        System.out.println("Prazo: "
                + projeto.getPrazo());

        System.out.println("Status: "
                + projeto.getStatus());

        System.out.println("Equipe: "
                + projeto.getEquipe());
    }

    private static void menuAdministrador() {

        int opcao;

        do {

            System.out.println("\n===== ADMINISTRADOR =====");

            System.out.println("1 - Cadastrar Projeto");
            System.out.println("2 - Listar Projetos");
            System.out.println("0 - Voltar");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    cadastrarProjeto();
                    break;

                case 2:
                    listarProjetos();
                    break;
            }

        } while (opcao != 0);
    }

    private static void cadastrarProjeto() {

        System.out.println("\nNome do Projeto:");
        String nome = sc.nextLine();

        System.out.println("Descrição:");
        String descricao = sc.nextLine();

        System.out.println("Nome da Equipe:");
        String nomeEquipe = sc.nextLine();

        System.out.println("Prazo (AAAA-MM-DD):");
        String data = sc.nextLine();

        model.Equipe equipe =
                new model.Equipe(nomeEquipe);

        Projeto projeto =
                new Projeto(
                        nome,
                        descricao,
                        LocalDate.parse(data),
                        nomeEquipe
                );

        projetoService.cadastrarProjeto(projeto);

        System.out.println("Projeto cadastrado com sucesso!");
    }

    private static void listarProjetos() {

        System.out.println("\n===== PROJETOS =====");

        for (Projeto projeto :
                projetoService.listarProjetos()) {

            System.out.println("Nome: "
                    + projeto.getNome());

            System.out.println("Descrição: "
                    + projeto.getDescricao());

            System.out.println("Prazo: "
                    + projeto.getPrazo());

            System.out.println("Status: "
                    + projeto.getStatus());

            System.out.println("Equipe: "
                    + projeto.getEquipe());

            System.out.println("-----------------------");
        }
    }

    static Scanner sc = new Scanner(System.in);

    static ProjetoService projetoService =
            new ProjetoService();

    static TarefaService tarefaService =
            new TarefaService();

    public static void main(String[] args) {

        int opcao;

        do {

            System.out.println("\n===== SISTEMA =====");

            System.out.println("1 - Administrador");
            System.out.println("2 - Gerente");
            System.out.println("3 - Colaborador");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    menuAdministrador();
                    break;

                case 2:
                    menuGerente();
                    break;

                case 3:
                    menuColaborador();
                    break;

                case 0:
                    System.out.println("Sistema encerrado.");
                    break;
            }

        } while (opcao != 0);
    }
}