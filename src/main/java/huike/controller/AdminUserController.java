package huike.controller;

import huike.po.AdminUser;
import huike.services.AdminUserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
@RequiresAuthentication
public class AdminUserController {

    @Autowired
    AdminUserService service;

    @RequiresPermissions("adminUser:list")
    @RequestMapping("/list.do")
    public String dolist(HttpServletRequest request,
                     @RequestParam(value = "currPage",required = false)Long currPage,
                     @RequestParam(value = "pageSize",required = false)Long pageSzie){
        Long recordRows = service.selectCount();
        if (currPage == null){
            currPage = 1L;
        }
        if (pageSzie == null){
            pageSzie = 5L;
        }
        Long totalPage = recordRows % pageSzie == 0?
                         recordRows/pageSzie:recordRows/pageSzie + 1;
        Long startRecord = (currPage - 1) * pageSzie;
        List<AdminUser> adminUsers = service.selectByPage(startRecord, pageSzie);
        request.setAttribute("currPage", currPage);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("adminUserList", adminUsers);
        request.setAttribute("pageSize", pageSzie);
        request.setAttribute("count", recordRows);

        return "adminUser/list";
    }

    @GetMapping("/delete")
    public String delete(){
        return "welcome";
    }

    @GetMapping("/disable")
    @RequiresPermissions("adminUser:disable")
    public String updateAdminUserDisabled(
            @RequestParam(value = "adminUserId")String adminUserId,
            RedirectAttributes redirectAttributes){
        try {
            if (adminUserId != null){
                service.updateAdminUserDisable(adminUserId);
            }
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message","启用/禁用失败");
            return "redirect:list.do";
        }

        return "redirect:list.do";
    }

    @GetMapping("/toadd")
    @RequiresPermissions("adminUser:addUser")
    public String toadd(Model model){
        model.addAttribute("roleList",service.queryAllRoles());
        return "adminUser/add";
    }

    @ResponseBody
    @RequestMapping("/checkUserName.do")
    @RequiresPermissions("adminUser:addUser")
    public Map<String,Object> checkUser(@RequestParam(value = "account")String account){
        Map<String,Object> result = new HashMap<>();
        boolean b = service.checkUser(account);
        if (b){
            result.put("status","200");
            result.put("message",true);
        }else {
            result.put("status","300");
            result.put("message",false);
        }
        System.out.println(result.toString());
        return result;
    }

    @RequestMapping("/adminUserAdd.do")
    @RequiresPermissions("adminUser:addUser")
    @ResponseBody
    public Map<String,Object> addUser(
            @RequestParam("account")String account,
            @RequestParam("password")String password,
            @RequestParam(value = "checkPID",required = false)String chekPID){
        Map<String,Object> result = new HashMap<>();
        boolean b = service.addAdminUserRole(account, password, chekPID);
        if (b){
            result.put("status",200);
            result.put("message",true);
        }else {
            result.put("status",500);
            result.put("message",false);
        }
        return result;
    }

    @GetMapping("/delete")
    @RequiresPermissions("adminUser:delete")
    public String deleteUser(@RequestParam("userId")String userId){
        boolean isdelete = service.delete(Long.parseLong(userId));
        return "adminUser/list";
    }

}
