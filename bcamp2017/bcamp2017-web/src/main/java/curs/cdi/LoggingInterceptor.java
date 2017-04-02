package curs.cdi;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Logging
public class LoggingInterceptor {
	@AroundInvoke
	public Object logMethodEntry(InvocationContext ctx) throws Exception {
		System.out.println("Entering method: " + ctx.getMethod().getName());
		
		// or logger.info statement
		try {
			//Thread.sleep(2000);
			return ctx.proceed();
		} finally {
			System.out.println("Exiting method: " + ctx.getMethod().getName());

		}
	}
}
