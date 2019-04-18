package ServerStation;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Antonio on 22/06/2015.
 */
public class chatListener implements Runnable {

    private ServerSocket serverChat = null;
    private Socket chat = null;

    @Override
    public void run() {
        try {
            serverChat = new ServerSocket(7000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                chat = serverChat.accept();
                PrintStream ps = new PrintStream(chat.getOutputStream());
                Server.clientes.add(ps);
                Thread t = new Thread(new ServerChatHandler(ps, chat.getInputStream()));
                t.start();
                Server.showMessage("Alguem conectou no chat");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
