package GameStation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;
import java.util.Objects;
import java.util.Scanner;

import static javax.swing.JOptionPane.*;

/**
 * Created by Antonio on 24/05/2015.
 */
public class login extends JFrame implements ActionListener{

    private JButton enter;
    private JButton cancelar;
    private JTextField userText, serverIP;
    protected static String usuario, servidor;

    public login(){

        super("Login Page");
        serverIP = new JTextField("");
        userText = new JTextField("");
        userText.setFont(new Font("Calibri", Font.PLAIN, 20));
        serverIP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(userText.getText().equals("") || serverIP.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Digite um nome de usuario e IP do servidor");
                }else{
                    usuario = userText.getText();
                    servidor = serverIP.getText();
                    callHandler();
                }
            }
        });

        enter = new JButton("enter");
        enter.addActionListener(this);
        cancelar = new JButton("cancelar");
        cancelar.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,1));
        add(new JLabel("User: "));
        add(userText);
        add(new JLabel("IP: "));
        add(serverIP);
        add(enter);
        add(cancelar);
        setResizable(false);
        setSize(300,130);
        setLocation(740,400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == enter)
        {
            if(userText.getText().equals("") || serverIP.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Digite um nome de usuario e o IP do servidor");
            }else{
                usuario = userText.getText();
                servidor = serverIP.getText();
                callHandler();
            }

        }else if(e.getSource() == cancelar){
            if(userText.getText().equals(""))
            {
                dispose();
            }
            userText.setText("");
            serverIP.setText("");
        }
    }

    protected void callHandler(){
        connection client = new connection(usuario);
        client.connect();
        dispose();
    }

    public static void main(String[] args){
        login janela = new login();
    }
}
