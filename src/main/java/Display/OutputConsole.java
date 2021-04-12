package Display;

public class OutputConsole implements OutputInterface {

    @Override
    public void output(String message) {
        System.out.println(message);
    }
}
