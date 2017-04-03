package curs.interfaces;

import java.io.Serializable;

public interface ShoppingCartItemInterface extends Serializable {
	Long getId();
	ShoppingCartInterface getShoppingCart();
	BookInterface getBook();
	void setBook(BookInterface pBook);
	int getQuantity();
	void setQuantity(int pQuantity);
}
