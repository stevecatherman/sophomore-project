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
    //XF = final position, XF = initial 
    public static String calculateDisplacement(String XF, String XI) { 
        String D;
        double d;
        double xf = Double.parseDouble(XF);//casting input XF as a double value using parse
        double xi = Double.parseDouble(XI);//casting input XI as a double value using parse
        d =  xf - xi;    //Displacement = Final Pos - Initial Pos
        D = Double.toString(d);//casting d from double to string D for output

        return D;//returns the string value for D
    }
    
    //Calculates Displacement when given Acceleration, Initial Velocity, and Time.
    //A = Acceleration, VI= Initial Velocity, T=Time
    public static String calculateDisplacement2(String A, String VI, String T) { 
        String D;
        double d;
        double a = Double.parseDouble(A);//casting input A as a double value using parse
        double vi = Double.parseDouble(VI); //casting input VI as a double value using parse
        double t = Double.parseDouble(T);//casting input T as a double value using parse
        d = (vi*t)+(.5*a*Math.pow(t,2));//d = vi*t + (1/2)at^2

        D = Double.toString(d);//casting d from double to string D for output

        return D;//returns the string value for D
    }
    
      //Calculates Displacement when given Initial Velcoity, Final Velocity, and Time. 
      //V = Final Velocity, VI= Initial Velocity, T=Time
      public static String calculateDisplacement3(String V, String VI, String T) { 
        String D;
        double d;
        double v = Double.parseDouble(V);//casting input V as a double value using parse
        double vi = Double.parseDouble(VI); //casting input VI as a double value using parse
        double t = Double.parseDouble(T);//casting input T as a double value using parse
        d = ((v+vi)/2)*t;  // d=((v+vi)/2)t
        D = Double.toString(d);//casting d from double to string D for output
        return D;//returns the string value for D
      }
      
      //Calculates Displacement when given Final Velocity, Initial Velocity, and Acceleration
      //V = Final Velocity, VI= Initial Velocity, A = Acceleration
      public static String calculateDisplacement4(String V, String VI, String A) { 
        String D;
        double d;
        double v = Double.parseDouble(V);//casting input V as a double value using parse
        double vi = Double.parseDouble(VI); //casting input VI as a double value using parse
        double a = Double.parseDouble(A);//casting input T as a double value using parse
        d = (Math.pow(v, 2)- Math.pow(vi, 2))/ (2*a);  // d = (v^2 - vi^2) / 2a
        D = Double.toString(d);//casting d from double to string D for output
        return D;//returns the string value for D
      }

public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
