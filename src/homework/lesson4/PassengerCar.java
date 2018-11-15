package homework.lesson4;

import java.awt.Color;

public abstract class PassengerCar extends Car {

    private int numberOfPassengers;


    public PassengerCar(double weight, Color color, int age, int yearOfManufacture, String fuel, int numberOfPassengers) {
        super("PassengerCar", weight, color, age, yearOfManufacture, fuel);
        this.numberOfPassengers = numberOfPassengers;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }


    @Override
    protected int getDepreciation(int borderCountOfYears, int borderMileage) {
        return (int) (getMileage() / borderMileage + getAge() / borderCountOfYears) * 100 / 2;
    }

    @Override
    protected double getAmounttUsedFuel(double expenditure) {
        return getMileage() / 100 * expenditure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PassengerCar that = (PassengerCar) o;

        return getNumberOfPassengers() == that.getNumberOfPassengers();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getNumberOfPassengers();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("кол-во пассажиров: => ").append(numberOfPassengers).append((" "));
        sb.append(super.toString());
        return sb.toString();
    }
}
