package curs.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import curs.cdi.Logging;
import curs.model.User;

@RequestScoped
@Logging
public class UserDao {
	@Inject
	private EntityManager mEM;

	public void addUser(User pUser) {
		if(mEM.getTransaction().isActive() && mEM.getTransaction().getRollbackOnly()) {
			throw new PersistenceException("Transaction marked for rollback");
		}
		boolean newTransaction = false;
		if (!mEM.getTransaction().isActive()) {
			newTransaction = true;
			mEM.getTransaction().begin();
		}
		try {
			mEM.persist(pUser);
			mEM.flush();
			if (newTransaction) {
				mEM.getTransaction().commit();
			}
		} catch (PersistenceException pex) {
			mEM.getTransaction().rollback();
			throw pex;
		}
	}
}
