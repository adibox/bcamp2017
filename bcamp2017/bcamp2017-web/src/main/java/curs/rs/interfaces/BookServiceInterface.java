package curs.rs.interfaces;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import curs.model.Book;

@Path("/books")
public interface BookServiceInterface {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getAllBooks();
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Book getBookById(@PathParam("id") Long pBookId);
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Book addBook(Book pBook);
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Book updateBook(Book pBook);
	
	@DELETE
	@Path("delete")
	public Book deleteBook(@QueryParam("book_id") Long pBookId);
}