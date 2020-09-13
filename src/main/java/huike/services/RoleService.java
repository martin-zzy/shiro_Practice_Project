package huike.services;

import huike.po.Role;

import java.util.List;

public interface RoleService extends huike.services.IBaseService {

    List<Role> queryAllRole();
}
