import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class TicTacToe {

    int size;
    Cell[][] tabCell = new Cell[3][3];

    Player firstPlayer;
    Player secondPlayer;

    TicTacToe(int size) {
        this.size = size;
        this.tabCell = new Cell[size][size];
        this.firstPlayer = new Player("X");
        this.secondPlayer = new Player("O");
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


            if (i % 2 == 0) {
                player = this.firstPlayer;
                System.out.println("au tour du premier joueur");
                this.setOwner(player);


            } else {
                player = this.secondPlayer;
                System.out.println("au tour du second joueur");
                this.setOwner(player);

            }
            this.display();
            if(isOver(player)){
                System.out.println("fini");
                break;
            }
        }
    }

    public void display() {

        for (Cell[] rowCell : this.tabCell) {
            System.out.println();
            System.out.println("-------------");
            for (Cell cell : rowCell) {

                System.out.print(cell.getRepresentation());
            }
            System.out.print("|");
        }
        System.out.println();
        System.out.println("-------------");
    }

    public int[] getMoveFromPlayer(Player player) {

        int[] numbers = player.captureCell(); // appeller la method qui retourne les chiffre saisie
        Cell chosenCell = this.tabCell[numbers[0]][numbers[1]];// recupere la cellule indiqué par les coordonnees

        while (!(numbers[0] < this.size) | !(numbers[1] < this.size)) { // verifie que les deux nombre ne soit pas plus grand que 3
            System.out.println("position incorrect ! position correct entre 0 et 2");
            numbers = player.captureCell();
        }

        while (!(chosenCell.getRepresentation().equals("|   "))) {
            System.out.println("case deja prise ! recommence");
            numbers = player.captureCell();
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

        if(this.checkRow(player)){
            return true;
        } else if (this.checkColumns(player)) {
            return true;
        } else if (this.checkDiagonal(player)) {
            return true;
        } else return checkTabCell();
    }

    /**
     * check if each cell of a row have representation like player's representation
     * @param player - the player whose turn it is
     * @return boolean
     */
    public boolean checkRow(Player player) {
        int cellCount = 0;
        for (int i = 0; i < this.size; i++) {

            for (int j = 0; j < this.size; j++) {
                if(Objects.equals(this.tabCell[i][j].getRepresentation(), player.getRepresentation())){
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
     * check if each cell of a column have representation like player's representation
     * @param player - the player whose turn it is @see TicTacToe#checkRow()
     * @return boolean
     */
    public boolean checkColumns(Player player) {

        int cellCount = 0;

        for (int i = 0; i < this.size; i++) {

            for (int j = 0; j < this.size; j++) {
                if(Objects.equals(this.tabCell[j][i].getRepresentation(), player.getRepresentation())){
                    cellCount += 1;
                }
            }

        }
        return cellCount == this.size;
    }

    /**
     * check if the tabCell
     * @return boolean
     */
    public boolean checkTabCell(){

        for(Cell[] rowCell : this.tabCell){
            for(Cell cell : rowCell){
                if(!Objects.equals(cell.getRepresentation(), "|   ")){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkDiagonal(Player player) {

        int cellCount = 0;

        for (int i = 0; i < this.size; i++) {

            if(Objects.equals(this.tabCell[i][i].getRepresentation(), player.getRepresentation())){
                cellCount += 1;
            }
        }
        return cellCount == this.size;
    }
}