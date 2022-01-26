package klasha.store.KlashaCourier.security;

/**
 * @author ehis
 * @description: an Authorization filter, a filter class that listens to or examines every request from the authorization header
 * and extract the username from the jwt, verifies it a valid jwt and if its a valid jwt
 * then you know that the person sending this jwt is trust worthy.Then you can now authorize the user.
 *
 */

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import klasha.store.KlashaCourier.security.exceptions.ErrorDetails;
import klasha.store.KlashaCourier.service.UserDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;

import static klasha.store.KlashaCourier.security.SecurityConstants.*;


@Slf4j
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {


    // return type should be a string and returns fake jwt
    // FilterChain chain GIVES its ability to pass the req to the next filter on the chain

    UserDetailsServiceImpl userDetailsServiceImpl;

    private ObjectMapper objectMapper = new ObjectMapper();


    public JWTAuthorizationFilter(AuthenticationManager authenticationManager, UserDetailsServiceImpl userDetailsService) {
        super(authenticationManager);
        this.userDetailsServiceImpl = userDetailsService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader(HEADER_STRING);

        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(req, res);
            return ;
        }


        try{
            UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }catch (RuntimeException re){
            log.info("Runtime exception occured");

            ErrorDetails errorDetails = new ErrorDetails(HttpStatus.FORBIDDEN, re.getMessage(),
                    re.getMessage(), Calendar.getInstance().getTime().toString());

            res.setStatus(403);

            OutputStream out = res.getOutputStream();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(out, errorDetails);
            out.flush();
            out.close();
        }

        chain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        log.info("Header string --> {}", token);
        if (token != null) {

            // parse the token.
            String user = JWT.require(Algorithm.HMAC512(SECRET.getBytes()))
                    .build()
                    .verify(token.replace(TOKEN_PREFIX, ""))
                    .getSubject();

            if (user != null) {
                log.info("Returned user --> {}", user);
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
           return null;
        }
        return null;
    }
}