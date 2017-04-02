package curs.rs;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class CursApplication extends Application {
	/**
	 * private Set<Object> singletons = new HashSet<Object>();
	 * 
	 * public CursApplication() { singletons.add(new BookService()); }
	 * 
	 * @Override public Set<Object> getSingletons() { return singletons; }
	 */

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(BookService.class);
		classes.add(UserService.class);
		return classes;
	}

}
