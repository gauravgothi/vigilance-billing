package in.co.mpwin.vigilencebilling.miscellanious;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TokenInfo {
   /* @Autowired
    //private CustomUserDetailsService customUserDetailsService;
    public String getCurrentUsername()
    {
        //Get the Current Logged-In Username
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
    public String getCurrentUserRole()
    {
        //Get the Current Logged-In Username
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<String> roles =  authentication.getAuthorities().stream().map(a -> a.getAuthority()).collect(Collectors.toList());
        return roles.get(0).substring(5);

    }*/
}
