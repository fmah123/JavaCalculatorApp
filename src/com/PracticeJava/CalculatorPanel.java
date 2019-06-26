package com.PracticeJava;

public final class CalculatorPanel {
   private static CalculatorPanel instance = null;
   private int output;
    private CalculatorPanel(){}

    public static CalculatorPanel getCalculatorPanel(){
        //use of this simpleton will prevent more than one instance being initialised.
        if(instance == null){
            instance = new CalculatorPanel();
        }

        return instance;
    }

    public boolean CalculatorOn(boolean on){
        //Simple method to simulate a working calculator,
        return on?true:false;
    }

    public synchronized int ResetCalculator(){
        output = 0;
        return output;
    }

    public int CalculationChaining(String type, int value, int previousValue){
        return Calculation(type, previousValue, value);
    }

    public boolean isTrigFunction(String type){
        if(type.toLowerCase().equals("sin()")){
            return true;
        } else if(type.toLowerCase().equals("cos()")){
            return true;
        } else if(type.toLowerCase().equals("tan()")){
            return true;
        } else {
            return false;
        }
    }

    public double Calculation(String type, int value){
        TrigFunctions trigFunctions;
        double output = 0;

        if(type.toLowerCase().equals("sin()")){
            trigFunctions = new TrigFunctions(value);
            output = trigFunctions.getSin();
            return output;
        } else if(type.toLowerCase().equals("cos()")){
            trigFunctions = new TrigFunctions(value);
            output = trigFunctions.getCos();
            return output;
        } else if(type.toLowerCase().equals("tan()")){
            trigFunctions = new TrigFunctions(value);
            output = trigFunctions.getTan();
            return output;
        } else if(type.toLowerCase().equals("asin()")){
            trigFunctions = new TrigFunctions(value);
            output = trigFunctions.getArcSin();
            return output;
        } else if(type.toLowerCase().equals("acos()")){
            trigFunctions = new TrigFunctions(value);
            output = trigFunctions.getArcCos();
            return output;
        } else if(type.toLowerCase().equals("atan()")){
            trigFunctions = new TrigFunctions(value);
            output = trigFunctions.getArcTan();
            return output;
        }else {
            return output;
        }
    }

    public double inDegreesTrig(double value){
        return TrigFunctions.getDegrees(value);
    }

    public synchronized int Calculation(String type, int value1, int value2){
        if(type.toLowerCase().equals("x") || type.toLowerCase().equals("multiply") || type.toLowerCase().equals("*")){
            Multiply multiply = new Multiply(value1, value2);
            output = multiply.Multiply();
        }else if(type.equals("/") || type.toLowerCase().equals("subtract")){
            Divide divide = new Divide(value1, value2);
            output = divide.Divide();
        }else if(type.equals("+") || type.toLowerCase().equals("add")){
            Add add = new Add(value1, value2);
            output = add.Add();
        }else if(type.equals("-") || type.toLowerCase().equals("divide")){
            Subtract subtract = new Subtract(value1, value2);
            output = subtract.Subtract();
        }else{
            System.out.println("Invalid character enter a correct arithematic operator + - * /");
        }

        return output;
    }
}
