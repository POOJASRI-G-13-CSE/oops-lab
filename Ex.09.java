import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StringOperations {
    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        // Adding strings
        names.add("Apple");
        names.add("Banana");
        names.add("Mango");
        names.add("Orange");

        System.out.println("Original ArrayList: " + names);

        // Displaying strings
        System.out.println("\nStrings in the ArrayList:");
        for (String name : names) {
            System.out.println(name);
        }

        // Searching for a string
        System.out.print("\nEnter a string to search: ");
        String search = sc.nextLine();

        if (names.contains(search)) {
            System.out.println(search + " is present in the ArrayList.");
        } else {
            System.out.println(search + " is not present.");
        }

        // Updating a string
        names.set(1, "Grapes");
        System.out.println("\nAfter updating: " + names);

        // Removing a string
        names.remove("Mango");
        System.out.println("After removing Mango: " + names);

        // Sorting strings
        Collections.sort(names);
        System.out.println("After sorting: " + names);

        // Size of ArrayList
        System.out.println("Number of strings: " + names.size());

        sc.close();
    }
}
