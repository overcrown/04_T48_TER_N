public class Assincrona{
    public static void main(String[] args) {
        
        Valores valor = new Valores();
        
        System.out.println("Iniciando os Threads...");
        System.out.println("--------ALT+F4---------");

        // criação dos Threads (2)
        new Thread(new Produtor(valor)).start();
        new Thread(new Consumidor(valor)).start();
    }
}

// Atividade
// Executar 10 vezes o código e observar a partir de quando
// ocorre um problerma com a sincronia.
// Execute novamente as 10 rodadas, alterando o tempo do: 
// Produtor e do Consumidor de forma diferente