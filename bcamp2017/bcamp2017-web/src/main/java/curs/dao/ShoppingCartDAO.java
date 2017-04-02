package curs.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import curs.cdi.Logging;

@RequestScoped
@Logging
public class ShoppingCartDAO {
	@Inject
	private EntityManager mEM;
}
