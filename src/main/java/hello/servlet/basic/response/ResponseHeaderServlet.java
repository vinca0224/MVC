package hello.servlet.basic.response;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "responseHeaderServlet", urlPatterns= "/response-header")
public class ResponseHeaderServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //status line
        resp.setStatus(HttpServletResponse.SC_OK);

        //response-headers
        // resp.setHeader("Content-Type", "text/plain");
        resp.setHeader("Cache-Control", "no-cache, co-store, must-revalidate");
        resp.setHeader("Pragma-Type", "no-cache");
        resp.setHeader("my-header", "hello");

        content(resp);
        cookie(resp);
        // redirect(resp);

        PrintWriter writer = resp.getWriter();
        writer.println("ok");
    }

    private void content(HttpServletResponse resp){
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
    }

    private void cookie(HttpServletResponse resp){
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);
        resp.addCookie(cookie);
    }

    private void redirect(HttpServletResponse resp) throws IOException{
        // resp.setStatus(302);
        // resp.setHeader("Location", "/basic/helloForm.html");
        resp.sendRedirect("/basic/helloForm.html");
    }
}
