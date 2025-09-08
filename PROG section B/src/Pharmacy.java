import java.util.Scanner;

// Class that handles the process of creating an order
public class Pharmacy {
    public  static PharmacyOrder createOrder(Scanner scanner){ // Method that asks all questions and create a PharmacyOrder

        System.out.println("Please specify the patient category: (1) Child or (2) Adult: ");
        String ageGroup = scanner.nextLine().equals("1")? "Children" : "Adults";

        System.out.println("Is the medication (1) Prescription or (2) Over-the-counter? ");
        String type = scanner.nextLine().equals("1") ? "Prescription" : "Over-the-counter";

        // Asked AI to assist me with this piece
        String doctorID = "";
        if (type.equals("Prescription")){
            System.out.println("Kindly enter the prescribing Doctor's ID number: ");
            doctorID = scanner.nextLine();
        }
        System.out.println("Please select the dosage form: (1) Syrup or (2) Tablet: ");
        String form = scanner.nextLine().equals("1") ? "Syrup" : "Tablet";

        System.out.print("Would you prefer the (1) Original brand or (2) Generic option? ");
        String brandType = scanner.nextLine().equals("1") ? "Original" : "Generic";

        System.out.print("Please choose your payment method: (1) Cash (2) Card (3) Medical Aid? ");
        String paymentChoice = scanner.nextLine();
        String paymentMethod = paymentChoice.equals("1") ? "Cash" :
                paymentChoice.equals("2") ? "Card" : "Medical Aid";

        // Copied the format of doctorID and added two strings together
        String medicalName = "";
        String medicalNumber = "";
        if (paymentMethod.equals("Medical Aid")) {
            System.out.print("Please enter your Medical Aid Name: ");
            medicalName = scanner.nextLine();
            System.out.print("Please enter your Medical Aid Number: ");
            medicalNumber = scanner.nextLine();
        }

        System.out.print("Would you like your order (1) Delivery (2) Pickup: ");
        String deliveryMethod = scanner.nextLine().equals("1") ? "Delivery" : "Pickup";

        // Create and return a PharmacyOrder object
        return new PharmacyOrder(ageGroup, type, doctorID, form, brandType, paymentMethod, medicalName, medicalNumber, deliveryMethod);
    }
}