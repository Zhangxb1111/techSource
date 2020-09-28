package frame.dao;

import java.util.List;

/**
 * 框架的入口
 *          操作框架
 */
public interface SqlSession {

    /**
     * 查询数据库
     * @param mapperId   全类名 + 方法名
     * @return   结果集：List<User>
     */
    public List selectList(String mapperId);

    /**
     * 关闭sqlSession
     */
    public void close();
}
