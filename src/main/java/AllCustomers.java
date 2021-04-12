import Display.InputInt;
import FileInput.GetDelimitedFileData;
import FileInput.ReadDelimitedFile;

import java.util.ArrayList;
import java.util.List;

public class AllCustomers {
    private List<Customer> listOfCustomers = new ArrayList<>();
    private boolean customersLoaded = false;
    private static GetDelimitedFileData fileReader;
    private static boolean fileReaderSet = false;

    public static void setFileReader(GetDelimitedFileData newFileReader){
        fileReader = newFileReader;
        fileReaderSet = true;
    }


    private List<String[]> loadRawCustomers(){
        if (!fileReaderSet){
            fileReader = new ReadDelimitedFile();
            fileReaderSet = true;
        }
        return fileReader.getFileData("customer.csv");
    }

    private List<Customer>  loadAsCustomers(){
        List<String[]> rawCustomers = loadRawCustomers();
        for (String[] rawCustomer : rawCustomers) {
            listOfCustomers.add( new Customer(rawCustomer[0],rawCustomer[1],rawCustomer[2],rawCustomer[3]));
        }
        customersLoaded = true;
        return listOfCustomers;
    }
    public List<Customer>  getListOfCustomers() {
        if (! customersLoaded){
            loadAsCustomers();
        }
        return listOfCustomers;
    }


}
