import Display.InputConsole;
import Display.InputInt;
import Display.OutputConsole;
import Display.OutputInterface;

import java.util.List;
import java.util.Scanner;

public class LogIn {
    private static InputInt input = new InputConsole();
    private static OutputInterface output = new OutputConsole();

    public static void setInput(InputInt input) {
        LogIn.input = input;
    }

    public static void setOutput(OutputInterface output) {
        LogIn.output = output;
    }


    private String getPassword(String emailAddress){
        AllCustomers allCustomers = new AllCustomers();
        String password = "";
        List<Customer> listOfCustomers = allCustomers.getListOfCustomers();
        for (Customer customer :listOfCustomers){
            if (customer.getEmailAddress().equals(emailAddress)){
                password = customer.getPassword();
            }
        }
        return password;
    }

    public void logIn() {
        String emailAddress = input.getInputString("Enter email address");
        String password = getPassword(emailAddress);
        if (password == "") {
            output.output("You are not a user");
        }
        else if (password.equals(input.getInputString("Enter password"))){
            output.output("You are logged in");
        }
        else {
            output.output("Wrong password, no second chances");
        }
    }

    public static void main(String[] args){
        LogIn logIn = new LogIn();
        logIn.logIn();
    }
}