public class View {

    public void showTitactoe(TicTacToe game){

        for (Cell[] rowCell : game.getTabCell()) {
            System.out.println();

            System.out.println(this.ligneSize(game));
            for (Cell cell : rowCell) {

                System.out.print(cell.getRepresentation());
            }
            System.out.print("|");
        }
        System.out.println();
        System.out.println(this.ligneSize(game));
    }

    private String ligneSize(TicTacToe game){

        return "----".repeat(Math.max(0, game.getSize()));
    }


    public void showMessage(String message){
        System.out.println(message);
    }


}
