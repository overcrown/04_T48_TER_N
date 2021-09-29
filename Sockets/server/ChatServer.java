import java.io.*;
import java.net.*;
import java.util.*;


public class ChatServer {
    // porta que o serviço ficará disponível
    private final int port;

    // lista dos usuários conectados
    private final Set<String> userNames = new HashSet<>();

    // lista de threads dos usuários (objetos thread)
    private final Set<UserThread> userThreads = new HashSet<>();

    public ChatServer(int port) {
        this.port = port;
    }

    // método para executar o servidor
    // modo listening (escutando a porta)
    public void execute() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Server executing in port: " + port);
            System.out.println("CTRL+C to finish");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New user connected: ");

                UserThread newUser = new UserThread(socket, this);
                userThreads.add(newUser);
                newUser.start();
                System.out.println(newUser);
            }
        } catch (IOException ex) {
            System.out.println("Server error " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("");
            System.out.print("To execute, type:");
            System.out.println("java ChatServer <port>");
            System.out.println("Eg. java ChatServer 9000");
            System.out.println("");
            System.exit(0);
        }

        int port = Integer.parseInt(args[0]);
        ChatServer server = new ChatServer(port);
        server.execute();
    }

    boolean hasUsers() {
        return !this.userNames.isEmpty();
    }

    Set<String> getUserNames() {
        return this.userNames;
    }

    public void addUserName(String userName) {
        userNames.add(userName);
    }

    public void broadcast(String serverMessage, UserThread excludeUser) {
        userThreads.stream().filter((aUser) -> (aUser != excludeUser)).forEachOrdered((aUser) -> {
            aUser.sendMessage(serverMessage);
        });

    }

    public void removeUser(String userName, UserThread aUser) {
        boolean removed = userNames.remove(userName);
        if (removed) {
            userThreads.remove(aUser);
            System.out.println("User " + userName + " exit");
        }
    }
}