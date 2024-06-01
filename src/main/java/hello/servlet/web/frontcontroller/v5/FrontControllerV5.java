package hello.servlet.web.frontcontroller.v5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import hello.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import hello.servlet.web.frontcontroller.v5.adapter.ControllerV3Adapter;
import hello.servlet.web.frontcontroller.v5.adapter.ControllerV4Adapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerV5 extends HttpServlet{

    private final Map<String, Object> handelerMappingMap = new HashMap<>();
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerV5(){
        initHandlerMapping();
        initHandlerAdapters();
    }

    private void initHandlerMapping() {
        handelerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handelerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handelerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());

        handelerMappingMap.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
        handelerMappingMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
        handelerMappingMap.put("/front-controller/v5/v4/members", new MemberListControllerV4());
    }

    private void initHandlerAdapters() {
        handlerAdapters.add(new ControllerV3Adapter());
        handlerAdapters.add(new ControllerV4Adapter());

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        Object handler = getHandler(request);

       if(handler == null){
            response.setStatus(404);
            return;
       }
       
       MyHandlerAdapter adapter = getHandlerAdapter(handler);

       ModelView mv = adapter.handle(request, response, handler);

       String viewName = mv.getViewName();

       MyView view = getView(viewName);
       view.render(mv.getModel(), request, response);
    }

    private Object getHandler(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return handelerMappingMap.get(requestURI);
    }

    private MyHandlerAdapter getHandlerAdapter(Object handler){
        for(MyHandlerAdapter myHandlerAdapter : handlerAdapters){
            if(myHandlerAdapter.supports(handler)){
                return myHandlerAdapter;
            }
       }
       throw new IllegalArgumentException("hadler adapter를 찾을수 없습니다" + handler);
    }

    private MyView getView(String viewName) {
        return new MyView("WEB-INF/views/" + viewName + ".jsp");
    }
}
