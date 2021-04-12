import Display.InputConsole;
import FileInput.StubDelimitedFile;
import Display.InputFake;
import Display.OutputFake;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

public class Testing {

    @BeforeEach
    public void setupStub() {AllCustomers.setFileReader(new StubDelimitedFile());}

    @BeforeEach
    public void clearOutputFake(){
        OutputFake.clearOutputList();
    }

    @Test
    public void testCorrectEmailAndPassword(){
        String[] inputList = {"matthew.barr@glasgow.ac.uk", "4321"};
        InputFake inputFake = new InputFake(inputList);

        ArrayList<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("Enter email address");
        expectedOutput.add("Enter password");
        expectedOutput.add("You are logged in");

        LogIn login = new LogIn();
        LogIn.setInput(inputFake);
        LogIn.setOutput(new OutputFake());
        login.logIn();

        Assertions.assertEquals(expectedOutput, OutputFake.getOutputList());
    }

    @Test
    public void testCorrectEmailWrongPassword(){
        String[] inputList = {"matthew.barr@glasgow.ac.uk", "1234"};
        InputFake inputFake = new InputFake(inputList);

        ArrayList<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("Enter email address");
        expectedOutput.add("Enter password");
        expectedOutput.add("Wrong password, no second chances");

        LogIn login = new LogIn();
        LogIn.setInput(inputFake);
        LogIn.setOutput(new OutputFake());
        login.logIn();

        Assertions.assertEquals(expectedOutput, OutputFake.getOutputList());
    }

    @Test
    public void testWrongEmail(){
        InputConsole mockedInput = mock(InputConsole.class);
        when(mockedInput.getInputString("Enter email address")).thenReturn("no");

        ArrayList<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("You are not a user");

        LogIn login = new LogIn();
        LogIn.setInput(mockedInput);
        LogIn.setOutput(new OutputFake());
        login.logIn();

        Assertions.assertEquals(expectedOutput, OutputFake.getOutputList());

    }
}
