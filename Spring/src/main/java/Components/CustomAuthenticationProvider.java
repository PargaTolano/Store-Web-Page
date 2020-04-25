package Components;


import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
 
    @Override
    @Transactional
    public Authentication authenticate(Authentication authentication) 
      throws AuthenticationException {
    	
    	/*
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        */
         
       /* if (shouldAuthenticateAgainstThirdPartySystem()) {
  
            // use the credentials
            // and authenticate against the third-party system
            return new UsernamePasswordAuthenticationToken(
              name, password, new ArrayList<>());
        } else {
            return null;
        }*/
        return null;
    }
 
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}