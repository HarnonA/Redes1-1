package GameStation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.PrintStream;

/**
 *
 * @author Antonio
 */
public class Game extends JPanel{
    protected static PrintStream out = null;
    protected static JButton botoes[];
    protected static  String simbolo, advSimbol;

    public Game()
    {
        setLayout(new GridLayout(3,3)); //Define a distribuiçao dos botoes, modo Grid, 3x3
        botoes = new JButton[9]; //Os botoes do jogo
        for(int i = 0; i < 9; i++)
        {
            botoes[i] = new JButton(""); //Aloca cada um zerado
            botoes[i].setEnabled(false);
        }

        for(int i = 0; i < 9; i++)
        {
            botoes[i].setFont(new Font("Calibri", Font.BOLD, 100));
            final int j = i;
            botoes[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Game.Movement(j);
                    //unblockGame(false);
                }
            });
            botoes[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            add(botoes[i]);
        }
        setVisible(true);
        setSimbol("X");
    }

    public static void Movement(int position) {
        botoes[position].setText(simbolo);
        botoes[position].setEnabled(false);
        out.print(position);
        unblockGame(false);
    }

    public static void OpponentMovement(int adversaryPosition) {

        botoes[adversaryPosition].setText(advSimbol);
        botoes[adversaryPosition].setEnabled(false);
        unblockGame(true);
    }

    public static void unblockGame(boolean state){
        for(int i = 0; i < 9; i++)
        {
            if(botoes[i].getText().equals(""))
                botoes[i].setEnabled(state);
        }
    }

    public static void resetGame(int Case)
    {
        if(Case == 10){
            JOptionPane.showMessageDialog(null, "YOU LOSE.");
        }else{
            JOptionPane.showMessageDialog(null, "YOU WIN.");
        }
        for(int i = 0; i < 9; i++) {
            //Reseta o jogo
            botoes[i].setText("");
            botoes[i].setEnabled(true);
        }
    }

    public static void setSimbol(String simbol){
        System.out.println("I have received my simbol");
        simbolo = simbol;
        if(simbol.equals("X")){
            advSimbol = "O";
        }else{
            advSimbol = "X";
        }
        unblockGame(true);
    }
}
