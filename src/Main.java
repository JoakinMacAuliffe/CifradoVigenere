//MAIN CLASS JUST FOR TESTING PURPOSES

package classes;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String num, word, encryptedWord;

        //System.out.println("Ingrese llave numerica: ");
        //num = sc.next();

        num = "1234";

        BigVigenere bv = new BigVigenere(num);

        bv.reEncrypt();


//        System.out.println(bv.decrypt("Pguhrf pf hpdrBruiqi blsjbbhvjc wgyt eA vslph a vgsihu pf lpueuypvhp Dahubr fkqhhtt"));
        //System.out.println(" La frase encriptada es: ");
        //System.out.println(bv.encrypt(word));

    }

}
