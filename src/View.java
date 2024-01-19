public class View {

    public void showTitactoe(TicTacToe game){

        for (Cell[] rowCell : game.getTabCell()) {
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

    public void showMessage(String message){
        System.out.println(message);
    }


}
