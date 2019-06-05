package al.gov.mb.asylum.services;

import org.springframework.stereotype.Service;

import al.gov.mb.asylum.dto.UserDTO;
import al.gov.mb.asylum.security.TokenUtil;


@Service
public class TokenService {

	
	public String generateToken(UserDTO dto)
	{
		return TokenUtil.generateToken(dto);
	}
	
	public String getUsername(String token)
	{
		return TokenUtil.getUsername(token);
	}
	
	
	
}
