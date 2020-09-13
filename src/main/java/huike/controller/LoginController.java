package huike.controller;


import huike.vo.AdminUserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class LoginController {
    @GetMapping("/login")
    public String tologin(){ return "login";}


    @RequestMapping("/login")
    public String login(AdminUserVo adminUserVo){
        try {
            Subject subject = SecurityUtils.getSubject();
            System.out.println(adminUserVo.toString());
            if (adminUserVo != null) {
                UsernamePasswordToken token =
                        new UsernamePasswordToken(adminUserVo.getUsername(),
                                adminUserVo.getPassword());

                subject.login(token);

                if (adminUserVo.isRemember()){
                    //shiro会将认证的信息写入到本地cookie中,下次访问时,提取本地cookie
                    token.setRememberMe(true);
                }
            }
        } catch (UnknownAccountException ex){
            System.out.println("输入的账号不存在");
            return  "login";

        }catch (IncorrectCredentialsException ex){
            System.out.println("输入用户名密码不正确，请重新输入");
            return  "login";
        }

        return "index";
    }

    @GetMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }


    @RequestMapping("/error")
    public String permsError(){

        return "perm_error";
    }


}
