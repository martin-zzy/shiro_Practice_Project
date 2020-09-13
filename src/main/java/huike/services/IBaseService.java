package huike.services;


import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IBaseService<T> {
     int insert(T pojo);

     int update(T pojo);

     boolean delete(Long id);

     List<T> selectList();

     List<T> selectList(T pojo);

     List<T> selectList(T pojo,String orderBy);

     T selectOne(T pojo);

     PageInfo<T> page(int pageNum, int pageSize, T pojo);

     PageInfo<T> page(int pageNum, int pageSize, T pojo, String orderBy);

     boolean isExisted(T pojo);
}
