package cn.itheima.tnb.core;

import java.util.List;

public interface SqlSession {


    /**
     * 根据ID执行相应的SQL语句
     * @param id
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T> List<T> selectList(String id)throws Exception;

}
