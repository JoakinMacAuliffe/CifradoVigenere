import java.io.IOException; // Usada para generar el mensaje
import java.nio.file.Files; // Usada para generar el mensaje
import java.nio.file.Paths; // Usada para generar el mensaje
import java.util.Scanner; // Usada para leer input del usuario
import java.util.Random; // Usada para generar clave

public class Main {

    public static void main(String[] args) {

        String filePath = "src/beeMovieScript.txt";
        String beeMovieScript = "";
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        //Variables a modificar:

        int messageLength = 10000; // Largo del mensaje a encriptar
        int keyLength = 5000; // Largo de la llave

        // El siguiente codigo genera las variables a utilizar en el algoritmo

        String key = "";

        for(int i = 0; i < keyLength; i++) { // Genera llave de largo keyLength, almacenada en String key
            int digit = random.nextInt(9) + 1;
            key = key + digit;
        }

        BigVigenere bigVigenere = new BigVigenere(key); // Crea objeto de la clase BigVigenere

        try { // Genera mensaje de largo messageLength, almacenado en String message
            String content = Files.readString(Paths.get(filePath));
            if (content.length() > messageLength) {
                beeMovieScript = content.substring(0, messageLength);
            } else {
                beeMovieScript = content;
            }
            beeMovieScript = beeMovieScript.replaceAll("[^a-zA-Z0-9\\s]", "").replaceAll("\\r?\\n", " ");
            if (beeMovieScript.length() < messageLength) {
                beeMovieScript = String.format("%-" + messageLength + "s", beeMovieScript);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String message = beeMovieScript;

        // Prueba metodos encrypt() y decrypt():

        System.out.println("Clave: " + key);
        System.out.println("Largo de la clave: " + keyLength);
        System.out.println("Largo del mensaje: " + messageLength);

        System.out.print("Mensaje sin cifrar: ");
        System.out.println(message);

        double startEncryptTime = System.nanoTime();
        String encryptedMessage = bigVigenere.encrypt(message);
        double endEncryptTime = System.nanoTime();
        double encryptTime = endEncryptTime - startEncryptTime;
        System.out.println("Mensaje cifrado: " + encryptedMessage);
        System.out.println("Tiempo de cifrado: " + encryptTime + " nanosegundos, " + encryptTime/1000000000 + " segundos.");

        double startDecryptTime = System.nanoTime();
        message = bigVigenere.decrypt(encryptedMessage);
        double endDecryptTime = System.nanoTime();
        double decryptTime = endDecryptTime - startDecryptTime;
        System.out.println("Mensaje cifrado y descifrado: " + message);
        System.out.println("Tiempo de descifrado: " + decryptTime + " nanosegundos, " + decryptTime/1000000000 + " segundos.");

    }

}