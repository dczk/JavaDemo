package com.info.test;

import com.info.po.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {


    @Test
    public void findCustomerByIdTest() throws Exception {
        String resoure = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resoure);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Customer customer = sqlSession.selectOne("com.info.mapper.CustomerMapper.findCustomerById", 1);
        System.out.println(customer.toString());
        sqlSession.close();
    }

    @Test
    public void findCustomerByNameTest() throws Exception {
        String resoure = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resoure);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Customer> list = sqlSession.selectList("com.info.mapper.CustomerMapper.findCustomerByName", "j");
        for (Customer customer : list) {
            System.out.println(customer.toString());
        }
        sqlSession.close();
    }
}
