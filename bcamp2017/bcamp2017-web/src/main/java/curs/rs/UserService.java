package curs.rs;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import curs.cdi.Logging;
import curs.cdi.PostgresDB;
import curs.dao.UserDao;
import curs.exceptions.ValidationException;
import curs.model.User;
import curs.rs.interfaces.UserServiceInterface;
import curs.utils.ValidationUtils;

@Logging
public class UserService implements UserServiceInterface {
	@Inject
	@PostgresDB
	private DataSource mDS;
	@Inject
	private HttpServletRequest mHTTPRequest;
	@Inject
	private UserDao mUserDAO;

	@Override
	public boolean login(User pUser) {
		try {
			mHTTPRequest.getSession();
			mHTTPRequest.login(pUser.getLoginName(), pUser.getPasswd());
			return true;
		} catch (ServletException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void logout() {
		try {
			mHTTPRequest.logout();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		mHTTPRequest.getSession().invalidate();
	}

	@Override
	public boolean register(User pUser) {
		try {
			ValidationUtils.validatePassword(pUser.getPasswd());
		} catch(ValidationException ex) {
			ex.printStackTrace();
			return false;
		}
		try {
			mUserDAO.addUser(pUser);
			return true;
		} catch(PersistenceException pex) {
			pex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean isLoggedIn() {
		return mHTTPRequest.getUserPrincipal() != null;
	}

	@Override
	public boolean hasRole(String pRole) {
		return mHTTPRequest.isUserInRole(pRole);
	}

}
