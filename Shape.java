abstract class Shape {
    // Abstract method
    abstract void area();
}

class Circle extends Shape {
    double radius = 5;

    void area() {
        double result = 3.14 * radius * radius;
        System.out.println("Area of Circle = " + result);
    }
}

class Rectangle extends Shape {
    double length = 10;
    double breadth = 5;

    void area() {
        double result = length * breadth;
        System.out.println("Area of Rectangle = " + result);
    }
}

public class Main {
    public static void main(String[] args) {

        Shape s1 = new Circle();
        Shape s2 = new Rectangle();

        s1.area();
        s2.area();
    }
}
