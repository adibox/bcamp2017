package curs.interfaces;

import java.util.Collection;
import java.util.Date;

public interface ShoppingCartInterface {
	static enum Status {
		OPENED,FINALIZED,CANCELLED;
	}
	
	Long getId();
	Collection<ShoppingCartItemInterface> getItems();
	void setItems(Collection<ShoppingCartItemInterface> pItems);
	String getCartUser();
	void setCartUser(String pName);
	Status getCartStatus();
	void setCartStatus(Status pStatus);
	Date getCartStartTime();
	void setCartStartTime(Date pDate);
	Date getCartClosingTime();
	void setCartClosingTime(Date pDate);
	String getPaymentData();
	void setPaymentData();
	
}
