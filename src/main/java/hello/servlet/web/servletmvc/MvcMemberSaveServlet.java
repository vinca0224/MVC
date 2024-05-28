package hello.servlet.web.servletmvc;

import java.io.IOException;

import org.apache.catalina.connector.Request;
import org.eclipse.tags.shaded.org.apache.xpath.operations.String;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "mvcMemberSaveServlet", urlPatterns = "/servlet-mvc/members/save")
public class MvcMemberSaveServlet extends HttpServlet{

    private MemberRepository memberRepository = MemberRepository.getInstance();
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        java.lang.String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        
        Member member = new Member(username, age);
        memberRepository.save(member);

        //model에 데이터 보관
        request.setAttribute("member", member);

        java.lang.String viewPath = "/WEB-INF/views/save-result.jsp"; 
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
