package com.itheima.service.impl;

import com.itheima.entity.UserInfo;
import com.itheima.mapper.UserMapper;
import com.itheima.service.UserService;
import com.itheima.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {




    @Override
    public int operateUser(UserInfo userInfo,Integer operateType) {
        // 创建方法的返回值
        int count = 0;
        // 创建数据库连接
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            // 执行
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            switch (operateType){
                case UserService.OPERATE_INSERT:
                    count = mapper.insertUser(userInfo);
                    break;
                case UserService.OPERATE_UPDATE:
                    count = mapper.updateUser(userInfo);
                    break;
                case UserService.OPERATE_DELETE:
                    count = mapper.deleteUser(userInfo);
                    break;
            }
            sqlSession.commit();
        } catch (RuntimeException e) {
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }
        // 返回
        return count;
    }

    @Override
    public UserInfo findUserByID(Integer id) {
        // 创建方法的返回值
        UserInfo userInfo = null;
        // 创建数据库连接
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        // 执行
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userInfo = userMapper.findUserByID(id);
        // 关闭
        MybatisUtil.closeSqlSession(sqlSession);
        // 返回
        return userInfo;
    }

    @Override
    public List<UserInfo> findUserByPage(Integer pageIndex, Integer pageSize) {
        // 创建方法的返回值
        List<UserInfo> pageList = null;
        // 获取数据库连接
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        // 执行
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("start",(pageIndex-1)*pageSize);
        map.put("end",pageSize);
        pageList = userMapper.findUsersByPage(map);
        // 关闭
        MybatisUtil.closeSqlSession(sqlSession);
        // 返回
        return pageList;
    }

    @Override
    public int findUserByPageCount() {
        // 创建方法的返回值
        int totalCount = 0;
        // 创建数据库连接
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        // 执行
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        totalCount = mapper.findUsersByPageCount();
        // 关闭
        MybatisUtil.closeSqlSession(sqlSession);
        // 返回
        return totalCount;
    }
}
