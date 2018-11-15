package homework.lesson4;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MagazAndService {

    public static void main(String[] args) {

        List<Car> listCars = new ArrayList<>();
        listCars.addAll(MagazAndService.getCollectionAudi(5));
        listCars.addAll(MagazAndService.getCollectionDaf(7));

        for (Car car : listCars) {
            System.out.println(car.toString());
            //car.willAccelerate();
            System.out.println("---------------------------------------------------");
        }

        System.out.println("Общая информация:\r\n");
        System.out.format("Средний возраст легковых машин: %.2f%n", getAverageAgePassengerCar(listCars));
        System.out.format("Общий пробег легковых машин: %.2f%n%n", getCommonMileagePassengerCar(listCars));
        System.out.format("Средний возраст грузовых машин: %.2f%n", getAverageAgeTruck(listCars));
        System.out.format("Общий пробег грузовых машин: %.2f%n%n", getCommonMileageTruck(listCars));

        System.out.println("Список всех машин, отсортированных по пробегу:\r\n");

        CarMileageComparator carMileageComparator = new CarMileageComparator();
        listCars.sort(carMileageComparator);

        listCars.forEach(System.out::println);
    }


    public static List<Car> getCollectionAudi(int count) {

        List<Car> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            list.add(new Audi(randInt(1100, 2700), new Color(randInt(0, 255), randInt(0, 255), randInt(0, 255)), randInt(15000, 450000), randInt(3, 15), i % 2 == 1 ? "gasoline" : "diesel", randInt(2, 7), "A" + i));
        }
        return list;
    }


    public static List<Car> getCollectionDaf(int count) {

        List<Car> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new Daf(randInt(6500, 17000), new Color(randInt(0, 255), randInt(0, 255), randInt(0, 255)), randInt(15000, 850000), randInt(3, 10), i % 2 == 1 ? "gasoline" : "diesel", randInt(15000, 35000), 1.2, "S" + (i + 1) * 100));
        }
        return list;
    }


    public static int randInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public static float getAverageAgePassengerCar(List<Car> cars) {
        float averageAge = 0;

        int countPassengerCar = 0;

        for (Car car : cars) {
            if (car instanceof PassengerCar) {
                averageAge += car.getAge();
                countPassengerCar++;
            }
        }

        countPassengerCar = countPassengerCar == 0 ? 1 : countPassengerCar;
        return averageAge / countPassengerCar;
    }

    public static float getAverageAgeTruck(List<Car> cars) {
        float averageAge = 0;
        int countTruck = 0;

        for (Car car : cars) {
            if (car instanceof Truck) {
                averageAge += car.getAge();
                countTruck++;
            }
        }

        countTruck = countTruck == 0 ? 1 : countTruck;
        return averageAge / countTruck;
    }

    public static float getCommonMileagePassengerCar(List<Car> cars) {
        float commonMileage = 0;

        for (Car car : cars) {
            if (car instanceof PassengerCar) commonMileage += car.getMileage();
        }
        return commonMileage;
    }

    public static float getCommonMileageTruck(List<Car> cars) {
        float commonMileage = 0;

        for (Car car : cars) {
            if (car instanceof Truck) commonMileage += car.getMileage();
        }
        return commonMileage;
    }
}
