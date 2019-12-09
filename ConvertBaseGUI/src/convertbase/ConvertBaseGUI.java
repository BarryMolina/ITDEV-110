/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertbase;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Node;
/**
 *
 * @author barrymolina
 */
public class ConvertBaseGUI extends Application{
	private Stage stage;
	private Scene scene1;
	private Scene scene2;
	private TextField numberTextField;
	private TextField base1TextField;
	private TextField base2TextField;
	private Label errorLabel;
	private final RadioButton binaryButton1 = new RadioButton("Binary");
	private final RadioButton ternaryButton1 = new RadioButton("Ternary");
	private final RadioButton octalButton1 = new RadioButton("Octal");
	private final RadioButton decimalButton1 = new RadioButton("Decimal");
	private final RadioButton hexadecimalButton1 = new RadioButton("Hexadecimal");
	private final RadioButton otherButton1 = new RadioButton("Other");
	private final RadioButton binaryButton2 = new RadioButton("Binary");
	private final RadioButton ternaryButton2 = new RadioButton("Ternary");
	private final RadioButton octalButton2 = new RadioButton("Octal");
	private final RadioButton decimalButton2 = new RadioButton("Decimal");
	private final RadioButton hexadecimalButton2 = new RadioButton("Hexadecimal");
	private final RadioButton otherButton2 = new RadioButton("Other");
	private Label baseLabel1;
	private Label baseLabel2;
	private Label numberLabel;
	private Label resultLabel;
	private String number;
	private String newNumber;
	private ToggleGroup radioGroup1;
	private ToggleGroup radioGroup2;
	private RadioButton[] radioArray1 = {binaryButton1, ternaryButton1, octalButton1, decimalButton1,
							hexadecimalButton1};
	private RadioButton[] radioArray2 = {binaryButton2, ternaryButton2, octalButton2, decimalButton2,
							hexadecimalButton2};
	private int[] radioBaseValues = {2, 3, 8, 10, 16};
	private final int NO_BASE = -1;
	private final int INVALID_BASE = -9;
	private final int TOO_LOW = -99;
	private int startBase;
	private int endBase;
	private int[] values;
	
	public static void main(String[] args) {
		launch(args);
    }
	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;
		scene1 = inputScene();
		scene2 = outputScene();

		primaryStage.setScene(scene1);
		primaryStage.setTitle("Base Converter");
		primaryStage.setMinWidth(420);

