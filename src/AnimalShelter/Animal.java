package src.AnimalShelter;

public abstract class Animal {
    private String name;
    private int arrivalTime;

    public Animal(String name, int arrivalTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public String getName() {
        return name;
    }
}

class Dog extends Animal {
    public Dog(String name, int arrivalTime) {
        super(name, arrivalTime);
    }
}

class Cat extends Animal {
    public Cat(String name, int arrivalTime) {
        super(name, arrivalTime);
    }
}
