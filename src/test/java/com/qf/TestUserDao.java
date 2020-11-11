package com.qf;


import com.qf.dao.UserDao;
import com.qf.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestUserDao {
    @Test
    public void testDao() throws IOException {
        String resource="mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> all = mapper.findAll();
        System.out.println(all);
    }

    @Test
    public void testById() throws IOException {
        String resource="mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.selectById(3);
        System.out.println("user = " + user);
    }

    @Test
    public void selectByIdAndUserName() throws IOException {
        String resource="mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.selectByIdAndUserName(2, "李");
        System.out.println("user = " + user);
    }

    @Test
    public void selectByUserName() throws IOException {
        String resource="mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> user = mapper.selectByUserName("李");
        System.out.println("user = " + user);
    }

    @Test
    public void deleteById() throws IOException {
        String resource="mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        int i = mapper.deleteById(3);
        System.out.println("受影响行数=="+i);
    }

    @Test
    public void updateById() throws IOException {
        String resource="mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setId(2);
        user.setName("李四");
        user.setSex("女");
        int i = mapper.updateById(user);
        System.out.println("受影响行数=="+i);
    }

    @Test
    public void insertUser() throws IOException {
        String resource="mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setName("李三四");
        user.setSex("女");
        int i = mapper.insertUser(user);
        System.out.println("i = " + i);
    }

    @Test
    public void insertUserGetId() throws IOException {
        String resource="mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setName("雒laoshi");
        user.setSex("女");
        int i = mapper.insertUserGetId(user);
        System.out.println("i = " + i+"当前新增id为:"+user.getId());
    }
}
