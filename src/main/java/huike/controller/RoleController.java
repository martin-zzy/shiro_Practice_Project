package huike.controller;


import huike.po.Role;
import huike.services.RoleService;
import huike.vo.RoleVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("list.do")
    @RequiresPermissions("role:list")
    public String listRoles(HttpServletRequest request){
        List<Role> roles = roleService.queryAllRole();
        System.out.println(roles.toString());
        request.setAttribute("roleList",roles);
        return "role/list";
    }

    @GetMapping("addRolePermission.to")
    @RequiresPermissions("role:add")
    public String toaddRole(Model model){
        //查询所有的权限信息




        return "adminRoel/add";
    }

    @RequestMapping("addRolePermission.do")
    public String saveRole(RoleVo roleVo){
        // 1.保存角色信息到角色表

        // 2.保存角色ID和权限信息到角色权限表
        return "redirect:adminUser/add";
    }


    public String toEditRolePermission(Long roleId,Model model){



        return null;
    }
}
