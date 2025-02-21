package org.nt_uni.web_studio.security.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
public class AbstractRestAuthFilter extends AbstractAuthenticationProcessingFilter {
    public AbstractRestAuthFilter(RequestMatcher requiresAuthMatcher){
        super(requiresAuthMatcher);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        String username = getParameter("Api-Key",request);
//        String pwd = getParameter("Api-Secret",request);

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Basic ")) {
            // 🔥 Extract Base64-encoded credentials
            String base64Credentials = authHeader.substring(6);
            String credentials = new String(Base64.getDecoder().decode(base64Credentials), StandardCharsets.UTF_8);

            // 🔥 Split "username:password"
            String[] values = credentials.split(":", 2);
            String username = values[0];
            String pwd = values[1];


            log.info(username);
            log.info(pwd);

            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, pwd);

            if (StringUtils.hasText(username))
                return this.getAuthenticationManager().authenticate(token);
            else
                return null;
        }
        return null;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)res;

        if (this.logger.isDebugEnabled()) {
            this.logger.debug("Request is to process authentication");
        }

        try{
            Authentication authResult = this.attemptAuthentication(request, response);
            if (authResult != null)
                successfulAuthentication(request, response, chain, authResult);
            else
                chain.doFilter(request, response);
        }catch (AuthenticationException e){
            log.info("Authentication failed. AuthUser hadn't passed auth.", e);
            unsuccessfulAuthentication(request,response,e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("Authentication success. Updating SecurityContextHolder to contain: " + authResult);
        }

        SecurityContextHolder.getContext().setAuthentication(authResult);
        chain.doFilter(request, response);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {
        SecurityContextHolder.clearContext();
        if (log.isDebugEnabled()) {
            log.debug("Authentication request failed: " + failed.toString(), failed);
            log.debug("Updated SecurityContextHolder to contain null Authentication");
        }

        response.sendError(HttpStatus.UNAUTHORIZED.value(),
                HttpStatus.UNAUTHORIZED.getReasonPhrase());
    }

    public String getParameter(String parameterName, HttpServletRequest request){
        String value = request.getHeader(parameterName);
        return value == null ? "" : value;
    }
}
