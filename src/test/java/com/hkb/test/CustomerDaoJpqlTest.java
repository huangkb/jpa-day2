package com.hkb.test;

import com.hkb.dao.CustomerDao;
import com.hkb.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        Customer one = customerDao.findCustomerByNameAndId("huangkb05", 9L);
        System.out.println(one);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testUpdate() {
        customerDao.updateCustomerById("119", 9L);
        System.out.println(customerDao.findOne(9L));
    }

    @Test
    public void testSql() {
        List<Object[]> bySql = customerDao.findBySql("huangkb01%");
        bySql.forEach(x -> {
            System.out.println(Arrays.toString(x));
        });
    }

    @Test
    public void testMethod() {
        //System.out.println(customerDao.findByCustName("huangkb010"));
        //customerDao.findByCustNameLike("huangkb01%").forEach(System.out::println);
        customerDao.findByCustNameLikeAndCustPhone("huangkb0%","119").forEach(System.out::println);

    }
}
