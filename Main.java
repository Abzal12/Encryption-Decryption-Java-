package encryptdecrypt;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Command command = new Command();
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                command.setUserChoice(args[i+1]);
            } else if (args[i].equals("-key")) {
                command.setShift(Integer.parseInt(args[i+1]));
            } else if (args[i].equals("-data")) {
                command.setText(args[i+1]);
            }
        }

        //Scanner scanner = new Scanner(System.in);
        String targetOperation = command.getUserChoice();
        String inputText = command.getText();
        int shift = command.getShift();

        if (targetOperation.equals("enc")) {
            String encryptedText = Key.encryptUsingAscii(inputText, shift);
            System.out.println(encryptedText);
        } else if (targetOperation.equals("dec")) {
            String decryptedText = Key.decryptUsingAscii(inputText, shift);
            System.out.println(decryptedText);
        }
    }
}
