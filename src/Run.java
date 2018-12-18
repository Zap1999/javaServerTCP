import java.io.IOException;

public class Run {
    public static void main(String args[]){
        socketServer server1 = new socketServer();
        try {
            server1.run();
        }
        catch(IOException er){
            System.err.println("Error: " + er.getMessage());
        }
    }

}
