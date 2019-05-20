package javafxapplication10;

import java.net.URL;
import java.util.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import java.io.*;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.scene.control.Alert.*;
import javafx.stage.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class FXMLDocumentController implements Initializable {
    
    private final Alert numberEntryAlert = new Alert(AlertType.INFORMATION);
    
    @FXML private TextField velocityText;
    @FXML private TextField massText;
    @FXML private TextField accelerationText;
    @FXML private TextField timeText;
    @FXML private TextField forceText;
    @FXML private TextField distanceText;

    @FXML private Label velocityLabel;
    @FXML private Label massLabel;
    @FXML private Label accelerationLabel;
    @FXML private Label timeLabel;
    @FXML private Label forceLabel;
    @FXML private Label distanceLabel;
    
    @FXML private Button calcButton;
    @FXML private Button enterButton;
    @FXML private Button helpButton;
    @FXML private Button clearButton;

    @FXML private ImageView step1image;
    private Image step1;
    @FXML private ImageView step2image;
    private Image step2;
    @FXML private ImageView step3image;
    
    double velocity;
    double force;
    double mass;
    double acceleration;
    double time;
    double distance;
    
    String velocityString;
    String forceString;
    String massString;
    String accelerationString;
    String timeString;
    String distanceString;

    String selectedForceUnit;
    
    
    @FXML private ChoiceBox<?> velocityUnits;
    @FXML private ChoiceBox<?> massUnits;
    @FXML private ChoiceBox<?> accelerationUnits;
    @FXML private ChoiceBox<?> timeunits;
    @FXML private ChoiceBox<String> forceUnits;
    @FXML private ChoiceBox<?> distanceUnits;
    

    
    @Override public void initialize(URL url, ResourceBundle rb) {
        
        numberEntryAlert.setTitle("Alert Message");
        numberEntryAlert.setHeaderText(null);
        
        step1 = new Image("images/1.jpg");
        step1image.setImage(step1);
        step2 = new Image("images/2.jpg");
        step2image.setImage(step2);
        step3image.setImage(step2);
        
        //Set up force units choice box - code borrowed from John Damien Smith 5/20/19
        //https://coderanch.com/t/649781/java/Set-values-ChoiceBox-created-Scene
        ObservableList<String> availableChoices = forceUnits.getItems();
        availableChoices = FXCollections.observableArrayList("N"); 
        forceUnits.setItems(availableChoices);
        selectedForceUnit = forceUnits.getSelectionModel().getSelectedItem();

    }//end constructor  
    
    //Enter button takes entered values and puts them into formulas
    @FXML private void enterButtonListener(ActionEvent event){
        ErrorCheck forceError = new ErrorCheck();
        forceString = forceError.variableEntry(forceText.getText());
        
        if(forceString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers.");
            numberEntryAlert.showAndWait();
            forceText.setText("");
            return;
        }//end if
        else{
            forceLabel.setText(forceString);
            force = Double.parseDouble(forceString);
        }//end if else             
        
    }//end enterButtonListner method
    
    //Calculates answer
    @FXML private void calcButtonListener(ActionEvent event) {
        //velocity = Double.parseDouble(velocityText.getText());
        force = Double.parseDouble(forceText.getText());
        mass = Double.parseDouble(massText.getText());
        
        if(accelerationText.getText() == "") acceleration = 0.0;
        else acceleration = Double.parseDouble(accelerationText.getText());
        
        //time = Double.parseDouble(timeText.getText());
        //distance = Double.parseDouble(distanceText.getText());

        if(mass != 0.0 && force !=0.0 /*&& acceleration == 0.0*/){
            acceleration = (double)force / (double)mass;
            accelerationString = "" + acceleration;
            accelerationText.setText(accelerationString);
        }//end if
        
    }//end calcButtonListener method

    //Clears entries
    @FXML private void clearButtonListener(ActionEvent event) {
        forceText.setText("");
        forceLabel.setText("");
    }//end clearButtonListener method
   
}//end DocumentController
