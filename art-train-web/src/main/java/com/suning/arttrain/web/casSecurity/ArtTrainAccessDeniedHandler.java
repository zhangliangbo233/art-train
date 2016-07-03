package com.suning.arttrain.web.casSecurity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhanglb on 4/4/15.
 */
public class ArtTrainAccessDeniedHandler extends AccessDeniedHandlerImpl {

    private final static Logger logger = LoggerFactory
            .getLogger(ArtTrainAccessDeniedHandler.class);

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response, AccessDeniedException exception)
            throws IOException, ServletException {
        logger.info("############### Access Denied Handler!");
        setErrorPage("/accessDenied");
        super.handle(request, response, exception);
    }
}
