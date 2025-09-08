import org.junit.Test;
import java.io.*;
import static org.junit.Assert.*;

public class MainTest{

    @Test
    public void testMain_PlaceOrderViewExit(){
        // Simulate user input:
        // 1 = Launch menu
        // 1 = Place new order
        // 2 = Adult
        // 2 = Over-the-counter
        // 2 = Tablet
        // 2 = Generic
        // 1 = Cash
        // 2 = Pickup
        // 2 = View all orders
        // 5 = Exit
        String simulatedInput = "1\n1\n2\n2\n2\n2\n1\n2\n2\n5\n";

        InputStream sysInBackup = System.in;
        PrintStream sysOutBackup = System.out;
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(out));

        // Run the main method
        Main.main(new String[]{});

        // Restore System.in and System.out
        System.setIn(sysInBackup);
        System.setOut(sysOutBackup);

        String output = out.toString();

        // Verify expected outputs
        assertTrue(output.contains("WELCOME TO IMAN'S PHARMACY"));
        assertTrue(output.contains("Order added successfully"));
        assertTrue(output.contains("1.Order: Adults, Over-the-counter, Payment: Cash, Pickup")); // from viewing orders
        assertTrue(output.contains("Thank you for using Iman's Pharmacy"));
    }
}