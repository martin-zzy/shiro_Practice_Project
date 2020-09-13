package huike.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 将基本的添加、修改、删除、检索方法定义在此接口中
 * 其他的Mappper接口在此接口派生
 */
@Repository
public interface Imapper<T> {
    /*添加*/
    int insert(T pojo);

    /*修改*/
    int update(T pojo);

    /*删除*/
    boolean delete(Long id);

    /*检索*/
    List<T> select(T pojo);
}
