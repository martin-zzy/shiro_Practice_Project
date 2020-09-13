package huike.Realm;

import huike.po.AdminUser;
import huike.realm.UserRealm01;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.Factory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestLogin {

    /*@Test
    public void testLoign(){
        try {

            //1、创建SecurityManager对象工厂
            Factory factory
                    = new IniSecurityManagerFactory("classpath:shiro_passwordMatchers.ini");
//
            SecurityManager instance = (SecurityManager) factory.getInstance();
            //通过工厂创建SecurityManager对象



            //1.创建SecurityManager对象工厂
//            DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
            //2.指定安全管理对象的安全配置文件
//            defaultSecurityManager.setRealm(new UserRealm01());
            //3.将securityMananger独享注册到shiro框架中
//            SecurityUtils.setSecurityManager(defaultSecurityManager);
            SecurityUtils.setSecurityManager(instance);
            //4.SecurityUtils对象获去主体对象
            Subject subject = SecurityUtils.getSubject();

            //模拟用户的登录
            String loginName="admin";
            String password="123";
            //创建用户的登录令牌对象
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginName,password);
            subject.login(usernamePasswordToken);
            if (subject.isAuthenticated()){
                System.out.println("您输入的用户名和密码正确, 登陆成功!");
            }

        } catch (UnknownAccountException ex) {
            System.out.println("您输入的账号不存在");
        } catch (IncorrectCredentialsException exception){
            System.out.println("您输入的账号密码错误");
        } catch (Exception e){
            e.printStackTrace();
        }

    }*/

    @Test
    public void testGetPassword(){

        String username = "test1";
        String password = "123";
        ByteSource salt = ByteSource.Util.bytes(username);
        String s = new Md5Hash(password,salt,2).toHex();
        System.out.println(username+"的盐值"+salt);
        System.out.println(username+"的密码"+s);
    }


}
