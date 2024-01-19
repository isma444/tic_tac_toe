import java.util.Random;
public class ArtificialPlayer extends Player{

    ArtificialPlayer() {
        super();
    }
//TODO regle le probleme probleme !!



    public int randomCell(TicTacToe game) {

        Random number = new Random();
        return number.nextInt(game.getSize());

    }
    @Override
    public int[] chosenCoord(TicTacToe game){

        int[] coordonnees = new int[2];

        coordonnees[0] = this.randomCell(game);
        coordonnees[1] = this.randomCell(game);

        return coordonnees;
    }

}
