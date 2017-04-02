package curs.model;

import curs.interfaces.BookInterface;
import curs.interfaces.ShoppingCartInterface;
import curs.interfaces.ShoppingCartItemInterface;

public class ShoppingCartItem implements ShoppingCartItemInterface {
	private BookInterface mBook;
	private int mQuantity;

	@Override
	public BookInterface getBook() {
		return mBook;
	}

	@Override
	public void setBook(BookInterface pBook) {
		mBook = pBook;

	}

	@Override
	public int getQuantity() {

		return mQuantity;
	}

	@Override
	public void setQuantity(int pQuantity) {
		mQuantity = pQuantity;

	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShoppingCartInterface getShoppingCart() {
		// TODO Auto-generated method stub
		return null;
	}

}
