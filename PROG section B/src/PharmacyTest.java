import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import static org.junit.Assert.*;

public class PharmacyTest{

    @Test
    public void testCreateOrder_OverTheCounterCash(){
        String simulatedInput = "2\n2\n2\n2\n1\n"; // Adult, OTC, Tablet, Generic, Cash, Pickup
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));

        PharmacyOrder order = Pharmacy.createOrder(scanner);

        assertEquals("Adults", order.ageGroup);
        assertEquals("Over-the-counter", order.type);
        assertEquals("", order.doctorID);
        assertEquals("Tablet", order.form);
        assertEquals("Generic", order.brandType);
        assertEquals("Cash", order.paymentMethod);
        assertEquals("", order.medicalName);
        assertEquals("", order.medicalNumber);
        assertEquals("Pickup", order.deliveryMethod);
    }

    @Test
    public void testCreateOrder_PrescriptionMedicalAid(){
        String simulatedInput = "1\n1\nDOC456\n1\n1\n3\nHealthPlus\n67890\n1\n";
        // Child, Prescription, DOC456, Syrup, Original, Medical Aid, HealthPlus, 67890, Delivery
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));

        PharmacyOrder order = Pharmacy.createOrder(scanner);

        assertEquals("Children", order.ageGroup);
        assertEquals("Prescription", order.type);
        assertEquals("DOC456", order.doctorID);
        assertEquals("Syrup", order.form);
        assertEquals("Original", order.brandType);
        assertEquals("Medical Aid", order.paymentMethod);
        assertEquals("HealthPlus", order.medicalName);
        assertEquals("67890", order.medicalNumber);
        assertEquals("Delivery", order.deliveryMethod);
    }
}