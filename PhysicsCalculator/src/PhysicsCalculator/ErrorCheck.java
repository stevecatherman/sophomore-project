package PhysicsCalculator;

//Checks to make sure user has entered a valid number
//Returns "bad" if they have not
//Returns String that is formatted as double, if they have
public class ErrorCheck {
    
    public String variableEntry(String originalEntry){
        String good = null;
        int forceSum = 0;
        int decimalSum = 0;
        int dashSum = 0;
        boolean negative = false;
        String negativeEntry;
        String entry = originalEntry;

        //If entry contains "-"
        //Count how many "-" there are
        if(originalEntry.contains("-")){
            for(int i = 0; i < originalEntry.length(); i++){
                if (originalEntry.charAt(i) == '-'){
                    dashSum++;
                }//end if
            }//end for
            
            //If there is only 1 "-" and it is the first character
            //remove the "-" and mark it as a negative number
            if(dashSum == 1 && originalEntry.charAt(0) == '-'){
                negative = true;
                negativeEntry = originalEntry.substring(1, originalEntry.length());
                entry = negativeEntry;
            }//end if
        }//end if
        
        
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
            
            if(negative == true){
                good = "-" + good;
            }//end if
        }//end if
       
            return good;

    }//end variable Entry method
    
}//end ErrorCheck class
