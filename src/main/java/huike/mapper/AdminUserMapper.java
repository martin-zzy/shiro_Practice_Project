package huike.mapper;

import huike.po.AdminUser;
import huike.po.AdminUserRole;
import huike.po.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AdminUserMapper extends Imapper{

    /**
     * 实现分页查询的方法
     * @param map
     * @return
     */
    List<AdminUser> selectByPage(Map<String,Long> map);


    /**
     * 查询总记录条数
     * @return 总记录条数
     */
    Long selectCount();

    /**
     * 添加用户角色信息
     */
    boolean addAdminUserRole(AdminUserRole adminUserRole);


    /**
     * 添加用户
     */


    /**
     *
     * 根据ID查询AdminUser
     */
    AdminUser selectAdminUserById(Long adminUserId);


    /**
     * 修改用户状态:启用/禁用
     */
    boolean updateAdminUserDisable(AdminUser adminUser);


    /**
     * 用户登录方法
     * 分别用于用户登录 用户角色和权限的授权
     */
    AdminUser queryUserByName(String username);

    List<String> findRolesById(Long userId);

    List<String> findPermissionsById(Long userId);


    /**
     * 添加用户方法
     */
    List<Role> queryAllRoles();
}
