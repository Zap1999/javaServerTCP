import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class RunServer implements Runnable {
    ServerUI ui;
    RunServer(ServerUI u) {
        ui = u;
    }

    @Override
    public void run() {
        try {
            ServerSocket listener = new ServerSocket(9090);
            while (true) {
                Socket socket = listener.accept();
                    ui.getTextArea().append("\n\nClient connected \nOn port: " + socket.getPort()
                            + "\nWith address: "
                            + socket.getInetAddress()
                            + "\n");

                // Waiting messages
                new Thread(() -> {
                    while (true) {
                        try {
                            BufferedReader input =
                                    new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            String msg = input.readLine();
                            if (msg == null) {
                                ui.getTextArea().append("\n\nClient disconnected;(((((((\n");
                                Thread.currentThread().interrupt();
                                return;
                            }
                            ui.getTextArea().append("\n\nMessage received!\n Message: "
                                    + msg);
                        }catch(IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
