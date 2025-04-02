package classes;
import java.util.Scanner;

public class BigVigenere {

    private int[] key;
    private char[][] alphabet;

    public BigVigenere() {

        System.out.print("Ingrese clave: ");
        Scanner sc = new Scanner(System.in);
        String clave = sc.next();

        for(int i = 0; i < clave.length(); i++) {

            key[i] = Integer.parseInt(String.valueOf(clave.charAt(i)));
        }

        String aux = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        key = new int[clave.length()];
        alphabet = new char[aux.length()][aux.length()];

        for(int i = 0; i < clave.length(); i++){

            key[i] = Integer.parseInt(String.valueOf(clave.charAt(i)));
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

    public String encrypt(String message) {

        String encrypt = "";
        int x = 0;

        for(int i=0; i<message.length(); i++){

            if(message.charAt(i) == ' '){

                encrypt = encrypt + " ";
                x++;
            }
            else{

                if(x == key.length){

                    x = 0;
                }

                encrypt = encrypt + alphabet[message.charAt(i)][key[x]];
                x++;
            }
        }

        return encrypt;
    }

    public String decrypt(String encryptedMessage) {

        String decrypt = "";
        int x = 0;

        for(int i = 0; i<encryptedMessage.length(); i++){

            if(encryptedMessage.charAt(x) == ' '){

                decrypt = decrypt + " ";
            }
            else{

                if(x == key.length){

                    x = 0;
                }

                for(int j=0; j<62; j++){

                    if(alphabet[j][key[x]] == encryptedMessage.charAt(i)){

                        decrypt = decrypt + alphabet[j][0];
                        x++;
                        break;
                    }
                }
            }
        }

        return decrypt;

    }

    public void reEncrypt() {

    }

    public char search(int position){

        char search = ' ';

        return search;
    }

    public char optimalSearch(int position){

        char search = ' ';

        return search;
    }

    public void imprimir(){

        for(int i=0; i<62; i++){

            for(int j=0; j<62; j++){

                System.out.print(alphabet[j][i]);
            }

            System.out.println("");
        }
    }

}