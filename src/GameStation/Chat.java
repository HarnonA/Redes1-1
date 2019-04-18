package GameStation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by Antonio on 14/06/2015.
 */
public class Chat extends JPanel{
    protected static JTextArea chatbox;
    protected JTextField userText;
    private JButton exit;
    public static String msg, me;
    //protected PrintStream saida = null;

    public Chat(String usuario) {
        setLayout(new BorderLayout());
        me = usuario;
        userText = new JTextField();
        Font f = new Font("Calibri", Font.BOLD, 16);
        userText.setFont(f);
        /*try {
            out = new PrintStream(connection.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        chatbox = new JTextArea();
        chatbox.setFont(f);
        chatbox.setBackground(new Color(192, 192, 192));
        chatbox.setEditable(false);
        exit = new JButton();
        exit.setText("Encerrar(por enqto, inutil)");
        exit.setFont(new Font("Arial", Font.PLAIN, 14));

        //Define listeners para os campos abaixo
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.unblockGame(true);
                //Codigo para desistir da partida
            }
        });
        userText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                msg = e.getActionCommand();
                userText.setText("");
                sendMessage(msg);
            }
        });
        //-------------------------------------------------------------------
        add(new JScrollPane(chatbox), BorderLayout.CENTER);
        add(userText, BorderLayout.NORTH);
        add(exit, BorderLayout.SOUTH);
        setVisible(true);

    }

    protected static void sendMessage(String msg) {
        showMessage(me + ": " + msg);
        connection.saida.println(me + ": " + msg);
    }

    public static void showMessage(final String text) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        chatbox.append("\n"+text);
                    }
                }
        );
    }

}
