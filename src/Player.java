import com.sun.net.httpserver.Authenticator;

import java.util.Scanner;

public class Player {

    protected TicTacToe game ;
    protected String representation ;

    Player(String symbole){
        this.representation = "| "+ symbole +" ";
    }
    public String getRepresentation(){
        return this.representation;
    }



    public int[] chosenCoord(TicTacToe game){

        int[] coordonnees = new int[2];

        coordonnees[0] = new InteractionUtilisateur().recoverInput("lignes", game);
        coordonnees[1] = new InteractionUtilisateur().recoverInput("colonnes", game);

        return coordonnees;
    }



}
