import java.util.Scanner;

public class BigVigenere {

    private int[] key;
    private char[][] alphabet;

    public BigVigenere() {

        System.out.print("Ingrese clave: ");
        Scanner sc = new Scanner(System.in);
        String clave = sc.next();

        key = new int[clave.length()];

        for(int i = 0; i < clave.length(); i++) {

            key[i] = Integer.parseInt(String.valueOf(clave.charAt(i)));
        }

        String aux = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        alphabet = new char[aux.length()][aux.length()];

        for(int i=0; i<aux.length(); i++){

            alphabet[i][0] = aux.charAt(i);
            int x = i+1;

            for(int j = 1; j<aux.length(); j++){

                if(x == aux.length()){
                    x = 0;
                }
                alphabet[i][j] = aux.charAt(x);
                x++;
            }
        }

    }

    public BigVigenere(String numericKey){

        String aux = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        key = new int[numericKey.length()];
        alphabet = new char[aux.length()][aux.length()];

        for(int i = 0; i < numericKey.length(); i++){
            key[i] = Integer.parseInt(String.valueOf(numericKey.charAt(i)));
        }

        for(int i=0; i<aux.length(); i++){

            alphabet[i][0] = aux.charAt(i);
            int x = i+1;

            for(int j = 1; j<aux.length(); j++){

                if(x == aux.length()){
                    x = 0;
                }

                alphabet[i][j] = aux.charAt(x);
                x++;
            }
        }
    }

    public int[] getCharIndex(String message) {

        int[] index = new int[message.length()];
        int position = 0;

        while (position < message.length()) {

            if(message.charAt(position) == ' '){

                index[position] = -1;
                position++;
            }
            else {

                for(int i = 0; i < alphabet.length; i++) {

                    if(message.charAt(position) == alphabet[i][0]) {
                        index[position] = i;
                        position++;
                        break;
                    }
                }
            }
        }

        return index;
    }

    public String encrypt(String message) {

        String encrypt = "";
        int position = 0;
        int[] charIndex = getCharIndex(message);

        for(int i = 0; i < message.length(); i++){

            if(message.charAt(i) == ' '){
                encrypt = encrypt + ' ';
            }
            else{

                if(position >= key.length){
                    position = 0;
                }
                encrypt = encrypt + alphabet[charIndex[i]][key[position] - 1];
                position++;
            }
        }
        return encrypt;
    }

    public String decrypt(String encryptedMessage) {

        String decrypt = "";
        int position = 0;

        for(int i = 0; i < encryptedMessage.length(); i++){

            if(encryptedMessage.charAt(i) == ' '){

                decrypt = decrypt + ' ';
            }
            else{

                if(position >= key.length){
                    position = 0;
                }

                for(int j = 0; j < alphabet.length; j++){

                    if(alphabet[j][key[position]-1] == encryptedMessage.charAt(i)){
                        decrypt = decrypt + alphabet[j][0];
                        position++;
                        break;
                    }
                }
            }
        }

        return decrypt;

    }

    public void reEncrypt() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese mensaje encriptado: ");
        String encryptedMessage = scanner.nextLine();

        String message = decrypt(encryptedMessage);

        System.out.print("Ingrese nueva clave: ");
        String inputKey = scanner.nextLine();

        int[] newKey = new int[inputKey.length()];

        for(int i = 0; i < newKey.length; i++){
            key[i] = Integer.parseInt(String.valueOf(inputKey.charAt(i)));
        }

        System.out.println("El nuevo mensaje es: " + encrypt(message));

    }

    public char search(int position){

        if(position > (alphabet.length* alphabet.length-1) || position < 0) {

            System.out.println("Error: La posicion debe ser positiva y menor a " + alphabet.length* alphabet.length + ".");
            return '.';
        }

        int x = 0, y = 0, contador = 0;

        while(contador != position){

            if(x == alphabet.length){

                x = 0;
                y++;
            }
            else{

                x++;
                contador++;
            }
        }

        return alphabet[x][y];
    }

    public char optimalSearch(int position){

        if(position > (alphabet.length* alphabet.length-1) || position < 0) {

            System.out.println("Error: La posicion debe ser mayor o igual cero y menor a " + alphabet.length* alphabet.length + ".");
            return '.';
        }

        return alphabet[position % alphabet.length][position / alphabet.length];
    }

}