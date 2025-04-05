//MAIN CLASS JUST FOR TESTING PURPOSES

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String key = "874365"; //En el abedecedario, 1234 sería abcd
        System.out.println("Key: " + key);

        Scanner sc = new Scanner(System.in);
        BigVigenere bigVigenere = new BigVigenere(key);

        //Pruebas para metodo encrypt()

        System.out.print("Inputted message: ");
        String message = sc.nextLine();

        String encryptedMessage = bigVigenere.encrypt(message);
        System.out.println("Encrypted message: " + encryptedMessage);

        //Pruebas para metodo decrypt()

        message = bigVigenere.decrypt(encryptedMessage);
        System.out.println("Encrypted and decrypted message: " + message);

    }

}