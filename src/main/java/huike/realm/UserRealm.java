package huike.realm;

import huike.po.AdminUser;
import huike.services.AdminUserServiceImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private AdminUserServiceImpl service;



    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        String username = (String) principal.getPrimaryPrincipal();
        Set<String> roles = service.findRoleByUserName(username);
        Set<String> permission = service.findPermissionByUserName(username);

//        System.out.println("授权方法roles="+roles.toString());
//        System.out.println("授权方法roles="+permission.toString());
        simpleAuthorizationInfo.addRoles(roles);
        simpleAuthorizationInfo.addStringPermissions(permission);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();


        AdminUser adminUser = service.queryUserByName(username);
        if (adminUser.getIsDeleted()){
            System.out.println("没有该用户");
        }
        if (adminUser.getIsDisabled()){
            System.out.println("该用户没有权限");
        }
//        System.out.println(adminUser.toString());
        String password = adminUser.getPassword();

        ByteSource salt = ByteSource.Util.bytes(adminUser.getAccount());


        SimpleAuthenticationInfo simpleAuthenticationInfo =
                new SimpleAuthenticationInfo(adminUser.getAccount(),password,salt,getName());
        return simpleAuthenticationInfo;
    }
}
