package curs.main;

import java.util.logging.Level;
import java.util.logging.Logger;

import curs.nav.ScreenNames;
import curs.nav.ScreensController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
	private static final Logger __log = Logger.getLogger(MainApp.class.getSimpleName());

	
	public static void main(String[] args) throws Exception {
		launch(args);
	}

	public void start(Stage stage) throws Exception {

		__log.info("Starting Hello JavaFX and Maven demonstration application");
		ScreensController mainContainer = new ScreensController();
		mainContainer.loadScreen(ScreenNames.loginScreen,ScreenNames.loginScreenResource);
		mainContainer.loadScreen(ScreenNames.bookListScreen, ScreenNames.bookListScreenResource);
		mainContainer.loadScreen(ScreenNames.registerScreen, ScreenNames.registerScreenResource);
		mainContainer.setScreen(ScreenNames.loginScreen);

		Group root = new Group();
		root.getChildren().addAll(mainContainer);
		Scene scene = new Scene(root,1024,600);
		stage.setScene(scene);
		stage.show();

		if (false) {
			// String fxmlFile = "/fxml/hello.fxml";
			String fxmlFile = "/fxml/books_table.fxml";
			// String fxmlFile = "/fxml/Login_screen.fxml";
			__log.log(Level.FINE, "Loading FXML for main view from: {}", new Object[] { fxmlFile });
			FXMLLoader loader = new FXMLLoader();
			Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

			__log.log(Level.FINE, "Showing JFX scene");
			Scene scene1 = new Scene(rootNode, 1024, 600);
			scene1.getStylesheets().add("/styles/styles.css");

			stage.setTitle("Hello JavaFX and Maven");
			stage.setScene(scene1);
			stage.show();

		}
	}
}
