/**

 * An Animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" bases.
 * People must adopt either the "oldest" (based on arrival time) of  all animals at the shelter, or they can select
 *  whether they would prefer a dog or cat (and will receive the oldest animal of that type).
 *  They cannot select which specific animal they would like.
 *  Create a datastucture to maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog and DequeueCat.
 */

package src.AnimalShelter;

import java.util.LinkedList;

public class AnimalShelter {
    private LinkedList<Dog> dogQueue; // stores dogs
    private LinkedList<Cat> catQueue; // stores cats
    private int timestamp; // tracks arrival time of animals

    public AnimalShelter() {
        dogQueue = new LinkedList<>(); // initializes 2 linkedlists for each animal
        catQueue = new LinkedList<>();
        timestamp = 0;
    }

    public void enqueue(Animal animal) {
        if (animal instanceof Dog) {
            dogQueue.addLast(new Dog(animal.getName(), timestamp));
        } else if (animal instanceof Cat) {
            catQueue.addLast(new Cat(animal.getName(), timestamp));
        }
        timestamp++; // checks to see if dog or cat and adds to appropiate dogQ or catQ
    }
    // uses ++ to icrement so next animal arrives at later time

    public Animal dequeueAny() {
        if (dogQueue.isEmpty()) return dequeueCat();
        if (catQueue.isEmpty()) return dequeueDog();

        Dog oldestDog = dogQueue.peekFirst();
        Cat oldestCat = catQueue.peekFirst();

        if (oldestDog.getArrivalTime() < oldestCat.getArrivalTime()) {
            return dogQueue.pollFirst();
        } else {
            return catQueue.pollFirst();
        }
    }

    public Dog dequeueDog() {
        return dogQueue.isEmpty() ? null : dogQueue.pollFirst();
    }

    public Cat dequeueCat() {
        return catQueue.isEmpty() ? null : catQueue.pollFirst();
    }
}
