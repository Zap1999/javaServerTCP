import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class socketServer {
    public void run(ServerUI ui) throws IOException {
        ui.getStatusLabel().setText("Online");
        Thread t1 = new Thread(new RunServer(ui));
        t1.start();
    }
}
