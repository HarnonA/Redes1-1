package GameStation;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by Antonio on 13/06/2015.
 */
public class chatHandler implements Runnable{
    private String message;

    @Override
    public void run() {

        InputStream inC = null;
        try {
            inC = connection.chatSocket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner s = new Scanner(inC);

        while (s.hasNextLine()) {
            message = s.nextLine();
            mainWindow.chat.showMessage(message);

        }

    }
}
