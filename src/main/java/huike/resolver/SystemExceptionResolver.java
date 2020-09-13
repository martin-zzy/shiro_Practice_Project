package huike.resolver;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SystemExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                        HttpServletResponse response, Object o, Exception e) {

        System.out.println(e.getClass());
        e.printStackTrace();
        ModelAndView mv = new ModelAndView();
        if (e instanceof IncorrectCredentialsException || e instanceof UnknownAccountException){
            mv.setViewName("redirect:/user/login");
        }
        if (e instanceof UnauthenticatedException){
            mv.setViewName("redirect:perm_error");
        }
        if (e instanceof AuthenticationException){
            mv.setViewName("redirect:perm_error");
        }
        return mv;
    }
}
