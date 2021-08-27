package fr.moha.myApp.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterCahin)
			throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers",
						 "Origin, Accept, X-Requested-With,Content-Type, Access-Control-Request-Method,"
						 + " Access-Control-RequestHeaders,authorization");
response.addHeader("Access-Control-Expose-Headers","Access-Control-Allow-Origin, "
		+ "Access-Control-Allow-Credentials, authorization");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, PATCH");
		                   
		if (request.getMethod().equals("OPTIONS")) {
			response.setStatus(HttpServletResponse.SC_OK);
		}
//				else if (request.getRequestURI().equals("/login"))  {
//					filterCahin.doFilter(request, response);
//				}
		else  {
			String jwtToken = request.getHeader(SecurityConstants.JWT_HEADER_NAME);
		
		if (jwtToken == null || !jwtToken.startsWith(SecurityConstants.HEADER_PREFIX)) {
			filterCahin.doFilter(request, response);
			return;
		}
		
			JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SecurityConstants.SECRET)).build();
			String jwt = jwtToken.substring(SecurityConstants.HEADER_PREFIX.length());
			System.out.println("token =" + jwtToken);
			DecodedJWT decodedJWT = verifier.verify(jwt);
			System.out.println("JWT = " + jwt);
			String username = decodedJWT.getSubject();
			List<String> roles = decodedJWT.getClaims().get("roles").asList(String.class);
			System.out.println("user name " + username);
			System.out.println("roles " + roles);
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			roles.forEach(rn -> {
				authorities.add(new SimpleGrantedAuthority(rn));
			});
			UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(username, null,
					authorities);
			SecurityContextHolder.getContext().setAuthentication(user);
			filterCahin.doFilter(request, response);
		}

	}
}
