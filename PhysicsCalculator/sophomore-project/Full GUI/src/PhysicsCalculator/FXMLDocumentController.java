package PhysicsCalculator;

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

    //Menu
    @FXML private MenuBar menu;
    @FXML private Menu fileMenu;
    @FXML private Menu editMenu;
    @FXML private Menu helpMenu;
    @FXML private MenuItem fileMenuSave;
    @FXML private MenuItem fileMenuOpen;
    @FXML private MenuItem fileMenuExit;
    @FXML private MenuItem helpMenuAbout;
    @FXML private MenuItem helpMenuCredits;
    private FileChooser fileChooser;
    
    //Input and output text
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

    String velocityString;
    String forceString;
    String massString;
    String accelerationString;
    String timeString;
    String distanceString;

    //Action buttons
    @FXML private Button calcButton;
    @FXML private Button enterButton;
    @FXML private Button clearButton;
    
    //Help Window Button
    @FXML private Button helpButton;
    Stage helpStage;
    Stage aboutStage;
    Stage creditsStage;
    
    //Instruction arrows and Title
    @FXML private ImageView step1image;
    private Image step1;
    @FXML private ImageView step2image;
    private Image step2;
    @FXML private ImageView step3image;
    @FXML private ImageView titleImage;
    private Image title;

    //Unit drop-down boxes
    @FXML private ChoiceBox<String> velocityUnits;
    @FXML private ChoiceBox<String> massUnits;
    @FXML private ChoiceBox<String> accelerationUnits;
    @FXML private ChoiceBox<String> timeUnits;
    @FXML private ChoiceBox<String> forceUnits;
    @FXML private ChoiceBox<String> distanceUnits;
    
    ObservableList<String> velocityAvailableChoices;
    ObservableList<String> forceAvailableChoices;
    ObservableList<String> massAvailableChoices;
    ObservableList<String> accelerationAvailableChoices;
    ObservableList<String> timeAvailableChoices;
    ObservableList<String> distanceAvailableChoices;
    
    String selectedVelocityUnit;
    String selectedForceUnit;
    String selectedMassUnit;
    String selectedAccelerationUnit;
    String selectedTimeUnit;
    String selectedDistanceUnit;    

    //Entries converted to numbers
    double velocity;
    double force;
    double mass;
    double acceleration;
    double time;
    double distance;   
    
    @Override public void initialize(URL url, ResourceBundle rb) {
        
        //Set up Help Window
        helpStage = new Stage();
        aboutStage = new Stage();
        creditsStage = new Stage();
        
        //Set up menu
        fileChooser = new FileChooser();
        editMenu.setDisable(true);
        
        //Warning message if entries are not valid numbers
        numberEntryAlert.setTitle("Alert Message");
        numberEntryAlert.setHeaderText(null);
        
        //Instruction arrows and Title
        step1 = new Image("images/1.jpg");
        step1image.setImage(step1);
        step2 = new Image("images/2.jpg");
        step2image.setImage(step2);
        step3image.setImage(step2);
        title = new Image("images/title.jpg");
        titleImage.setImage(title);
        
        //Set up units choice box - code borrowed from John Damien Smith 5/20/19
        //https://coderanch.com/t/649781/java/Set-values-ChoiceBox-created-Scene
        velocityAvailableChoices = velocityUnits.getItems();
        velocityAvailableChoices = FXCollections.observableArrayList("m/s"); 
        velocityUnits.setItems(velocityAvailableChoices);
        selectedVelocityUnit = velocityUnits.getSelectionModel().getSelectedItem();

        forceAvailableChoices = forceUnits.getItems();
        forceAvailableChoices = FXCollections.observableArrayList("N"); 
        forceUnits.setItems(forceAvailableChoices);
        selectedForceUnit = forceUnits.getSelectionModel().getSelectedItem();
        
        massAvailableChoices = massUnits.getItems();
        massAvailableChoices = FXCollections.observableArrayList("kg"); 
        massUnits.setItems(massAvailableChoices);
        selectedMassUnit = massUnits.getSelectionModel().getSelectedItem();        
        
        accelerationAvailableChoices = accelerationUnits.getItems();
        accelerationAvailableChoices = FXCollections.observableArrayList("m/s/s"); 
        accelerationUnits.setItems(accelerationAvailableChoices);
        selectedAccelerationUnit = accelerationUnits.getSelectionModel().getSelectedItem();

        timeAvailableChoices = timeUnits.getItems();
        timeAvailableChoices = FXCollections.observableArrayList("s"); 
        timeUnits.setItems(timeAvailableChoices);
        selectedTimeUnit = timeUnits.getSelectionModel().getSelectedItem(); 

        distanceAvailableChoices = distanceUnits.getItems();
        distanceAvailableChoices = FXCollections.observableArrayList("m"); 
        distanceUnits.setItems(distanceAvailableChoices);
        selectedDistanceUnit = distanceUnits.getSelectionModel().getSelectedItem();               
    }//end constructor  
    
    //Enter button takes entered values and puts them into formulas
    @FXML private void enterButtonListener(ActionEvent event){
        
        //Error check user entries to make sure they are valid numbers
        ErrorCheck velocityError = new ErrorCheck();
        velocityString = velocityError.variableEntry(velocityText.getText());
        ErrorCheck forceError = new ErrorCheck();
        forceString = forceError.variableEntry(forceText.getText());       
        ErrorCheck massError = new ErrorCheck();
        massString = forceError.variableEntry(massText.getText());
        ErrorCheck accelerationError = new ErrorCheck();
        accelerationString = accelerationError.variableEntry(accelerationText.getText());
        ErrorCheck timeError = new ErrorCheck();
        timeString = timeError.variableEntry(timeText.getText()); 
        ErrorCheck distanceError = new ErrorCheck();
        distanceString = distanceError.variableEntry(distanceText.getText()); 
        
        //Produce warning if entries are invalid
        if(velocityString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers for velocity.");
            numberEntryAlert.showAndWait();
            velocityText.setText("");
        }//end if     
        if(massString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers for mass.");
            numberEntryAlert.showAndWait();
            massText.setText("");
        }//end else if
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
        if(forceString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers for force.");
            numberEntryAlert.showAndWait();
            forceText.setText("");
        }//end else if                
        if(distanceString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers for distance.");
            numberEntryAlert.showAndWait();
            distanceText.setText("");
        }//end else if   
        
        if(velocityString == "bad" || forceString == "bad" || massString == "bad" ||
                accelerationString == "bad" || timeString == "bad" || distanceString == "bad"){
            return;
        }//end if
        
        //Enter numbers if they are valid
        else {
            velocityLabel.setText(velocityString);
            forceLabel.setText(forceString);            
            massLabel.setText(massString);            
            accelerationLabel.setText(accelerationString); 
            timeLabel.setText(timeString);            
            distanceLabel.setText(distanceString);            

            velocity = Double.parseDouble(velocityString);
            force = Double.parseDouble(forceString);
            mass = Double.parseDouble(massString);
            acceleration = Double.parseDouble(accelerationString);
            time = Double.parseDouble(timeString);
            distance = Double.parseDouble(distanceString);
        }//end if else                     
    }//end enterButtonListner method
    
    //Calculates answer
    @FXML private void calcButtonListener(ActionEvent event) {
        
    }//end calcButtonListener method

    //Clears entries, resets units
    @FXML private void clearButtonListener(ActionEvent event) {

        velocityText.setText("");
        velocityLabel.setText("");
        velocityUnits.getSelectionModel().clearSelection();
        
        forceText.setText("");
        forceLabel.setText("");
        forceUnits.getSelectionModel().clearSelection();

        massText.setText("");
        massLabel.setText("");
        massUnits.getSelectionModel().clearSelection();

        accelerationText.setText("");
        accelerationLabel.setText("");
        accelerationUnits.getSelectionModel().clearSelection();

        timeText.setText("");
        timeLabel.setText("");
        timeUnits.getSelectionModel().clearSelection();
        
        distanceText.setText("");
        distanceLabel.setText("");
        distanceUnits.getSelectionModel().clearSelection();        
    }//end clearButtonListener method
    
    //Help button
    @FXML private void helpButtonListener(ActionEvent event) throws Exception{
        if(helpStage.isShowing()){
            helpStage.toFront();
        }//end if
        else{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLHelpDocument.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            helpStage.setScene(new Scene(root));
            helpStage.show();
        }//end if else
    }//end helpButtonListener method  

    //Menu
    @FXML private void menuListener(ActionEvent event) throws Exception{
        Stage stage = (Stage)velocityLabel.getScene().getWindow();
        Scanner inFile = null;
        String input;

        //FILE menu
        //OPEN file
        if(event.getSource() == fileMenuOpen) {
            try{
                File file = fileChooser.showOpenDialog(stage);
                inFile = new Scanner(file);
                
                input = inFile.nextLine();
                velocityLabel.setText(input);
                input = inFile.nextLine();
                massLabel.setText(input);                
                input = inFile.nextLine();
                accelerationLabel.setText(input);
                input = inFile.nextLine();
                timeLabel.setText(input);
                input = inFile.nextLine();
                forceLabel.setText(input);
                input = inFile.nextLine();
                distanceLabel.setText(input);                

                //Units
                //Velocity
                input = inFile.nextLine();
                for(int i = 0; i < velocityAvailableChoices.size(); i++){
                    if(velocityAvailableChoices.get(i).equals(input)){
                        velocityUnits.getSelectionModel().select(i);
                        break;
                    }//end if
                }//end for loop
                
                //mass
                input = inFile.nextLine();
                for(int i = 0; i < massAvailableChoices.size(); i++){
                    if(massAvailableChoices.get(i).equals(input)){
                        massUnits.getSelectionModel().select(i);
                        break;
                    }//end if
                }//end for loop

                //acceleration
                input = inFile.nextLine();
                for(int i = 0; i < accelerationAvailableChoices.size(); i++){
                    if(accelerationAvailableChoices.get(i).equals(input)){
                        accelerationUnits.getSelectionModel().select(i);
                        break;
                    }//end if
                }//end for loop
                
                //time
                input = inFile.nextLine();
                for(int i = 0; i < timeAvailableChoices.size(); i++){
                    if(timeAvailableChoices.get(i).equals(input)){
                        timeUnits.getSelectionModel().select(i);
                        break;
                    }//end if
                }//end for loop
                
                //force
                input = inFile.nextLine();
                for(int i = 0; i < forceAvailableChoices.size(); i++){
                    if(forceAvailableChoices.get(i).equals(input)){
                        forceUnits.getSelectionModel().select(i);
                        break;
                    }//end if
                }//end for loop  

                //distance
                input = inFile.nextLine();
                for(int i = 0; i < distanceAvailableChoices.size(); i++){
                    if(distanceAvailableChoices.get(i).equals(input)){
                        distanceUnits.getSelectionModel().select(i);
                        break;
                    }//end if
                }//end for loop  
                
                inFile.close();
            }//end try
            
            catch(FileNotFoundException ex) {
                System.out.println("Can't write.");
            }//end catch
        }//end if, for Open Saved Character File menu item
               
        //SAVE file
        else if(event.getSource() == fileMenuSave) {
                
            try{
                File file = fileChooser.showSaveDialog(stage);
                PrintWriter pw = new PrintWriter(file);

                pw.println(velocityLabel.getText());
                pw.println(massLabel.getText());
                pw.println(accelerationLabel.getText());
                pw.println(timeLabel.getText());
                pw.println(forceLabel.getText());
                pw.println(distanceLabel.getText());
                
                pw.println(velocityUnits.getValue());
                pw.println(massUnits.getValue());
                pw.println(accelerationUnits.getValue());
                pw.println(timeUnits.getValue());
                pw.println(forceUnits.getValue());
                pw.println(distanceUnits.getValue());
                
                pw.close();
            }//end try

            catch(FileNotFoundException ex){
                System.out.println("Can't read.");
            }//end catch
        }//end if

        //CLOSE program
        else if(event.getSource() == fileMenuExit){
            System.exit(0);
        }//end else if 

        //HELP Menu
        //ABOUT
        if(event.getSource() == helpMenuAbout){
            if(aboutStage.isShowing()){
                aboutStage.toFront();
            }//end if
            else{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLAboutDocument.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                aboutStage.setScene(new Scene(root));
                aboutStage.show();
            }//end if else
        }//end if
            
        //CREDITS
        if(event.getSource() == helpMenuCredits){        
            if(creditsStage.isShowing()){
                creditsStage.toFront();
            }//end if
            else{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLCreditsDocument.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                creditsStage.setScene(new Scene(root));
                creditsStage.show();
            }//end if else
        }//end if
        
    }//end menuListener method
}//end DocumentController
