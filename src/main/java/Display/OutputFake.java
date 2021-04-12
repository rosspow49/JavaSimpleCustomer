package Display;

import java.util.ArrayList;

public class OutputFake implements OutputInterface{
    private static ArrayList<String> outputList = new ArrayList<>();

    public static ArrayList<String> getOutputList(){
        return outputList;
    }

    public static void clearOutputList(){outputList = new ArrayList<>();}

    @Override
    public void output(String message) {
        outputList.add(message);

    }
}
