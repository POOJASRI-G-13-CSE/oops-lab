import java.util.Scanner;

class InternetBill {
    String name;
    int dataUsed;
    double bill;

    // Method to calculate bill
    void calculateBill() {
        if (dataUsed <= 10) {
            bill = 300;
        } else if (dataUsed <= 20) {
            bill = 300 + (dataUsed - 10) * 20;
        } else {
            bill = 500 + (dataUsed - 20) * 30;
        }
    }

    // Method to display bill
    void displayBill() {
        System.out.println("\n----- Internet Bill -----");
        System.out.println("Customer Name : " + name);
        System.out.println("Data Used     : " + dataUsed + " GB");
        System.out.println("Total Bill    : Rs. " + bill);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        InternetBill customer = new InternetBill();

        System.out.print("Enter customer name: ");
        customer.name = sc.nextLine();

        System.out.print("Enter data used (in GB): ");
        customer.dataUsed = sc.nextInt();

        customer.calculateBill();
        customer.displayBill();

        sc.close();
    }
}
