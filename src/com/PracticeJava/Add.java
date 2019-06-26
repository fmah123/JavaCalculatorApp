package com.PracticeJava;

public final class Add extends BaseOperation{
    public Add(int value1, int value2) {
        super(value1, value2, Operation.ADD);
    }

    public int Add(){
        return getValue1() + getValue2();
    }

    @Override
    public Operation getType() {
        return super.getType();
    }
}
