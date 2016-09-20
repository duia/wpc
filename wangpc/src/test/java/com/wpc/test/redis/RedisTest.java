package com.wpc.test.redis;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wpc.admin.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
"classpath:config/spring-mybatis.xml"
})
public class RedisTest {

	@Resource(name=UserService.BEAN_ID)
	private UserService userService;
	
	@Test
    public void testaddObject(){  
        System.out.println("执行测试");
        System.out.println(userService.findById(3));
        System.out.println("运行完成");  
    }
}
