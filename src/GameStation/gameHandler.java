package GameStation;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

/**
 * Created by Antonio on 16/06/2015.
 */
public class gameHandler implements Runnable {
    private int position;

    @Override
    public void run() {
        try {
            Game.out = new PrintStream(connection.gameSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStream streamGame = null;
        try {
            streamGame = connection.gameSocket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //First thing to be received is the player's simbol (X or O)
        Scanner s = new Scanner(streamGame);
        /*String tmp;
        while (s.hasNextLine()) {
            tmp = s.nextLine();
            System.out.println("Chegou meu simbolo");
            Game.setSimbol(tmp);
            break;
        }*/
        System.out.println("Gamehandler running");
        //Now it will be read the positions to be filled in the board
        while (s.hasNextInt()) {
            System.out.println("Waiting for opponent's movement");
            position = s.nextInt();
            if(position == 10 || position == 11){
                Game.resetGame(position);
            }else{
                Game.OpponentMovement(position);
                System.out.println("The other player made his movement to " + position);
            }
        }

    }
}
