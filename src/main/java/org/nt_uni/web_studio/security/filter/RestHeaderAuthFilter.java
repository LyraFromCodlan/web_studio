package org.nt_uni.web_studio.security.filter;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Slf4j
public class RestHeaderAuthFilter extends AbstractRestAuthFilter {
//    AbstractAuthenticationProcessingFilter
    public RestHeaderAuthFilter(RequestMatcher requiresAuthMatcher){
        super(requiresAuthMatcher);
    }

    public String getParameter(String parameterName, HttpServletRequest request){
        String value = request.getHeader(parameterName);
        return value == null ? "" : value;
    }
}
