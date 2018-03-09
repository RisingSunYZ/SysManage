package com.hfmx.service.base.test;


import java.util.Date;




import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hfmx.model.TLogOperation;
import com.hfmx.service.log.ILogService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:applicationContext.xml")
public class LogServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Resource(name="logService")
	private ILogService logService;
	
	@Test
	public void testAdd(){
		
		TLogOperation log=new TLogOperation();
		log.setContent("王伟来测试了下");
		log.setTime(new Date());
		logService.save(log);
		Assert.assertEquals(logService.count(), 1);
	}
}
