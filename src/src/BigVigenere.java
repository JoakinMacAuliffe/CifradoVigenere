package src;

public class BigVigenere {

    private int[] key;
    private char[][] alphabet;

    public BigVigenere(int[] key, char[][] alphabet) {
        this.key = key;
        this.alphabet = alphabet;
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
}
