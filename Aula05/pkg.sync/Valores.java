public class Valores {
    int valor;
    private boolean bloqueado; // flag

    public Valores() {
        bloqueado = false;
    }

    // synchronized força uma sincronização
    public synchronized void guardar(int valores) {
        while (bloqueado) {
            try {
                // chamando o escalonador (Psiu!!!)
                wait(); // aguardar
            } catch (InterruptedException e) {
                System.out.println("ERRO Guardando..." + e.getMessage());
            }
        }
        this.valor = valores;
        bloqueado = true;
        // faz uma notificação ao escalonador que algo mudou
        notify();
    }

    public synchronized int exibir() {
        while (!bloqueado) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("ERRO Exibindo..." + e.getMessage());
            }
        }
        bloqueado = false;
        notify();
        return this.valor;
    }

}
