package com.hfmx.test.test;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hfmx.model.TUser;
import com.hfmx.service.user.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:applicationContext.xml")
public class HelloTest1 extends AbstractTransactionalJUnit4SpringContextTests {

	@Resource(name = "userServiceImpl")
	private IUserService userService;
	
	@Test
	   public void handleUserLogin(){
	       TUser user = new TUser();
	       user.setUserName("");
	       userService.save(user);
	       long count=userService.count(TUser.class);
	       System.out.println("添加的人数为："+count);
	       Assert.assertEquals(1, (int)count);
	   }
	
	@Test
	public void testControl(){
		
	}
	
}
