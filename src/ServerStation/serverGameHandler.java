package ServerStation;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Antonio on 19/06/2015.
 */
public class serverGameHandler implements Runnable {

    private Player one, two;
    private Reasoner reasoner;
    private boolean turn = true;
    public serverGameHandler(Player one, Player two){
        this.one = one;
        this.two = two;
        //this.one.getPrintStream().print("X");
        //this.two.getPrintStream().print("O");
    }

    @Override
    public void run() {

        reasoner = new Reasoner();
        int position;
        Scanner s = new Scanner(one.getInputStream());
        while(s.hasNextInt())
        {
            position = s.nextInt();
            if(turn){
                reasoner.tabuleiro[position] = one.getSimbol();
                System.out.println("Player 1 has chosen position "+position);
                two.getPrintStream().print(position);
                //if(reasoner.check()){
                 //   two.getPrintStream().print(10);
                 //   one.getPrintStream().print(11);
                //}
                s.close();
                s = new Scanner(two.getInputStream());
                turn = false;
            }else{
                reasoner.tabuleiro[position] = two.getSimbol();
                System.out.println("Player 2 has chosen position " + position);
                one.getPrintStream().print(position);
                //if(reasoner.check()){
                //    one.getPrintStream().print(10);
                //    two.getPrintStream().print(11);
                //}
                s.close();
                s = new Scanner(one.getInputStream());
                turn = true;
            }

        }

        s.close();
    }
}
