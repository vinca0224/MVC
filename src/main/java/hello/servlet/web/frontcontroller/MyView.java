package hello.servlet.web.frontcontroller;

import java.io.*;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyView {

    private String viewPath;

    public MyView(String viewPath){
        this.viewPath = viewPath;
    }


    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        model.forEach((key,value) -> request.setAttribute("key", value));
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
