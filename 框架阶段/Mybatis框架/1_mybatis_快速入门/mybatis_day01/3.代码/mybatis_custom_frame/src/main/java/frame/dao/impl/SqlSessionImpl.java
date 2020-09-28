package frame.dao.impl;

import frame.dao.SqlSession;
import frame.domain.Configuration;
import frame.domain.Mapper;
import frame.utils.Executor;

import java.util.List;

/**
 * 耦合度： 工厂模式 创建对象 ， 代替new的方法
 */
public class SqlSessionImpl implements SqlSession {

    Configuration cfg;
    Executor executor;
    public SqlSessionImpl(Configuration cfg) {
        this.cfg = cfg;
        //创建sql语句执行器对象
        executor = new Executor(cfg);
    }

    /**
     *
     * @param mapperId   全类名 + 方法名
     * @return
     */
    @Override
    public List selectList(String mapperId) {
        // 通过key获取value , 根据mapperId获取sql语句和返回值类型
        Mapper mapper = cfg.getMappers().get(mapperId);

        //执行sql语句的过程
        List list = executor.executeQuery(mapper);

        return list;
    }

    @Override
    public void close() {
        executor.close();
    }
}
