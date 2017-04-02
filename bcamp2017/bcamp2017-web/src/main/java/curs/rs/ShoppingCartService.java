package curs.rs;

import java.util.Collection;

import javax.inject.Inject;
import javax.sql.DataSource;

import curs.cdi.PostgresDB;
import curs.dao.BookDAO;
import curs.dao.ShoppingCartDAO;
import curs.interfaces.ShoppingCartItemInterface;
import curs.model.Book;
import curs.model.ShoppingCart;
import curs.model.ShoppingCartItem;
import curs.rs.interfaces.ShoppingCartServiceInterface;

public class ShoppingCartService implements ShoppingCartServiceInterface {
	@Inject
	private ShoppingCartDAO mCartDAO;

	@Inject
	ShoppingCart mCart;

	@Override
	public boolean removeCartItem(ShoppingCartItem pItem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCartItem(Book pItem, int pQuantity) {
		for (ShoppingCartItemInterface sci : mCart.getItems()) {
			if (sci.getBook().getId().equals(pItem.getId())) {
				sci.setQuantity(sci.getQuantity() + pQuantity);
				return true;
			}
		}
		ShoppingCartItemInterface sci = new ShoppingCartItem();
		sci.setBook(pItem);
		sci.setQuantity(pQuantity);
		return true;
	}

	@Override
	public void cancelCart() {
		mCart.getItems().clear();

	}

	@Override
	public ShoppingCartItem checkoutCart() {
		// BAZA DATE !!!
		return null;
	}

	@Override
	public ShoppingCart getShoppingCart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ShoppingCart> getShoppingCartList() {
		// TODO Auto-generated method stub
		return null;
	}

}
