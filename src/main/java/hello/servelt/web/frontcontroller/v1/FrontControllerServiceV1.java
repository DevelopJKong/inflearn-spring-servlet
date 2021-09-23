package hello.servelt.web.frontcontroller.v1;

import hello.servelt.web.frontcontroller.v1.controller.MemberFormControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServiceV1 extends HttpServlet {
    private Map<String,ControllerV1> controllerMap = new HashMap<>();

    public FrontControllerServiceV1() {
        controllerMap.put("/front-controller/v1/members/new-form",new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save",new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/",new MemberFormControllerV1());

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServiceV1.service");

        //front-controller/v1/members
        String requestURI = request.getRequestURI();

        //ControllerV1 controller = new MemberListControllerV1(); 부모는 자식을 품을수 있지만 자식은 어렵다
        ControllerV1 controller = controllerMap.get(requestURI);
        if(controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        controller.process(request,response);

    }
}
