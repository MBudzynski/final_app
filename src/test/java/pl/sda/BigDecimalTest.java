package pl.sda;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BigDecimalTest {
    @Test
    void name() {
        double a = 0.01;
        double b = 0.03;
        System.out.println(a-b);
        BigDecimal aa = new BigDecimal(0.01);
        BigDecimal bb = new BigDecimal(0.03);
        System.out.println(aa.subtract(bb));
        BigDecimal aaa =  BigDecimal.valueOf(0.01);
        BigDecimal bbb =  BigDecimal.valueOf(0.03);
        System.out.println(aaa.subtract(bbb));
    }
}
