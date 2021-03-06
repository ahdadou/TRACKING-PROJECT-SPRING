package com.gaming.worspace.services.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {


    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);



    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse httpServletResponse,
                         AuthenticationException ex) throws IOException {
//
//        if (request.getAttribute("javax.servlet.error.exception") != null) {
//            Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
//            resolver.resolveException(request, httpServletResponse, null, (Exception) throwable);
//        }
        if (!httpServletResponse.isCommitted()) {
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
        }

    }
}