public class Produtor implements java.lang.Runnable {
    // a classe que criamos anteriormente
    Valores valor;

    public Produtor(Valores valor) {
        this.valor = valor;
    }

    public void run() {
        int tempo;
        for (int i = 0; i < 11; i++) {
            tempo = (int) (Math.random() * 3000);
            valor.guardar(i);
            System.out
                    .println("Guardando o valor: \t" + i + "\t" + tempo + "/ms\t\t" + Thread.currentThread().getName());

            // System.out.println("");

            try {
                Thread.sleep(tempo);
            } catch (InterruptedException e) {
                System.out.println("Run-Produtor" + e.getMessage());
            }
        }
    }

}