public class Player {

    protected String representation ;
    protected String name;

    protected InteractionUtilisateur interaction;

    public String getName(){
        return this.name;
    }
    Player(){
        this.interaction = new InteractionUtilisateur();
        this.name = this.interaction.chosePlayerName();
        this.representation = "| "+ this.interaction.recoverSymbol() +" ";
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
