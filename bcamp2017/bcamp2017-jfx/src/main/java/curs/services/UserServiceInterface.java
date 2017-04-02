package curs.services;

import curs.model.User;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Path;

public interface UserServiceInterface {
	
	@Headers({
		"Accept: application/json",
		"Content-Type: application/json"
	})
	@POST("users/login") 
	Call<Boolean> login(@Body User pUser);
	
	@Headers({
		"Accept: application/json",
		"Content-Type: application/json"
	})
	@POST("users/logout")
	Call<Void> logout();
	
	@Headers({
		"Accept: application/json",
		"Content-Type: application/json"
	})
	@POST("users/register")
	Call<Boolean> register(@Body User pUser);
	
	@Headers({
		"Accept: application/json",
		"Content-Type: application/json"
	})
	@GET("users")
	Call<Boolean> isLoggedIn();
	
	@Headers({
		"Accept: application/json",
		"Content-Type: application/json"
	})
	@GET("users/role/{role_name}")
	Call<Boolean> hasRole(@Path("role_name") String pRole);
}
