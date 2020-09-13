package huike.services;

import huike.mapper.AdminUserMapper;
import huike.mapper.RoleMapper;
import huike.po.AdminUser;
import huike.po.AdminUserRole;
import huike.po.Role;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("adminUserService")
public class AdminUserServiceImpl extends huike.services.IBaseServiceImpl implements huike.services.AdminUserService {

    @Autowired
    AdminUserMapper adminUserMapper;
    @Autowired
    RoleMapper roleMapper;


    Map<String,Long> maps = new HashMap<>();

    /**
     * 登录授权
     */

    @Override
    public AdminUser queryUserByName(String account) {
        return adminUserMapper.queryUserByName(account);
    }

    @Override
    public Set<String> findRoleByUserName(String username) {
        AdminUser adminUser = adminUserMapper.queryUserByName(username);
        if (adminUser == null){
            System.out.println("adminUser为空 角色返回空set");
            return Collections.EMPTY_SET;
        }
        List<String> roles = adminUserMapper.findRolesById(adminUser.getId());
//        System.out.println(roles.toString());


        return new HashSet<>(roles);
    }

    @Override
    public Set<String> findPermissionByUserName(String username) {
        AdminUser adminUser = adminUserMapper.queryUserByName(username);
        if (adminUser ==null){
            System.out.println("adminUser为空 权限返回空set");
            return Collections.EMPTY_SET;
        }
        List<String> roles = adminUserMapper.findPermissionsById(adminUser.getId());
//        System.out.println("findPermission方法"+roles.toString());

        return new HashSet<>(roles);
    }

    /**
     * 显示用户信息
     * 1.根据页码和显示条数查询信息返回map集合
     * 2.添加用户信息和用户角色表信息
     * 3.查询总记录数
     */
    @Override
    public List<AdminUser> selectByPage(Long currPage, Long pageSize) {
        maps.put("currPage",currPage);
        maps.put("pageSize",pageSize);
        return adminUserMapper.selectByPage(maps);
    }

    @Override
    public Long selectCount() {
        return adminUserMapper.selectCount();
    }



    /**
     * 新增用户
     * 1.检查用户名是否重复
     * 2.在用户表中添加用户数据
     * 3.在用户角色表中添加数据
     *
     */
    @Override
    public boolean addAdminUserRole(String account, String password,String checkPID){
        try {
            AdminUser adminUser = new AdminUser();
            adminUser.setAccount(account);
            ByteSource salt = ByteSource.Util.bytes(account);
            String newPassword = new Md5Hash(password,salt,2).toHex();
            adminUser.setPassword(newPassword);
            adminUser.setPasswordSalt(salt.toString());
            adminUser.setIsDisabled(false);
            adminUser.setIsDeleted(false);
            adminUserMapper.insert(adminUser);
            if (null !=checkPID && !"".equals(checkPID)){
                AdminUserRole adminUserRole = new AdminUserRole();
                adminUserRole.setAdminUserId(adminUser.getId());
                adminUserRole.setRoleId(4L);//如果未指定角色,默认角色为用户
                adminUserMapper.addAdminUserRole(adminUserRole);
            }else {
                String[] roleIds = checkPID.split(",");
                for (String roleId:roleIds) {
                    //向用户角色表中添加
                    AdminUserRole adminUserRole = new AdminUserRole();
                    adminUserRole.setAdminUserId(adminUser.getId());
                    adminUserRole.setRoleId(Long.parseLong(roleId));
                    adminUserMapper.addAdminUserRole(adminUserRole);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Role> queryAllRoles() {
        return adminUserMapper.queryAllRoles();
    }

    @Override
    public boolean checkUser(String account) {
        return adminUserMapper.queryUserByName(account) == null;
    }

    /**
     * 修改用户的状态
     *
     */
    @Override
    public boolean updateAdminUserDisable(String adminUserId) {
        AdminUser adminUser = adminUserMapper.selectAdminUserById(Long.parseLong(adminUserId));
        if (adminUser.getIsDisabled()){
            adminUser.setIsDisabled(false);
        }else {
            adminUser.setIsDisabled(true);
        }
        return adminUserMapper.updateAdminUserDisable(adminUser);
    }

    @Override
    public boolean delete(Long id) {
        return adminUserMapper.delete(id) && roleMapper.delete(id);
    }
}
