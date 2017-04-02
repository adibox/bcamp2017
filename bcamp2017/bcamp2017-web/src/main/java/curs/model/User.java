package curs.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "users", schema = "security")
public class User {
	@Id
	@Column(name = "user_name")
	private String mLoginName;
	@Column(name = "user_pass")
	private String mPasswd;
	@ElementCollection
	@CollectionTable(name = "user_roles", schema = "security", joinColumns = { @JoinColumn(name = "user_name") })
	@Column(name = "role_name")
	private Collection<String> mRoles = new ArrayList<String>();

	public Collection<String> getRoles() {
		return mRoles;
	}

	public void setRoles(Collection<String> pRoles) {
		mRoles = pRoles;
	}

	public String getLoginName() {
		return mLoginName;
	}

	public void setLoginName(String pLoginName) {
		mLoginName = pLoginName;
	}

	public String getPasswd() {
		return mPasswd;
	}

	public void setPasswd(String pPasswd) {
		mPasswd = pPasswd;
	}

}
