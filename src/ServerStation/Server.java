package ServerStation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;
/**
 * Created by Antonio on 10/06/2015.
 */
public class Server extends JFrame{
    private static JTextArea chatWindow;
    protected static ArrayList<PrintStream> clientes;

    public Server(){
        super("SERVIDOR");
        clientes = new ArrayList<>();
        chatWindow = new JTextArea();
        chatWindow.setEditable(false);
        add(new JScrollPane(chatWindow));
        JButton showMatchs = new JButton("Partidas Rolando");
        showMatchs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Codigo para montar a lista
                //JOptionPane.showMessageDialog(null, list);
            }
        });
        add(showMatchs, BorderLayout.SOUTH);
        setSize(400, 400);
        setLocation(480,100);
        setVisible(true);
    }

    public void StartRunning() {

        showMessage("Servidor iniciado");
        Thread t = new Thread(new chatListener());
        t.start();
        Thread g = new Thread(new gameListener());
        g.start();

    }


    public static void distribuiMensagem(String msg, PrintStream myself) {
        // envia msg para TODO MUNDO
        showMessage(msg);
        for (PrintStream cliente : clientes) {
            if(cliente != myself){
                cliente.println(msg);
            }
        }
    }

    public static void showMessage(final String text) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        chatWindow.append("\n" + text);
                    }
                }
        );
    }

    public static void main(String[] args){
        Server servidor = new Server();
        servidor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        servidor.StartRunning();
    }
}

