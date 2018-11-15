package homework.lesson4;

public interface SecondCarBasicFunctions extends FirstCarBasicFunctions {

    public default void refuel() {
        System.out.println("Автомобиль заправляется");
    }
}
