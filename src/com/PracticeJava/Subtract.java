package com.PracticeJava;

public final class Subtract extends BaseOperation {
    public Subtract(int value1, int value2) {
        super(value1, value2, Operation.SUBTRACT);
    }

    public int Subtract(){
        return getValue1() - getValue2();
    }

    @Override
    public Operation getType() {
        return super.getType();
    }
}

