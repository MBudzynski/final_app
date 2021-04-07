package pl.sda.equals_hashcode;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class EqualsHashCode {

    @Test
    void equals(){
        Plane plane1= new Plane("model1", 100, 123);
        Plane plane2= new Plane("model1", 100, 123);
        Bike bike= new Bike("model1", 100, 123);
        Plane plane3= new Plane("model1", 100, 888);

        Set<Plane> planes = new HashSet<>();
        planes.add(plane1);
        planes.add(plane2);
        planes.add(plane3);
        System.out.println(planes.size());

        System.out.println(plane1.equals(bike));
        System.out.println(plane1.equals(plane2));
        System.out.println(plane1.equals(plane3));
    }

}
