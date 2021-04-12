package Display;
import java.util.Scanner;

public class InputConsole implements InputInt {

    private Scanner userInput = new Scanner(System.in);
    private OutputConsole outputConsole = new OutputConsole();

    public String getInputString(String message){
        outputConsole.output(message);
        return userInput.nextLine();
    }
}
