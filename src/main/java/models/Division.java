package models;

/**
 * Created by Sulaymon on 05.10.2017.
 */
public class Division implements Operation {
    public Float compute(Float num1, Float num2){
        try {
            return num1/num2;
        }catch (ArithmeticException e){
            throw new IllegalArgumentException("Dividing by zero!");
        }
    }
}
