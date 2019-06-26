package com.PracticeJava;

import com.sun.org.apache.regexp.internal.RE;

public final class TrigFunctions extends BaseOperation {
    public TrigFunctions(int value1) {
        super(value1, 0, Operation.TRIG_FUNCTIONS);
    }

    @Override
    public Operation getType() {
        return super.getType();
    }

    public double getSin(){
        return Math.sin(getValue1());
    }

    public double getCos(){
        return Math.cos(getValue1());
    }

    public double getTan(){
        return Math.tan(getValue1());
    }

    public double getArcSin(){
        return Math.asin(getValue1());
    }

    public double getArcCos(){
        return Math.acos(getValue1());
    }

    public double getArcTan(){
        return Math.atan(getValue1());
    }

    public static double getDegrees(double value){
        return (value * 180) / Math.PI;
    }
}
