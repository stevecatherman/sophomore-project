
package PhysicsCalculator;

public class Converter {

public String metersToFeet(String entry){
    String result = Double.toString(Double.parseDouble(entry) * 3.28084);
    
    return result;
}//end metersToFeet method

public String feetToMeters(String entry){
    String result = Double.toString(Double.parseDouble(entry) / 3.28084);
    
    return result;
}//end metersToFeet method

public String lbToKg(String entry){
    String result = Double.toString(Double.parseDouble(entry) / 2.20462);
    
    return result;
}//end metersToFeet method

public String kgToLb(String entry){
    String result = Double.toString(Double.parseDouble(entry) * 2.20462);
    
    return result;
}//end metersToFeet method

public String NToLb(String entry){
    String result = Double.toString(Double.parseDouble(entry) * 0.22481);
    
    return result;
}//end metersToFeet method

public String lbToN(String entry){
    String result = Double.toString(Double.parseDouble(entry) / 0.22481);
    
    return result;
}//end metersToFeet method

}//end Converter class
