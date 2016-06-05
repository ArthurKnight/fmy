/*package com.fmy.test;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fmy.entity.User;
import com.fmy.util.MyBatisUtil;
import com.springincation.springidol.Performer;

public class TestUserCase {

	
	public void test() {
		//mybatis的配置文件
        String resource = "config_mybatis.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = MyBatisUtil.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource); 
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        *//**
         * 映射sql的标识字符串，
         * com.fmy.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         *//*
        String statement = "com.fmy.mapping.userMapper.getUser";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        User user = session.selectOne(statement, 2);
        System.out.println(user);
        
	}
	
	
    public void testAdd(){
        //SqlSession sqlSession = MyBatisUtil.getSqlSession(false);
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        *//**
         * 映射sql的标识字符串，
         * com.fmy.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * addUser是insert标签的id属性值，通过insert标签的id属性值就可以找到要执行的SQL
         *//*
        String statement = "com.fmy.mapping.userMapper.addUser";//映射sql的标识字符串
        User user = new User();
        user.setName("用户孤傲苍狼");
        user.setAge(20);
        //执行插入操作
        int retResult = sqlSession.insert(statement,user);
        //手动提交事务
        //sqlSession.commit();
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(retResult);
    }
    
    
    public void testUpdate(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        *//**
         * 映射sql的标识字符串，
         * com.fmy.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * updateUser是update标签的id属性值，通过update标签的id属性值就可以找到要执行的SQL
         *//*
        String statement = "com.fmy.mapping.userMapper.updateUser";//映射sql的标识字符串
        User user = new User();
        user.setId(1);
        user.setName("孤傲苍狼update");
        user.setAge(24);
        //执行修改操作
        int retResult = sqlSession.update(statement,user);
        //sqlSession.commit();
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(retResult);
    }
    
    
    public void testDelete(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        *//**
         * 映射sql的标识字符串，
         * com.fmy.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * deleteUser是delete标签的id属性值，通过delete标签的id属性值就可以找到要执行的SQL
         *//*
        String statement = "com.fmy.mapping.userMapper.deleteUser";//映射sql的标识字符串
        //执行删除操作
        int retResult = sqlSession.delete(statement,5);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(retResult);
    }
    
    
    public void testGetAll(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        *//**
         * 映射sql的标识字符串，
         * com.fmy.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getAllUsers是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         *//*
        String statement = "com.fmy.mapping.userMapper.getAllUsers";//映射sql的标识字符串
        //执行查询操作，将查询结果自动封装成List<User>返回
        List<User> lstUsers = sqlSession.selectList(statement);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(lstUsers);
    }
	@Test
	public void testPerform(){
		ApplicationContext context=new ClassPathXmlApplicationContext("dispatcherServlet-servlet.xml");
		Performer p=(Performer) context.getBean("poeticDuke");
		p.perform();
	}

}
*/