		primaryStage.show();
	}
	public Scene inputScene() {
		//declarations
			numberTextField = new TextField();
			base1TextField= new TextField();
			base2TextField= new TextField();
			radioGroup1 =  new ToggleGroup();
			radioGroup2 = new ToggleGroup();
			errorLabel = new Label();

			Button calcButton = new Button("Convert");
			Button resetButton = new Button("Reset");
			Label promptLabel = new Label("Enter a Number:");
			Label convertFromLabel = new Label("Base to Convert From:");
			Label convertToLabel = new Label("Base to Convert To:");
			Label otherBase1Label = new Label("Enter other base (1-16):");
			Label otherBase2Label = new Label("Enter other base (1-16):");

			HBox promptHBox = new HBox(10, promptLabel, numberTextField);
			HBox otherBase1Box = new HBox(10, otherBase1Label, base1TextField);
			HBox otherBase2Box = new HBox(10, otherBase2Label, base2TextField);
			VBox radioVBox1 = new VBox(5, convertFromLabel, binaryButton1, ternaryButton1, octalButton1,
										decimalButton1, hexadecimalButton1, otherButton1,
										otherBase1Box);
			VBox radioVBox2 = new VBox(5, convertToLabel, binaryButton2, ternaryButton2, octalButton2,
										decimalButton2, hexadecimalButton2, otherButton2,
										otherBase2Box);
			HBox radioBoxes = new HBox(0, radioVBox1, radioVBox2);
			HBox buttonsBox = new HBox(25, resetButton, calcButton);
			VBox mainVBox = new VBox(20, promptHBox, radioBoxes, errorLabel, buttonsBox);

		binaryButton1.setToggleGroup(radioGroup1);
		ternaryButton1.setToggleGroup(radioGroup1);
		octalButton1.setToggleGroup(radioGroup1);
		decimalButton1.setToggleGroup(radioGroup1);
		hexadecimalButton1.setToggleGroup(radioGroup1);
		otherButton1.setToggleGroup(radioGroup1);

		binaryButton2.setToggleGroup(radioGroup2);
		ternaryButton2.setToggleGroup(radioGroup2);
		octalButton2.setToggleGroup(radioGroup2);
		decimalButton2.setToggleGroup(radioGroup2);
		hexadecimalButton2.setToggleGroup(radioGroup2);
		otherButton2.setToggleGroup(radioGroup2);

		base1TextField.setPrefWidth(40);
		base2TextField.setPrefWidth(40);

		radioVBox1.setMinWidth(200);
		radioVBox2.setMinWidth(200);

		buttonsBox.setAlignment(Pos.CENTER);
		mainVBox.setAlignment(Pos.CENTER);
		mainVBox.setPadding(new Insets(10));

		numberTextField.textProperty().addListener(new textFieldListener());
		otherBase1Box.visibleProperty().bind(otherButton1.selectedProperty());
		otherBase2Box.visibleProperty().bind(otherButton2.selectedProperty());

		calcButton.setOnAction(new CalcButtonHandler());
		resetButton.setOnAction(new resetButtonHandler());

		return new Scene(mainVBox);
	}
	public Scene outputScene() {
		//declarations
			baseLabel1 = new Label();
			baseLabel2 = new Label();
			numberLabel = new Label();
			resultLabel = new Label();

			Button againButton = new Button("Convert Again");
			Button quitButton = new Button("Quit");

			HBox baseBox = new HBox(20, baseLabel1, baseLabel2);
			HBox numberBox = new HBox(20, numberLabel, resultLabel);
			HBox buttonBox = new HBox(20, againButton, quitButton);
			VBox mainVBox = new VBox(10, baseBox, numberBox, buttonBox);

		againButton.setOnAction(new convertAgainHandler());
		quitButton.setOnAction(new quitHandler());

		baseBox.setAlignment(Pos.CENTER);
		numberBox.setAlignment(Pos.CENTER);
		buttonBox.setAlignment(Pos.CENTER);
		mainVBox.setPadding(new Insets(10));

		return new Scene(mainVBox);
	}
	private class textFieldListener implements ChangeListener<String> {
		@Override
		public void changed(ObservableValue< ? extends String> observable, String oldValue, String newValue) {
			char[] validChars = Converter.allChars;
			int highestNum = 0;
			int x = 0;
			int i;
			boolean foundIt;
			boolean invalidChar = false;
			values = new int[newValue.length()];

			errorLabel.setText(null);
			disableAll(false);

			while (!invalidChar && x < newValue.length()) {
				i = 0;
				foundIt = false;
				while (!foundIt && i < validChars.length) {
					if (Character.toUpperCase(newValue.charAt(x)) == validChars[i]) {
						foundIt = true;
						values[x] = i;
						if (i > highestNum) {
							highestNum = i;
							disableButtons(highestNum);
						}
					}
					i++;
				}
				if (!foundIt) {
					invalidChar = true;
					errorLabel.setText("You must enter an integer or letter A-F");
					disableAll(true);
				}
				x++;
			}
		}
    }
	public void disableButtons(int highestNum) {
		int x = 0;
		boolean validButton = false;
		while (!validButton && x < radioBaseValues.length) {
			if (radioBaseValues[x] <= highestNum) {
				radioArray1[x].setSelected(false);
				radioArray1[x].setDisable(true);
			}
			else {
				validButton = true;
			}
			x++;
		}
	}
	public void resetControls() {
		radioGroup1.selectToggle(null);
		radioGroup2.selectToggle(null);
		numberTextField.clear();
		base1TextField.clear();
		base2TextField.clear();
		errorLabel.setText("");
	}
	public void disableAll(boolean truthValue) {
		radioGroup1.getToggles().forEach(toggle -> {
			Node node = (Node) toggle ;
			node.setDisable(truthValue);
		});
	}
	public class resetButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			resetControls();
		}
	}
	
	public class CalcButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			Converter c;

			if (numberTextField.getText().isEmpty()) {
				errorLabel.setText("You must enter a number to convert");
			}
			else if (getStartBase() == NO_BASE || getEndBase() == NO_BASE) {
				errorLabel.setText("Enter a base to convert from and a base to convert from");
			}
			else if (startBase == INVALID_BASE || endBase == INVALID_BASE) {
				errorLabel.setText("Invalid base");
			}
			else if (startBase == TOO_LOW) {
				errorLabel.setText("Start Base too low.");
			}
			else {
				number = numberTextField.getText().toUpperCase();
				c = new Converter(startBase, endBase, number);
				c.convert();
				
				newNumber = c.getNewNumber();
				baseLabel1.setText("Start Base: " + startBase);
				baseLabel2.setText("End Base: " + endBase);
				numberLabel.setText("Number Converted: " + number);
				resultLabel.setText("Result: " + newNumber);
				stage.setScene(scene2);

				stage.setTitle("Result");
			}
		}
	}
	public class convertAgainHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			resetControls();
            stage.setTitle("Base Converter");
			stage.setScene(scene1);
		}
	}
	public class quitHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			System.exit(0);
		}
	}
	public int getStartBase() {
		startBase = getRadioBase(radioArray1);
		if (startBase == NO_BASE && !base1TextField.getText().isEmpty()) {
			try {
				startBase = Integer.parseInt(base1TextField.getText());
				validateStartBase();
			} catch(NumberFormatException e) {
				startBase = INVALID_BASE;
			}
		}
		return startBase;
	}
	public int getEndBase() {
		endBase = getRadioBase(radioArray2);
		if (endBase == NO_BASE && !base2TextField.getText().isEmpty()) {
			try {
				endBase = Integer.parseInt(base2TextField.getText());
				validateEndBase();
			} catch(NumberFormatException e) {
				endBase = INVALID_BASE;
			}
		}
		return endBase;
	}
	public int getRadioBase(RadioButton[] arr) {
		int x = 0;
		boolean foundIt = false;
		int baseValue = NO_BASE;

		while (!foundIt && x < arr.length) {
			if (arr[x].isSelected()) {
				foundIt = true;
				baseValue = radioBaseValues[x];
			}
			x++;
		}
		return baseValue;
	}
	public void validateStartBase() {
		int x = 0;
		if (startBase < 1 || startBase > 16) {
			startBase = INVALID_BASE;
		}
		else {
			while (x < values.length && startBase != TOO_LOW) {
				if (startBase <= values[x]) {
					startBase = TOO_LOW;
				}
				x++;
			}
		}
	}
	public void validateEndBase() {
		if (endBase < 1 || endBase > 16) {
			endBase = INVALID_BASE;
		}
	}
}
	
