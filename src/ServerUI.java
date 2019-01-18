import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ServerUI {
    private JButton runServerButton;
    private JLabel statusLabel;
    private JTextArea textArea;
    private JPanel mainPanel;
    static public ServerUI ui = new ServerUI();


    JLabel getStatusLabel(){
        return statusLabel;
    }

    JTextArea getTextArea(){
        return textArea;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ServerUI");
        frame.setContentPane(ui.mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public ServerUI() {
        runServerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                socketServer server1 = new socketServer();
                    server1.run(ui);
            }
        });
    }
}
