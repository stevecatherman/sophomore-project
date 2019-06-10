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
    @FXML private TextField initialVelocityText;
    @FXML private TextField finalVelocityText;
    @FXML private TextField accelerationText;
    @FXML private TextField initialTimeText;
    @FXML private TextField finalTimeText;
    @FXML private TextField initialDisplacementText;
    @FXML private TextField finalDisplacementText;

    @FXML private Label initialVelocityLabel;
    @FXML private Label finalVelocityLabel;
    @FXML private Label accelerationLabel;
    @FXML private Label initialTimeLabel;
    @FXML private Label finalTimeLabel;
    @FXML private Label initialDisplacementLabel;
    @FXML private Label finalDisplacementLabel;
    
    String initialVelocityString;
    String finalVelocityString; 
    String accelerationString;    
    String initialTimeString;
    String finalTimeString;
    String initialDisplacementString;
    String finalDisplacementString;

    //Action buttons
    @FXML private Button calcButton;
    @FXML private Button clearButton;
    
    //Help Window Button
    @FXML private Button helpButton;
    Stage helpStage;
    Stage aboutStage;
    Stage creditsStage;
    
    //Title
    @FXML private ImageView titleImage;
    private Image title;

    //Unit drop-down boxes
    @FXML private ChoiceBox<String> initialVelocityUnits;
    @FXML private ChoiceBox<String> finalVelocityUnits;
    @FXML private ChoiceBox<String> accelerationUnits;
    @FXML private ChoiceBox<String> initialTimeUnits;
    @FXML private ChoiceBox<String> finalTimeUnits;
    @FXML private ChoiceBox<String> initialDisplacementUnits;
    @FXML private ChoiceBox<String> finalDisplacementUnits;
    
    ObservableList<String> initialVelocityAvailableChoices;
    ObservableList<String> finalVelocityAvailableChoices;
    ObservableList<String> accelerationAvailableChoices; 
    ObservableList<String> initialTimeAvailableChoices;    
    ObservableList<String> finalTimeAvailableChoices;
    ObservableList<String> initialDisplacementAvailableChoices;
    ObservableList<String> finalDisplacementAvailableChoices;
    
    String selectedInitialVelocityUnit;
    String selectedFinalVelocityUnit;   
    String selectedAccelerationUnit;
    String selectedInitialTimeUnit;    
    String selectedFinalTimeUnit;
    String selectedInitialDisplacementUnit;
    String selectedFinalDisplacementUnit;

    //Saved variable value drop-down boxes
    @FXML private ChoiceBox<String> initialVelocityBox;
    @FXML private ChoiceBox<String> finalVelocityBox;
    @FXML private ChoiceBox<String> accelerationBox;
    @FXML private ChoiceBox<String> initialTimeBox;
    @FXML private ChoiceBox<String> finalTimeBox;
    @FXML private ChoiceBox<String> initialDisplacementBox;
    @FXML private ChoiceBox<String> finalDisplacementBox;
    
    ObservableList<String> initialVelocityEntries;
    ObservableList<String> finalVelocityEntries;    
    ObservableList<String> accelerationEntries;
    ObservableList<String> initialTimeEntries;    
    ObservableList<String> finalTimeEntries;
    ObservableList<String> initialDisplacementEntries;
    ObservableList<String> finalDisplacementEntries;
    
    String selectedInitialVelocityEntry;
    String selectedFinalVelocityEntry;    
    String selectedAccelerationEntry;
    String selectedInitialTimeEntry;    
    String selectedFinalTimeEntry;
    String selectedInitialDisplacementEntry; 
    String selectedFinalDisplacementEntry;

    @FXML private Button initialVelocityButton;
    @FXML private Button finalVelocityButton;
    @FXML private Button accelerationButton;
    @FXML private Button initialTimeButton;
    @FXML private Button finalTimeButton;
    @FXML private Button initialDisplacementButton;
    @FXML private Button finalDisplacementButton;

    @Override public void initialize(URL url, ResourceBundle rb) {
        
        //Set up Help Window
        helpStage = new Stage();
        aboutStage = new Stage();
        creditsStage = new Stage();
        
        //Set up menu
        fileChooser = new FileChooser();
        editMenu.setDisable(true);
        fileMenu.setDisable(true);
        
        //Warning message if entries are not valid numbers
        numberEntryAlert.setTitle("Alert Message");
        numberEntryAlert.setHeaderText(null);
        
        //Title
        title = new Image("images/title.jpg");
        titleImage.setImage(title);
        
        //Set up units choice box - code borrowed from John Damien Smith 5/20/19
        //https://coderanch.com/t/649781/java/Set-values-ChoiceBox-created-Scene
        initialVelocityAvailableChoices = initialVelocityUnits.getItems();
        initialVelocityAvailableChoices = FXCollections.observableArrayList("m/s"); 
        initialVelocityUnits.setItems(initialVelocityAvailableChoices);
        selectedInitialVelocityUnit = initialVelocityUnits.getSelectionModel().getSelectedItem();

        finalVelocityAvailableChoices = finalVelocityUnits.getItems();
        finalVelocityAvailableChoices = FXCollections.observableArrayList("m/s"); 
        finalVelocityUnits.setItems(finalVelocityAvailableChoices);
        selectedFinalVelocityUnit = finalVelocityUnits.getSelectionModel().getSelectedItem();       
        
        accelerationAvailableChoices = accelerationUnits.getItems();
        accelerationAvailableChoices = FXCollections.observableArrayList("m/s/s"); 
        accelerationUnits.setItems(accelerationAvailableChoices);
        selectedAccelerationUnit = accelerationUnits.getSelectionModel().getSelectedItem();

        initialTimeAvailableChoices = initialTimeUnits.getItems();
        initialTimeAvailableChoices = FXCollections.observableArrayList("s"); 
        initialTimeUnits.setItems(initialTimeAvailableChoices);
        selectedInitialTimeUnit = initialTimeUnits.getSelectionModel().getSelectedItem();        
        
        finalTimeAvailableChoices = finalTimeUnits.getItems();
        finalTimeAvailableChoices = FXCollections.observableArrayList("s"); 
        finalTimeUnits.setItems(finalTimeAvailableChoices);
        selectedFinalTimeUnit = finalTimeUnits.getSelectionModel().getSelectedItem();

        initialDisplacementAvailableChoices = initialDisplacementUnits.getItems();
        initialDisplacementAvailableChoices = FXCollections.observableArrayList("m"); 
        initialDisplacementUnits.setItems(initialDisplacementAvailableChoices);
        selectedInitialDisplacementUnit = initialDisplacementUnits.getSelectionModel().getSelectedItem();    

        finalDisplacementAvailableChoices = finalDisplacementUnits.getItems();
        finalDisplacementAvailableChoices = FXCollections.observableArrayList("m"); 
        finalDisplacementUnits.setItems(finalDisplacementAvailableChoices);
        selectedFinalDisplacementUnit = finalDisplacementUnits.getSelectionModel().getSelectedItem();
        
        //Set up entries choice box - code borrowed from John Damien Smith 5/20/19
        //https://coderanch.com/t/649781/java/Set-values-ChoiceBox-created-Scene        
        initialVelocityEntries = initialVelocityBox.getItems();
        //velocityEntries = FXCollections.observableArrayList(); 
        initialVelocityBox.setItems(initialVelocityEntries);
        selectedInitialVelocityEntry = initialVelocityBox.getSelectionModel().getSelectedItem();

        finalVelocityEntries = finalVelocityBox.getItems();
        //massEntries = FXCollections.observableArrayList(""); 
        finalVelocityBox.setItems(finalVelocityEntries);
        selectedFinalVelocityEntry = finalVelocityBox.getSelectionModel().getSelectedItem();        
        
        accelerationEntries = accelerationBox.getItems();
        //accelerationEntries = FXCollections.observableArrayList(""); 
        accelerationBox.setItems(accelerationEntries);
        selectedAccelerationEntry = accelerationBox.getSelectionModel().getSelectedItem(); 

        initialTimeEntries = initialTimeBox.getItems();
        //timeEntries = FXCollections.observableArrayList(""); 
        initialTimeBox.setItems(initialTimeEntries);
        selectedInitialTimeEntry = initialTimeBox.getSelectionModel().getSelectedItem(); 
               
        finalTimeEntries = finalTimeBox.getItems();
        //forceEntries = FXCollections.observableArrayList(""); 
        finalTimeBox.setItems(finalTimeEntries);
        selectedFinalTimeEntry = finalTimeBox.getSelectionModel().getSelectedItem();

        initialDisplacementEntries = initialDisplacementBox.getItems();
        //distanceEntries = FXCollections.observableArrayList(""); 
        initialDisplacementBox.setItems(initialDisplacementEntries);
        selectedInitialDisplacementEntry = initialDisplacementBox.getSelectionModel().getSelectedItem(); 
        
        finalDisplacementEntries = finalDisplacementBox.getItems();
        //distanceEntries = FXCollections.observableArrayList(""); 
        finalDisplacementBox.setItems(finalDisplacementEntries);
        selectedFinalDisplacementEntry = finalDisplacementBox.getSelectionModel().getSelectedItem();                 
    }//end constructor      
    
    //Calculates answer
    @FXML private void calcButtonListener(ActionEvent event) {
        
        //Error check user entries to make sure they are valid numbers
        ErrorCheck initialVelocityError = new ErrorCheck();
        initialVelocityString = initialVelocityError.variableEntry(initialVelocityText.getText());
        ErrorCheck finalVelocityError = new ErrorCheck();
        finalVelocityString = finalVelocityError.variableEntry(finalVelocityText.getText());        
        ErrorCheck accelerationError = new ErrorCheck();
        accelerationString = accelerationError.variableEntry(accelerationText.getText());
        ErrorCheck initialTimeimeError = new ErrorCheck();
        initialTimeString = initialTimeimeError.variableEntry(initialTimeText.getText());       
        ErrorCheck finalTimeError = new ErrorCheck();
        finalTimeString = finalTimeError.variableEntry(finalTimeText.getText());       
        ErrorCheck initialDisplacementError = new ErrorCheck();
        initialDisplacementString = initialDisplacementError.variableEntry(initialDisplacementText.getText());                 
        ErrorCheck finalDisplacementError = new ErrorCheck();
        finalDisplacementString = finalDisplacementError.variableEntry(finalDisplacementText.getText());
        
        //Produce warning if entries are invalid
        if(initialVelocityString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers for velocity.");
            numberEntryAlert.showAndWait();
            initialVelocityText.setText("");
        }//end if     
        if(finalVelocityString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers for mass.");
            numberEntryAlert.showAndWait();
            finalVelocityText.setText("");
        }//end else if
        if(accelerationString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers for acceleration.");
            numberEntryAlert.showAndWait();
            accelerationText.setText("");
        }//end else if 
        if(initialTimeString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers for time.");
            numberEntryAlert.showAndWait();
            initialTimeText.setText("");
        }//end else if
        if(finalTimeString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers for force.");
            numberEntryAlert.showAndWait();
            finalTimeText.setText("");
        }//end else if                
        if(initialDisplacementString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers for distance.");
            numberEntryAlert.showAndWait();
            initialDisplacementText.setText("");
        }//end else if   
        if(finalDisplacementString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers for distance.");
            numberEntryAlert.showAndWait();
            finalDisplacementText.setText("");
        }//end else if           
        if(initialVelocityString == "bad" || finalVelocityString == "bad" ||
               accelerationString == "bad" || initialTimeString == "bad" ||
               finalTimeString == "bad" || initialDisplacementString == "bad" ||
               finalDisplacementString == "bad"){
            return;
        }//end if
        
        //Enter numbers if they are valid
        if(initialVelocityString != ""){
            initialVelocityLabel.setText(initialVelocityString);
         }//end if           
        if(finalVelocityString != ""){                           
            finalVelocityLabel.setText(finalVelocityString);  
        }//end if
        if(accelerationString != ""){        
            accelerationLabel.setText(accelerationString);
        }//end if
        if(initialTimeString != ""){
            initialTimeLabel.setText(initialTimeString);
        }//end if
        if(finalTimeString != ""){
            finalTimeLabel.setText(finalTimeString); 
        }//end if
        if(initialDisplacementString != ""){
            initialDisplacementLabel.setText(initialDisplacementString);
        }//end if
        if(finalDisplacementString != ""){
            finalDisplacementLabel.setText(finalDisplacementString); 
        }//end if

        //Add previous entries to drop-down box
        initialVelocityEntries.add(initialVelocityString);
        finalVelocityEntries.add(finalVelocityString);        
        accelerationEntries.add(accelerationString);        
        initialTimeEntries.add(initialTimeString);        
        finalTimeEntries.add(finalTimeString);
        initialDisplacementEntries.add(initialDisplacementString);
        finalDisplacementEntries.add(finalDisplacementString);        
            
        //Calculate Answer
        String[] numbersIn = new String[7];
        numbersIn[0] = initialVelocityLabel.getText();
        numbersIn[1] = finalVelocityLabel.getText();
        numbersIn[2] = accelerationLabel.getText();
        numbersIn[3] = initialTimeLabel.getText();
        numbersIn[4] = finalTimeLabel.getText();
        numbersIn[5] = initialDisplacementLabel.getText();
        numbersIn[6] = finalDisplacementLabel.getText();
        
        String[] numbersOut = Formulas.solveEquations(numbersIn);
        initialVelocityLabel.setText(numbersOut[0]);
        finalVelocityLabel.setText(numbersOut[1]);
        accelerationLabel.setText(numbersOut[2]);
        initialTimeLabel.setText(numbersOut[3]);
        finalTimeLabel.setText(numbersOut[4]);
        initialDisplacementLabel.setText(numbersOut[5]);
        finalDisplacementLabel.setText(numbersOut[6]); 

        //Test
        /*for (int i = 0; i <= numbersOut.length - 1; i++) {
            System.out.println(numbersOut[i]);        
        }//end for*/
        
    }//end calcButtonListener method

    //Clears entries, resets units
    @FXML private void clearButtonListener(ActionEvent event) {

        initialVelocityText.setText("");
        initialVelocityLabel.setText("");
        initialVelocityUnits.getSelectionModel().clearSelection();
        initialVelocityBox.getSelectionModel().clearSelection();

        finalVelocityText.setText("");
        finalVelocityLabel.setText("");
        finalVelocityUnits.getSelectionModel().clearSelection();
        finalVelocityBox.getSelectionModel().clearSelection();

        initialTimeText.setText("");
        initialTimeLabel.setText("");
        initialTimeUnits.getSelectionModel().clearSelection();
        initialTimeBox.getSelectionModel().clearSelection();
        
        finalTimeText.setText("");
        finalTimeLabel.setText("");
        finalTimeUnits.getSelectionModel().clearSelection();
        finalTimeBox.getSelectionModel().clearSelection();
        
        accelerationText.setText("");
        accelerationLabel.setText("");
        accelerationUnits.getSelectionModel().clearSelection();
        accelerationBox.getSelectionModel().clearSelection();
                
        initialDisplacementText.setText("");
        initialDisplacementLabel.setText("");
        initialDisplacementUnits.getSelectionModel().clearSelection();  
        initialDisplacementBox.getSelectionModel().clearSelection();
        
        finalDisplacementText.setText("");
        finalDisplacementLabel.setText("");
        finalDisplacementUnits.getSelectionModel().clearSelection();  
        finalDisplacementBox.getSelectionModel().clearSelection();                
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
        Stage stage = (Stage)initialVelocityLabel.getScene().getWindow();
        Scanner inFile = null;
        String input;

        //FILE menu
        //OPEN file
        if(event.getSource() == fileMenuOpen) {
            try{
                File file = fileChooser.showOpenDialog(stage);
                inFile = new Scanner(file);
                
                input = inFile.nextLine();
                initialVelocityLabel.setText(input);
                input = inFile.nextLine();
                finalVelocityLabel.setText(input);                
                input = inFile.nextLine();
                accelerationLabel.setText(input);
                input = inFile.nextLine();
                initialTimeLabel.setText(input);
                input = inFile.nextLine();
                finalTimeLabel.setText(input);
                input = inFile.nextLine();
                initialDisplacementLabel.setText(input);                
                input = inFile.nextLine();
                finalDisplacementLabel.setText(input); 
                
                //Units
                //Velocity
                input = inFile.nextLine();
                for(int i = 0; i < initialVelocityAvailableChoices.size(); i++){
                    if(initialVelocityAvailableChoices.get(i).equals(input)){
                        initialVelocityUnits.getSelectionModel().select(i);
                        break;
                    }//end if
                }//end for loop
                
                //mass
                input = inFile.nextLine();
                for(int i = 0; i < finalVelocityAvailableChoices.size(); i++){
                    if(finalVelocityAvailableChoices.get(i).equals(input)){
                        finalVelocityUnits.getSelectionModel().select(i);
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
                for(int i = 0; i < initialTimeAvailableChoices.size(); i++){
                    if(initialTimeAvailableChoices.get(i).equals(input)){
                        initialTimeUnits.getSelectionModel().select(i);
                        break;
                    }//end if
                }//end for loop
                
                //force
                input = inFile.nextLine();
                for(int i = 0; i < finalTimeAvailableChoices.size(); i++){
                    if(finalTimeAvailableChoices.get(i).equals(input)){
                        finalTimeUnits.getSelectionModel().select(i);
                        break;
                    }//end if
                }//end for loop  

                //distance
                input = inFile.nextLine();
                for(int i = 0; i < initialDisplacementAvailableChoices.size(); i++){
                    if(initialDisplacementAvailableChoices.get(i).equals(input)){
                        initialDisplacementUnits.getSelectionModel().select(i);
                        break;
                    }//end if
                }//end for loop  

                //final displacement
                input = inFile.nextLine();
                for(int i = 0; i < finalDisplacementAvailableChoices.size(); i++){
                    if(finalDisplacementAvailableChoices.get(i).equals(input)){
                        finalDisplacementUnits.getSelectionModel().select(i);
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

                pw.println(initialVelocityLabel.getText());
                pw.println(finalVelocityLabel.getText());
                pw.println(accelerationLabel.getText());
                pw.println(initialTimeLabel.getText());
                pw.println(finalTimeLabel.getText());
                pw.println(initialDisplacementLabel.getText());
                pw.println(finalDisplacementLabel.getText());
                
                pw.println(initialVelocityUnits.getValue());
                pw.println(finalVelocityUnits.getValue());
                pw.println(accelerationUnits.getValue());
                pw.println(initialTimeUnits.getValue());
                pw.println(finalTimeUnits.getValue());
                pw.println(initialDisplacementUnits.getValue());
                pw.println(finalDisplacementUnits.getValue());
                
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

    @FXML private void SavedEntriesListener(ActionEvent event) {
        if(event.getSource() == initialVelocityButton){        
            initialVelocityLabel.setText(initialVelocityBox.getSelectionModel().getSelectedItem());
            initialVelocityText.setText("");
        }//end if 
        if(event.getSource() == finalVelocityButton){        
            finalVelocityLabel.setText(finalVelocityBox.getSelectionModel().getSelectedItem());
            finalVelocityText.setText("");
        }//end if          
        if(event.getSource() == accelerationButton){        
            accelerationLabel.setText(accelerationBox.getSelectionModel().getSelectedItem());
            accelerationText.setText("");
        }//end if          
        if(event.getSource() == initialTimeButton){        
            initialTimeLabel.setText(initialTimeBox.getSelectionModel().getSelectedItem());
            initialTimeText.setText("");
        }//end if                  
        if(event.getSource() == finalTimeButton){        
            finalTimeLabel.setText(finalTimeBox.getSelectionModel().getSelectedItem());
            finalTimeText.setText("");
        }//end if                        
        if(event.getSource() == initialDisplacementButton){        
            initialDisplacementLabel.setText(initialDisplacementBox.getSelectionModel().getSelectedItem());
            initialDisplacementText.setText("");
        }//end if            
        if(event.getSource() == finalDisplacementButton){        
            finalDisplacementLabel.setText(finalDisplacementBox.getSelectionModel().getSelectedItem());
            finalDisplacementText.setText("");
        }//end if          
        
    }//end SavedEntriesListener method
}//end DocumentController
