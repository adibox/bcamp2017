package curs.test;

import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import curs.model.Book;
import curs.rs.interfaces.BookServiceInterface;

import static org.junit.Assert.*;


public class InMemoryRestTest {
    public static class BookResource implements BookServiceInterface {

		@Override
		public List<Book> getAllBooks() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Book getBookById(Long pBookId) {
			Book book = new Book();
			book.setAuthor("MyAUth");
			return book;
		}

		@Override
		public Book addBook(Book pBook) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Book updateBook(Book pBook) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Book deleteBook(Long pBookId) {
			// TODO Auto-generated method stub
			return null;
		}

    }
    
    public static BookResource sut = new BookResource();
    public static InMemoryRestServer server;

    @BeforeClass
    public static void beforeClass() throws Exception {
        server = InMemoryRestServer.create(sut);
    }

    @AfterClass
    public static void afterClass() throws Exception {
        server.close();
    }

    @Test
    public void getBookById() throws Exception {

        Response response = server.newRequest("/books/{id}").resolveTemplate("id", 22).request().get();
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        Book myModel = response.readEntity(Book.class);
        assertEquals("MyAUth", myModel.getAuthor());
    }
}
