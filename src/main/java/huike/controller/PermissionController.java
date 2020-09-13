package huike.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class PermissionController {

    public String pagePermission(){


        return "permission/list";
    }

    public String toEditPermission(){

        return null;
    }


    @ResponseBody
    public Map<String,Object> editSubmitPermissin(){


        return null;
    }


    public String addPermission(){



        return "";
    }

}
