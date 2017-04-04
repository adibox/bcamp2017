package curs.oauth;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.Logger;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

/**
 * Servlet implementation class OAuth2CallbackServlet
 */
@WebServlet(urlPatterns = { "/oauth2callback" })
public class OAuth2CallbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger __logger = Logger.getLogger("OAuth2CallbackServlet");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OAuth2CallbackServlet() {
		super();
	}

	protected void doGet(HttpServletRequest pReq, HttpServletResponse pResp) throws IOException, ServletException {
		// Check if the user have rejected
		__logger.info("doGet :" + pReq.getRequestURI() + ":" + pReq.getQueryString());
		String error = pReq.getParameter("error");
		__logger.info("doGet : error: " + error);

		if ((null != error) && ("access_denied".equals(error.trim()))) {
			HttpSession sess = pReq.getSession();
			sess.invalidate();
			pResp.sendRedirect(pReq.getContextPath());
			return;
		}
		// OK the user have consented so lets find out about the user
		__logger.info("doGet startAsync");

		new GetUserInfo(pReq, pResp).run();
	}

	static class GetUserInfo implements Runnable {
		private HttpServletRequest req;
		private HttpServletResponse resp;

		public GetUserInfo(HttpServletRequest req, HttpServletResponse resp) {
			this.req = req;
			this.resp = resp;
		}

		@Override
		public void run() {
			__logger.info("GetUserInfo run - req:" + req.getRequestURI() + ":" + req.getQueryString());
			HttpSession sess = req.getSession();
			OAuthService service = (OAuthService) sess.getAttribute("oauth2Service");
			// Get the all important authorization code
			String code = req.getParameter("code");
			// Construct the access token
			__logger.info("GetUserInfo code");
			Token token = service.getAccessToken(null, new Verifier(code));
			// Save the token for the duration of the session
			sess.setAttribute("token", token);
			// Perform a proxy login
			// Now do something with it - get the user's G+ profile
			OAuthRequest oReq = new OAuthRequest(Verb.GET, "https://www.googleapis.com/oauth2/v2/userinfo");
			service.signRequest(token, oReq);
			Response oResp = oReq.send();

			// Read the result
			JsonReader reader = Json.createReader(new ByteArrayInputStream(oResp.getBody().getBytes()));
			JsonObject profile = reader.readObject();
			// Save the user details somewhere or associate it with
			__logger.info("GetUserInfo profile:" + profile);
			sess.setAttribute("user_name", profile.getString("name"));
			sess.setAttribute("user_email", profile.getString("email"));
			try {
				req.login("viorel", "viorel");
				__logger.info("Login success");
			} catch (ServletException e) {
				// Handle error - should not happen
			}
			try {
				resp.sendRedirect(req.getContextPath() + "/protected");
				__logger.info("Send redirect");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
