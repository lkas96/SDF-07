package workshopd6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static workshopd6.Cookie.init;

public class ServerApp {
    public static final String ARG_MESSAGE = "usage: java workshop6.ServerApp <port> <cookie file>";

    public static void main(String[] args) throws NumberFormatException, IOException {
        System.out.println("ServerApp");
        if (args.length < 2) {
            System.out.println(ARG_MESSAGE);
            return;
        }

        String serverPort = args[0];
        String cookieFile = args[1];
        System.out.println("ServerApp: serverPort=" + serverPort + ", cookieFile=" + cookieFile);

        try (ServerSocket server = new ServerSocket(Integer.parseInt(serverPort))) {
            init(cookieFile);
            while (true) {
                Socket client = server.accept();
                ClientHandler clientHandler = new ClientHandler(client);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        }
    }
}