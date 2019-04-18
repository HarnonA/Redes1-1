package ServerStation;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Antonio on 13/06/2015.
 */
public class ServerChatHandler implements Runnable {

    private InputStream cliente;
    private PrintStream myself;

    public ServerChatHandler(PrintStream ps, InputStream client){
        cliente = client;
        myself = ps;
    }

    @Override
    public void run() {
        String message;
        Scanner s = new Scanner(cliente);
        while(s.hasNextLine())
        {
            message = s.nextLine();
            Server.distribuiMensagem(message, myself);
        }

        s.close();
    }
}
