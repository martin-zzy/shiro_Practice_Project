package huike.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexPagecontroller {


    @RequestMapping("/")
    public String index(){

        //此处写跳转index.jsp页面之前的逻辑代码

        return "login";
    }

    @RequestMapping("welcome.do")
    public String welcome(){
        return "welcome";
    }

}
