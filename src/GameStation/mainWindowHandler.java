package GameStation;

/**
 * Created by Antonio on 16/06/2015.
 */
public class mainWindowHandler{

    public mainWindowHandler(){

        //thread para ler as msg recebidas
        Thread threadChat = new Thread(new chatHandler());
        threadChat.start();
        //thread para manipular as jogadas
        Thread threadGame = new Thread(new gameHandler());
        threadGame.start();


    }


}
