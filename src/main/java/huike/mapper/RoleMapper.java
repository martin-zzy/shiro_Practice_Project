package huike.mapper;

import huike.po.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper extends huike.mapper.Imapper {


    List<Role> selectByPage();

    @Override
    int insert(Object pojo);

    @Override
    int update(Object pojo);

    @Override
    boolean delete(Long id);

    @Override
    List<Role> select(Object pojo);
}
