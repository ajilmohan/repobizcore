package com.href.biz.test.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.href.biz.domain.DicnClazz;
import com.href.biz.repository.DicnClazzRepo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:config.xml",
        "classpath:repo.xml"
})

@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class })
public class DicnClazzRepoTest {
	
	@Autowired
	DicnClazzRepo dicnClazzRepo;
	
	
	@Test
	@Transactional
	@Rollback(false)
	public void saveTest(){
		
		DicnClazz clazz = new DicnClazz();
		clazz.setName("Gold");
		clazz.setRate(150D);
		
		dicnClazzRepo.save(clazz);
		
		clazz = new DicnClazz();
		clazz.setName("Silver");
		clazz.setRate(100D);
		
		dicnClazzRepo.save(clazz);
	}

}
