package curs.rs.interfaces;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import curs.model.Book;
import curs.model.ShoppingCart;
import curs.model.ShoppingCartItem;

@Path("/cart")
public interface ShoppingCartServiceInterface {
	@POST
	@Path("/remove/item")
	@Consumes(MediaType.APPLICATION_JSON)
	boolean removeCartItem(ShoppingCartItem pItem);

	@POST
	@Path("/add/item")
	@Consumes(MediaType.APPLICATION_JSON)
	boolean addCartItem(Book pItem,@QueryParam("q") int pQuantity);
	
	@POST
	@Path("/cancel")
	void cancelCart();

	@POST
	@Path("/checkout")
	@Produces(MediaType.APPLICATION_JSON)
	ShoppingCartItem checkoutCart();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	ShoppingCart getShoppingCart();

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	Collection<ShoppingCart> getShoppingCartList();
}
