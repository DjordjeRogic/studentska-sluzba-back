package ftn.diplomski.studentskasluzbaback.security.auth;

import ftn.diplomski.studentskasluzbaback.security.TokenUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class TokenAuthenticationFilter extends OncePerRequestFilter {
    private TokenUtils tokenUtils;

    private UserDetailsService userDetailsService;

    public TokenAuthenticationFilter(TokenUtils tokenHelper, UserDetailsService userDetailsService) {
        this.tokenUtils = tokenHelper;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        System.out.println("FILTER");
        String email;
        String authToken = tokenUtils.getToken(request);
        System.out.println(authToken);

        if (authToken != null) {
            // uzmi email iz tokena
            email = tokenUtils.getEmailFromToken(authToken); //prima jwt token
            System.out.println("Email" + email);

            if (email != null) {
                // uzmi user-a na osnovu email-a
                UserDetails userDetails = userDetailsService.loadUserByUsername(email);
                System.out.println("User details" + userDetails.getUsername());
                // proveri da li je prosledjeni token validan
                if (tokenUtils.validateToken(authToken, userDetails)) {
                    // kreiraj autentifikaciju
                    System.out.println("Validate");
                    TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails);
                    authentication.setToken(authToken);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        // prosledi request dalje u sledeci filter
        chain.doFilter(request, response);
    }
}
