package src.AnimalShelter;

public class Main {
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();

        shelter.enqueue(new Dog("Buddy", 0));
        shelter.enqueue(new Cat("Whiskers", 0));
        shelter.enqueue(new Dog("Bella", 0));
        shelter.enqueue(new Cat("Sage", 0));

        System.out.println("Adopting any: " + shelter.dequeueAny().getName());
        System.out.println("Adopting a dog: " + shelter.dequeueDog().getName());
        System.out.println("Adopting a cat: " + shelter.dequeueCat().getName());
        System.out.println("Adopting any: " + shelter.dequeueAny().getName());
    }
}
