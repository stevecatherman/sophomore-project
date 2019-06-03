/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equations;

/**
 *
 * @author mpeace
 */
public class Equations {
    
    //Calculates Displacement when given Initial and Final Position
    public static String calculateDisplacement(String XF, String XI) { //Calculate Displacement. XF = final position, XF = initial 
        String D;
        double d;
        double xf = Double.parseDouble(XF);//casting input XF as a double value using parse
        double xi = Double.parseDouble(XI);//casting input XI as a double value using parse
        d =  xf - xi;    //Displacement = Final Pos - Initial Pos
        D = Double.toString(d);//casting d from double to string D for output

        return D;//returns the string value for D
    }
    
    //Calculates Displacement when given acceleration, Initial Velocity, and Time.
    public static String calculateDisplacement2(String A, String VI, String T) { //Calculate Displacement. A = Acceleration, VI= Initial Velocity, T=Time
        String D;
        double d;
        double a = Double.parseDouble(A);//casting input A as a double value using parse
        double vi = Double.parseDouble(VI); //casting input VI as a double value using parse
        double t = Double.parseDouble(T);//casting input T as a double value using parse
        d = (vi*t)+(.5*a*Math.pow(t,2));//d = vi*t + (1/2)at^2

        D = Double.toString(d);//casting d from double to string D for output

        return D;//returns the string value for D
    }
    
      //Calculates the Final Position when given Final Velocity, Initial Velocity, and Time. 
      public static String calculateDisplacement3(String V, String VI, String T) { //Calculate Displacement. V = Final Velocity, VI= Initial Velocity, T=Time
        String D;
        double d;
        double v = Double.parseDouble(V);//casting input V as a double value using parse
        double vi = Double.parseDouble(VI); //casting input VI as a double value using parse
        double t = Double.parseDouble(T);//casting input T as a double value using parse
        d = ((v+vi)/2)*t;  // d=((v+vi)/2)t
        D = Double.toString(d);//casting d from double to string D for output
        return D;//returns the string value for D
      }

public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
