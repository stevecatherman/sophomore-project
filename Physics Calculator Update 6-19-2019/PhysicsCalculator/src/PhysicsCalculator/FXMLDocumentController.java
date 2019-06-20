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
import javafx.scene.input.MouseEvent;

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
    
    @FXML private ComboBox<String> initialVelocityUnits;
    @FXML private ComboBox<String> finalVelocityUnits;
    @FXML private ComboBox<String> accelerationUnits;
    @FXML private ComboBox<String> initialTimeUnits;
    @FXML private ComboBox<String> finalTimeUnits;
    @FXML private ComboBox<String> initialDisplacementUnits;
    @FXML private ComboBox<String> finalDisplacementUnits;
    @FXML private ComboBox<String> forceUnits;
    @FXML private ComboBox<String> massUnits;

    private ObservableList initialVelocityUnitOptions = FXCollections.observableArrayList();
    private ObservableList finalVelocityUnitOptions = FXCollections.observableArrayList();    
    private ObservableList accelerationUnitOptions = FXCollections.observableArrayList();
    private ObservableList initialTimeUnitOptions = FXCollections.observableArrayList();
    private ObservableList finalTimeUnitOptions = FXCollections.observableArrayList();
    private ObservableList initialDisplacementUnitOptions = FXCollections.observableArrayList();
    private ObservableList finalDisplacementUnitOptions = FXCollections.observableArrayList();
    private ObservableList forceUnitOptions = FXCollections.observableArrayList();
    private ObservableList massUnitOptions = FXCollections.observableArrayList();

    //Unit Conversion Buttons
    @FXML private Button convertButtonIV;
    @FXML private Button convertButtonFV;
    @FXML private Button convertButtonA;
    @FXML private Button convertButtonID;
    @FXML private Button convertButtonFD;
    @FXML private Button convertButtonF;
    @FXML private Button convertButtonM;

    //New Unit Drop-Downs
    @FXML private ComboBox<String> newInitialVelocityUnits;
    @FXML private ComboBox<String> newFinalVelocityUnits;
    @FXML private ComboBox<String> newAccelerationUnits;
    @FXML private ComboBox<String> newInitialTimeUnits;
    @FXML private ComboBox<String> newFinalTimeUnits;
    @FXML private ComboBox<String> newInitialDisplacementUnits;
    @FXML private ComboBox<String> newFinalDisplacementUnits;
    @FXML private ComboBox<String> newForceUnits;
    @FXML private ComboBox<String> newMassUnits;

    private ObservableList newInitialVelocityUnitOptions = FXCollections.observableArrayList();
    private ObservableList newFinalVelocityUnitOptions = FXCollections.observableArrayList();    
    private ObservableList newAccelerationUnitOptions = FXCollections.observableArrayList();
    private ObservableList newInitialTimeUnitOptions = FXCollections.observableArrayList();
    private ObservableList newFinalTimeUnitOptions = FXCollections.observableArrayList();
    private ObservableList newInitialDisplacementUnitOptions = FXCollections.observableArrayList();
    private ObservableList newFinalDisplacementUnitOptions = FXCollections.observableArrayList();
    private ObservableList newForceUnitOptions = FXCollections.observableArrayList();
    private ObservableList newMassUnitOptions = FXCollections.observableArrayList();
    
    boolean metersPerSecondVI = false;
    boolean feetPerSecondVI = false;
    boolean metersPerSecondVF = false;
    boolean feetPerSecondVF = false;
    boolean metersPerSecondSq = false;
    boolean feetPerSecondSq = false;
    boolean metersXI = false;
    boolean feetXI = false;
    boolean metersXF = false;
    boolean feetXF = false;
    boolean newtons = false;
    boolean forceLBS = false;
    boolean kilograms = false;
    boolean lbs = false;
    
    @Override public void initialize(URL url, ResourceBundle rb) {

        //Populate Old Units ComboBox
        fileChooser = new FileChooser();
        
        initialVelocityUnitOptions.add("m/s");
        initialVelocityUnitOptions.add("ft/s");        
        initialVelocityUnits.setItems(initialVelocityUnitOptions);
        initialVelocityUnits.getSelectionModel().selectFirst();
        if(initialVelocityUnits.getValue() == "m/s"){
            metersPerSecondVI = true;
        } else if(initialVelocityUnits.getValue()  == "f/s"){
            feetPerSecondVI = true;
        }

        finalVelocityUnitOptions.add("m/s");
        finalVelocityUnitOptions.add("ft/s");        
        finalVelocityUnits.setItems(finalVelocityUnitOptions);
        finalVelocityUnits.getSelectionModel().selectFirst();
        if(finalVelocityUnits.getValue() == "m/s"){
            metersPerSecondVF = true;
        } else if(finalVelocityUnits.getValue()  == "f/s"){
            feetPerSecondVF = true;
        }
        
        accelerationUnitOptions.add("m/s^2");
        accelerationUnitOptions.add("ft/s^2");        
        accelerationUnits.setItems(accelerationUnitOptions);
        accelerationUnits.getSelectionModel().selectFirst();
        if(accelerationUnits.getValue() == "m/s^2"){
            metersPerSecondSq = true;
        } else if(accelerationUnits.getValue() == "ft/s^2"){
            feetPerSecondSq = true;
        }
        
        initialTimeUnitOptions.add("s");       
        initialTimeUnits.setItems(initialTimeUnitOptions);
        initialTimeUnits.getSelectionModel().selectFirst();
        
        finalTimeUnitOptions.add("s");       
        finalTimeUnits.setItems(finalTimeUnitOptions);
        finalTimeUnits.getSelectionModel().selectFirst();
        
        initialDisplacementUnitOptions.add("m");
        initialDisplacementUnitOptions.add("ft");        
        initialDisplacementUnits.setItems(initialDisplacementUnitOptions);
        initialDisplacementUnits.getSelectionModel().selectFirst();
        if(initialDisplacementUnits.getValue() == "m"){
            metersXI = true;
        } else if(initialDisplacementUnits.getValue() == "ft"){
            feetXI = true;
        }

        finalDisplacementUnitOptions.add("m");
        finalDisplacementUnitOptions.add("ft");        
        finalDisplacementUnits.setItems(finalDisplacementUnitOptions);        
        finalDisplacementUnits.getSelectionModel().selectFirst();
        if(finalDisplacementUnits.getValue() == "m"){
            metersXF = true;
        } else if(finalDisplacementUnits.getValue() == "ft"){
            feetXF = true;
        }
        
        forceUnitOptions.add("N");
        forceUnitOptions.add("lb");        
        forceUnits.setItems(forceUnitOptions);         
        forceUnits.getSelectionModel().selectFirst();
        if(forceUnits.getValue() == "N"){
            newtons = true;
        } else if(forceUnits.getValue() == "lb"){
            forceLBS = true;
        }
        
        massUnitOptions.add("kg");
        massUnitOptions.add("lb");        
        massUnits.setItems(massUnitOptions); 
        massUnits.getSelectionModel().selectFirst();
        if(massUnits.getValue() == "kg"){
            kilograms = true;
        } else if(massUnits.getValue() == "lb"){
            lbs = true;
        }

        //Populate New Units ComboBox        
        newInitialVelocityUnitOptions.add("m/s");
        newInitialVelocityUnitOptions.add("ft/s");        
        newInitialVelocityUnits.setItems(newInitialVelocityUnitOptions);
        newInitialVelocityUnits.getSelectionModel().selectFirst();

        newFinalVelocityUnitOptions.add("m/s");
        newFinalVelocityUnitOptions.add("ft/s");        
        newFinalVelocityUnits.setItems(newFinalVelocityUnitOptions);
        newFinalVelocityUnits.getSelectionModel().selectFirst();
        
        newAccelerationUnitOptions.add("m/s^2");
        newAccelerationUnitOptions.add("ft/s^2");        
        newAccelerationUnits.setItems(newAccelerationUnitOptions);
        newAccelerationUnits.getSelectionModel().selectFirst();
        
        newInitialTimeUnitOptions.add("s");       
        newInitialTimeUnits.setItems(newInitialTimeUnitOptions);
        newInitialTimeUnits.getSelectionModel().selectFirst();
        
        newFinalTimeUnitOptions.add("s");       
        newFinalTimeUnits.setItems(newFinalTimeUnitOptions);
        newFinalTimeUnits.getSelectionModel().selectFirst();
        
        newInitialDisplacementUnitOptions.add("m");
        newInitialDisplacementUnitOptions.add("ft");        
        newInitialDisplacementUnits.setItems(newInitialDisplacementUnitOptions);
        newInitialDisplacementUnits.getSelectionModel().selectFirst();        

        newFinalDisplacementUnitOptions.add("m");
        newFinalDisplacementUnitOptions.add("ft");        
        newFinalDisplacementUnits.setItems(newFinalDisplacementUnitOptions);        
        newFinalDisplacementUnits.getSelectionModel().selectFirst();
        
        newForceUnitOptions.add("N");
        newForceUnitOptions.add("lb");        
        newForceUnits.setItems(newForceUnitOptions);         
        newForceUnits.getSelectionModel().selectFirst();
        
        newMassUnitOptions.add("kg");
        newMassUnitOptions.add("lb");        
        newMassUnits.setItems(newMassUnitOptions); 
        newMassUnits.getSelectionModel().selectFirst();

        
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

        //Produce warning if entries are not metric
        if(newInitialVelocityUnits.getValue() != "m/s" || newFinalVelocityUnits.getValue() != "m/s"
                || newAccelerationUnits.getValue() != "m/s^2" || newInitialTimeUnits.getValue() != "s"
                || newFinalTimeUnits.getValue() != "s" || newInitialDisplacementUnits.getValue() != "m"
                || newFinalDisplacementUnits.getValue() != "m" || newForceUnits.getValue() != "N"
                || newMassUnits.getValue() != "kg"){
            numberEntryAlert.setContentText("Please convert all entries to standard SI units, before calculating.");
            numberEntryAlert.showAndWait();
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
        initialVelocityUnits.getSelectionModel().selectFirst();
        newInitialVelocityUnits.getSelectionModel().selectFirst();
        
        finalVelocityText.setText("");
        finalVelocityLabel.setText("");
        finalVelocityUnits.getSelectionModel().selectFirst();
        newFinalVelocityUnits.getSelectionModel().selectFirst();

        initialTimeText.setText("");
        initialTimeLabel.setText("");
        initialTimeUnits.getSelectionModel().selectFirst();
        newInitialTimeUnits.getSelectionModel().selectFirst();
        
        finalTimeText.setText("");
        finalTimeLabel.setText("");
        finalVelocityUnits.getSelectionModel().selectFirst();
        newFinalVelocityUnits.getSelectionModel().selectFirst();
        
        accelerationText.setText("");
        accelerationLabel.setText("");
        accelerationBox.getSelectionModel().clearSelection();
        accelerationUnits.getSelectionModel().selectFirst();
        newAccelerationUnits.getSelectionModel().selectFirst();
        
        initialDisplacementText.setText("");
        initialDisplacementLabel.setText(""); 
        initialDisplacementBox.getSelectionModel().clearSelection();
        initialDisplacementUnits.getSelectionModel().selectFirst();
        newInitialDisplacementUnits.getSelectionModel().selectFirst();
        
        finalDisplacementText.setText("");
        finalDisplacementLabel.setText("");  
        finalDisplacementBox.getSelectionModel().clearSelection();                
        finalDisplacementUnits.getSelectionModel().selectFirst();
        newFinalDisplacementUnits.getSelectionModel().selectFirst();
        
        forceText.setText("");
        forceLabel.setText(""); 
        forceBox.getSelectionModel().clearSelection(); 
        forceUnits.getSelectionModel().selectFirst();
        newForceUnits.getSelectionModel().selectFirst();
        
        massText.setText("");
        massLabel.setText("");  
        massBox.getSelectionModel().clearSelection(); 
        massUnits.getSelectionModel().selectFirst();
        newMassUnits.getSelectionModel().selectFirst();        
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
            accelerationText.setText("-9.8");
        }//end if
        if(!gravityCheckBox.isSelected()){
            accelerationText.setText("");
        }//end if       
    }//end gravityBoxListener method
    @FXML private void convertButtonListenerIV(ActionEvent event) {
        //Error check user entries to make sure they are valid numbers
        ErrorCheck errorIV = new ErrorCheck();
        initialVelocityString = errorIV.variableEntry(initialVelocityText.getText());

        //Produce warning if entries are invalid
        if(initialVelocityString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers for initial velocity.");
            numberEntryAlert.showAndWait();
            initialVelocityText.setText("");
            initialVelocityUnits.getSelectionModel().selectFirst();
            newInitialVelocityUnits.getSelectionModel().selectFirst();
        }//end if          
        
        //Convert
        
        Converter convertIV = new Converter();
        if(initialVelocityUnits.getValue() == "m/s" && newInitialVelocityUnits.getValue() == "ft/s" && metersPerSecondVI == true){
            initialVelocityLabel.setText(convertIV.metersToFeet(initialVelocityLabel.getText()));
            initialVelocityText.setText(initialVelocityLabel.getText());
            feetPerSecondVI = true;
            metersPerSecondVI = false;
        }
        else if(newInitialVelocityUnits.getValue() == "m/s" && initialVelocityUnits.getValue() == "ft/s" && feetPerSecondVI == true){
            initialVelocityLabel.setText(convertIV.feetToMeters(initialVelocityLabel.getText()));
            initialVelocityText.setText(initialVelocityLabel.getText());
            feetPerSecondVI = false;
            metersPerSecondVI = true;
        }//end if         
    }//end convertButtonListenerIV method

    @FXML private void convertButtonListenerFV(ActionEvent event) {
        //Error check user entries to make sure they are valid numbers
        ErrorCheck errorFV = new ErrorCheck();
        finalVelocityString = errorFV.variableEntry(finalVelocityText.getText());

        //Produce warning if entries are invalid
        if(finalVelocityString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers for final velocity.");
            numberEntryAlert.showAndWait();
            finalVelocityText.setText("");
            finalVelocityUnits.getSelectionModel().selectFirst();
            newFinalVelocityUnits.getSelectionModel().selectFirst();
        }//end if          
        
        //Convert
        Converter convertFV = new Converter();        
        if(finalVelocityUnits.getValue() == "m/s" && newFinalVelocityUnits.getValue() == "ft/s" && metersPerSecondVF == true){
            finalVelocityLabel.setText(convertFV.metersToFeet(finalVelocityLabel.getText()));
            finalVelocityText.setText(finalVelocityLabel.getText());  
            feetPerSecondVF = true;
            metersPerSecondVF = false;
        } 
        else if(newFinalVelocityUnits.getValue() == "m/s" && finalVelocityUnits.getValue() == "ft/s" && feetPerSecondVF == true){
            finalVelocityLabel.setText(convertFV.feetToMeters(finalVelocityLabel.getText()));
            finalVelocityText.setText(finalVelocityLabel.getText());
            feetPerSecondVF = false;
            metersPerSecondVF = true;            
        }//end if           
    }//end convertButtonListenerFV

    @FXML private void convertButtonListenerA(ActionEvent event) {
        //Error check user entries to make sure they are valid numbers
        ErrorCheck errorA = new ErrorCheck();
        accelerationString = errorA.variableEntry(accelerationText.getText());

        //Produce warning if entries are invalid
        if(accelerationString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers for acceleration.");
            numberEntryAlert.showAndWait();
            accelerationText.setText("");
            accelerationUnits.getSelectionModel().selectFirst();
            newAccelerationUnits.getSelectionModel().selectFirst();
        }//end if          
        
        //Convert
        Converter convertA = new Converter();        
        if(accelerationUnits.getValue() == "m/s^2" && newAccelerationUnits.getValue() == "ft/s^2" && metersPerSecondSq == true){
            accelerationLabel.setText(convertA.metersToFeet(accelerationLabel.getText()));
            accelerationText.setText(accelerationLabel.getText());
            metersPerSecondSq = false;
            feetPerSecondSq = true;
        }  
        else if(newAccelerationUnits.getValue() == "m/s^2" && accelerationUnits.getValue() == "ft/s^2" && feetPerSecondSq == true){
            accelerationLabel.setText(convertA.feetToMeters(accelerationLabel.getText()));
            accelerationText.setText(accelerationLabel.getText());
            metersPerSecondSq = true;
            feetPerSecondSq = false;
        }//end if              
    }//end convertButtonListenerA

    @FXML private void convertButtonListenerID(ActionEvent event) {
        //Error check user entries to make sure they are valid numbers
        ErrorCheck errorID = new ErrorCheck();
        initialDisplacementString = errorID.variableEntry(initialDisplacementText.getText());

        //Produce warning if entries are invalid
        if(initialDisplacementString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers for initial position.");
            numberEntryAlert.showAndWait();
            initialDisplacementText.setText("");
            initialDisplacementUnits.getSelectionModel().selectFirst();
            newInitialDisplacementUnits.getSelectionModel().selectFirst();
        }//end if          
        
        //Convert
        Converter convertID = new Converter();
        if(initialDisplacementUnits.getValue() == "m" && newInitialDisplacementUnits.getValue() == "ft" && metersXI == true){
            initialDisplacementLabel.setText(convertID.metersToFeet(initialDisplacementLabel.getText()));
            initialDisplacementText.setText(initialDisplacementLabel.getText());
            metersXI = false;
            feetXI = true;
        }//end if  
        if(newInitialDisplacementUnits.getValue() == "m" && initialDisplacementUnits.getValue() == "ft" && feetXI == true){
            initialDisplacementLabel.setText(convertID.feetToMeters(initialDisplacementLabel.getText()));
            initialDisplacementText.setText(initialDisplacementLabel.getText());
            metersXI = true;
            feetXI = false;
        }//end if            
    }//end convertButtonListenerID

    @FXML private void convertButtonListenerFD(ActionEvent event) {
        //Error check user entries to make sure they are valid numbers
        ErrorCheck errorFD = new ErrorCheck();
        finalDisplacementString = errorFD.variableEntry(finalDisplacementText.getText());

        //Produce warning if entries are invalid
        if(finalDisplacementString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers for final position.");
            numberEntryAlert.showAndWait();
            finalDisplacementText.setText("");
            finalDisplacementUnits.getSelectionModel().selectFirst();
            newFinalDisplacementUnits.getSelectionModel().selectFirst();
        }//end if          
        
        //Convert
        Converter convertFD = new Converter();
        
        if(finalDisplacementUnits.getValue() == "m" && newFinalDisplacementUnits.getValue() == "ft" && metersXF == true){
            finalDisplacementLabel.setText(convertFD.metersToFeet(finalDisplacementLabel.getText()));
            finalDisplacementText.setText(finalDisplacementLabel.getText());
            metersXF = false;
            feetXF = true;
        } 
        else if(newFinalDisplacementUnits.getValue() == "m" && finalDisplacementUnits.getValue() == "ft" && feetXF == true){
            finalDisplacementLabel.setText(convertFD.feetToMeters(finalDisplacementLabel.getText()));
            finalDisplacementText.setText(finalDisplacementLabel.getText());
            metersXF = true;
            feetXF = false;            
        }//end if           
    }//end convertButtonListenerFD

    @FXML private void convertButtonListenerF(ActionEvent event) {
        //Error check user entries to make sure they are valid numbers
        ErrorCheck errorF = new ErrorCheck();
        forceString = errorF.variableEntry(forceText.getText());

        //Produce warning if entries are invalid
        if(forceString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers for force.");
            numberEntryAlert.showAndWait();
            forceText.setText("");
            forceUnits.getSelectionModel().selectFirst();
            newForceUnits.getSelectionModel().selectFirst();
        }//end if          
        
        //Convert
        Converter convertF = new Converter();        
        if(forceUnits.getValue() == "N" && newForceUnits.getValue() == "lb" && newtons == true){
            forceLabel.setText(convertF.metersToFeet(forceLabel.getText()));
            forceText.setText(forceLabel.getText());
            newtons = false;
            forceLBS = true;
        } else if(newForceUnits.getValue() == "N" && forceUnits.getValue() == "lb" && forceLBS == true){
            forceLabel.setText(convertF.feetToMeters(forceLabel.getText()));
            forceText.setText(forceLabel.getText());
            newtons = true;
            forceLBS = false;
        }//end if         
    }//end convertButtonListenerF

    @FXML private void convertButtonListenerM(ActionEvent event) {
        //Error check user entries to make sure they are valid numbers
        ErrorCheck errorM = new ErrorCheck();
        massString = errorM.variableEntry(massText.getText());

        //Produce warning if entries are invalid
        if(massString == "bad"){
            numberEntryAlert.setContentText("Please enter only numbers for mass.");
            numberEntryAlert.showAndWait();
            massText.setText("");
            massUnits.getSelectionModel().selectFirst();
            newMassUnits.getSelectionModel().selectFirst();
        }//end if          
        
        //Convert
        Converter convertM = new Converter();       
        if(massUnits.getValue() == "kg" && newMassUnits.getValue() == "lb" && kilograms == true){
            massLabel.setText(convertM.metersToFeet(massLabel.getText()));
            massText.setText(massLabel.getText());
            kilograms = false;
            lbs = true;
        }//end if  
        if(newMassUnits.getValue() == "kg" && massUnits.getValue() == "lb" && lbs == true){
            massLabel.setText(convertM.feetToMeters(massLabel.getText()));
            massText.setText(massLabel.getText());
            kilograms = true;
            lbs = false;
        }//end if          
    }//end convertButtonListenerM
}//end DocumentController
