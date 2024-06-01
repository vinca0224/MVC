package hello.servlet.web.frontcontroller.v5;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import hello.servlet.web.frontcontroller.ModelView;

public interface MyHandlerAdapter {
    
    boolean supports(Object handeler);

    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}
