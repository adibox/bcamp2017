package curs.cdi;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

public class ConstantProducer {
	@Produces @Named("rest_url")
	String getRestServiceURL() {
		return "http://localhost:8080/Day33CDI/rest";
	}
}
