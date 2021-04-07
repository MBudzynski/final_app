package pl.sda.equals_hashcode;

public class Plane extends Vehicle{

    private String model;
    private Integer seats;
    private Integer planeNumber;

    public Plane(String model, Integer seats, Integer planeNumber) {
        this.model = model;
        this.seats = seats;
        this.planeNumber = planeNumber;
    }

    @Override
    public boolean equals(Object other){
        if(other==this){
            return true;
        }
        if(!other.getClass().equals(this.getClass())){
            return  false;
        }
        if(((Plane)other).getRegistrationNumber().equals(this.planeNumber)){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){ return this.planeNumber;
    }

    @Override
    public Integer getRegistrationNumber() {
        return planeNumber;
    }
}
