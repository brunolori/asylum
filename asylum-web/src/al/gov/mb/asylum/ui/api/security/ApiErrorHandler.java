package al.gov.mb.asylum.ui.api.security;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import al.gov.mb.asylum.ui.utils.StringUtil;



public class ApiErrorHandler implements ResponseErrorHandler {

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
    	
    	System.out.println("Response Code "+response.getStatusCode().value());
    	    	
    	if(response.getBody() != null)
    	{
    	   InputStream is = response.getBody();
    	   String message = StringUtil.toString(is);
    	   ApiException aexp = new ObjectMapper().readValue(message, ApiException.class);
    	   throw aexp;
    	}   	
    	    	
    	
    }

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
    	    	
    	HttpStatus.Series series = response.getStatusCode().series();
        return (HttpStatus.Series.CLIENT_ERROR.equals(series)
                || HttpStatus.Series.SERVER_ERROR.equals(series));
    }
}