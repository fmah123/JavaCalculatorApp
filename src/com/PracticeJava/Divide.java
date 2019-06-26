package com.PracticeJava;

public final class Divide extends BaseOperation {
    public Divide(int value1, int value2) {
        super(value1, value2, Operation.DIVIDE);
    }

    public int Divide(){
        try{
            return getValue1() / getValue2();
        }catch (ArithmeticException e){
            System.out.println("Can not divide by zero.");
        }
        return 0;
    }

    @Override
    public Operation getType() {
        return super.getType();
    }
}
