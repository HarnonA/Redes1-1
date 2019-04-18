package ServerStation;

import javax.swing.*;

/**
 * Created by Antonio on 04/06/2015.
 */
public class Reasoner {
    protected static String[] tabuleiro;

    public Reasoner(){
        tabuleiro = new String[9];

    }

    public boolean check()
    {
        if(checkLines()) {
            return true;
        }
        if(checkColumns()) {
            return true;
        }
        if(checkDiag()){
            return true;
        }
        return false;

    }

    public boolean checkLines(){

        for(int i = 0; i <= 6; i+=3)
        {
            if(tabuleiro[i].equals(tabuleiro[i+1]) && tabuleiro[i].equals(tabuleiro[i + 2])) {
                if (!tabuleiro[i].equals("")) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkColumns(){

        for(int i = 0; i < 3; i++)
        {
            if(tabuleiro[i].equals(tabuleiro[i + 3]) && tabuleiro[i].equals(tabuleiro[i + 6])) {
                if (!tabuleiro[i].equals("")) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean checkDiag() {
        if (tabuleiro[0].equals(tabuleiro[4]) && tabuleiro[0].equals(tabuleiro[8])){
            if (!tabuleiro[0].equals("")) {
                return true;
            }
            return false;
        }else if(tabuleiro[2].equals(tabuleiro[4]) && tabuleiro[2].equals(tabuleiro[6])) {
            if (!tabuleiro[2].equals("")) {
                return true;
            }
            return false;
        }else {
            return false;
        }
    }
}
