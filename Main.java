package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static String makeTextCipher(String text) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char currentCh = text.charAt(i);
            if (currentCh >= 'a' && currentCh <= 'z')
            {
                char cipherCh = (char) ('z' - (currentCh - 'a'));
                result.append(cipherCh);
            }
            else
            {
                result.append(currentCh);
            }
        }
        return result.toString();
    }

    public static String encrypt(String text, int shift) {
        StringBuilder sb = new StringBuilder();
        boolean isFoundInAlphabet;
        for (int i = 0; i < text.length(); i++) {
            isFoundInAlphabet = false;
            for (int j = 0; j < alphabet.length(); j++) {
                if (text.charAt(i) == alphabet.charAt(j)) {
                    sb.append(alphabet.charAt((j + shift)%alphabet.length()));
                    isFoundInAlphabet = true;
                    break;
                }
            }
            if (!isFoundInAlphabet) {
                sb.append(text.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine();
        int shift = scanner.nextInt();
        String encryptedText = encrypt(inputText, shift);
        System.out.println(encryptedText);
    }
}
