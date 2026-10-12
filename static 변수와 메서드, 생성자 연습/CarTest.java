public class CarTest {
    public static void main(String[] args) {
        Car c1 = new Car("red");
        Car c2 = new Car("blue");
        Car c3 = new Car("RED");

        System.out.printf("-> 자동차 수 : %d, 빨간색 자동차 수 : %d\n", Car.getNumOfCar(), Car.getNumOfRedCar());
        System.out.printf("-> 자동차 수 : %d, 파란색 자동차 수 : %d\n", Car.getNumOfCar(), Car.getNumOfBlueCar());
    }
}
