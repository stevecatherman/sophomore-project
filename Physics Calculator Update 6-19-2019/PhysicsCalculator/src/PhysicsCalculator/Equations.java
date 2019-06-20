//June 13, 2019 4:07 PM


package PhysicsCalculator;



public class Equations {

    

    //Calculates Initial Position given Final Position and Displacement
    //XF = final position, XI = Initial Position, D = Displacement
    public static String calculateInitialPosition(String D, String XF) {
        String XI;
        double xi;
        double xf = Double.parseDouble(XF);//casting input XF as a double value using parse
        double d = Double.parseDouble(D); //casting input D as a double value using parse
        
        xi = xf - d; //Initial Position = Final Pos - Displacement
        XI = Double.toString(xi);//casting xi from double to string XI for output

        return XI;//returns the string value for XI
    }
 
    //Calculates Initial Position when given acceleration, initial velocity, time, and final position
    //A = Acceleration, VI = Initial Velocity, T = Time, XF = Final Position, XI = Initial Position
    public static String calculateInitialPosition2(String A, String VI, String T, String XF) {
        String XI;
        double xi;
        double a = Double.parseDouble(A);//casting input A as a double value using parse
        double xf = Double.parseDouble(XF);
        double vi;
        if (VI != null) {
            vi = Double.parseDouble(VI);//casting input VI as a double value using parse
        } else {
            vi = 0;
        }
        
        double t = Double.parseDouble(T);//casting input T as a double value using parse
        xi = (-vi * t) - (a * Math.pow(t, 2)/2) + xf;  //Initial pos = -velocity*time - (accleration * time^2)/2 + xf

        XI = Double.toString(xi);//casting xi from double to string XI for output

        return XI;//returns the string value for XI
    }
    
    //Calculates Initial Position when given Initial Velcoity, Final Velocity, Final Position,and Time. 
    //V = Final Velocity, VI= Initial Velocity, T=Time, XI= Initial Position, XF = Final Position
    public static String calculateInitialPosition3(String VF, String VI, String T, String XF) {
        String XI;
        double xi;
        double vf;
        if (VF != null) {
            vf = Double.parseDouble(VF);//casting input VF as a double value using parse
        } else {
            vf = 0;
        }
        
        double xf = Double.parseDouble(XF);
        
        double vi;
        if (VI != null) {
            vi = Double.parseDouble(VI);//casting input VI as a double value using parse
        } else {
            vi = 0;
        }
      
        double t = Double.parseDouble(T);//casting input T as a double value using parse
        xi = -1 * ((t*vf)+(t*vi)-(2*t))/ 2;  
        XI = Double.toString(xi);//casting xi from double to string XI for output
        return XI;//returns the string value for XI
    }
    
    
    //Calculates Initial Position when given Final Velocity, Initial Velocity, Acceleration, and Final Position
    // VF = Final Velocity, VI = Initial Velocity, A = Acceleration, XF = Final Position, XI = Initial Position
    public static String calculateInitialPosition4(String VF, String VI, String A, String XF) {
        String XI;
        double xi;
        double vf;
        double xf = Double.parseDouble(XF); //casting input XF as a double value using parse
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
        xi = -1 * ((Math.pow(vf, 2) - Math.pow(vi, 2) - (2*xf*a))/(2*a));  // xi = -(v^2 - vi^2 - 2*xf*a) / 2a
        XI = Double.toString(xi);//casting xi from double to string XI for output
        return XI;//returns the string value for XI
    }
    
    
    //Calculates Final Position given Inital Position and Displacement
    //XI = Initial position, XF = Final Position, D = Displacement 
    public static String calculateFinalPosition(String D, String XI) {
        String XF;
        double xf;
        double xi;
        if (XI != null) {
            xi = Double.parseDouble(XI);//casting input XI as a double value using parse
        } else {
            xi = 0;
        }
        double d = Double.parseDouble(D); //casting input D as a double value using parse
        
        xf = d + xi; //Final Position = Displacement + Initial Position
        XF = Double.toString(xf);//casting xf from double to string XF for output

        return XF;//returns the string value for XF
    }
    
    //Calculates Final position when given Acceleration, Initial Velocity, Time, and Initial Position
    //A = Acceleration, VI = Initial Velocity, T = Time, XI = Initial Position, XF = Final Position
    public static String calculateFinalPosition2(String A, String VI, String T, String XI) {
        String XF;
        double xf;
        double a = Double.parseDouble(A);//casting input A as a double value using parse
        double xi;
        if (XI != null) {
            xi = Double.parseDouble(XI);//casting input XI as a double value using parse
        } else {
            xi = 0;
        }
        
        double vi;
        if (VI != null) {
            vi = Double.parseDouble(VI);//casting input VI as a double value using parse
        } else {
            vi = 0;
        }
        double t = Double.parseDouble(T);//casting input T as a double value using parse
        xf = (vi * t) + (.5 * a * Math.pow(t, 2)) + xi;  //Initial pos = velocity*time +(accleration * time^2)/2 + xi

        XF = Double.toString(xf);//casting xf from double to string XF for output

        return XF;//returns the string value for D
    }
    
