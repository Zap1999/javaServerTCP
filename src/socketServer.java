import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class socketServer {
    public void run() throws IOException {
        try (ServerSocket listener = new ServerSocket(9090)) {
            System.out.println("Server running!");
            while (true) {
                try (Socket socket = listener.accept()) {
                    BufferedReader input =
                            new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    //if (input.readLine() != null) {
                        System.out.println("\n\nMessage received!\n On port: " + socket.getPort()
                                + "\nFrom address: "
                                + socket.getInetAddress()
                                + "\nMessage: "
                                + input.readLine()
                        );
                        //if (input.readLine() == "@exit")
                            //break;
                   // }
                    input.close();
                }
            }

        }
    }
}
