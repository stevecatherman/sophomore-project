//June 13, 2019, 4:07 PM

package PhysicsCalculator;



import java.util.*;
//test

public class Formulas {

    public static String[] solveEquations(String[] numbers) {
        String initVeloc;
        if(numbers[0] != null){
        initVeloc = numbers[0];
        } else{
            initVeloc = "0";
            numbers[0] = initVeloc;
        }
        
        String finalVeloc = numbers[1];
        String accel = numbers[2];
        String initTime;
        if(numbers[3] != null){
            initTime = numbers[3];
        }else{
            initTime = "0";
            numbers[3] = initTime;
        }
        String finalTime = numbers[4];
        String initDisp;
        if(numbers[5] != null){
            initDisp = numbers[5];
        }else{
            initDisp = "0";
            numbers[5] = initDisp;
        }
        String finalDisp = numbers[6];
        String force = numbers[7];
        String mass = numbers[8];
        String totalTime = null;
        String totalDisp = null;
        String avgVeloc = null;

        int timesToRun = 12;//number of times the for loop has to run

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
        if(force != null) {
            timesToRun--;
        }
        if(mass != null) {
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
            else if (initDisp == null && totalDisp != null && finalDisp != null) {
                initDisp = Equations.calculateInitialPosition(totalDisp, finalDisp);
                numbers[5] = initDisp;
            }
            else if (initDisp == null && accel != null && initVeloc != null && totalTime != null
                    && finalDisp !=null) {
                initDisp = Equations.calculateInitialPosition2(accel, initVeloc, totalTime, finalDisp);
                numbers[5] = initDisp;
            }
            else if (initDisp == null && finalVeloc != null && initVeloc != null && totalTime != null
                    && finalDisp !=null) {
                initDisp = Equations.calculateInitialPosition3(finalVeloc, initVeloc, totalTime, finalDisp);
                numbers[5] = initDisp;
            }
            else if (initDisp == null && finalVeloc != null && initVeloc != null && accel != null
                    && finalDisp !=null) {
                initDisp = Equations.calculateInitialPosition4(accel, initVeloc, totalTime, finalDisp);
                numbers[5] = initDisp;
            }
            else if (finalDisp == null && totalDisp != null && initDisp != null) {
                finalDisp = Equations.calculateFinalPosition(totalDisp, initDisp);
                numbers[6] = finalDisp;
            }
            else if (finalDisp == null && accel != null && initVeloc != null && totalTime != null
                    && initDisp !=null) {
                finalDisp = Equations.calculateFinalPosition2(accel, initVeloc, totalTime, initDisp);
                numbers[6] = finalDisp;
            }
            else if (finalDisp == null && finalVeloc != null && initVeloc != null && totalTime != null
                    && initDisp !=null) {
                finalDisp = Equations.calculateFinalPosition3(finalVeloc, initVeloc, totalTime, initDisp);
                numbers[6] = finalDisp;
            }
            else if (finalDisp == null && finalVeloc != null && initVeloc != null && accel != null
                    && initDisp !=null) {
                finalDisp = Equations.calculateFinalPosition4(finalVeloc, initVeloc, accel, initDisp);
                numbers[6] = finalDisp;
            }
            else if (finalVeloc == null && accel != null && totalTime != null){
                finalVeloc = Equations.calculateFinalVelocity(initVeloc, accel, totalTime);
                numbers[1] = finalVeloc;
            }
            else if (initVeloc == null && finalVeloc != null && accel != null && totalTime != null){
                initVeloc = Equations.calculateInitialVelocity(finalVeloc, accel, totalTime);
                numbers[0] = initVeloc;
            }
            else if(accel == null && finalVeloc != null && initVeloc != null && totalTime != null){
                accel = Equations.calculateAcceleration(finalVeloc, initVeloc, totalTime);
                numbers[2] = accel;
            }
            else if(avgVeloc == null && totalDisp != null && totalTime != null){
                avgVeloc = Equations.calculateAvgVelocity(totalDisp, totalTime);
            }
            else if(totalDisp == null && avgVeloc != null && totalTime != null){
                totalDisp = Equations.calculateDisplacement5(avgVeloc, totalTime);
            }
            else if(totalTime == null && totalDisp != null && avgVeloc != null){
                totalTime = Equations.calculateTotalTime(totalDisp, avgVeloc);
            }
            else if(avgVeloc == null && finalVeloc != null && initVeloc != null){
                avgVeloc = Equations.calculateAvgVelocity2(finalVeloc, initVeloc);
            }
            else if(finalTime == null && finalVeloc != null && initVeloc != null && accel != null
                    && initTime!= null){
                finalTime = Equations.calculateFinalTime(finalVeloc, initVeloc, accel, initTime);
                numbers[4] = finalTime;
            }
            else if(force == null && mass != null && accel != null){
                force = Equations.calculateForce(mass, accel);
                numbers[7] = force;
            }
            else if(mass == null && force != null && accel != null){
                mass = Equations.calculateMass(force, accel);
                numbers[8] = mass;
            }
            else if(accel == null && force != null && mass != null){
                accel = Equations.calculateAccel(force, mass);
                numbers[2] = accel;
            }

        }
        return numbers;
    }


}