package curs.cdi;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Logger;

@ApplicationScoped
public class EntityManagerProducer {
	private static Logger mLogger = Logger.getLogger("EntityManagerProducer");
	
	private EntityManagerFactory mEMF;
	
	@PostConstruct
	public void postConstruct() {
		mEMF = Persistence.createEntityManagerFactory("JAXRS");
	}

	@Produces
	@Singleton
	public EntityManagerFactory getEntityManagerFactory() {
		return mEMF;
	}

	@Produces
	@RequestScoped
	public EntityManager getEM(EntityManagerFactory pEMFactory) {
		return pEMFactory.createEntityManager();
	}

	void close(@Disposes EntityManager pEM) {
		mLogger.info("Dispose:" + pEM);
		pEM.close();
	}
}
