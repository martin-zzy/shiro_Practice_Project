package huike.services;

import huike.po.Permission;
import huike.po.RolePermission;

import java.util.List;
import java.util.Map;

public class PermissionServiceImpl extends IBaseServiceImpl implements PermissionService{

    @Override
    public List<Permission> queryAllPermissions() {
        return null;
    }

    @Override
    public Boolean deleteRolePermission(RolePermission rp) {
        return null;
    }

    @Override
    public Boolean addRolePermission(RolePermission rp) {
        return null;
    }

    @Override
    public List<Permission> selectByPage(Map<String, Object> map) {
        return null;
    }

    @Override
    public List<Permission> selectCount(Map<String, Object> map) {
        return null;
    }
}
