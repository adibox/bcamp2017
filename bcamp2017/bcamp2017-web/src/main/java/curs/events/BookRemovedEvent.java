package curs.events;

import curs.model.Book;

public class BookRemovedEvent {
	private Book mBook;

	public BookRemovedEvent(Book pBook) {
		mBook = pBook;
	}

	@Override
	public String toString() {
		return "BookRemovedEvent [mBook=" + mBook + "]";
	}
}
