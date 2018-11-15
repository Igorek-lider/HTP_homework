package homework.lesson4;

import java.awt.Color;

public abstract class Truck extends Car {

    private double loadCapacity;

    private double rateDepreciation;

    public Truck(double weight, Color color, int mileage, int age, String fuel, double loadCapacity, double rateDepreciation) {
        super("Truck", weight, color, mileage, age, fuel);
        this.loadCapacity = loadCapacity;
        this.rateDepreciation = rateDepreciation;
    }

    public double getRateDepreciation() {
        return rateDepreciation;
    }

    public void setRateDepreciation(double rateDepreciation) {
        this.rateDepreciation = rateDepreciation;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    protected double getAmounttUsedFuel(double expenditure, double heightenedCoef) {
        return getMileage() / 100 * expenditure * heightenedCoef;
    }

    protected int getDepreciation(int borderCountOfYears, int borderMileage, double rateDepreciation) {
        return (int) ((getMileage() / borderMileage + getAge() / borderCountOfYears) * rateDepreciation * 100 / 2);
    }

    @Override
    protected int getDepreciation(int borderCountOfYears, int borderMileage) {
        return (int) ((getMileage() / borderMileage + getAge() / borderCountOfYears) * rateDepreciation * 100 / 2);
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

        Truck truck = (Truck) o;

        if (Double.compare(truck.loadCapacity, loadCapacity) != 0) return false;
        return Double.compare(truck.rateDepreciation, rateDepreciation) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(loadCapacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(rateDepreciation);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("грузоподъемность: => ").append(loadCapacity).append(("т "));
        sb.append(super.toString());
        return sb.toString();
    }
}
