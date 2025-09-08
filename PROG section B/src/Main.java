import java.util.Scanner;
import java.util.ArrayList;

//Main class runs the pharmacy applications
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<PharmacyOrder> orders = new ArrayList<>();
        Pharmacy pharmacy = new Pharmacy();

        // Welcome message from business and launch menu
        System.out.println("****************************************");
        System.out.println("WELCOME TO IMAN'S PHARMACY");
        System.out.println("****************************************");
        System.out.println("Please enter (1) to launch menu: ");
        String start = scanner.nextLine();

        if (!start.equals("1")) { // if you don't pick number 1, it won't display the menu
            System.out.println("Exiting");
            return;
        }
        boolean running = true;
        while (running){
            // Display menu
            System.out.println("\n -- Pharmacy Menu --");
            System.out.println("1. Place new order");
            System.out.println("2. View all orders");
            System.out.println("3. Delete an order");
            System.out.println("4. Update an order");
            System.out.println("5. Exit");
            System.out.println("choose an option: ");
            String choice = scanner.nextLine();

            // AI was used to assist with case 3 and 4
            switch (choice){
                case "1": // Create new order using Pharmacy class
                    PharmacyOrder order = pharmacy.createOrder(scanner);
                    orders.add(order);
                    System.out.println("Order added successfully");
                    break;

                case "2": // Show all orders
                    if (orders.isEmpty()){
                        System.out.println("No orders yet");
                    }
                    else{
                        System.out.println("\n -- All Orders --");
                        for (int i = 0; i < orders.size(); i++){
                            System.out.println((i+1) + "." + orders.get(i));
                        }
                    }
                    break;

                case "3": // Delete order
                    if (orders.isEmpty()){
                        System.out.println("no orders to delete");
                    }
                    else{
                        System.out.println("Enter order  number to delete: ");
                        int delIndex = Integer.parseInt(scanner.nextLine()) - 1;
                        if (delIndex >= 0 && delIndex < orders.size()) {
                            orders.remove(delIndex);
                            System.out.println("Order deleted successfully");
                        } else {
                            System.out.println("Invalid order number");
                        }
                    }
                    break;

                case "4": // Update order
                    if (orders.isEmpty()) {
                        System.out.println("No orders to update");
                    } else {
                        System.out.println("Enter order number to update: ");
                        int updIndex = Integer.parseInt(scanner.nextLine()) - 1;
                        if (updIndex >= 0 && updIndex < orders.size()) {
                            PharmacyOrder updatedOrder = pharmacy.createOrder(scanner);
                            orders.set(updIndex, updatedOrder);
                            System.out.println("Order updated successfully");
                        } else {
                            System.out.println("Invalid order number");
                        }
                    }
                    break;

                case "5":
                    running = false;
                    System.out.println("Thank you for using Iman's Pharmacy :)");
                    break;
                default:
                    System.out.println("Invalid option try again");
            }
        }
    }
}