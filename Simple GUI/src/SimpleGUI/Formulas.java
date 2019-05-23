package SimpleGUI;

import java.util.*;

public class Formulas {
    public String calcAcceleration(String dV, String t) { //a=∆v/t
        String acceleration;
        if (dV.isEmpty() == true || t.isEmpty() == true) {//checks if there is empty input
            acceleration = "N/A";
        }//end if
        else{
            double changeInVelocity = Double.parseDouble(dV);//casting input dV as a double value using parse
            double time = Double.parseDouble(t);//casting input t as a double value using parse
            double acc = changeInVelocity / time;//formula
            acceleration = Double.toString(acc);//casting acc from double to string for output
        }//end if-else

        return acceleration;//returns the string value for acceleration
    }//end calcAcceleration method
}//end Formulas class