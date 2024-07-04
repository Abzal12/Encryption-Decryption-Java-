package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Command {

    private String userChoice = "enc";
    private int shift = 0;
    private String text = "";

    private boolean hasWriter = false;
    private String writerDocName = "";

    public void writeToFile(String resultingText) {
        File file = new File(System.getProperty("user.dir") + "\\" + writerDocName);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(resultingText);
        } catch (IOException e) {
            System.out.printf("An exception occurred %s", e.getMessage());
        }
    }
    public String getWriterDocName() {
        return writerDocName;
    }

    public void setWriterDocName(String writerDocName) {
        this.writerDocName = writerDocName;
    }

    public String getUserChoice() {
        return userChoice;
    }

    public void setUserChoice(String userChoice) {
        this.userChoice = userChoice;
    }

    public boolean isHasWriter() {
        return hasWriter;
    }

    public void setHasWriter(boolean hasWriter) {
        this.hasWriter = hasWriter;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
