package huike.services;

import huike.mapper.RoleMapper;
import huike.po.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("RoleService")
public class RoleServiceImpl extends huike.services.IBaseServiceImpl implements huike.services.RoleService {

    @Autowired
    RoleMapper roleMapper;


    @Override
    public List<Role> queryAllRole() {
        return roleMapper.select(null);
    }


}
