package curs.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import curs.interfaces.ShoppingCartInterface;
import curs.interfaces.ShoppingCartItemInterface;

@SessionScoped
@Entity
@Table(name = "cart_item")
public class ShoppingCart implements ShoppingCartInterface {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(mappedBy="mCart")
	private Collection<ShoppingCartItem> mItems;
	@Column(name="status")
	private Status mStatus = Status.OPENED;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public Collection<ShoppingCartItemInterface> getItems() {
		return new ArrayList<>(mItems);
	}

	@Override
	public void setItems(Collection<ShoppingCartItemInterface> pItems) {
		mItems = new ArrayList<>();
		for(ShoppingCartItemInterface sci : pItems) {
			mItems.add((ShoppingCartItem)sci);
		}
	}

	@Override
	public String getCartUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCartUser(String pName) {
		// TODO Auto-generated method stub

	}

	@Override
	public Status getCartStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCartStatus(Status pStatus) {
		// TODO Auto-generated method stub

	}

	@Override
	public Date getCartStartTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCartStartTime(Date pDate) {
		// TODO Auto-generated method stub

	}

	@Override
	public Date getCartClosingTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCartClosingTime(Date pDate) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getPaymentData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPaymentData() {
		// TODO Auto-generated method stub

	}

}
