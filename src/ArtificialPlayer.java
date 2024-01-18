import java.util.Random;
import java.util.Scanner;

public class ArtificialPlayer extends Player{

    String representation;
    ArtificialPlayer(String symbole ) {
        this.representation = "| "+ symbole +" ";
    }
//TODO probleme !!
@Override
    public int recoverInput(String axis, TicTacToe game) {

        Random number = new Random();
        return number.nextInt(game.getSize());

    }

}
