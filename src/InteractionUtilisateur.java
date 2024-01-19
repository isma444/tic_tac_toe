import java.util.Objects;
import java.util.Scanner;

public class InteractionUtilisateur {

    private View view;

    private Scanner scanner = new Scanner(System.in);
    
    InteractionUtilisateur(){
        this.view = new View();
    }
    public String recoverSymbol(){
        this.view.showMessage("Choisie ton symbole (un seul caractère, pas d'espace)");
        String symbol;
        do {
            this.view.showMessage("symbole :");
            symbol = this.scanner.next();

        } while (Objects.equals(symbol," ") && symbol.length() != 1);
        return symbol;
    }

    public  int recoverInput(String axis ){
        this.view.showMessage("entrez le chiffre des "+axis);
        while(true){
            try {
                return this.scanner.nextInt();

            }catch (Exception e){
                this.view.showMessage("il faut entrer un chiffre");
                this.scanner.next();
            }
        }

    }

    protected Player chosePlayers( int playerNumber ){
        this.view.showMessage("taper 'ia' pour que l'ordi joue player"+playerNumber+" sinon taper entrer");
        String choice;
        do {
            this.view.showMessage("choix :");
            choice = this.scanner.nextLine();
        } while (!(Objects.equals(choice, "") | Objects.equals(choice, "ia")));

        if(choice.equals("ia")) {
            return new ArtificialPlayer();
        }
        return new HumanPlayer();
    }

    public String chosePlayerName(){

        String name;

        do {
            this.view.showMessage("choisie un nom au (au moins deux carctères)");
            name = this.scanner.next();

        } while(name.trim().length()<2);

        return name;
    }


}
