package com.fmy.test;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fmy.entity.Order;
import com.fmy.service.UserService;
import com.fmy.util.MyBatisUtil;

@RunWith(SpringJUnit4ClassRunner.class)
//配置了@ContextConfiguration注解并使用该注解的locations属性指明spring和配置文件之后，
//@ContextConfiguration(locations = {"classpath:dispatcherServlet-servlet.xml","classpath:dispatcherServlet-servlet.xml","classpath:mybatis_config.xml"})
public class UserServiceImplTest {
	
	@Autowired
	private UserService userService;

	@Test
	public void testSendFlower() {
		userService.sendFlower("1", "123");
	}

}
