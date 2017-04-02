package curs.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import curs.nav.ScreenNames;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterScreenController extends BaseController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField tLogin;

	@FXML
	private PasswordField tPassword;

	@FXML
	private PasswordField tPasswordConfirm;

	@FXML
	private Button bRegister;

	@FXML
	private ComboBox<String> tRole;

	@FXML
	void onRegister(ActionEvent event) {
		navigateToScreen(ScreenNames.loginScreen);
	}

	@FXML
	void initialize() {
		assert tLogin != null : "fx:id=\"tLogin\" was not injected: check your FXML file 'register_screen.fxml'.";
		assert tPassword != null : "fx:id=\"tPassword\" was not injected: check your FXML file 'register_screen.fxml'.";
		assert tPasswordConfirm != null : "fx:id=\"tPasswordConfirm\" was not injected: check your FXML file 'register_screen.fxml'.";
		assert bRegister != null : "fx:id=\"bRegister\" was not injected: check your FXML file 'register_screen.fxml'.";
		assert tRole != null : "fx:id=\"tRole\" was not injected: check your FXML file 'register_screen.fxml'.";
	
		tRole.getItems().addAll("User","Admin");
	}
}
