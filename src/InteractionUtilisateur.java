import java.awt.event.KeyEvent;
import java.util.Objects;
import java.util.Scanner;

public class InteractionUtilisateur {


    public String recoverSymbol(){
        System.out.println("Choisie ton symbole (un seul caractère, pas d'espace");
        Scanner scanner = new Scanner(System.in);
        String symbol;
        do {
            System.out.println("symbole :");
            symbol = scanner.nextLine();
            System.out.println(symbol.length());
        } while (Objects.equals(symbol," ") && symbol.length() != 1);
        return symbol;
    }

    public  int recoverInput(String axis , TicTacToe game){
        Scanner scanner = new Scanner(System.in);
        System.out.println("entrez le chiffre des "+axis);
        while(true){
            try {
                return scanner.nextInt();

            }catch (Exception e){
                System.out.println("il faut entrer un chiffre");
                scanner.next();
            }
        }

    };
    //refaire le trajet de capture de case
    protected Player chosePlayers( int playerNumber, TicTacToe game ){
        System.out.println("taper 'ia' pour que l'ordi joue player"+playerNumber+" sinon taper entrer");
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.println("choix :");
            choice = scanner.nextLine();
        } while (!(Objects.equals(choice, "") | Objects.equals(choice, "ia")));

        if(choice.equals("ia")) {
            return new ArtificialPlayer(recoverSymbol());
        }
        return new HumanPlayer(recoverSymbol());
    }


}
