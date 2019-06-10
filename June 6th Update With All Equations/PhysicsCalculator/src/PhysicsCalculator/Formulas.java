
package PhysicsCalculator;



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
            else if (initDisp == null && totalDisp != null && finalDisp != null) {
                initDisp = Equations.calculateInitialPosition(totalDisp, finalDisp);
            }
            else if (initDisp == null && accel != null && initVeloc != null && totalTime != null
                    && finalDisp !=null) {
                initDisp = Equations.calculateInitialPosition2(accel, initVeloc, totalTime, finalDisp);
            }
            else if (initDisp == null && finalVeloc != null && initVeloc != null && totalTime != null
                    && finalDisp !=null) {
                initDisp = Equations.calculateInitialPosition3(finalVeloc, initVeloc, totalTime, finalDisp);
            }
            else if (initDisp == null && finalVeloc != null && initVeloc != null && accel != null
                    && finalDisp !=null) {
                initDisp = Equations.calculateInitialPosition4(accel, initVeloc, totalTime, finalDisp);
            }
            else if (finalDisp == null && totalDisp != null && initDisp != null) {
                finalDisp = Equations.calculateFinalPosition(totalDisp, initDisp);
            }
            else if (finalDisp == null && accel != null && initVeloc != null && totalTime != null
                    && initDisp !=null) {
                finalDisp = Equations.calculateFinalPosition2(accel, initVeloc, totalTime, initDisp);
            }
            else if (finalDisp == null && finalVeloc != null && initVeloc != null && totalTime != null
                    && initDisp !=null) {
                finalDisp = Equations.calculateFinalPosition3(finalVeloc, initVeloc, totalTime, initDisp);
            }
            else if (finalDisp == null && finalVeloc != null && initVeloc != null && accel != null
                    && initDisp !=null) {
                finalDisp = Equations.calculateFinalPosition4(finalVeloc, initVeloc, accel, initDisp);
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


}