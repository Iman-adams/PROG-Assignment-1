import org.junit.Test;
import static org.junit.Assert.*;

public class PharmacyOrderTest{

    @Test
    public void testConstructorAndToString_CashPayment(){
        PharmacyOrder order = new PharmacyOrder(
                "Adults", "Over-the-counter", "",
                "Tablet", "Generic", "Cash",
                "", "", "Pickup"
        );

        assertEquals("Adults", order.ageGroup);
        assertEquals("Over-the-counter", order.type);
        assertEquals("", order.doctorID);
        assertEquals("Tablet", order.form);
        assertEquals("Generic", order.brandType);
        assertEquals("Cash", order.paymentMethod);
        assertEquals("", order.medicalName);
        assertEquals("", order.medicalNumber);
        assertEquals("Pickup", order.deliveryMethod);

        String expectedString = "Order: Adults, Over-the-counter, Payment: Cash, Pickup";
        assertEquals(expectedString, order.toString());
    }

    @Test
    public void testConstructorAndToString_PrescriptionMedicalAid(){
        PharmacyOrder order = new PharmacyOrder(
                "Children", "Prescription", "DOC123",
                "Syrup", "Original", "Medical Aid",
                "MediCare", "12345", "Delivery"
        );

        assertEquals("Children", order.ageGroup);
        assertEquals("Prescription", order.type);
        assertEquals("DOC123", order.doctorID);
        assertEquals("Syrup", order.form);
        assertEquals("Original", order.brandType);
        assertEquals("Medical Aid", order.paymentMethod);
        assertEquals("MediCare", order.medicalName);
        assertEquals("12345", order.medicalNumber);
        assertEquals("Delivery", order.deliveryMethod);

        String expectedString = "Order: Children, Prescription (DoctorID: DOC123), Payment: Medical Aid [Medical Aid: MediCare (12345)], Delivery";
        assertEquals(expectedString, order.toString());
    }
}
