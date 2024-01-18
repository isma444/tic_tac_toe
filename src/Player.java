import com.sun.net.httpserver.Authenticator;

import java.util.Scanner;

public class Player extends InteractionUtilisateur {

    protected TicTacToe game ;
    private String representation ;

    public String getRepresentation(){
        return this.representation;
    }



    public int[] chosenCoord(TicTacToe game){

        int[] coordonnees = new int[2];

        coordonnees[0] = this.recoverInput("lignes", game);
        coordonnees[1] = this.recoverInput("colonnes", game);

        return coordonnees;
    }



}
