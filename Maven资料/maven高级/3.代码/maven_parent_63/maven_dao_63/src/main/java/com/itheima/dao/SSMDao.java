package com.itheima.dao;

import com.itheima.domain.SSM;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface SSMDao {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from ssm where id = #{id}")
    public SSM findById(Integer id);

}
