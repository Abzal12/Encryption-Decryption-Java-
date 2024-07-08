package encryptdecrypt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        Command command = new Command();
        //FileWriter writer;
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode" -> command.setUserChoice(args[i + 1]);
                case "-key" -> command.setShift(Integer.parseInt(args[i + 1]));
                case "-data" -> command.setText(args[i + 1]);
                case "-in" -> command.readFromFile(args[i + 1]);
                case "-out" -> {
                    command.setHasWriter(true);
                    command.setWriterDocName(args[i + 1]);
                }
                case "-alg" -> command.setAlgoritmType(args[i + 1]);
            }
        }

        String targetOperation = command.getUserChoice();
        String inputText = command.getText();
        int shift = command.getShift();

        if (command.getAlgoritmType().equals("unicode")) {
            if (targetOperation.equals("enc")) {
                String encryptedText = Key.encryptUsingAscii(inputText, shift);
                if (command.isHasWriter()) {
                    command.writeToFile(encryptedText);
                } else {
                    System.out.println(encryptedText);
                }
            } else if (targetOperation.equals("dec")) {
                String decryptedText = Key.decryptUsingAscii(inputText, shift);
                if (command.isHasWriter()) {
                    command.writeToFile(decryptedText);
                } else {
                    System.out.println(decryptedText);
                }
            }
        } else {
            if (targetOperation.equals("enc")) {
                String encryptedText = Key.encryptUsingAlphabet(inputText, shift);
                if (command.isHasWriter()) {
                    command.writeToFile(encryptedText);
                } else {
                    System.out.println(encryptedText);
                }
            } else if (targetOperation.equals("dec")) {
                String decryptedText = Key.decryptUsingAlphabet(inputText, shift);
                if (command.isHasWriter()) {
                    command.writeToFile(decryptedText);
                } else {
                    System.out.println(decryptedText);
                }
            }
        }
    }
}
