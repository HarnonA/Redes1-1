package GameStation;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * Created by Antonio on 16/06/2015.
 */
public class connection{
    private static mainWindow window;
    private int reconnections = 0;
    private static int MAX_CONNECTION = 3;
    protected static Socket chatSocket = null, gameSocket = null;
    private static mainWindowHandler mw;
    private InetSocketAddress endpoint;
    protected static String usuario;
    public static PrintStream saida = null;

    public connection(String usuario){
        this.usuario = usuario;
    }
    public void connect(){
        chatSocket = new Socket();
        endpoint = new InetSocketAddress(login.servidor, 7000);
        try {
            chatSocket.connect(endpoint);
            try {
                saida = new PrintStream(chatSocket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        gameSocket = new Socket();
        endpoint = new InetSocketAddress(login.servidor, 7001);
        try {
            gameSocket.connect(endpoint);
        } catch (IOException e) {
            e.printStackTrace();
        }

        window = new mainWindow();
        mw = new mainWindowHandler();
    }
    public void reconnect(){
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(reconnections < MAX_CONNECTION){
            reconnections++;
            connect();
        }else{
            System.exit(0);
            return;
        }
    }

}
