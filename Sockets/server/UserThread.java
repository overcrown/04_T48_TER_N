import java.io.*; // i/o
import java.net.*; // rede

public class UserThread extends Thread {
    private final Socket socket; // meio de comunicação (TCP)
    private final ChatServer server; // o servidor
    private PrintWriter writer; // para escrever o buffer de saída

    // construtor
    public UserThread(Socket socket, ChatServer server) {
        this.socket = socket;
        this.server = server;
    }

    // sobrescrevendo o método run() da classe Thread
    @Override
    public void run() {
        try {

            // leitura dos dados
            InputStream input = socket.getInputStream();

            // joga para o bufer
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // canal de saída (response)
            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);

            // mostrar os usuários conectados
            printUsers();

            // captar os dados via teclado
            String userName = reader.readLine();
            server.addUserName(userName);

            // broadcast - falar para geral!!!!!
            String serverMessage = "Novo usuário conectado: " + userName;
            server.broadcast(serverMessage, this);

            // captura a mensagem do cliente
            String clientMessage;

            do {
                clientMessage = reader.readLine();
                // Implementar um método que filtre palavras não permitidas
                // azul -> ****
                // O céu está azul demais da conta
                // O céu está **** demais da conta
                // Isso está uma m***a

                // Apena uma ideia: mandar um broadcast informando que 
                // não são permitidas palavras de baixo calão

                serverMessage = "[" + userName + "]: " + clientMessage;
                server.broadcast(serverMessage, this);

                // mostra a mensagem enviada no servidor
                // seria aqui que guardaríamos em um BD
                System.out.println(serverMessage);

            } while(!clientMessage.equals("bye"));

            // remove o usuário do sistema
            server.removeUser(userName, this);
            socket.close();

            // avisa a galera que alguém saiu
            serverMessage = userName + " saiu!";
            server.broadcast(serverMessage, this);

        } catch (Exception e) {
            System.out.println("Erro no processo: " + e.getMessage());
        }
    }

    void printUsers() {
        if (server.hasUsers()) { // hasUsers() é da classe ChatServer
            writer.println("Usuários Conectados: " + server.getUserNames());
        } else {
            writer.println("Não existem outros usuários conectados.");
        }
    }

    void sendMessage(String message) {
        writer.println(message);
    }
}
