package curs.interfaces;

public interface ShoppingCartItemInterface {
	Long getId();
	ShoppingCartInterface getShoppingCart();
	BookInterface getBook();
	void setBook(BookInterface pBook);
	int getQuantity();
	void setQuantity(int pQuantity);
}
