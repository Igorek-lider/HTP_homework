package homework.lesson4;

import java.awt.Color;

public abstract class Car implements SecondCarBasicFunctions{

    private double weight;
    private Color color;
    private String category;
    private int mileage;
    private int age;
    private String fuel;


    public Car(String category, double weight, Color color, int mileage, int age, String fuel) {
        this.weight = weight;
        this.color = color;
        this.category = category;
        this.mileage = mileage;
        this.age = age;
        this.fuel = fuel;
    }

    /**
     * Возвращает процент износа транспортного средства
     *
     * @param borderCountOfYears максимальный возраст
     * @param borderMileage      максимальный пробег
     * @return процент износа
     */
    protected abstract int getDepreciation(int borderCountOfYears, int borderMileage);

    /**
     * Возвращает количество сожженного топлива данным авто
     *
     * @param expenditure средний расход топлива на 100 км
     * @return общее количество сожженного топлива
     */
    protected abstract double getAmounttUsedFuel(double expenditure);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (Double.compare(car.getWeight(), getWeight()) != 0) return false;
        if (Double.compare(car.getMileage(), getMileage()) != 0) return false;
        if (getAge() != car.getAge()) return false;
        if (!getColor().equals(car.getColor())) return false;
        if (!getCategory().equals(car.getCategory())) return false;
        return getFuel().equals(car.getFuel());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Информация об авто { ");
        sb.append("категория : '").append(category).append('\'');
        sb.append(", вес : ").append(weight);
        sb.append(", пробег : ").append(mileage);
        sb.append(", возраст : ").append(age);
        sb.append(", тип топлива : '").append(fuel).append('\'');
        sb.append(", цвет : ").append(color);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getWeight());
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + getColor().hashCode();
        result = 31 * result + getCategory().hashCode();
        temp = Double.doubleToLongBits(getMileage());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getAge();
        result = 31 * result + getFuel().hashCode();
        return result;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public double getWeight() {

        return weight;
    }

    public Color getColor() {
        return color;
    }

    public String getCategory() {
        return category;
    }

    public double getMileage() {
        return mileage;
    }

    public int getAge() {
        return age;
    }

    public String getFuel() {
        return fuel;
    }
}



