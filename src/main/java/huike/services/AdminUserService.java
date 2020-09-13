package huike.services;

import huike.po.AdminUser;
import huike.po.Role;

import java.util.List;
import java.util.Set;

public interface AdminUserService extends IBaseService {
    /**
     * 用户登录和授权
     */
    AdminUser queryUserByName(String account);


    Set<String> findRoleByUserName(String username);


    Set<String> findPermissionByUserName(String username);

    /**
     * 显示用户信息
     */
    List<AdminUser> selectByPage(Long currPage,Long pageSize);

    Long selectCount();

    /**
     * 添加用户信息
     */
    boolean addAdminUserRole(String account, String password,String checkPID);

    List<Role> queryAllRoles();

    boolean checkUser(String account);


    /**
     * 启用和禁用用户
     */
    boolean updateAdminUserDisable(String adminUser);



}
