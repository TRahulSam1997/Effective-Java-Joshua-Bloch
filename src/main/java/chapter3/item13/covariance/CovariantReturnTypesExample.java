package chapter3.item13.covariance;

class Vehicle {
    Vehicle startEngine() {
        System.out.println("Starting the vehicle's engine.");
        return this;
    }
}

class Car extends Vehicle {
    @Override
    Car startEngine() {
        System.out.println("Starting the car's engine.");
        return this;
    }
}

class Motorcycle extends Vehicle {
    @Override
    Motorcycle startEngine() {
        System.out.println("Starting the motorcycle's engine.");
        return this;
    }
}

public class CovariantReturnTypesExample {
    public static void main(String[] args) {
        Vehicle myVehicle = new Vehicle();
        Car myCar = new Car();
        Motorcycle myMotorcycle = new Motorcycle();

        myVehicle = myVehicle.startEngine();
        myCar = myCar.startEngine();
        myMotorcycle = myMotorcycle.startEngine();
    }
}
