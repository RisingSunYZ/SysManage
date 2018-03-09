package com.hfmx.service.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hfmx.dao.book.IBookModelDao;
import com.hfmx.model.TBookModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class BookServiceTest {
	@Resource(name = "bookModelDao")
	private IBookModelDao modeldao;

	@Test
	public void test() {
		TBookModel model = modeldao.find(TBookModel.class, 19);
		System.out.println(model == null);
	}
}
