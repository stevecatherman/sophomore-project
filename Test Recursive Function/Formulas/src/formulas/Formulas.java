package formulas;

import java.util.*;

public class Formulas {

    /*
    Since the GUI can only create string type variables as input, either we can
    cast them as double type variables within each method of each equation, or
    in the beginning of the recursive method(before it starts to run each
    equation).
    This will allow the inputs to be of null value since a double 
    can not be null. 
    Also, the output on the GUI will have to be String type variables or else it
    will only give the memory location of each. 
    So before the numbers are output, we will have to cast them back into String
    variables which will also either be done within each method for each equation 
    or as the recursive method outputs the variables.
    
    For this formula example, I casted the inputs from strings(which would be the
    input from the GUI to the program), into double variables using the parse function.
    Then used the formula to calculate the value of acceleration. And lastly, I 
    casted the double value acc back into a string so it could be output by the GUI.
     */
    public static String calculateA(String A, String B, String C) {
        double a = Double.parseDouble(A);//casting input A as a double value using parse
        double b = Double.parseDouble(B);//casting input B as a double value using parse
        double c = Double.parseDouble(C);//casting input C as a double value using parse
        a = c - b;//formula

        A = Double.toString(a);//casting a from double to string A for output

        return A;//returns the string value for A
    }

    public static String calculateB(String A, String B, String C) {
        double a = Double.parseDouble(A);//casting input A as a double value using parse
        double b = Double.parseDouble(B);//casting input B as a double value using parse
        double c = Double.parseDouble(C);//casting input C as a double value using parse
        b = c - a;//formula

        B = Double.toString(b);//casting b from double to string B for output

        return B;//returns the string value for B
    }

    public static String calculateC(String A, String B, String C) {
        double a = Double.parseDouble(A);//casting input A as a double value using parse
        double b = Double.parseDouble(B);//casting input B as a double value using parse
        double c = Double.parseDouble(C);//casting input C as a double value using parse
        c = a + b;//formula

        C = Double.toString(c);//casting c from double to string C for output

        return C;//returns the string value for C
    }

    public static String calculateD(String B, String C, String D) {
        double b = Double.parseDouble(B);//casting input B as a double value using parse
        double c = Double.parseDouble(C);//casting input C as a double value using parse
        double d = Double.parseDouble(D);//casting input D as a double value using parse
        d = b + c;//formula

        D = Double.toString(d);//casting d from double to string D for output

        return D;//returns the string value for D
    }

    public static String calculateB2(String B, String C, String D) {
        double b = Double.parseDouble(B);//casting input B as a double value using parse
        double c = Double.parseDouble(C);//casting input C as a double value using parse
        double d = Double.parseDouble(D);//casting input D as a double value using parse
        b = d - c;//formula

        B = Double.toString(b);//casting b from double to string B for output

        return B;//returns the string value for B
    }

    public static String calculateC2(String B, String C, String D) {
        double b = Double.parseDouble(B);//casting input B as a double value using parse
        double c = Double.parseDouble(C);//casting input C as a double value using parse
        double d = Double.parseDouble(D);//casting input D as a double value using parse
        c = d - b;//formula

        C = Double.toString(c);//casting c from double to string C for output

        return C;//returns the string value for C
    }

    public static String calculateE(String C, String D, String E) {
        double c = Double.parseDouble(C);//casting input C as a double value using parse
        double d = Double.parseDouble(D);//casting input D as a double value using parse
        double e = Double.parseDouble(E);//casting input E as a double value using parse
        e = c + d;//formula

        E = Double.toString(e);//casting e from double to string E for output

        return E;//returns the string value for D
    }

    public static String calculateC3(String C, String D, String E) {
        double c = Double.parseDouble(C);//casting input C as a double value using parse
        double d = Double.parseDouble(D);//casting input D as a double value using parse
        double e = Double.parseDouble(E);//casting input E as a double value using parse
        c = e - d;//formula

        C = Double.toString(c);//casting c from double to string C for output

        return C;//returns the string value for C
    }

    public static String calculateD2(String C, String D, String E) {
        double c = Double.parseDouble(C);//casting input C as a double value using parse
        double d = Double.parseDouble(D);//casting input D as a double value using parse
        double e = Double.parseDouble(E);//casting input E as a double value using parse
        d = e - c;//formula

        D = Double.toString(d);//casting d from double to string D for output

        return D;//returns the string value for D
    }

    public static String[] recursive(String[] numbers) {
        String A = numbers[0];
        String B = numbers[1];
        String C = numbers[2];
        String D = numbers[3];
        String E = numbers[4];

        if (A != null && B != null && C != null && D != null && E != null) {
            return numbers;
        } else if (A == null && B != null && C != null) {
            A = calculateA(A, B, C);
            numbers[0] = A;
            recursive(numbers);
        } else if (B == null && A != null && C != null) {
            B = calculateB(A, B, C);
            numbers[1] = B;
            recursive(numbers);
        } else if (C == null && A != null && B != null) {
            C = calculateC(A, B, C);
            numbers[2] = C;
            recursive(numbers);
        } else if (D == null && B != null && C != null) {
            D = calculateD(B, C, D);
            numbers[3] = D;
            recursive(numbers);
        } else if (B == null && C != null && D != null) {
            B = calculateB2(B, C, D);
            numbers[1] = B;
            recursive(numbers);
        } else if (C == null && B != null && D != null) {
            C = calculateC2(B, C, D);
            numbers[2] = C;
            recursive(numbers);
        } else if (E == null && C != null && D != null) {
            E = calculateE(C, D, E);
            numbers[4] = E;
            recursive(numbers);
        } else if (C == null && D != null && E != null) {
            C = calculateC3(C, D, E);
            numbers[2] = C;
            recursive(numbers);
        } else if (D == null && C != null && E != null) {
            D = calculateD2(C, D, E);
            numbers[3] = D;
            recursive(numbers);
        } else{
            return numbers;
        }
        
    }

    public static void main(String[] args) {

        String[] numbers = new String[4];
        numbers[0] = "1";
        numbers[1] = "2";
        
        String numbersFunction[] = recursive(numbers);
        for (int i = 0; i <= numbersFunction.length; i++) {
            System.out.println(numbersFunction[i]);
        }

//        String time, velocity, acceleration;//strings for input to the method
//
//        Scanner scan = new Scanner(System.in);
//
//        System.out.println("Enter change in velocity:");
//        velocity = scan.nextLine();//takes input and sets it as the String for velocity
//
//        System.out.println("Enter Time:");
//        time = scan.nextLine();//takes input and sets it to the String for time
//
//        acceleration = calcAcceleration(velocity, time);//runs the function with the input Strings
//
//        System.out.println("Acceleration is: " + acceleration);//output
    }

}
