public class socketServer {
    public void run(ServerUI ui) {
        ui.getStatusLabel().setText("Online");
        Thread t1 = new Thread(new RunServer(ui));
        t1.start();
    }
}