    //Calculates Final Position when given Final Velocity, Initial Velocity, Time, and Initial Position
    //VF = Final Velocity, VI = Initial Velocity, T = Time, XI = Initial Position
    public static String calculateFinalPosition3(String VF, String VI, String T, String XI) {
        String XF;
        double xf;
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
        xf = ((t*vf)+(t*vi)+(2*t))/ 2;  
        XF = Double.toString(xf);//casting xf from double to string XF for output
        return XF;//returns the string value for XF
    }
    
    
    //Calculates Final Position when given Final Velocity, Initial Velocity, Acceleration, and Initial Position
    // VF = Final Velocity, VI = Initial Velocity, A = Acceleration, XF = Final Position, XI = Initial Position
    public static String calculateFinalPosition4(String VF, String VI, String A, String XI) {
        String XF;
        double xf;
        double vf;
        double xi;
        if (XI != null) {
            xi = Double.parseDouble(XI);//casting input XI as a double value using parse
        } else {
            xi = 0;
        }
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
        xf = (Math.pow(vf, 2) - Math.pow(vi, 2) + (2*xi*a))/(2*a);  // xf = (v^2 - vi^2 - 2*xi*a) / 2a
        XF = Double.toString(xf);//casting xf from double to string XF for output
        return XF;//returns the string value for XF
    }
    
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
        double ti = Double.parseDouble(TI);
//        if (TI == null) {
//            ti = 0;//casting input VI as a double value using parse
//        } else {
//            ti = Double.parseDouble(TI);
//        }
        
        t = tf - ti;//formula for average time, final time - initial time
        T = Double.toString(t);//casting t from double to string T for output

        return T;//returns the string value for T
    }
    
    public static String calculateFinalTime(String VF, String VI, String A, String TI){
        String TF;
        double tf;
        double vf = Double.parseDouble(VF);
        double vi = Double.parseDouble(VI);
        double a = Double.parseDouble(A);
        double ti = Double.parseDouble(TI);
        
        tf = ((vf-vi)/a) + ti;
        TF = Double.toString(tf);
        
        return TF;
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
    
    //Calculates Acceleration when given Force and Mass.
    //F = Force, M = Mass
    public static String calculateAccleration2(String F, String M){
        String A;
        double a;
        double f = Double.parseDouble(F);
        double m = Double.parseDouble(M);
        a = f/m;  //Acceleration = Force / Mass
        A = Double.toString(a);
        
        return A; //Return string value for A
    }
    

    //Steven J - 6/4/19
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

        return VF;//returns the string value for VF
    }

    //Steven J - 6/4/19
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

        return VI;//returns the string value for VI
    }
    //Steven J - 6/5/19
    //Calculates Velocity when given Final Position, Initial Position and Time
    //Displacement = D, Time = T
    public static String calculateAvgVelocity(String D, String T) {
        String V;
        double v;
        double d = Double.parseDouble(D);
        double t = Double.parseDouble(T);//casting input T as a double value using parse
        
        v = d / t;    // AvgVelocity = (Final Position - Initial Position)/ time
        V = Double.toString(v);//casting v from double to string V for output

        return V;//returns the string value for V
    }
    
    //Calculates total Displacement when given avg velocity and change in time
    //V = avg Velocity, T = Total Time
    public static String calculateDisplacement5(String V, String T) {
        String D;
        double d;
        double v = Double.parseDouble(V);//casting input V as a double value using parse
        double t = Double.parseDouble(T);//casting input T as a double value using parse
        
        d = v * t;    // Displacement = AvgVelocity * time
        D = Double.toString(v);//casting d from double to string D for output

        return D;//returns the string value for D
    }
    
    //Calculates Total Time when given total Displacement and avg velocity
    //D = Total Displacement, V = Avg Velocity
    public static String calculateTotalTime(String D, String V) {
        String T;
        double t;
        double d = Double.parseDouble(D);//casting input D as a double value using parse
        double v = Double.parseDouble(V);//casting input V as a double value using parse
        
        t = d / v;    //Change in Time = Displacement / AvgVelocity
        T = Double.toString(t);//casting v from double to string V for output

        return T;//returns the string value for T
    }
    
    //Calculates Avg Velocity when given Final Velocity and Initial Velocity
    // VF = Final Velocity, VI = InitialVelocity
    public static String calculateAvgVelocity2(String VF, String VI){
        String V;
        double v;
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
        
        v = (vf + vi)/ 2;
        V = Double.toString(v);
        
        return V;
    }
    
    //Calculates Force when given Mass and Acceleration
    // M = Mass, A = Acceleration
    public static String calculateForce(String M, String A){
        String F;
        double f;
        double m = Double.parseDouble(M);
        double a = Double.parseDouble(A);
        f = m*a;  //Force = Mass * Acceleration
        F = Double.toString(f);
        
        return F; //Return string value for F
    }
    
    //Calculates Mass when given Force and Acceleration
    // F = Force, A = Acceleration
    public static String calculateMass(String F, String A){
        String M;
        double m;
        double f = Double.parseDouble(F);
        double a = Double.parseDouble(A);
        m = f/a;  //Mass = Force / Acceleration
        M = Double.toString(m);
        
        return M; //Return string value for M
    }
    
    //Calculates Acceleration when given Force and Mass
    // F = Force, M = Mass
    public static String calculateAccel(String F, String M){
        String A;
        double a;
        double f = Double.parseDouble(F);
        double m = Double.parseDouble(M);
        a = f/m;  //Acceleration = Force / Mass
        A = Double.toString(a);
        
        return M; //Return string value for A
    }
    
}