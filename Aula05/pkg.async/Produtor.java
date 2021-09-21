public class Produtor implements java.lang.Runnable{
    // a classe que criamos anteriormente
    Valores valor;

    public Produtor(Valores valor){
        this.valor = valor;
    }

    public void run(){
        int tempo;
        for(int i=0; i < 11; i++){
            tempo = (int) (Math.random() * 3000);
            valor.guardar(i);
            System.out.println("O Produtor está guardando o valor: \t" + i);

            try {
                Thread.sleep(tempo);
            } catch (InterruptedException e) {
            }
        }
    }

}