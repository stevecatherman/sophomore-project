package formulas;

import java.util.*;
//test
public class Formulas {
    
    public static String calculateA(String B, String C) {
        String A;
        double a;
        double b = Double.parseDouble(B);//casting input B as a double value using parse
        double c = Double.parseDouble(C);//casting input C as a double value using parse
        a = c - b;//formula

        A = Double.toString(a);//casting a from double to string A for output

        return A;//returns the string value for A
    }

    public static String calculateB(String A, String C) {
        String B;
        double a = Double.parseDouble(A);//casting input A as a double value using parse
        double b;
        double c = Double.parseDouble(C);//casting input C as a double value using parse
        b = c - a;//formula

        B = Double.toString(b);//casting b from double to string B for output

        return B;//returns the string value for B
    }

    public static String calculateC(String A, String B) {
        String C;
        double a = Double.parseDouble(A);//casting input A as a double value using parse
        double b = Double.parseDouble(B);//casting input B as a double value using parse
        double c;
        c = a + b;//formula

        C = Double.toString(c);//casting c from double to string C for output

        return C;//returns the string value for C
    }

    public static String calculateD(String B, String C) {
        String D;
        double b = Double.parseDouble(B);//casting input B as a double value using parse
        double c = Double.parseDouble(C);//casting input C as a double value using parse
        double d;
        d = b + c;//formula

        D = Double.toString(d);//casting d from double to string D for output

        return D;//returns the string value for D
    }

    public static String calculateB2(String C, String D) {
        String B;
        double b;
        double c = Double.parseDouble(C);//casting input C as a double value using parse
        double d = Double.parseDouble(D);//casting input D as a double value using parse
        b = d - c;//formula

        B = Double.toString(b);//casting b from double to string B for output

        return B;//returns the string value for B
    }

    public static String calculateC2(String B, String D) {
        String C;
        double b = Double.parseDouble(B);//casting input B as a double value using parse
        double c;
        double d = Double.parseDouble(D);//casting input D as a double value using parse
        c = d - b;//formula

        C = Double.toString(c);//casting c from double to string C for output

        return C;//returns the string value for C
    }

    public static String calculateE(String C, String D) {
        String E;
        double c = Double.parseDouble(C);//casting input C as a double value using parse
        double d = Double.parseDouble(D);//casting input D as a double value using parse
        double e;
        e = c + d;//formula

        E = Double.toString(e);//casting e from double to string E for output

        return E;//returns the string value for D
    }

    public static String calculateC3(String D, String E) {
        String C;
        double c;
        double d = Double.parseDouble(D);//casting input D as a double value using parse
        double e = Double.parseDouble(E);//casting input E as a double value using parse
        c = e - d;//formula

        C = Double.toString(c);//casting c from double to string C for output

        return C;//returns the string value for C
    }

    public static String calculateD2(String C, String E) {
        String D;
        double c = Double.parseDouble(C);//casting input C as a double value using parse
        double d;
        double e = Double.parseDouble(E);//casting input E as a double value using parse
        d = e - c;//formula

        D = Double.toString(d);//casting d from double to string D for output

        return D;//returns the string value for D
    }

    public static String[] solveEquations(String[] numbers) {
        String A = numbers[0];
        String B = numbers[1];
        String C = numbers[2];
        String D = numbers[3];
        String E = numbers[4];
        
        int timesToRun = 5;//number of times the for loop has to run

        //these check which variables are input. For each variable input, the for loop will run one less time.
        if (A != null) {
            timesToRun--;
        }
        if (B != null) {
            timesToRun--;
        }
        if (C != null) {
            timesToRun--;
        }
        if (D != null) {
            timesToRun--;
        }
        if (E != null) {
            timesToRun--;
        }

        
        /*
        The for loop that does the calculation. Checks which variables are null or not
        and calculates them accordingly.
        */
        for (int i = 1; i <= timesToRun; i++) {
            if (A != null && B != null && C != null && D != null && E != null) {
                return numbers;
            } else if (A == null && B != null && C != null) {
                A = Formulas.calculateA(B, C);
                numbers[0] = A;

            } else if (B == null && A != null && C != null) {
                B = Formulas.calculateB(A, C);
                numbers[1] = B;

            } else if (C == null && A != null && B != null) {
                C = Formulas.calculateC(A, B);
                numbers[2] = C;

            } else if (D == null && B != null && C != null) {
                D = Formulas.calculateD(B, C);
                numbers[3] = D;

            } else if (B == null && C != null && D != null) {
                B = Formulas.calculateB2(C, D);
                numbers[1] = B;

            } else if (C == null && B != null && D != null) {
                C = Formulas.calculateC2(B, D);
                numbers[2] = C;

            } else if (E == null && C != null && D != null) {
                E = Formulas.calculateE(C, D);
                numbers[4] = E;

            } else if (C == null && D != null && E != null) {
                C = Formulas.calculateC3(D, E);
                numbers[2] = C;

            } else if (D == null && C != null && E != null) {
                D = Formulas.calculateD2(C, E);
                numbers[3] = D;

            }
        }
        return numbers;
    }

    public static void main(String[] args) {
        
        //The array of strings used for input.
        String[] numbers = new String[5];
        numbers[0] = "1";
        numbers[1] = "2";
        
        String numbersFunction[] = Formulas.solveEquations(numbers);
        for (int i = 0; i <= numbersFunction.length-1; i++) {
            System.out.println(numbersFunction[i]);
        }
    }

}
