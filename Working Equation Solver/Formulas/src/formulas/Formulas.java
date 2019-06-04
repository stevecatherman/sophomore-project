package formulas;

import java.util.*;
//test

public class Formulas {

    public static String[] solveEquations(String[] numbers) {
        String initVeloc = numbers[0];
        String finalVeloc = numbers[1];
        String accel = numbers[2];
        String initTime = numbers[3];
        String finalTime = numbers[4];
        String initDisp = numbers[5];
        String finalDisp = numbers[6];
        String totalTime = null;
        String totalDisp = null;

        int timesToRun = 9;//number of times the for loop has to run

        //these check which variables are input. For each variable input, the for loop will run one less time.
        if (initVeloc != null) {
            timesToRun--;
        }
        if (finalVeloc != null) {
            timesToRun--;
        }
        if (accel != null) {
            timesToRun--;
        }
        if (initTime != null) {
            timesToRun--;
        }
        if (finalTime != null) {
            timesToRun--;
        }
        if (initDisp != null) {
            timesToRun--;
        }
        if (finalDisp != null) {
            timesToRun--;
        }

        /*
        The for loop that does the calculation. Checks which variables are null or not
        and calculates them accordingly.
         */
        for (int i = 1; i <= timesToRun; i++) {
            
            if (totalTime == null && finalTime != null) {
                totalTime = Equations.calculateTimeDifference(finalTime, initTime);
            } 
            else if (totalTime == null && finalVeloc != null && accel != null) {
                totalTime = Equations.calculateTime(finalVeloc, initVeloc, accel);
            } 
            else if (totalDisp == null && finalDisp != null) {
                totalDisp = Equations.calculateDisplacement(finalDisp, initDisp);
            } 
            else if (totalDisp == null && accel != null && totalTime != null) {
                totalDisp = Equations.calculateDisplacement2(accel, initVeloc, totalTime);
            } 
            else if (totalDisp == null && finalVeloc != null && totalTime != null) {
                totalDisp = Equations.calculateDisplacement3(finalVeloc, initVeloc, totalTime);
            } 
            else if (totalDisp == null && finalVeloc != null && accel != null) {
                totalDisp = Equations.calculateDisplacement4(finalVeloc, initVeloc, accel);
            }
            else if (finalVeloc == null && accel != null && totalTime != null){
                finalVeloc = Equations.calculateFinalVelocity(initVeloc, accel, totalTime);
                numbers[1] = finalVeloc;
            }
            else if (initVeloc == null && finalVeloc != null && accel != null && totalTime != null){
                initVeloc = Equations.calculateInitialVelocity(finalVeloc, accel, totalTime);
                numbers[0] = initVeloc;
            }
            else if(accel == null && finalVeloc != null && totalTime != null){
                accel = Equations.calculateAcceleration(finalVeloc, initVeloc, totalTime);
                numbers[2] = accel;
            }
            else{
                i = timesToRun;
            }

        }
        return numbers;
    }

    public static void main(String[] args) {

        //The array of strings used for input.
        String[] numbers = new String[7];
        numbers[0] = "2";
        numbers[1] = "4";
        numbers[4] = "4";

        String numbersFunction[] = Formulas.solveEquations(numbers);
        for (int i = 0; i <= numbersFunction.length - 1; i++) {
            System.out.println(numbersFunction[i]);
        }
    }

}
