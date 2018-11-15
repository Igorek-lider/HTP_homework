package homework.lesson4;

import java.util.Comparator;

public class CarMileageComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        if (o1.getMileage() > o2.getMileage()) {
            return 1;
        } else if (o1.getMileage() < o2.getMileage()) {
            return -1;
        } else {
            return 0;
        }
    }
}
