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
public class ConvertBase extends Application{
	private Stage stage;
	private Scene scene1;
	private Scene scene2;
	private TextField numberTextField;
	private TextField base1TextField;
	private TextField base2TextField;
	private Label resultLabel;
	private Label errorLabel;
	//private RadioButton binaryButton1;
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
	ToggleGroup radioGroup1;
	ToggleGroup radioGroup2;
	RadioButton[] radioArray1 = {binaryButton1, ternaryButton1, octalButton1, decimalButton1,
							hexadecimalButton1};
	RadioButton[] radioArray2 = {binaryButton2, ternaryButton2, octalButton2, decimalButton2,
							hexadecimalButton2};
	int[] radioBaseValues = {2, 3, 8, 10, 16};
	final int INVALID_BASE = -1;
	int startBase;
	int endBase;
	
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
		Button calcButton = new Button("Convert");
		Button resetButton = new Button("Reset");

		Label promptLabel = new Label("Enter a Number:");

		numberTextField = new TextField();
		numberTextField.textProperty().addListener(new textFieldListener());

		errorLabel = new Label();

		calcButton.setOnAction(new CalcButtonHandler());
		resetButton.setOnAction(new resetButtonHandler());

		Label convertFromLabel = new Label("Base to Convert From:");
		//binaryButton1 = new RadioButton("Binary");
		Label otherBase1Label = new Label("Enter other base (1-16):");
		base1TextField= new TextField();
		base1TextField.setPrefWidth(40);

		//decimalButton1.setSelected(true);

		radioGroup1 =  new ToggleGroup();
		binaryButton1.setToggleGroup(radioGroup1);
		ternaryButton1.setToggleGroup(radioGroup1);
		octalButton1.setToggleGroup(radioGroup1);
		decimalButton1.setToggleGroup(radioGroup1);
		hexadecimalButton1.setToggleGroup(radioGroup1);
		otherButton1.setToggleGroup(radioGroup1);

		Label convertToLabel = new Label("Base to Convert To:");
		Label otherBase2Label = new Label("Enter other base (1-16):");
		base2TextField= new TextField();
		base2TextField.setPrefWidth(40);

		//decimalButton2.setSelected(true);

		radioGroup2 = new ToggleGroup();
		binaryButton2.setToggleGroup(radioGroup2);
		ternaryButton2.setToggleGroup(radioGroup2);
		octalButton2.setToggleGroup(radioGroup2);
		decimalButton2.setToggleGroup(radioGroup2);
		hexadecimalButton2.setToggleGroup(radioGroup2);
		otherButton2.setToggleGroup(radioGroup2);





		HBox promptHBox = new HBox(10, promptLabel, numberTextField);

		HBox otherBase1Box = new HBox(10, otherBase1Label, base1TextField);
		otherBase1Box.visibleProperty().bind(otherButton1.selectedProperty());
		otherBase1Box.managedProperty().bind(otherButton1.selectedProperty());
		
		VBox radioVBox1 = new VBox(5, convertFromLabel, binaryButton1, ternaryButton1, octalButton1,
									decimalButton1, hexadecimalButton1, otherButton1,
									otherBase1Box);
		radioVBox1.setMinWidth(200);

		HBox otherBase2Box = new HBox(10, otherBase2Label, base2TextField);
		otherBase2Box.visibleProperty().bind(otherButton2.selectedProperty());
		otherBase2Box.managedProperty().bind(otherButton2.selectedProperty());

		VBox radioVBox2 = new VBox(5, convertToLabel, binaryButton2, ternaryButton2, octalButton2,
									decimalButton2, hexadecimalButton2, otherButton2,
									otherBase2Box);
		radioVBox2.setMinWidth(200);

		HBox radioBoxes = new HBox(0, radioVBox1, radioVBox2);

		HBox buttonsBox = new HBox(25, resetButton, calcButton);
		buttonsBox.setAlignment(Pos.CENTER);

		VBox mainVBox = new VBox(20, promptHBox, radioBoxes, errorLabel, buttonsBox);

		mainVBox.setAlignment(Pos.CENTER);

		mainVBox.setPadding(new Insets(10));

		return new Scene(mainVBox);
	}
	public Scene outputScene() {
		resultLabel = new Label();
		Button convertAgain = new Button("Convert Again");

		convertAgain.setOnAction(new convertAgainHandler());

		VBox mainVBox = new VBox(10, resultLabel, convertAgain);
		mainVBox.setAlignment(Pos.CENTER);
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
//			int[] values = new int[newValue.length()];

			errorLabel.setText(null);
			disableAll(false);

			while (!invalidChar && x < newValue.length()) {
				i = 0;
				foundIt = false;
				while (!foundIt && i < validChars.length) {
					if (Character.toUpperCase(newValue.charAt(x)) == validChars[i]) {
						foundIt = true;
//						values[x] = i;
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
//			for (int j = 0; j < values.length; j++) {
//				System.out.print(values[j] + ", ");
//			}
//			System.out.println();
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
			String number;
			Converter c;

			if (numberTextField.getText().isEmpty()) {
				errorLabel.setText("You must enter a number to convert");
			}
			else if (!getStartBase()) {
				errorLabel.setText("Enter a base to convert from");
			}
			else if (!getEndBase()) {
				errorLabel.setText("Enter a base to convert to");
			}
//			else {
//				startBase = getBaseValue(radioArray1);
//				if (startBase == INVALID_BASE && !base1TextField.getText().isEmpty()) {
//					try {
//						startBase = Integer.parseInt(base1TextField.getText());
//					} catch(NumberFormatException e) {
//						convertIt = false;
//						errorLabel.setText("Enter a base to convert from and to");
//					}
//				}
//				else {
//					convertIt = false;
//				}
//				endBase = getBaseValue(radioArray2);
//				if (endBase == INVALID_BASE && otherButton2.isSelected()) {
//					endBase = Integer.parseInt(base2TextField.getText());
//				}
//			}
////
//			if (startBase == INVALID_BASE || endBase == INVALID_BASE) {
//				errorLabel.setText("Enter a base to convert from and to");
//			}
			else {
				number = numberTextField.getText().toUpperCase();
//				System.out.println("start: " + startBase + " end: " + endBase + 
//						" number: " + number);
				c = new Converter(startBase, endBase, number);
				c.convert();
				
				resultLabel.setText(c.getNewNumber());
				stage.setScene(scene2);

				stage.setTitle("Base Converter");
			}
		}
	}
	public class convertAgainHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			resetControls();
			stage.setScene(scene1);
		}
	}
	public boolean getStartBase() {
		startBase = getBaseValue(radioArray1);
		if (startBase == INVALID_BASE && !base1TextField.getText().isEmpty()) {
			try {
				startBase = Integer.parseInt(base1TextField.getText());
			} catch(NumberFormatException e) {
				startBase = INVALID_BASE;
			}
		}
		return startBase != INVALID_BASE;
	}
	public boolean getEndBase() {
		endBase = getBaseValue(radioArray2);
		if (endBase == INVALID_BASE && !base2TextField.getText().isEmpty()) {
			try {
				endBase = Integer.parseInt(base2TextField.getText());
			} catch(NumberFormatException e) {
				endBase = INVALID_BASE;
			}
		}
		return endBase != INVALID_BASE;
	}
	public int getBaseValue(RadioButton[] arr) {
		int x = 0;
		boolean foundIt = false;
		int baseValue = INVALID_BASE;

		while (!foundIt && x < arr.length) {
			if (arr[x].isSelected()) {
				foundIt = true;
				baseValue = radioBaseValues[x];
			}
			x++;
		}
		return baseValue;
	}
}
	
