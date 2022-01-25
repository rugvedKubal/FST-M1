package activities;

public class Activity1 {

    public static void main(String[] args) {
        Car hondaCity = new Car();

        hondaCity.make = 2014;
        hondaCity.color = "Black";
        hondaCity.transmission = "Manual";

        hondaCity.displayCharacteristics();
        hondaCity.accelerate();
        hondaCity.brake();
    }
}

class Car {

    String color;
    String transmission;
    int make;
    int tyres;
    int doors;

    public Car() {
        this.tyres = 4;
        this.doors = 4;
    }

    public void displayCharacteristics() {
        System.out.println("Color: "+color+ "\nTransmission: "+transmission+"\nMake: "+make+"\nTyres: "+tyres+"\nDoors: "+doors);
    }

    public void accelerate() {
        System.out.println("Car is moving forward.");
    }

    public void brake() {
        System.out.println("Car has stopped.");
    }
}