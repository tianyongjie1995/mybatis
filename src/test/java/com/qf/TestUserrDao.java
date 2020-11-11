package com.qf;

import com.qf.dao.UserrDao;
import com.qf.pojo.Userr;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestUserrDao {
    @Test
    public void findAll() throws IOException {
        String resource="mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserrDao mapper = sqlSession.getMapper(UserrDao.class);
        List<Userr> all = mapper.findAll();
        System.out.println("all = " + all);
    }
}
