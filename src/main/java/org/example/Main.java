package org.example;

import java.util.function.DoubleUnaryOperator;

public class Main {
    public static void main(String[] args) throws SameSignException {
        System.out.println(solveBisection((x) -> x*x - Math.exp(x), -1, 1, 0.1));
    }

    public static class SameSignException extends Exception{
    }

    public static double solveBisection(DoubleUnaryOperator fun, double initial1, double initial2, double epsilon) throws SameSignException {
        if(fun.applyAsDouble(initial1)*fun.applyAsDouble(initial2) >= 0){
            throw new SameSignException();
        }
        double midpoint = (initial1 + initial2)/2;
        while (Math.abs(fun.applyAsDouble(midpoint)) >= epsilon){
            if(fun.applyAsDouble(initial1)* fun.applyAsDouble(midpoint) < 0){
                midpoint = (midpoint + initial1)/2;
            }
            else {
                midpoint = (midpoint + initial2)/2;
            }
        }
        return midpoint;
    }
}