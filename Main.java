package encryptdecrypt;

public class Main {
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


    public static void main(String[] args) {
        //System.out.println("Hello World!");
        String text = "we found a treasure!";
        String cipherText = makeTextCipher(text);
        System.out.println(cipherText);
    }
}
