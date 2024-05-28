package hello.servlet.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "MemberFormServlet", urlPatterns = "/servlet/members/new-form")
public class MemberFormServlet extends HttpServlet{
    
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        PrintWriter writer = resp.getWriter();
        writer.write("<!DOCTYPE html>"+
        "<html>" +
       " <head>" +
            "<meta charset=\"UTF-8\">\n" +
            "<title>Document</title>" +
       "</head>" +
        "<body>" +
            "<form action=\"/servlet/members/save\" method=\"post\">\n" +
                "username:<input type=\"text\" name=\"username\">\n" +
                "age:<input type=\"text\" name=\"age\">" +
                "<input type=\"submit\" value=\"전송\">\n" +
           " </form>\n" +
        "</body>\n" +
        "</html>\n");
    }
}
