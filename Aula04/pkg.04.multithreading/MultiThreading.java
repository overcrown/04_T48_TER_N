class MeuThread extends java.lang.Thread{
    private final String thread;
    private final String nome;

    public MeuThread(String thread, String nome) {
        this.thread = thread;
        this.nome = nome;
    }

    @Override
    public void run(){
        System.out.println("Nome do Thread..: " + nome);
        System.out.println("Thread Executado: " + thread);
        System.out.println("");
    }
}

public class MultiThreading{
    public static void main(String[] args) {
        MeuThread t1 = new MeuThread("1", "Listar Produtos");
        MeuThread t2 = new MeuThread("2", "Atualizar Produtos");
        MeuThread t3 = new MeuThread("3", "Excluir Produtos");

        // Executar os Threads
        t3.start();
        t2.start();
        t1.start();
    }
}