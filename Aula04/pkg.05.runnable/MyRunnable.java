class ClasseRunnable implements java.lang.Runnable{
    private int contador;
    private final int contadorTotal;

    public ClasseRunnable(int contadorTotal){
        this.contadorTotal = contadorTotal;
        this.contador = 0;
    }

    @Override
    public void run(){
        while (contador <= contadorTotal){
            System.out.println(
                Thread.currentThread().getName() 
                + " Prioridade de Execução: "
                + Thread.currentThread().getPriority()
                + " - Contador Atual: " + contador
            );
            contador++;

            // Vamos colocar o Thread para dormir "sleep" (pausa)
            try {
                System.out.println(Thread.currentThread().getName() + " Dormindo por 2 segundos...");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
        }
        System.out.println("\nThread " + Thread.currentThread().getName()
        + " Finalizada com sucesso!!!");
    }
}

public class MyRunnable {
    public static void main(String[] args) {
        // criação dos Threads Runnable
        //  parâmetro do método é o total do contador
        ClasseRunnable runnable1 = new ClasseRunnable(3);
        ClasseRunnable runnable2 = new ClasseRunnable(4);
        ClasseRunnable runnable3 = new ClasseRunnable(5);

        // criação dos Threads
        Thread t1 = new Thread(runnable1);
        t1.setName("Runnable 1 - ");
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();

        Thread t2 = new Thread(runnable2);
        t2.setName("Runnable 2 - ");
        t2.setPriority(Thread.MAX_PRIORITY);
        t2.start();

        Thread t3 = new Thread(runnable3);
        t3.setName("Runnable 3 - ");
        t3.setPriority(Thread.NORM_PRIORITY);
        t3.start();

        System.out.println("Threads Runnable inicializados com sucesso!!!\n");
    }
}
