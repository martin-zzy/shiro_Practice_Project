package huike.vo;

import java.util.Arrays;

public class RoleVo {
    private String roleName;
    private String roleDesc;
    private String rolePermissionId[];


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String[] getRolePermissionId() {
        return rolePermissionId;
    }

    public void setRolePermissionId(String[] rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    @Override
    public String toString() {
        return "RoleVo{" +
                "roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", rolePermissionId='" + Arrays.toString(rolePermissionId) + '\'' +
                '}';
    }
}
