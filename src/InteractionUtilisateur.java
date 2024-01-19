import java.awt.event.KeyEvent;
import java.util.Objects;
import java.util.Scanner;

public class InteractionUtilisateur {


    public String recoverSymbol(){
        new View().showMessage("Choisie ton symbole (un seul caractère, pas d'espace)");
        Scanner scanner = new Scanner(System.in);
        String symbol;
        do {
            new View().showMessage("symbole :");
            symbol = scanner.nextLine();
        } while (Objects.equals(symbol," ") && symbol.length() != 1);
        return symbol;
    }

    public  int recoverInput(String axis , TicTacToe game){
        Scanner scanner = new Scanner(System.in);
        new View().showMessage("entrez le chiffre des "+axis);
        while(true){
            try {
                return scanner.nextInt();

            }catch (Exception e){
                new View().showMessage("il faut entrer un chiffre");
                scanner.next();
            }
        }

    };
    //refaire le trajet de capture de case
    protected Player chosePlayers( int playerNumber, TicTacToe game ){
        new View().showMessage("taper 'ia' pour que l'ordi joue player"+playerNumber+" sinon taper entrer");
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            new View().showMessage("choix :");
            choice = scanner.nextLine();
        } while (!(Objects.equals(choice, "") | Objects.equals(choice, "ia")));

        if(choice.equals("ia")) {
            return new ArtificialPlayer(recoverSymbol());
        }
        return new HumanPlayer(recoverSymbol());
    }


}
