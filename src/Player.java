import com.sun.net.httpserver.Authenticator;

import java.util.Scanner;

public class Player {


    String representation  ;

    public String getRepresentation(){
        return this.representation;
    }

    Player(String symbole){

        this.representation = "| "+ symbole +" ";
    }

    public int[] captureCell(){

        int[] coordonnees = new int[2];

        coordonnees[0] = this.recoverInput("lignes");
        coordonnees[1] = this.recoverInput("colonnes");
//        System.out.println("entrez le chiffre des lignes");
//        while(true){
//            try {
//                int coord1 = scanner.nextInt();
//                coordonnees[1] = Math.abs(coord1);
//                break;
//            }catch (Exception e){
//                System.out.println("il faut entrer un chiffre");
//                scanner.next();
//            }
//        }

//        System.out.println("entrez le chiffre des colonnes");
//        while(true){
//            try {
//                int coord2 = scanner.nextInt();
//                coordonnees[0] = Math.abs(coord2);
//                break;
//            }catch (Exception e){
//                System.out.println("il faut entrer un chiffre");
//                scanner.next();
//            }
//        }

        return coordonnees;
    }

    public int recoverInput(String axis){

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
    }
}
