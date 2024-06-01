package hello.servlet.web.frontcontroller.v5.adapter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ControllerV3Adapter implements MyHandlerAdapter{
    
    @Override
    public boolean supports(Object handler){
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler)throws ServletException, IOException{
        ControllerV3 controller = (ControllerV3) handler;
        
        Map<String, String> paraMap = createParamMap(request);
        ModelView mv = controller.process(paraMap);
        return mv;
    }
    
        private Map<String, String> createParamMap(HttpServletRequest request){
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(paramName ->paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
   }
}
