class Tarefa {
    private final String tarefa;
    private final String nome;

    public Tarefa(String tarefa, String nome) {
        this.tarefa = tarefa;
        this.nome = nome;
    }

    // método que executa o processo "tarefa"
    public void run() { // correr (executar)
        System.out.println("O nome da tarefa é: " + nome);
        System.out.println("Tarefa executada: " + tarefa);
    }
}

public class MultiTarefa {
    public static void main(String[] args) {
        // criação de muitas tarefas
        Tarefa t1 = new Tarefa("Listar", "Produtos");
        Tarefa t2 = new Tarefa("Apagar", "Produtos");
        Tarefa t3 = new Tarefa("Atualizar", "Produtos");

        // excutar a tarefa
        t1.run();
        t2.run();
        t3.run();
    }
}
