package homework.lesson4;

import java.awt.Color;

public class Daf extends Truck {

    private static String MANUFACTURER = "DAF";

    private String fullName;


    public Daf(double weight, Color color, int mileage, int age, String fuel, double loadCapacity, double rateDepreciation, String model) {
        super(weight, color, mileage, age, fuel, loadCapacity, rateDepreciation);
        this.fullName = String.format("%s %s", MANUFACTURER, model);
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Daf daf = (Daf) o;

        return fullName != null ? fullName.equals(daf.fullName) : daf.fullName == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(fullName).append(" => ");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void willAccelerate() {
        System.out.format("Грузовой автомобиль '%s' набирает скорость", fullName);
    }

    @Override
    public void toBrake() {
        System.out.format("Грузовой автомобиль '%s' сбрасывает скорость", fullName);
    }

    @Override
    public void refuel() {
        System.out.format("Грузовой автомобиль '%s' заправляется", fullName);
    }
}
