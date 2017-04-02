package curs.services;

import java.util.List;

import curs.model.Book;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;

public interface BookServiceInterface {
	@Headers({
		
		"Accept: application/json",
		"Content-Type: application/json"
	})
	@GET("books")
	public Call<List<Book>> getAllBooks();
	
	@Headers({
		"Accept: application/json",
		"Content-Type: application/json"
	})
	@GET("books/{id}")
	public Call<Book> getBookById(@Path("id") Long pBookId);
	
	@Headers({
		"Accept: application/json",
		"Content-Type: application/json"
	})
	@POST("books")
	public Call<Book> addBook(@Body Book pBook);
	
	@Headers({
		"Accept: application/json",
		"Content-Type: application/json"
	})
	@PUT("books")
	public Call<Book> updateBook(@Body Book pBook);
	
	@Headers({
		"Accept: application/json",
		"Content-Type: application/json"
	})
	@DELETE("books/delete")
	public Call<Book> deleteBook(@Query("book_id") Long pBookId);
}
