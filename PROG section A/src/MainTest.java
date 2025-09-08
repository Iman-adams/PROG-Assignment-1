import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertTrue;

public class MainTest {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    public void testMain_LaunchMenuAndExit() {
        // Arrange: Provide input to launch the menu (1) and then exit (6)
        String input = "1\n6\n";
        provideInput(input);

        // Act: Run the main method
        Main.main(new String[]{});

        // Assert: Verify that the menu and exit messages were printed
        String output = outContent.toString();
        assertTrue("Menu should be displayed", output.contains("Please select one of the following menu items:"));
        assertTrue("Exit message should be displayed", output.contains("Exiting application..."));
    }

    @Test
    public void testMain_InvalidInitialInput_Exits() {
        // Arrange: Provide a non-'1' input to exit immediately
        String input = "abc\n";
        provideInput(input);

        // Act: Run the main method
        Main.main(new String[]{});

        // Assert: Verify that the application exits without showing the menu
        String output = outContent.toString();
        assertTrue("Initial exit message should be displayed", output.contains("Exiting application..."));
        assertTrue("Menu should not be displayed", !output.contains("Please select one of the following menu items:"));
    }
}