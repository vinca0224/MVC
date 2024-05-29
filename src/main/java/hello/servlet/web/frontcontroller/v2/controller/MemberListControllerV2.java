package hello.servlet.web.frontcontroller.v2.controller;

import java.io.IOException;
import java.util.List;

import hello.servlet.domain.member.Member;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberListControllerV2 implements ControllerV2{    

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        // List<Member> members = memberRepository.findAll();

        // request.setAttribute("members", members);

        java.lang.String viewPath = "/WEB-INF/views/members.jsp";
        return new MyView(viewPath);
    }
}
