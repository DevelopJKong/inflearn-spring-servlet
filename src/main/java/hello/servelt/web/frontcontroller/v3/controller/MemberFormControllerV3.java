package hello.servelt.web.frontcontroller.v3.controller;

import hello.servelt.web.frontcontroller.ModelView;
import hello.servelt.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {

    @Override
    public ModelView process(Map<String, String> paramMap) {
        return new ModelView("new-form"); // 생성자를 만들때 이것은 안 만들어줘서 에러가 났었다
    }
}
