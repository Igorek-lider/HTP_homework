package homework.lesson4;

import java.awt.Color;

public class Audi extends PassengerCar {

    private static String MANUFACTURER = "Audi";

    private String fullName;

    public Audi(double weight, Color color, int mileage, int age, String fuel, int numberOfPassengers, String model) {
        super(weight, color, mileage, age, fuel, numberOfPassengers);
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

        Audi audi = (Audi) o;

        return fullName.equals(audi.fullName);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + fullName.hashCode();
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
        System.out.format("Легковой автомобиль '%s' набирает скорость", fullName);
    }

    @Override
    public void toBrake() {
        System.out.format("Легковой автомобиль '%s' сбрасывает скорость", fullName);
    }

    @Override
    public void refuel() {
        System.out.format("Легковой автомобиль '%s' заправляется", fullName);
    }
}
