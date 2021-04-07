package pl.sda.lambdaandgenericstype;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdasExample {

    List<String> pets = Arrays.asList("pig", "dog", "hamster", " dog", null);
    Predicate<String> notNullPredicate = p -> p != null;
    Function<String, String> trimFunction = p -> p.trim();

    @Test
    void basicLambdas(){

        pets.stream().filter(notNullPredicate).map(trimFunction).distinct().sorted().forEach(p-> System.out.println(p));
    }

    @FunctionalInterface
    public interface MathOperation{
        int calculate(int x, int y);
    }

    @Test
    void calculatorTest(){
        MathOperation adder = (a,b) -> a + b;
        System.out.println(adder.calculate(1,2));
    }

    @FunctionalInterface
    public interface SuperMathOperation<T>{
        T calculate(T x, T y);
    }

    @Test
    void superCalculatorTest(){
        SuperMathOperation<Float> adderFloat= (a,b) -> a + b;
        System.out.println(adderFloat.calculate(1.5f,2.8f));
    }

    @FunctionalInterface
    public interface TurboMathOperation<X, Y, RESOULT>{
        RESOULT calculate(X x, Y y);

    }

    @Test
    void turboCalculatorTest(){
        TurboMathOperation<String, Integer, BigDecimal> adderMix= (a, b) -> BigDecimal.valueOf(Double.parseDouble(a)).add(BigDecimal.valueOf(b));
        System.out.println(adderMix.calculate("1.8",2));
    }

}
