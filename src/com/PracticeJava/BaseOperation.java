package com.PracticeJava;

class BaseOperation {
    private int value1;
    private int value2;
    private Operation type;

    BaseOperation(int value1,int value2, Operation type) {
        this.value1 = value1;
        this.value2 = value2;
        this.type = type;
    }

    public enum Operation{
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE,
        TRIG_FUNCTIONS
    }

    public Operation getType(){
        return type;
    }

    synchronized int getValue1() {
        return value1;
    }

    synchronized int getValue2() {
        return value2;
    }
}
