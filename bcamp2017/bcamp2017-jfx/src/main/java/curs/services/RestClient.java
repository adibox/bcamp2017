package curs.services;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;

import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;

public class RestClient {
	private static RestClient __instance;
	
	private OkHttpClient mOKClient;
	private BookServiceInterface mBSI;
	private UserServiceInterface  mUSI;
	
	private RestClient() {
		CookieHandler cookieHandler = new CookieManager(null, CookiePolicy.ACCEPT_ALL);
		// init okhttp 3 logger
		mOKClient = new OkHttpClient();
		mOKClient.setCookieHandler(cookieHandler);
		mOKClient.interceptors().add(new Interceptor() {
			public Response intercept(Chain chain) throws IOException {
				System.out.println("req:" + chain.request().toString());
				Response response = chain.proceed(chain.request());
				return response;
			}
			
		});
		String baseUrl = "http://localhost:8080/bcamp/rest/";
		Retrofit client = new Retrofit.Builder().baseUrl(baseUrl).client(mOKClient).addConverterFactory(JacksonConverterFactory.create()).build();
		mBSI = client.create(BookServiceInterface.class);
		mUSI = client.create(UserServiceInterface.class);
	}
	
	public BookServiceInterface getBookServiceInterface() {
		return mBSI;
	}
	
	public UserServiceInterface getUserServiceInterface() {
		return mUSI;
	}
	
	// SINGLETON
	public static RestClient instance() {
		if(__instance == null) {
			__instance = new RestClient();
		}
		return __instance;
	}
}
