package SimpleGUI;

import java.net.URL;
import java.util.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import java.io.*;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.scene.control.Alert.*;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class FXMLDocumentController implements Initializable {
    
    private final Alert numberEntryAlert = new Alert(AlertType.INFORMATION);

    //Input and output text
    @FXML private TextField velocityText;
    @FXML private TextField accelerationText;
    @FXML private TextField timeText;

    @FXML private Label velocityLabel;
    @FXML private Label accelerationLabel;
    @FXML private Label timeLabel;

    String velocityString;
    String accelerationString;
    String timeString;

    //Action buttons
    @FXML private Button calcButton;
    @FXML private Button enterButton;
    @FXML private Button clearButton; 

    //Entries converted to numbers
    double velocity;
    double acceleration;
    double time;
    
    @Override public void initialize(URL url, ResourceBundle rb) {        
        //Warning message if entries are not valid numbers
        numberEntryAlert.setTitle("Alert Message");
        numberEntryAlert.setHeaderText(null);              
    }//end constructor  
    
    //Enter button takes entered values and puts them into formulas
    @FXML private void enterButtonListener(ActionEvent event){
        
        //Error check user entries to make sure they are valid numbers
        ErrorCheck velocityError = new ErrorCheck();
        velocityString = velocityError.variableEntry(velocityText.getText());
        ErrorCheck accelerationError = new ErrorCheck();
        accelerationString = accelerationError.variableEntry(accelerationText.getText());
        ErrorCheck timeError = new ErrorCheck();
        timeString = timeError.variableEntry(timeText.getText()); 
        
        //Produce warning if entries are invalid
        if(velocityString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers for velocity.");
            numberEntryAlert.showAndWait();
            velocityText.setText("");
        }//end if     
        if(accelerationString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers for acceleration.");
            numberEntryAlert.showAndWait();
            accelerationText.setText("");
        }//end else if 
        if(timeString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers for time.");
            numberEntryAlert.showAndWait();
            timeText.setText("");
        }//end else if
        
        if(velocityString == "bad" || accelerationString == "bad" || timeString == "bad"){
            return;
        }//end if
        
        //Enter numbers if they are valid
        else {
            velocityLabel.setText(velocityString);         
            accelerationLabel.setText(accelerationString); 
            timeLabel.setText(timeString);                       

            //velocity = Double.parseDouble(velocityString);
            //acceleration = Double.parseDouble(accelerationString);
            //time = Double.parseDouble(timeString);
        }//end if else                     
    }//end enterButtonListner method
    
    //Calculates answer
    @FXML private void calcButtonListener(ActionEvent event) {
        Formulas accelerationFormula = new Formulas();
        velocityString = velocityLabel.getText();
        timeString = timeLabel.getText();
        
        accelerationString = accelerationFormula.calcAcceleration(velocityString, timeString);
        accelerationLabel.setText(accelerationString);        
    }//end calcButtonListener method

    //Clears entries, resets units
    @FXML private void clearButtonListener(ActionEvent event) {

        velocityText.setText("");
        velocityLabel.setText("");

        accelerationText.setText("");
        accelerationLabel.setText("");

        timeText.setText("");
        timeLabel.setText("");    
    }//end clearButtonListener method
}//end DocumentController
