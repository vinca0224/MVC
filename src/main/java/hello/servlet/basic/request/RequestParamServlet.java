package hello.servlet.basic.request;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 1. 파라미터 전송기능
// http://localhost:8080/request-param?username=hello&age=20
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //전체 파라미터
        req.getParameterNames().asIterator()
        .forEachRemaining(paramName -> System.out.println(paramName + "=" + req.getParameter(paramName)));
        System.out.println();

        //단일 파라미터
        String userName = req.getParameter("username");
        String age = req.getParameter("age");
        System.out.println(userName + "," + age);
        System.out.println();

        //이름이 같은 복수 파라미터
        String[] userNames = req.getParameterValues("username");
        for(String name : userNames){
            System.out.println(name);
        }
    }
}
