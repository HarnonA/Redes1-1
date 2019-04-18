package ServerStation;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Antonio on 22/06/2015.
 */
public class gameListener implements Runnable {

    private ServerSocket serverGame = null;
    private Socket game = null;
    private Player one = null, two = null;
    private boolean status = false;

    @Override
    public void run() {
        try {
            serverGame = new ServerSocket(7001);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                game = serverGame.accept();
                checkStartGame();

                Server.showMessage("Alguem conectou no jogo");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void checkStartGame() throws IOException {
        if(status){
            two = new Player(game.getInetAddress().getHostName(), game, "O");
            Thread t = new Thread(new serverGameHandler(one, two));
            t.start();
            status = false;
            one = two = null;
        }else{
            one = new Player(game.getInetAddress().getHostName(), game, "X");
            status = true;
        }

    }
}
