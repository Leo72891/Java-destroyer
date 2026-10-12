public class Car {
    private static int numOfCar = 0;
    private static int numOfRedCar = 0;
    private static int numOfBlueCar = 0;

    public Car(String color) {
        numOfCar++;
        if (color.equalsIgnoreCase("red")) {
            numOfRedCar++;
        } else if (color.equalsIgnoreCase("blue")) {
            numOfBlueCar++;
        }
    }

    public static int getNumOfCar() {
        return numOfCar;
    }

    public static int getNumOfRedCar() {
        return numOfRedCar;
    }

    public static int getNumOfBlueCar() {
        return numOfBlueCar;
    }
}
