package week8;

public class PolymorphismDemo {
    // This program demonstrates Polymorphism ("Many Forms").
    // It shows how a superclass reference can point to a subclass object.

    // Superclass
    static class Animal {
        public void makeSound() {
            // Default sound for a generic animal.
            System.out.println("Some generic animal sound");
        }
    }

    // Subclass 1
    static class Dog extends Animal {
        // Overriding the makeSound method.
        @Override
        public void makeSound() {
            // Specific sound for a Dog.
            System.out.println("Woof! Woof!");
        }
    }

    // Subclass 2
    static class Cat extends Animal {
        // Overriding the makeSound method.
        @Override
        public void makeSound() {
            // Specific sound for a Cat.
            System.out.println("Meow!");
        }
    }

    // Subclass 3
    static class Cow extends Animal {
        // Overriding the makeSound method.
        @Override
        public void makeSound() {
            // Specific sound for a Cow.
            System.out.println("Moo!");
        }
    }

    public static void main(String[] args) {
        // Upcasting: Assigning subclass objects to superclass references.
        Animal[] myAnimals = new Animal[3];
        myAnimals[0] = new Dog(); // A Dog IS-AN Animal.
        myAnimals[1] = new Cat(); // A Cat IS-AN Animal.
        myAnimals[2] = new Cow(); // A Cow IS-AN Animal.

        System.out.println("=== ANIMAL SOUNDS ===");

        // Loop through the array.
        for (Animal animal : myAnimals) {
            // This is Polymorphism in action!
            // The JVM looks at the ACTUAL object type (Dog, Cat, Cow) at runtime,
            // not the reference type (Animal), and calls the correct method.
            animal.makeSound();
        }
    }
}

