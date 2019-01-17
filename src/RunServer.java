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

    ServerSocket createListener(){
        try {
            ServerSocket listen = new ServerSocket(9090);
            return listen;
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    Socket accept (ServerSocket listen) {
        try {
            Socket socket = listen.accept();
            return socket;
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    InputStreamReader getInput(Socket socket) {
        try {
            return new InputStreamReader(socket.getInputStream());
        }catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    String read (BufferedReader buf){
        try {
            return buf.readLine();
        }catch(IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void run() {
        ServerSocket listener = createListener();
        //System.out.println("Server running!");
        while (true) {
            Socket socket = accept(listener);
                    /*System.out.println("Client connected \nOn port: " + socket.getPort()
                            + "\nWith address: "
                            + socket.getInetAddress()
                            + "\n");*/
                ui.getTextArea().append("Client connected \nOn port: " + socket.getPort()
                        + "\nWith address: "
                        + socket.getInetAddress()
                        + "\n");
                BufferedReader input =
                        new BufferedReader(getInput(socket));
                        /*System.out.println("\n\nMessage received!\n Message: "
                                + input.readLine()
                        );*/
                ui.getTextArea().append("\n\nMessage received!\n Message: "
                        + read(input));
                if (read(input) == "@exit")
                    break;
                try {
                    input.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
        }

    }

}
