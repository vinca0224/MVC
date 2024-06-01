package hello.servlet.web.frontcontroller;

import java.io.*;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyView {

    private java.lang.String viewPath;

    public MyView(java.lang.String viewPath){
        this.viewPath = viewPath;
    }


    public void render(Map<java.lang.String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        model.forEach((key,value) -> request.setAttribute("key", value));
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
