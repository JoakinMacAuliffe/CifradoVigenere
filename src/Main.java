package classes;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Scanner mensaje = new Scanner(System.in);
        String num, word;

        num = sc.next();

        BigVigenere bv = new BigVigenere(num);

        System.out.println("Ingrese el mensaje: ");
        word = mensaje.nextLine();

        System.out.println(" La frase encriptada es: ");
        System.out.println(bv.encrypt(word));



    }
}