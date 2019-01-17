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
                    ui.getTextArea().append("Client connected \nOn port: " + socket.getPort()
                            + "\nWith address: "
                            + socket.getInetAddress()
                            + "\n");
                    BufferedReader input =
                            new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    ui.getTextArea().append("\n\nMessage received!\n Message: "
                            + input.readLine());
                    if (input.readLine() == "@exit")
                        break;

            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }

}
