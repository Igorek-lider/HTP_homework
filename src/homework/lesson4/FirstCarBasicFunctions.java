package homework.lesson4;

public interface FirstCarBasicFunctions {

    public void willAccelerate();
    public void toBrake();

    public default void move() {
        System.out.println("Автомобиль находится в движении");
    }
}
