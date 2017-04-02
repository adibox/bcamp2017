package curs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import curs.interfaces.BookInterface;
import curs.interfaces.ShoppingCartInterface;
import curs.interfaces.ShoppingCartItemInterface;

@Entity
@Table(name = "cart_item")
public class ShoppingCartItem implements ShoppingCartItemInterface {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="cart_fk")
	private ShoppingCart mCart;
	@ManyToOne
	@JoinColumn(name="book_fk")
	private Book mBook;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public ShoppingCartInterface getShoppingCart() {
		return mCart;
	}

	@Override
	public BookInterface getBook() {
		return mBook;
	}

	@Override
	public void setBook(BookInterface pBook) {
		mBook = (Book)pBook;
	}

	@Override
	public int getQuantity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setQuantity(int pQuantity) {
		// TODO Auto-generated method stub

	}

}
