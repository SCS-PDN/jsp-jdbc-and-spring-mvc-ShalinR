package com.university.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;
import java.util.logging.*;

public class LoggingInterceptor implements HandlerInterceptor {

    private static final Logger logger = Logger.getLogger(LoggingInterceptor.class.getName());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String path = request.getRequestURI();
        String method = request.getMethod();
        String user = (request.getSession().getAttribute("student") != null) ?
                request.getSession().getAttribute("student").toString() : "Anonymous";

        String logMessage = String.format("[%s] %s request to %s by %s", 
            LocalDateTime.now(), method, path, user);

        logger.info(logMessage);

        return true;
    }
}
