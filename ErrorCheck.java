package PhysicsCalculator;

public class ErrorCheck {
    
    public String variableEntry(String entry){
        String good = "";
        
        //Error checking entry
        int forceSum = 0;
        int decimalSum = 0;        

        for(int i = 0; i < entry.length(); i++){
            forceSum += (int)entry.charAt(i);

            if((int)entry.charAt(i) == 46){
                decimalSum += 1;
            }//end if

            if((int)entry.charAt(i) < 46 || (int)entry.charAt(i) > 57 || (int)entry.charAt(i) == 47){
                good = "bad";
            }//end if
        }//end for loop

        if(forceSum == 46 || decimalSum > 1){
            good = "bad";
        }//end if
        
        if(good != "bad"){
            if(entry.contains(".")){               
                if(entry.charAt(0) == '.'){
                    good = '0' + entry;
                }//end if
                else if(entry.charAt(entry.length() - 1) == '.'){
                    good = entry + '0';
                }//end else if
                else{
                    good = entry;
                }//end if else
            }//end if
            else if(entry.length() > 0){
                good = entry + ".0";
            }//end else if
        }//end if

        
        return good;
    }//end variable Entry method
    
}//end ErrorCheck class
