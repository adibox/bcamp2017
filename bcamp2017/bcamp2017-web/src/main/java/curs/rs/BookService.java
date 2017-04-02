package curs.rs;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.sql.DataSource;

import curs.cdi.Logging;
import curs.cdi.PostgresDB;
import curs.dao.BookDAO;
import curs.events.BookAddedEvent;
import curs.events.BookRemovedEvent;
import curs.model.Book;
import curs.rs.interfaces.BookServiceInterface;

@Logging
public class BookService implements BookServiceInterface, Serializable {
	@Inject
	@PostgresDB
	private DataSource mDS;
	@Inject
	private BookDAO mBookDAO;

	@Inject
	Event<BookAddedEvent> mBookAddNotifier;
	@Inject
	Event<BookRemovedEvent> mBookRemoveNotifier;

	public List<Book> getAllBooks() {
		return mBookDAO.getAllBooks();
	}

	public Book getBookById(Long pBookId) {
		return mBookDAO.findBookById(pBookId);
	}

	public Book addBook(Book pBook) {
		Book book = mBookDAO.addBook(pBook);
		mBookAddNotifier.fire(new BookAddedEvent(book));
		return book;
	}

	public Book updateBook(Book pBook) {
		return mBookDAO.updateBook(pBook.getId(), pBook);
	}

	public Book deleteBook(Long pBookId) {
		Book book = mBookDAO.deleteBook(pBookId);
		mBookRemoveNotifier.fire(new BookRemovedEvent(book));
		return book;
	}
}