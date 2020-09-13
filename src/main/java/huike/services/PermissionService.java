package huike.services;

import huike.po.Permission;
import huike.po.RolePermission;

import java.util.List;
import java.util.Map;

public interface PermissionService extends IBaseService {
    List<Permission> queryAllPermissions();

    Boolean deleteRolePermission(RolePermission rp);

    Boolean addRolePermission(RolePermission rp);

    List<Permission> selectByPage(Map<String,Object> map);

    List<Permission> selectCount(Map<String,Object> map);
}
