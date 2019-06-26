package com.PracticeJava;

public final class Multiply extends BaseOperation {
    public Multiply(int value1, int value2) {
        super(value1, value2, Operation.MULTIPLY);
    }

    public int Multiply(){
        return getValue1() * getValue2();
    }

    @Override
    public Operation getType() {
        return super.getType();
    }
}
