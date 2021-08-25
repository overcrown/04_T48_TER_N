class Valores extends java.lang.Thread{
    private final int valor1;
    private final int valor2;
    private int resul;

    public Valores(int valor1, int valor2){
        this.valor1 =  valor1;
        this.valor2 = valor2;
    }

    @Override
    public void run(){
        resul = valor1 * valor2;
        System.out.println("os valores digitados são: " + valor1 + " e " + valor2);
        System.out.println("o resultado da multiplicação é: " + resul);
    }

}

public class Multiplica {
    public static void main(String[] args) {
        Valores v1 = new Valores(5, 4);
        Valores v2 = new Valores(9, 3);

        v1.start();
        v2.start();
    }

}