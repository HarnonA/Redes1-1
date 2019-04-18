package ServerStation;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by Antonio on 19/06/2015.
 */
public class Player {
    protected String playerName, simbol;
    protected Socket connection;

    public Player(String name, Socket gcnt, String simbol){
        playerName = name;
        connection = gcnt;
        this.simbol = simbol;
    }

    public String getName(){return playerName;}
    
    public String getSimbol(){return simbol;}

    public InputStream getInputStream(){
        try {
            return connection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public PrintStream getPrintStream(){
        PrintStream ps = null;
        try {
            ps = new PrintStream(connection.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ps;
    }

}
