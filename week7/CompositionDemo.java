package week7;

// This program demonstrates Composition (HAS-A relationship).

// The Engine class
class Engine {

    public void start() {
        System.out.println("Engine started.");
    }
}

// The Car class uses Composition
class Car {

    private Engine engine;

    // Constructor initializes the Engine
    public Car() {
        this.engine = new Engine();
    }

    // Car delegates starting to Engine
    public void startCar() {

        System.out.println("Car is starting...");

        // Call the Engine's method
        engine.start();
    }
}

// Main class
public class CompositionDemo {

    public static void main(String[] args) {

        Car myCar = new Car();

        myCar.startCar();
    }
}