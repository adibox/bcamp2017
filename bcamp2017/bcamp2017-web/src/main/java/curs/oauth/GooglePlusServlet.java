package curs.oauth;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.scribe.builder.ServiceBuilder;
import org.scribe.oauth.OAuthService;

/**
 * Servlet implementation class GooglePlusServlet
 */
@WebServlet("/googleplus")
public class GooglePlusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String CLIENT_ID = "410250824477-6se9f1ho0qat5ns11art9iob4hfd53lh.apps.googleusercontent.com";
	private static final String CLIENT_SECRET = "5LBF9AVJpCTUvHZX-hltH1tZ";

	@Override
	protected void doGet(HttpServletRequest pReq, HttpServletResponse pRes) throws IOException, ServletException {
		// Configure
		pReq.getSession();
		ServiceBuilder builder = new ServiceBuilder();
		OAuthService service = builder.provider(Google2Api.class).apiKey(CLIENT_ID).apiSecret(CLIENT_SECRET).callback("http://localhost:8080/bcamp/oauth2callback")
		    .scope("openid profile email https://www.googleapis.com/auth/plus.login https://www.googleapis.com/auth/plus.me").build(); // Now
		                                                                                                                               // build
		                                                                                                                               // the
		                                                                                                                               // call
		HttpSession sess = pReq.getSession();
		sess.setAttribute("oauth2Service", service);
		pRes.sendRedirect(service.getAuthorizationUrl(null));
	}

}
