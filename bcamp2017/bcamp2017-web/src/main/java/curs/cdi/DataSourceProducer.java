package curs.cdi;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import javax.naming.InitialContext;
import javax.sql.DataSource;

@Singleton
public class DataSourceProducer {
	private Logger mLogger = Logger.getLogger("DataSourceProducer");

	@Resource(name = "jdbc/postgres_test")
	DataSource mDS;

	@Produces
	@PostgresDB
	DataSource getPostgresDS() {
		mLogger.info("In getPostgresDS");
		return mDS;
	}

	@Produces
	@OracleDB
	public DataSource getOracleDS() {
		mLogger.info("In getOracleDS");
		try {
			InitialContext cxt = new InitialContext();
			return (DataSource) cxt.lookup("java:/comp/env/jdbc/postgres_test");
		} catch (Exception e) {
			mLogger.log(Level.WARNING, "getOracleDS", e);
			throw new RuntimeException();
		}
	}
}
