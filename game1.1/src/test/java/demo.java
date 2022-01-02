import java.util.ArrayList;
import java.util.List;

public class demo {
    public static void main(String[] args) {
        DealCards dealCards = new DealCards();
        dealCards.giveCards();
        GameControl gameControl=new GameControl();
        gameControl.firstBout();
        gameControl.gameBout();

    }
}