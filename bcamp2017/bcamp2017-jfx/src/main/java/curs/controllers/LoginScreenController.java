package curs.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import curs.model.User;
import curs.nav.ScreenNames;
import curs.services.RestClient;
import curs.services.UserServiceInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginScreenController extends BaseController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField tLogin;

	@FXML
	private PasswordField tPassword;

	@FXML
	private Button bLogin;

	@FXML
	private Button bRegister;

	@FXML
	void onLogin(ActionEvent event) {
		if(true) {
			navigateToScreen(ScreenNames.bookListScreen);
			return;
		}
		
		UserServiceInterface us = RestClient.instance().getUserServiceInterface();
		User user = new User();
		user.setLoginName(tLogin.getText());
		user.setPasswd(tPassword.getText());
		if(user.getLoginName() == null ||
				user.getLoginName().trim().isEmpty() ||
				user.getPasswd() == null ||
				user.getPasswd().trim().isEmpty()) {
			Alert dlg = new Alert(AlertType.WARNING);
			dlg.setTitle("Please fill in user name and password");
			dlg.setContentText("Unsuccessful login");
			dlg.showAndWait();
			return;
		}
		try {
			if(us.login(user).execute().body()) {
				Alert dlg = new Alert(AlertType.CONFIRMATION);
				dlg.setTitle("Hello:" + user.getLoginName());
				dlg.setContentText("Successful login");
				dlg.showAndWait();
			} else {
				Alert dlg = new Alert(AlertType.WARNING);
				dlg.setTitle("Try again or register");
				dlg.setContentText("Unsuccessful login");
				dlg.showAndWait();
			
			}
		} catch (IOException e) {
			Alert dlg = new Alert(AlertType.ERROR);
			dlg.setTitle("Error");
			dlg.setContentText("Err message:" + e.getMessage());
			dlg.showAndWait();		}
	}

	@FXML
	void onRegister(ActionEvent event) {
		navigateToScreen(ScreenNames.registerScreen);
	}

	@FXML
	void initialize() {
		assert tLogin != null : "fx:id=\"tLogin\" was not injected: check your FXML file 'Login_screen.fxml'.";
		assert tPassword != null : "fx:id=\"tPassword\" was not injected: check your FXML file 'Login_screen.fxml'.";
		assert bLogin != null : "fx:id=\"bLogin\" was not injected: check your FXML file 'Login_screen.fxml'.";
		assert bRegister != null : "fx:id=\"bRegister\" was not injected: check your FXML file 'Login_screen.fxml'.";

	}
}
