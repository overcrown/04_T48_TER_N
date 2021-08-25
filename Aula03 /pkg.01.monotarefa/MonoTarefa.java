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

public class MonoTarefa {
    public static void main(String[] args) {
        // criação da tarefa
        Tarefa tarefa = new Tarefa("Listar", "Produtos");

        // excutar a tarefa
        tarefa.run();
    }
}
