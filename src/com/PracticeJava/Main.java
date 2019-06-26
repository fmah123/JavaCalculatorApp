    package com.PracticeJava;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static CalculatorPanel panel = CalculatorPanel.getCalculatorPanel();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        /*For this calculator app need to add more features
        * like calculating angles(degrees or radians), logarithms, ..etc (Done)*/
        try {
            // applied some concurrent programming concepts in this calculator app.
            Thread thread = new Thread(() -> {
                    boolean isOn = false;
                    System.out.println("Turn calculator on = true / off = false: ");
                    boolean value = scanner.nextBoolean();
                    if (panel.CalculatorOn(value)) {
                        System.out.println("Calculator is on.");
                        isOn = true;
                    } else {
                        System.out.println("Calculator is off.");
                    }

                    while (isOn) {
                        try {
                            EnteringCalculationParameters();
                            if (isOn) {
                                System.out.println("Do you want to do another calculation? (true/false) ");
                                isOn = scanner.nextBoolean();
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("InputMisMatch error " + e.getMessage());
                        }
                    }
            });

            thread.start();
        }catch (InputMismatchException e){
            System.out.println("InputMisMatch error: " + e.getMessage());
        }
    }

    public static void EnteringCalculationParameters(){
        try{
            int value1;
            String operation;
            int value2;
            int output = 0;
            System.out.println("Enter a first value: ");
            scanner.nextLine();
            value1 = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter an operation: ");
            operation = scanner.nextLine();
            boolean isTrig =panel.isTrigFunction(operation);
            if(!isTrig){
                System.out.println("Enter a second value: ");
                value2 = Integer.parseInt(scanner.nextLine());
                output = panel.Calculation(operation, value1, value2);
                System.out.println("Output = " + output);
            } else{
                double output1 = panel.Calculation(operation, value1);
                System.out.println("Convert to degrees: ");
                boolean isDegrees = scanner.nextBoolean();
                if(isDegrees){
                    output1 = panel.inDegreesTrig(panel.Calculation(operation,value1));
                }
                System.out.println("Output = " + output1);
            }
            panel.ResetCalculator();
            System.out.println("Do you want to chain this calculation: ");
            boolean value = scanner.nextBoolean();
            while(value){
                System.out.println("Enter a value you want to chain: ");
                scanner.nextLine();
                value1 = Integer.parseInt(scanner.nextLine());
                System.out.println("What operation will be usedd: ");
                operation = scanner.nextLine();
                System.out.println("Output = " + panel.CalculationChaining(operation ,output ,value1));
                System.out.println("Do you want to chain this calculation: ");
                value = scanner.nextBoolean();
                System.out.println("Do you want to reset this chain calculation: ");
                boolean isReset = scanner.nextBoolean();
                if(isReset){
                    panel.ResetCalculator();
                }
            }

        }catch (InputMismatchException e){
            System.out.println("InputMisMatch exception: " + e.getMessage());
        }catch (NumberFormatException e){
            System.out.println("NumberFormat exception: " + e.getMessage());
        }
    }
}
