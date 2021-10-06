import java.io.*;
import java.net.*;

public class ChatClient {
    private final String hostname;
    private final int port;
    private String userName;

    public ChatClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void execute() {
        try {
            Socket socket = new Socket(hostname, port);
            System.out.println("Conected at server\nType <bye> to exit");

            // instâncias dos Threads
            new ReadThread(socket, this).start(); // leitura
            new WriteThread(socket, this).start(); // escrita

        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    void setUserName(String userName){
        this.userName = userName;
    }

    String getUserName(){
        return this.userName;
    }

    public static void main(String[] args) {
        if(args.length < 2){
            System.out.println("Eg.: java ChatClient <host> <port>");
            return;
        }

        String hostname = args[0];
        int port = Integer.parseInt(args[1]);

        ChatClient client = new ChatClient(hostname, port);
        client.execute();
    }
}
