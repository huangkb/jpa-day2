package com.hkb.test;

import com.hkb.dao.CustomerDao;
import com.hkb.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)//声明spring提供的单元测试环境
@ContextConfiguration(locations = "classpath:applicationContext.xml")//指定spring容器配置信息
public class CustomerDaoJpqlTest {

    //动态代理（生成基于接口的实现类对象）
    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testFindOne() {
        Customer one = customerDao.findCustomerByName("huangkb05");
        System.out.println(one);
    }

    @Test
    public void testFind() {
        Customer one = customerDao.findCustomerByNameAndId("huangkb05",9L);
        System.out.println(one);
    }
}
