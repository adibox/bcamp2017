package curs.model;

import curs.interfaces.BookInterface;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book implements BookInterface {
	private SimpleLongProperty id = new SimpleLongProperty();
	private SimpleStringProperty title = new SimpleStringProperty();
	private SimpleStringProperty author = new SimpleStringProperty();
	private SimpleIntegerProperty available = new SimpleIntegerProperty();
	private SimpleIntegerProperty booked = new SimpleIntegerProperty();

	
	public Long getId() {
		return id.getValue();
	}

	public void setId(Long id) {
		this.id.set(id);
	}

	public String getTitle() {
		return title.get();
	}

	public void setTitle(String title) {
		this.title.set(title);
	}

	public String getAuthor() {
		return author.get();
	}

	public void setAuthor(String author) {
		this.author.set(author);
	}

	public Integer getAvailableCount() {
		return available.getValue();
	}

	public void setAvailableCount(Integer available) {
		this.available.set(available);
	}

	public Integer getSellCount() {
		return booked.getValue();
	}

	public void setSellCount(Integer booked) {
		this.booked.set(booked);
	}

}
