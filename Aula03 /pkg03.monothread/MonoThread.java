class MeuThread extends java.lang.Thread{
    private final String thread;
    private final String nome;

    public MeuThread(String thread, String nome){
        this.thread = thread;
        this.nome = nome;
    }

    @Override
    public void run(){
        System.out.println("Nome do Thread: " + nome);
        System.out.println("Thread executando: " + thread);
    }
}

public class MonoThread{
    public static void main(String[] args){
        MeuThread t1 = new MeuThread("Listar", "Produtos");
        MeuThread t2 = new MeuThread("Apagar", "Produtos");

        // aqui é inicializado o thread
        // (despacho para o escalonador)
        t1.start();
        t2.start();
    }
}

// Implementar algum cálculo (soma, multiplicação, etc...)
// utilizando Mono ou MultiThread.
// 20 minutos
