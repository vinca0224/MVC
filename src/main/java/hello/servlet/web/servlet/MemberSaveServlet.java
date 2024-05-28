package hello.servlet.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "memberSaveServlet", urlPatterns= "/servlet/members/save")
public class MemberSaveServlet extends HttpServlet{

    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        PrintWriter writer = resp.getWriter();
        writer.write("<html>" +
        " <head>" +
             "<meta charset=\"UTF-8\">\n" +
             "<title>Document</title>" +
        "</head>" +
         "<body>" +
            "성공\n<ul>\n<li>id=" + member.getId() + "</li>\n<li>username=" + member.getAge() + "</li>\n</ul>\n" +
         "</body>\n" +
         "</html>\n");
    }
}
