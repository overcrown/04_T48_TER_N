public class Sincrona{
    public static void main(String[] args) {
        
        Valores valor = new Valores();

        System.out.println("Processadores: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Iniciando os Threads...");
        System.out.println("");

        // criação dos Threads (2)
        new Thread(new Produtor(valor)).start();
        new Thread(new Consumidor(valor)).start();
    }
}

// Atividade
// 1. Implementar novos Threadse  verificar o comportamento das execuções.
// 2. Usando o Runtime (pesquisar), calcular o custo da memória para cada execução dos métodos


//                                                              Free Mem.
// Guardando o valor:      0       1473/ms         Thread-0     8196
// Lendo o valor:          0       2176/ms         Thread-1     