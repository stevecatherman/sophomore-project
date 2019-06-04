/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulas;

public class Equations {

    //Calculates Displacement when given Initial and Final Position
    //XF = final position, XF = initial 
    public static String calculateDisplacement(String XF, String XI) {
        String D;
        double d;
        double xf = Double.parseDouble(XF);//casting input XF as a double value using parse
        double xi;
        if (XI != null) {
            xi = Double.parseDouble(XI);//casting input XI as a double value using parse
        } else {
            xi = 0;
        }
        
        d = xf - xi;    //Displacement = Final Pos - Initial Pos
        D = Double.toString(d);//casting d from double to string D for output

        return D;//returns the string value for D
    }

    //Calculates Displacement when given Acceleration, Initial Velocity, and Time.
    //A = Acceleration, VI= Initial Velocity, T=Time
    public static String calculateDisplacement2(String A, String VI, String T) {
        String D;
        double d;
        double a = Double.parseDouble(A);//casting input A as a double value using parse
        double vi;
        if (VI != null) {
            vi = Double.parseDouble(VI);//casting input VI as a double value using parse
        } else {
            vi = 0;
        }
        
        double t = Double.parseDouble(T);//casting input T as a double value using parse
        d = (vi * t) + (.5 * a * Math.pow(t, 2));//d = vi*t + (1/2)at^2

        D = Double.toString(d);//casting d from double to string D for output

        return D;//returns the string value for D
    }

    //Calculates Displacement when given Initial Velcoity, Final Velocity, and Time. 
    //V = Final Velocity, VI= Initial Velocity, T=Time
    public static String calculateDisplacement3(String VF, String VI, String T) {
        String D;
        double d;
        double vf;
        if (VF != null) {
            vf = Double.parseDouble(VF);//casting input VF as a double value using parse
        } else {
            vf = 0;
        }
        
        double vi;
        if (VI != null) {
            vi = Double.parseDouble(VI);//casting input VI as a double value using parse
        } else {
            vi = 0;
        }
        
        double t = Double.parseDouble(T);//casting input T as a double value using parse
        d = ((vf + vi) / 2) * t;  // d=((v+vi)/2)t
        D = Double.toString(d);//casting d from double to string D for output
        return D;//returns the string value for D
    }

    //Calculates Displacement when given Final Velocity, Initial Velocity, and Acceleration
    //V = Final Velocity, VI= Initial Velocity, A = Acceleration
    public static String calculateDisplacement4(String VF, String VI, String A) {
        String D;
        double d;
        double vf;
        if (VF != null) {
            vf = Double.parseDouble(VF);//casting input VF as a double value using parse
        } else {
            vf = 0;
        }
        
        double vi;
        if (VI != null) {
            vi = Double.parseDouble(VI);//casting input VI as a double value using parse
        } else {
            vi = 0;
        }
        
        double a = Double.parseDouble(A);//casting input A as a double value using parse
        d = (Math.pow(vf, 2) - Math.pow(vi, 2)) / (2 * a);  // d = (v^2 - vi^2) / 2a
        D = Double.toString(d);//casting d from double to string D for output
        return D;//returns the string value for D
    }

    //calculate time using final velocity, initial velocity and acceleration
    //VF = final velocity, VI = initial velocity, A = acceleration
    public static String calculateTime(String VF, String VI, String A) {
        String T;
        double t;
        double vf;
        if (VF != null) {
            vf = Double.parseDouble(VF);//casting input VF as a double value using parse
        } else {
            vf = 0;
        }
        
        double vi;
        if (VI != null) {
            vi = Double.parseDouble(VI);//casting input VI as a double value using parse
        } else {
            vi = 0;
        }
        
        double a = Double.parseDouble(A);//casting input A  as a double value using parse   
        t = ((vf - vi) / a);//formula for time final velocity - initial velocity  / acceleration
        T = Double.toString(t);//casting t from double to string T for output

        return T;//returns the string value for T 
    }

    //Calculate average time when given final time and initial time
    //TF = final time, TI = initial time
    public static String calculateTimeDifference(String TF, String TI) {
        String T;
        double t;
        double tf = Double.parseDouble(TF);//casting input tf as a double value using parse
        double ti;
        if (TI == null) {
            ti = 0;//casting input VI as a double value using parse
        } else {
            ti = Double.parseDouble(TI);
        }
        
        t = tf - ti;//formula for average time, final time - initial time
        T = Double.toString(t);//casting t from double to string T for output

        return T;//returns the string value for T
    }

    //Calculate acceleration when given final velocity, initial velocity, final time and initial time 
    //VF = final velocity, VI = inital velocity, TF = final time, TI = initial time
    public static String calculateAcceleration(String VF, String VI, String T) {
        String A;
        double a;
        double vf;
        if (VF != null) {
            vf = Double.parseDouble(VF);//casting input VF as a double value using parse
        } else {
            vf = 0;
        }
        
        double vi;
        if (VI != null) {
            vi = Double.parseDouble(VI);//casting input VI as a double value using parse
        } else {
            vi = 0;
        }
        
        double t = Double.parseDouble(T);//casting input tf as a double value using parse
        a = (vf - vi) / (t);//formula acceleration final velocity - initial velocity / final time - initial time
        A = Double.toString(a);//casting a from double to string A for output

        return A;//returns the string value for A
    }

    //Steven J - 6/4/29
    //Calculates Final Velocity when given Initial Velocity, Acceleration and Time
    //U = Initial Velocity, A = Acceleration, T = Time
    public static String calculateFinalVelocity(String VI, String A, String T) {
        String VF;
        double vf;
        double vi;
        if (VI != null) {
            vi = Double.parseDouble(VI);//casting input VI as a double value using parse
        } else {
            vi = 0;
        }
        
        double t = Double.parseDouble(T);//casting input T as a double value using parse
        double a = Double.parseDouble(A);//casting input A as a double value using parse
        vf = vi + a * t;    //Final Velocity = Initial Velocity + Acceleration*(time)
        VF = Double.toString(vf);//casting v from double to string V for output

        return VF;//returns the string value for V
    }

    //Steven J - 6/4/29
    //Calculates Initial Velocity when given Final Velocity, Acceleration and Time
    //Final Velocity = V, A = Acceleration, T = Time
    public static String calculateInitialVelocity(String VF, String A, String T) {
        String VI;
        double vi;
        double vf;
        if (VF != null) {
            vf = Double.parseDouble(VF);//casting input VF as a double value using parse
        } else {
            vf = 0;
        }
        
        double t = Double.parseDouble(T);//casting input T as a double value using parse
        double a = Double.parseDouble(A);//casting input A as a double value using parse
        vi = vf - a * t;    //Initial Velocity = Final Velocity - Acceleration*(time)
        VI = Double.toString(vi);//casting vi from double to string VI for output

        return VI;//returns the string value for U
    }

}
