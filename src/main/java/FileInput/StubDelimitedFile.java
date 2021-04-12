package FileInput;

import java.util.ArrayList;
import java.util.List;

public class StubDelimitedFile implements GetDelimitedFileData {

    private ArrayList<String[]> inputList = new ArrayList<>();

    public StubDelimitedFile(){
        this.inputList.add("emailAddress,firstName,lastName,password".split(","));
        this.inputList.add("derek.somerville@glasgow.ac.uk,Derek,Somerville,1234".split(","));
        this.inputList.add("matthew.barr@glasgow.ac.uk,Matt,Barr,4321".split(","));

    }
    @Override
    public List<String[]> getFileData(String fileName) {
        return inputList;
    }
}
