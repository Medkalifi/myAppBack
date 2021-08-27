package fr.moha.myApp.config;

public interface SecurityConstants {
	public static final String JWT_HEADER_NAME = "Authorization";
	public static final String SECRET = "kalifi";
	public static final long EXPIRATION = 10*24*3600*1000;
	public static final String HEADER_PREFIX = "Bearer ";

}
