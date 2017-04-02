package curs.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import curs.model.Book;
import curs.model.User;
import curs.nav.ScreenNames;
import curs.services.BookServiceInterface;
import curs.services.RestClient;
import curs.services.UserServiceInterface;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class BooksTableController extends BaseController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private VBox VBox;

	@FXML
	private Button btnRefresh;

	@FXML
	private TableView<Book> bookTable;

	@FXML
	private TableColumn<Book, String> colTitle;

	@FXML
	private TableColumn<Book, String> colAuthor;

	@FXML
	private TableColumn<Book, Integer> colAvail;

	@FXML
	private TableColumn<Book, Integer> colBooked;

	@FXML
	private TextField bTitle;

	@FXML
	private TextField bAuthor;

	@FXML
	private TextField bAvailable;

	@FXML
	private Button btnUpdate;

	@FXML
	private Button btnRemove;

	@FXML
	private Button btnAdd;

	@FXML
	private Button btnBook;

	@FXML
	private TextField bBooked;

	@FXML
	void onAdd(ActionEvent event) {
		if(true) {
			navigateToScreen(ScreenNames.loginScreen);
			return;
		}
		Book b = new Book();
		b.setTitle(bTitle.getText());
		b.setAuthor(bAuthor.getText());
		b.setAvailableCount(Integer.parseInt(bAvailable.getText()));
		try {
			mBSI.addBook(b).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		onRefreshBooks(event);
	}

	@FXML
	void onBook(ActionEvent event) {
		try {
			Integer count = Integer.parseInt(bBooked.getText());
			mCurrentBook.setAvailableCount(mCurrentBook.getAvailableCount() - count);
			mCurrentBook.setSellCount(mCurrentBook.getSellCount() + count);
			mBSI.updateBook(mCurrentBook).execute();
			onRefreshBooks(event);
		} catch(NumberFormatException ex) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Wrong quantity");
			alert.setContentText("Invalid number value");
			alert.showAndWait();
			return;
		} catch (IOException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Service Error");
			alert.setContentText("Service err:" + e.getMessage());
			alert.showAndWait();
		}
	}

	@FXML
	void onRemove(ActionEvent event) {
		try {
			mBSI.deleteBook(mCurrentBook.getId()).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		onRefreshBooks(event);
	}

	@FXML
	void onUpdate(ActionEvent event) {
		Book b = new Book();
		b.setTitle(bTitle.getText());
		b.setAuthor(bAuthor.getText());
		b.setId(mCurrentBook.getId());
		b.setAvailableCount(Integer.parseInt(bAvailable.getText()));
		b.setSellCount(mCurrentBook.getSellCount());
		try {
			mBSI.updateBook(b).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		onRefreshBooks(event);
	}
	
  @FXML
  void onRefreshBooks(ActionEvent event) {
  	System.out.println("OnResfreshBooks");
  	mBookCollection.clear();
  	try {
  		List<Book> books = mBSI.getAllBooks().execute().body();
    	System.out.println("OnResfreshBooks:" + books);
			mBookCollection.addAll(books);
			showBookDetails(null);
			mCurrentBook = null;
		} catch (IOException e) {
			e.printStackTrace();
		}
  }
  
  private final ObservableList<Book> mBookCollection = FXCollections.observableArrayList();
  private BookServiceInterface mBSI;
  private UserServiceInterface mUSI;
  private Book mCurrentBook;
  
  
  private void showBookDetails(Book pBook) {
    if (pBook != null) {
        // Fill the labels with info from the person object.
        bTitle.setText(pBook.getTitle());
        bAuthor.setText(pBook.getAuthor());
        bAvailable.setText("" + pBook.getAvailableCount());
    } else {
        // Person is null, remove all the text.
      bTitle.setText("");
      bAuthor.setText("");
      bAvailable.setText("");
    }
}

	@FXML
	void initialize() {
		assert VBox != null : "fx:id=\"VBox\" was not injected: check your FXML file 'books_table.fxml'.";
		assert btnRefresh != null : "fx:id=\"btnRefresh\" was not injected: check your FXML file 'books_table.fxml'.";
		assert bookTable != null : "fx:id=\"bookTable\" was not injected: check your FXML file 'books_table.fxml'.";
		assert colTitle != null : "fx:id=\"colTitle\" was not injected: check your FXML file 'books_table.fxml'.";
		assert colAuthor != null : "fx:id=\"colAuthor\" was not injected: check your FXML file 'books_table.fxml'.";
		assert colAvail != null : "fx:id=\"colAvail\" was not injected: check your FXML file 'books_table.fxml'.";
		assert colBooked != null : "fx:id=\"colBooked\" was not injected: check your FXML file 'books_table.fxml'.";
		assert bTitle != null : "fx:id=\"bTitle\" was not injected: check your FXML file 'books_table.fxml'.";
		assert bAuthor != null : "fx:id=\"bAuthor\" was not injected: check your FXML file 'books_table.fxml'.";
		assert bAvailable != null : "fx:id=\"bAvailable\" was not injected: check your FXML file 'books_table.fxml'.";
		assert btnUpdate != null : "fx:id=\"btnUpdate\" was not injected: check your FXML file 'books_table.fxml'.";
		assert btnRemove != null : "fx:id=\"btnRemove\" was not injected: check your FXML file 'books_table.fxml'.";
		assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'books_table.fxml'.";
		assert bBooked != null : "fx:id=\"bBooked\" was not injected: check your FXML file 'books_table.fxml'.";
		colAuthor.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
		colTitle.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
		colAvail.setCellValueFactory(new PropertyValueFactory<Book, Integer>("availableCount"));
		colBooked.setCellValueFactory(new PropertyValueFactory<Book, Integer>("sellCount"));

		/**
		OkHttpClient okClient = new OkHttpClient();
		okClient.interceptors().add(new Interceptor() {
			
			public Response intercept(Chain chain) throws IOException {
				System.out.println("req:" + chain.request().toString());
				Response response = chain.proceed(chain.request());
				return response;
			}
		});
		String baseUrl = "http://localhost:8080/Day33CDI/rest/";
		Retrofit client = new Retrofit.Builder().baseUrl(baseUrl).client(okClient).addConverterFactory(JacksonConverterFactory.create()).build();
		mBSI = client.create(BookServiceInterface.class);
		*/
		mBSI = RestClient.instance().getBookServiceInterface();
		mUSI = RestClient.instance().getUserServiceInterface();
		User user = new User();
		user.setLoginName("viorel");
		user.setPasswd("viorel");
		try {
			System.out.println("Login:" + mUSI.login(user).execute().body());
			System.out.println("isLoggedIn:" + mUSI.isLoggedIn().execute().body());
			System.out.println("logout:" + mUSI.logout().execute().body());
			System.out.println("isLoggedIn:" + mUSI.isLoggedIn().execute().body());
			System.out.println("Login:" + mUSI.login(user).execute().body());
		} catch (IOException e) {
			e.printStackTrace();
		}
		bookTable.setItems(mBookCollection);
		btnUpdate.disableProperty().bind(Bindings.isNull(bookTable.getSelectionModel().selectedItemProperty()));
		btnRemove.disableProperty().bind(Bindings.isNull(bookTable.getSelectionModel().selectedItemProperty()));
		btnBook.disableProperty().bind(Bindings.isNull(bookTable.getSelectionModel().selectedItemProperty()));
		showBookDetails(null);
	  // Listen for selection changes and show the person details when changed.
	  bookTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
	  	showBookDetails(newValue);
	  	mCurrentBook = newValue;
	  });
	}

	
	
}
