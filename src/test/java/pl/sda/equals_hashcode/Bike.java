package pl.sda.equals_hashcode;

public class Bike extends Vehicle {

    private String model;
    private Integer seats;
    private Integer bikeNumber;

    public Bike(String model, Integer seats, Integer bikeNumber) {
        this.model = model;
        this.seats = seats;
        this.bikeNumber = bikeNumber;
    }

    @Override
    public Integer getRegistrationNumber() {
        return bikeNumber;
    }
}
