import java.util.Objects;

public class TicTacToe extends BordGame {

  private View view;
  private int size;
  private Cell[][] tabCell;
  private InteractionUtilisateur interaction;
  private Player firstPlayer ;
  private Player secondPlayer;
    public Cell[][] getTabCell() {
        return tabCell;
    }
    public int getSize(){
       return this.size;
    }

    TicTacToe(int size) {
    
        this.size = size;
        this.tabCell = new Cell[size][size];
        this.view = new View();
        this.interaction = new InteractionUtilisateur();
        this.firstPlayer = this.interaction.chosePlayers( 1);
        this.secondPlayer = this.interaction.chosePlayers( 2);
        for (Cell[] rowCell : this.tabCell) {
            for (int i = 0; i < rowCell.length; i++) {
                rowCell[i] = new Cell();
            }
        }
    }

    public void play() {

        Player player;
        this.display();

        for (int i = 0; i < this.size*this.size; ++i) {

            player = this.switchPlayer(i);
            this.setOwner(player);
            this.display();
            if(this.isOver(player)){
                this.view.showMessage("fini");
                break;
            }
        }
    }
    private Player switchPlayer(int iterator){

        if(iterator%2 == 0){
            this.view.showMessage("au tour du premier joueur");
            return this.firstPlayer;
        }else{
            this.view.showMessage("au tour du second joueur");
            return this.secondPlayer;
        }
    }
    public void display() {

        this.view.showTitactoe(this);
    }

    public int[] getMoveFromPlayer(Player player) {

        int[] numbers = player.chosenCoord(this); // appeller la method qui retourne les chiffre saisie

        while (!(numbers[0] < this.size) | !(numbers[1] < this.size)) { // verifie que les deux nombre ne soit pas plus grand que 3
            this.view.showMessage("position incorrect ! position correct entre 0 et 2");
            numbers = player.chosenCoord(this);
        }
        Cell chosenCell = this.tabCell[numbers[0]][numbers[1]];// recupere la cellule indiqué par les coordonnees
        while (!(chosenCell.getRepresentation().equals("|   "))) {
            this.view.showMessage("case deja prise ! recommence");
            numbers = player.chosenCoord(this);
            chosenCell = this.tabCell[numbers[0]][numbers[1]];
        }

        return numbers;
    }

    /**
     * set the owner of the cell
     * @param player
     */
    public void setOwner(Player player) {
        int[] numbers = this.getMoveFromPlayer(player);
        this.tabCell[numbers[0]][numbers[1]].setRepresentation(player.getRepresentation());

    }

    /**
     * check if the game is over
     * @param player - the player whose turn it is
     * @return boolean
     */
    public boolean isOver(Player player) {
        if(this.checkRow(player) || this.checkColumns(player) || this.checkDiagonal(player) ){
            this.view.showMessage(player.getName()+" win !");
            return true;
        }else {
            if (isCompleted()) {
                this.view.showMessage("Vous êtes tout les deux mauvais ...");
            }
        }
        return isCompleted();

    }

    /**
     * check if each cell of a row have representation like player's representation
     * @param player - the player whose turn it is
     * @return boolean
     */
    public boolean checkRow(Player player) {

        for (int i = 0; i < this.size; i++) {
            int cellCount = 0;
            for (int j = 0; j < this.size; j++) {
                if(Objects.equals(this.tabCell[i][j].getRepresentation(), player.getRepresentation())){
                    cellCount += 1;
                }
            }
            if (cellCount == this.size){
                return true;
            }
        }
        return false;
    }

    /**
     * check if each cell of a column have representation like player's representation
     * @param player - the player whose turn it is @see TicTacToe#checkRow()
     * @return boolean
     */
    public boolean checkColumns(Player player) {

        for (int i = 0; i < this.size; i++) {
            int cellCount = 0;
            for (int j = 0; j < this.size; j++) {
                if(Objects.equals(this.tabCell[j][i].getRepresentation(), player.getRepresentation())){
                    cellCount += 1;
                }
            }
            if(cellCount == this.size){
                return true;
            }
        }
        return false;
    }

    /**
     * check if the tabCell
     * @return boolean
     */
    public boolean isCompleted(){

        for(Cell[] rowCell : this.tabCell){
            for(Cell cell : rowCell){
                if(Objects.equals(cell.getRepresentation(), "|   ")){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkDiagonal(Player player) {

        int cellCount1 = 0;
        int cellCount2 = 0;

        for (int i = 0; i < this.size; i++) {

            if(Objects.equals(this.tabCell[i][i].getRepresentation(), player.getRepresentation())){
                cellCount1 += 1;
            }
            if(Objects.equals(this.tabCell[i][(Math.abs(i-(this.size-1)))].getRepresentation(), player.getRepresentation())){
                cellCount2+=1;
            }
        }
        return (cellCount1 == this.size | cellCount2 == this.size);
    }

}