package curs.events;

import curs.model.Book;

public class BookAddedEvent {
	private Book mBook;
	
	public BookAddedEvent(Book pBook) {
		mBook = pBook;
	}

	@Override
	public String toString() {
		return "BookAddedEvent [mBook=" + mBook + "]";
	}
}
