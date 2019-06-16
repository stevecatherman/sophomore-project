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
    @FXML private TextField forceText;
    @FXML private TextField massText;
    
    @FXML private Label initialVelocityLabel;
    @FXML private Label finalVelocityLabel;
    @FXML private Label accelerationLabel;
    @FXML private Label initialTimeLabel;
    @FXML private Label finalTimeLabel;
    @FXML private Label initialDisplacementLabel;
    @FXML private Label finalDisplacementLabel;
    @FXML private Label forceLabel;
    @FXML private Label massLabel;
    
    String initialVelocityString;
    String finalVelocityString; 
    String accelerationString;    
    String initialTimeString;
    String finalTimeString;
    String initialDisplacementString;
    String finalDisplacementString;
    String forceString;
    String massString;

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
    @FXML private ChoiceBox<String> forceUnits;
    @FXML private ChoiceBox<String> massUnits;
    
    ObservableList<String> initialVelocityAvailableChoices;
    ObservableList<String> finalVelocityAvailableChoices;
    ObservableList<String> accelerationAvailableChoices; 
    ObservableList<String> initialTimeAvailableChoices;    
    ObservableList<String> finalTimeAvailableChoices;
    ObservableList<String> initialDisplacementAvailableChoices;
    ObservableList<String> finalDisplacementAvailableChoices;
    ObservableList<String> forceAvailableChoices;    
    ObservableList<String> massAvailableChoices;    
    
    String selectedInitialVelocityUnit;
    String selectedFinalVelocityUnit;   
    String selectedAccelerationUnit;
    String selectedInitialTimeUnit;    
    String selectedFinalTimeUnit;
    String selectedInitialDisplacementUnit;
    String selectedFinalDisplacementUnit;
    String selectedForceUnit;    
    String selectedMassUnit;    

    //Saved variable value drop-down boxes
    @FXML private ChoiceBox<String> initialVelocityBox;
    @FXML private ChoiceBox<String> finalVelocityBox;
    @FXML private ChoiceBox<String> accelerationBox;
    @FXML private ChoiceBox<String> initialTimeBox;
    @FXML private ChoiceBox<String> finalTimeBox;
    @FXML private ChoiceBox<String> initialDisplacementBox;
    @FXML private ChoiceBox<String> finalDisplacementBox;
    @FXML private ChoiceBox<String> forceBox;
    @FXML private ChoiceBox<String> massBox;
    
    ObservableList<String> initialVelocityEntries;
    ObservableList<String> finalVelocityEntries;    
    ObservableList<String> accelerationEntries;
    ObservableList<String> initialTimeEntries;    
    ObservableList<String> finalTimeEntries;
    ObservableList<String> initialDisplacementEntries;
    ObservableList<String> finalDisplacementEntries;
    ObservableList<String> forceEntries;
    ObservableList<String> massEntries;
    
    String selectedInitialVelocityEntry;
    String selectedFinalVelocityEntry;    
    String selectedAccelerationEntry;
    String selectedInitialTimeEntry;    
    String selectedFinalTimeEntry;
    String selectedInitialDisplacementEntry; 
    String selectedFinalDisplacementEntry;
    String selectedForceEntry;
    String selectedMassEntry;    
    
    @FXML private Button initialVelocityButton;
    @FXML private Button finalVelocityButton;
    @FXML private Button accelerationButton;
    @FXML private Button initialTimeButton;
    @FXML private Button finalTimeButton;
    @FXML private Button initialDisplacementButton;
    @FXML private Button finalDisplacementButton;
    @FXML private Button forceButton;
    @FXML private Button massButton;
    
    //Gravity check box
    @FXML private CheckBox gravityCheckBox;

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
        initialVelocityAvailableChoices = FXCollections.observableArrayList("m/s", "ft/s"); 
        initialVelocityUnits.setItems(initialVelocityAvailableChoices);
        selectedInitialVelocityUnit = initialVelocityUnits.getSelectionModel().getSelectedItem();

        finalVelocityAvailableChoices = finalVelocityUnits.getItems();
        finalVelocityAvailableChoices = FXCollections.observableArrayList("m/s", "ft/s"); 
        finalVelocityUnits.setItems(finalVelocityAvailableChoices);
        selectedFinalVelocityUnit = finalVelocityUnits.getSelectionModel().getSelectedItem();       
        
        accelerationAvailableChoices = accelerationUnits.getItems();
        accelerationAvailableChoices = FXCollections.observableArrayList("m/s/s", "ft/s/s"); 
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
        initialDisplacementAvailableChoices = FXCollections.observableArrayList("m", "ft"); 
        initialDisplacementUnits.setItems(initialDisplacementAvailableChoices);
        selectedInitialDisplacementUnit = initialDisplacementUnits.getSelectionModel().getSelectedItem();    

        finalDisplacementAvailableChoices = finalDisplacementUnits.getItems();
        finalDisplacementAvailableChoices = FXCollections.observableArrayList("m", "ft"); 
        finalDisplacementUnits.setItems(finalDisplacementAvailableChoices);
        selectedFinalDisplacementUnit = finalDisplacementUnits.getSelectionModel().getSelectedItem();

        forceAvailableChoices = forceUnits.getItems();
        forceAvailableChoices = FXCollections.observableArrayList("N", "lb"); 
        forceUnits.setItems(forceAvailableChoices);
        selectedForceUnit = forceUnits.getSelectionModel().getSelectedItem();

        massAvailableChoices = massUnits.getItems();
        massAvailableChoices = FXCollections.observableArrayList("kg", "lb"); 
        massUnits.setItems(massAvailableChoices);
        selectedMassUnit = massUnits.getSelectionModel().getSelectedItem();
        
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

        forceEntries = forceBox.getItems();
        //distanceEntries = FXCollections.observableArrayList(""); 
        forceBox.setItems(forceEntries);
        selectedForceEntry = forceBox.getSelectionModel().getSelectedItem();

        massEntries = massBox.getItems();
        //distanceEntries = FXCollections.observableArrayList(""); 
        massBox.setItems(massEntries);
        selectedMassEntry = massBox.getSelectionModel().getSelectedItem();   
        
        //if(event.getSource() == fileMenuOpen)
        //gravityCheckBox;
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
        ErrorCheck forceError = new ErrorCheck();
        forceString = finalDisplacementError.variableEntry(forceText.getText());
        ErrorCheck massError = new ErrorCheck();
        massString = finalDisplacementError.variableEntry(massText.getText());
       
        //Produce warning if entries are invalid
        if(initialVelocityString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers for initial velocity.");
            numberEntryAlert.showAndWait();
            initialVelocityText.setText("");
        }//end if     
        if(finalVelocityString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers for final velocity.");
            numberEntryAlert.showAndWait();
            finalVelocityText.setText("");
        }//end else if
        if(accelerationString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers for acceleration.");
            numberEntryAlert.showAndWait();
            accelerationText.setText("");
        }//end else if 
        if(initialTimeString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers for initial time.");
            numberEntryAlert.showAndWait();
            initialTimeText.setText("");
        }//end else if
        if(finalTimeString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers for final time.");
            numberEntryAlert.showAndWait();
            finalTimeText.setText("");
        }//end else if                
        if(initialDisplacementString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers for initial displacement.");
            numberEntryAlert.showAndWait();
            initialDisplacementText.setText("");
        }//end else if   
        if(finalDisplacementString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers for final displacement.");
            numberEntryAlert.showAndWait();
            finalDisplacementText.setText("");
        }//end else if           
        if(forceString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers for force.");
            numberEntryAlert.showAndWait();
            forceText.setText("");
        }//end else if        
        if(massString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers for mass.");
            numberEntryAlert.showAndWait();
            massText.setText("");
        }//end else if                               
        
        if(initialVelocityString == "bad" || finalVelocityString == "bad" ||
               accelerationString == "bad" || initialTimeString == "bad" ||
               finalTimeString == "bad" || initialDisplacementString == "bad" ||
               finalDisplacementString == "bad" || forceString == "bad" || massString == "bad"){
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
        if(forceString != ""){
            forceLabel.setText(forceString); 
        }//end if  
        if(massString != ""){
            massLabel.setText(massString); 
        }//end if          
                        
        //Calculate Answer
        String[] numbersIn = new String[9];
        numbersIn[0] = initialVelocityLabel.getText();
        numbersIn[1] = finalVelocityLabel.getText();
        numbersIn[2] = accelerationLabel.getText();
        numbersIn[3] = initialTimeLabel.getText();
        numbersIn[4] = finalTimeLabel.getText();
        numbersIn[5] = initialDisplacementLabel.getText();
        numbersIn[6] = finalDisplacementLabel.getText();
        numbersIn[7] = forceLabel.getText();
        numbersIn[8] = massLabel.getText();
        
        String[] numbersOut = Formulas.solveEquations(numbersIn);
        initialVelocityLabel.setText(numbersOut[0]);
        finalVelocityLabel.setText(numbersOut[1]);
        accelerationLabel.setText(numbersOut[2]);
        initialTimeLabel.setText(numbersOut[3]);
        finalTimeLabel.setText(numbersOut[4]);
        initialDisplacementLabel.setText(numbersOut[5]);
        finalDisplacementLabel.setText(numbersOut[6]);
        forceLabel.setText(numbersOut[7]);
        massLabel.setText(numbersOut[8]);
        
        //Add new entries to drop-down box
        initialVelocityEntries.add(initialVelocityLabel.getText());
        finalVelocityEntries.add(finalVelocityLabel.getText());        
        accelerationEntries.add(accelerationLabel.getText());        
        initialTimeEntries.add(initialTimeLabel.getText());        
        finalTimeEntries.add(finalTimeLabel.getText());
        initialDisplacementEntries.add(initialDisplacementLabel.getText());
        finalDisplacementEntries.add(finalDisplacementLabel.getText());        
        forceEntries.add(forceLabel.getText());         
        massEntries.add(massLabel.getText()); 
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

        forceText.setText("");
        forceLabel.setText("");
        forceUnits.getSelectionModel().clearSelection();  
        forceBox.getSelectionModel().clearSelection(); 

        massText.setText("");
        massLabel.setText("");
        massUnits.getSelectionModel().clearSelection();  
        massBox.getSelectionModel().clearSelection();         
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
            initialVelocityText.setText(initialVelocityBox.getSelectionModel().getSelectedItem());
            initialVelocityLabel.setText("");
        }//end if 
        if(event.getSource() == finalVelocityButton){        
            finalVelocityText.setText(finalVelocityBox.getSelectionModel().getSelectedItem());
            finalVelocityLabel.setText("");
        }//end if          
        if(event.getSource() == accelerationButton){        
            accelerationText.setText(accelerationBox.getSelectionModel().getSelectedItem());
            accelerationLabel.setText("");
        }//end if          
        if(event.getSource() == initialTimeButton){        
            initialTimeText.setText(initialTimeBox.getSelectionModel().getSelectedItem());
            initialTimeLabel.setText("");
        }//end if                  
        if(event.getSource() == finalTimeButton){        
            finalTimeText.setText(finalTimeBox.getSelectionModel().getSelectedItem());
            finalTimeLabel.setText("");
        }//end if                        
        if(event.getSource() == initialDisplacementButton){        
            initialDisplacementText.setText(initialDisplacementBox.getSelectionModel().getSelectedItem());
            initialDisplacementLabel.setText("");
        }//end if            
        if(event.getSource() == finalDisplacementButton){        
            finalDisplacementText.setText(finalDisplacementBox.getSelectionModel().getSelectedItem());
            finalDisplacementLabel.setText("");
        }//end if          
        if(event.getSource() == forceButton){        
            forceText.setText(forceBox.getSelectionModel().getSelectedItem());
            forceLabel.setText("");
        }//end if   
        if(event.getSource() == massButton){        
            massText.setText(massBox.getSelectionModel().getSelectedItem());
            massLabel.setText("");
        }//end if          
    }//end SavedEntriesListener method

    @FXML private void gravityBoxListener(ActionEvent event) {
        if(gravityCheckBox.isSelected()){
            accelerationText.setText("9.8");
            accelerationUnits.getSelectionModel().selectFirst();
        }//end if
        if(!gravityCheckBox.isSelected()){
            accelerationText.setText(null);
            accelerationUnits.getSelectionModel().clearSelection();
        }//end if       
    }//end gravityBoxListener method
}//end DocumentController
