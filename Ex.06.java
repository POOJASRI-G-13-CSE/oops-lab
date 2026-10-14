public class Main {
    public static void main(String[] args) {

        Integer num = 10;

        System.out.println("Before changing: " + num);

        // Trying to change the value
        num = num + 20;

        System.out.println("After changing: " + num);

        // String is also immutable
        String str = "Hello";

        System.out.println("\nBefore changing String: " + str);

        str = str + " World";

        System.out.println("After changing String: " + str);
    }
}
