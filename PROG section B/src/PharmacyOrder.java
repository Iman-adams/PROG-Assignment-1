// Class to represent a single pharmacy order
public class PharmacyOrder {
    // Order details
    String ageGroup; // Child or Adult
    String type; // Prescription or Over the counter
    String doctorID; // Only if prescription
    String form; // Syrup or Tablet
    String brandType; // Original or Generic
    String paymentMethod; // Cash, Card, or Medical aid
    String medicalName; // only add medical name if you chose Medical aid payment
    String medicalNumber; // Only add medical aid number if you chose medical aid payment
    String deliveryMethod; // Pickup or Delivery

    // Constructor
    public PharmacyOrder(String ageGroup, String type, String doctorID, String form, String brandType, String paymentMethod, String medicalName, String medicalNumber,  String deliveryMethod){
        this.ageGroup = ageGroup;
        this.type = type;
        this.doctorID = doctorID;
        this.form = form;
        this.brandType = brandType;
        this.paymentMethod = paymentMethod;
        this.medicalName =  medicalName;
        this.medicalNumber = medicalNumber;
        this.deliveryMethod = deliveryMethod;
    }

    // Method to return order details
    public String toString() {
        String details = "Order: " + ageGroup + ", " + type;
        if (!doctorID.isEmpty()) {
            details += " (DoctorID: " + doctorID + ")";
        }
        details += ", Payment: " + paymentMethod;
        if (paymentMethod.equals("Medical Aid")){ // asked AI to assist with this part
            details += " [Medical Aid: " + medicalName + " (" + medicalNumber + ")]";
        }
        details += ", " + deliveryMethod;
        return details;
    }
}