package GameStation;

import javax.swing.*;
import java.awt.*;
import java.net.Socket;

/**
 * Created by Antonio on 15/06/2015.
 */
public class mainWindow extends JFrame{
    private JSplitPane splitH;
    protected static Chat chat;
    protected static Game partida;

    public mainWindow(){
        super("Jogo da Velha");
        partida = new Game();
        chat = new Chat(connection.usuario);

        //Um JPanel para serem colocados subpaineis
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        getContentPane().add(painel);
        //-----------------------------------------

        //Objeto manipulador da divisoria da JPanel
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int width = d.width;
        //-----------------------------------------
        //Cria o separador
        splitH = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitH.setDividerLocation(width/5);
        splitH.setOneTouchExpandable(true);
        splitH.setLeftComponent(partida);
        splitH.setRightComponent(chat);

        //Define ele como configuracao do JPanel e centralizado
        painel.add(splitH, BorderLayout.CENTER);
        painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));

        //Termina a configuracao da JFrame
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,480);
        setLocation(200,200);
        setVisible(true);
    }
}
