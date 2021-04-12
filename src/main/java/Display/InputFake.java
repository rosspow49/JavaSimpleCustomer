package Display;

public class InputFake implements InputInt {
    private String[] inputList;
    private int index = 0;
    private OutputFake outputFake = new OutputFake();

    public InputFake(String[] inputList){
        this.inputList = inputList;
    }

    @Override
    public String getInputString(String message) {
        outputFake.output(message);
        String inputToReturn = inputList[index];
        index += 1;
        return inputToReturn;
    }
}
