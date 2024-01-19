import java.util.Objects;
import java.util.Scanner;

public class InteractionUtilisateur {

    private View view;
    
    InteractionUtilisateur(){
        this.view = new View();
    }
    public String recoverSymbol(){
        this.view.showMessage("Choisie ton symbole (un seul caractère, pas d'espace)");
        Scanner scanner = new Scanner(System.in);
        String symbol;
        do {
            this.view.showMessage("symbole :");
            symbol = scanner.nextLine();
        } while (Objects.equals(symbol," ") && symbol.length() != 1);
        return symbol;
    }

    public  int recoverInput(String axis , TicTacToe game){
        Scanner scanner = new Scanner(System.in);
        this.view.showMessage("entrez le chiffre des "+axis);
        while(true){
            try {
                return scanner.nextInt();

            }catch (Exception e){
                this.view.showMessage("il faut entrer un chiffre");
                scanner.next();
            }
        }

    }

    protected Player chosePlayers( int playerNumber, TicTacToe game ){
        this.view.showMessage("taper 'ia' pour que l'ordi joue player"+playerNumber+" sinon taper entrer");
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            this.view.showMessage("choix :");
            choice = scanner.nextLine();
        } while (!(Objects.equals(choice, "") | Objects.equals(choice, "ia")));

        if(choice.equals("ia")) {
            return new ArtificialPlayer();
        }
        return new HumanPlayer();
    }

    public String chosePlayerName(){
        Scanner scanner = new Scanner(System.in);
        String name;

        do {
            this.view.showMessage("choisie un nom au (au moins deux carctères)");
            name = scanner.next();

        } while(name.trim().length()<2);

        return name;
    }


}
