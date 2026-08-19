package conversion;

public class AreaConversion {

    // Square meter to square feet
    public double squareMeterToSquareFeet(double sqMeter) {
        return sqMeter * 10.7639;
    }

    // Square feet to square meter
    public double squareFeetToSquareMeter(double sqFeet) {
        return sqFeet * 0.092903;
    }

    // Square kilometer to square meter
    public double squareKmToSquareMeter(double sqKm) {
        return sqKm * 1000000;
    }

    // Square meter to square kilometer
    public double squareMeterToSquareKm(double sqMeter) {
        return sqMeter / 1000000;
    }
}
