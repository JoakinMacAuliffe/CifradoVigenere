package classes;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String num, word;

        //System.out.println("Ingrese llave numerica: ");
        //num = sc.next();

        num = "1234";
        word = "hola como estas";

        BigVigenere bv = new BigVigenere(num);
        System.out.println(bv.encrypt(word));

        //System.out.println("Ingrese el mensaje: ");
        //word = sc.next();

        //System.out.println(" La frase encriptada es: ");
        //System.out.println(bv.encrypt(word));

    }

}