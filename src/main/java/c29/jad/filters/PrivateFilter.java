package c29.jad.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.naming.AuthenticationException;
import java.io.IOException;
import java.util.List;


@Component
public class PrivateFilter extends OncePerRequestFilter {

    final Logger logger = LoggerFactory.getLogger(PrivateFilter.class);

    @Autowired
    Environment env;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        logger.info(request.getRequestURL().toString());
        try{
            var header = request.getHeader("Authorization");
            if (header == null){
                throw new AuthenticationException("Invalid header");
            }
            var token = header.split(" ")[1];
            if (token == null) {
                throw new AuthenticationException("Invalid Token");
            }

            var decoded  = JWT.require(Algorithm.HMAC256(env.getProperty("jwt.secret"))).build().verify(token);
            var userId = decoded.getClaim("userId").asInt();
            request.setAttribute("userId", userId);
            if(userId !=null) {
                filterChain.doFilter(request, response);
            } else {
                response.setStatus(401);
                response.getWriter().write("{\"message\":\"Permission Denied\"}");
            }
        } catch (AuthenticationException e){
            response.setStatus(401);
            response.getWriter().write("{\"message\":\"Permission Denied\"}");
        }
//        var session = request.getSession(true);
//        var userId = (Integer) session.getAttribute("userId");

    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        var pathMatcher = new AntPathMatcher();
        List<String> matchedPatterns = List.of(
                "/page/model",
                "/page/model*",
                "/page/model/*",
                "/page/test",
                "/page/test*",
                "/page/test/*",
                "/record/data"

        );

        return !matchedPatterns
                .stream()
                .anyMatch(p -> pathMatcher.match(p, request.getRequestURI()));
    }
}
