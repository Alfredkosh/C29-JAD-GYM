package c29.jad.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;


@Component
public class PrivateFilter extends OncePerRequestFilter {

    final Logger logger = LoggerFactory.getLogger(PrivateFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        logger.info(request.getRequestURL().toString());
        var session = request.getSession(true);
        var userId = (Integer) session.getAttribute("userId");
        if(userId !=null) {
            filterChain.doFilter(request, response);
        } else {
          response.setStatus(401);
          response.getWriter().write("{\"message\":\"Permission Denied\"}");
        }
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
                "/page/test/*"

        );

        return !matchedPatterns
                .stream()
                .anyMatch(p -> pathMatcher.match(p, request.getRequestURI()));
    }
}
