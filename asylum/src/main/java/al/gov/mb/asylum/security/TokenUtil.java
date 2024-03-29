package al.gov.mb.asylum.security;

import java.util.Calendar;

import al.gov.mb.asylum.dto.UserDTO;
import al.gov.mb.asylum.exceptions.InvalidTokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

public class TokenUtil {

	public static String getUsername(String token)
	{
		try {
			String jwt = token.substring(7);
			Claims claims = Jwts.parser().setSigningKey(TextCodec.BASE64.decode(SecurityConstants.SECRET))
				       .parseClaimsJws(jwt).getBody();
				    
			return claims.getSubject();
		}catch(Exception e) {
			e.printStackTrace();
			throw new InvalidTokenException("TOKEN i pa vlefshem");
		}
	}
	
	
	
	public static String generateToken(UserDTO user)
	{
		String jws = Jwts.builder()
				  .setIssuer("Asylum")
				  .setSubject(user.getUsername())
				  .claim("role", user.getRole())
				  .setIssuedAt(Calendar.getInstance().getTime())
			      //.setExpiration(Date.from(Instant.ofEpochSecond(4622470422L)))
				  .signWith(
				    SignatureAlgorithm.HS256,
				    TextCodec.BASE64.decode(SecurityConstants.SECRET)
				  )
				  .compact();
		
		return jws;
	}
	
}
