import java.util.Arrays;

public class TicTacToe {

    int size;
    Cell[][] tabCell = new Cell[3][3];

    Player player ;

    TicTacToe(){
        for(Cell[] rowCell : this.tabCell){
            for(int i =0 ; i < rowCell.length ; i++) {
                rowCell[i] = new Cell();
            }
        }
    }

     public void display(){
        for(Cell[] rowCell : this.tabCell){
            System.out.println();
            System.out.println("-------------");
            for(Cell cell : rowCell){

                System.out.print(cell.getRepresentation());
            }
            System.out.print("|");
        }
        System.out.println();
         System.out.println("-------------");
    }

    public String[] getMoveFromPlayer(String[] numbers){

        if (numbers.length  == 2){
            for(String number : numbers){
                if(Math.abs(Integer.parseInt(number)) < 4){
                        
                }
            }
        }
    }

    public static boolean isNumeric(String string){
        try{
            int number = Integer.parseInt(string);
        }catch(NumberFormatException nfe){
            return false;
        }
        return true;
    }

}
