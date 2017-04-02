package curs.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import curs.interfaces.ShoppingCartInterface;
import curs.interfaces.ShoppingCartItemInterface;

public class ShoppingCart implements ShoppingCartInterface {
	private Collection<ShoppingCartItemInterface> mItems = new ArrayList<>();
	private String mCartUser;
	private Status mStatus;
	private Date mStartTime;
	private Date mClosingTime;
	private String mPaymentData;
	
	@Override
	public Collection<ShoppingCartItemInterface> getItems() {
		return mItems;
	}

	@Override
	public void setItems(Collection<ShoppingCartItemInterface> pItems) {
		mItems = new ArrayList<>(pItems);
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

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
