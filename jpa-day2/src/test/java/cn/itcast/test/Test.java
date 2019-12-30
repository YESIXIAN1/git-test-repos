package cn.itcast.test;

import cn.itcast.dao.CustomerDao;
import cn.itcast.entity.Customer;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ${ysxian}
 * Date: 2019/12/25
 * TIME: 15:06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test {
    @Autowired
    private CustomerDao customerDao;

    @org.junit.Test
    public void save() {
        Customer customer = new Customer();
        customer.setCustAddress("北京");

        customerDao.save(customer);
    }

    @org.junit.Test
    public void testUpdate() {
        Customer customer = customerDao.findOne(9L);
        customer.setCustAddress("安庆");

        customerDao.save(customer);
    }

    @org.junit.Test
    public void testDelete() {
        customerDao.delete(8L);
        System.out.println(1/0);
    }

    @org.junit.Test
    public void testFind() {
        Customer one = customerDao.findOne(7L);

        System.out.println(one);

    }

    @org.junit.Test
    public void testCount() {
        long count = customerDao.count();

        System.out.println(count);
    }

    @org.junit.Test
    public void testExists() {
        boolean exists = customerDao.exists(6L);

        System.out.println(exists);
    }

    @org.junit.Test
    public void testFindOne() {
        Customer one = customerDao.findOne(6L);
        System.out.println("测试延迟加载....");

        System.out.println(one);
    }

    @org.junit.Test
    @Transactional
    public void testGetOne() {
        Customer one = customerDao.getOne(6L);
        System.out.println("测试延迟加载....");

        System.out.println(one);
    }

    @org.junit.Test
    public  void testJpl() {
        Customer customer = customerDao.findJPL("北京");

        System.out.println(customer);
    }

    @org.junit.Test
    public  void testJpl1() {
        Customer customer = customerDao.findCustomerByIdAndCustAddress(7L, "北京");

        System.out.println(customer);
    }

    @org.junit.Test
    @Transactional
    @Rollback(value = false)
    public void testJpl2() {
        customerDao.updateById(7L, "上海");
    }

    @org.junit.Test
    public  void testJpl3() {
        List<Object[]> objects = customerDao.queryAllBySQL();

        for(Object[] object : objects) {
            System.out.println(object[1]);
        }
    }

    @org.junit.Test
    public  void testJpl4() {
        List<Object[]> objects = customerDao.queryAllByCustNameSQL("bill");

        for(Object[] object : objects) {
            System.out.println(object[1]);
        }
    }

    @org.junit.Test
    public  void testJpl5() {
        Customer customer = customerDao.findByCustName("bill");

        System.out.println(customer);
    }

    @org.junit.Test
    public  void testJpl6() {
        List<Customer> customers = customerDao.findByCustNameLike("bill");

        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

	// 测试
	// 测试1
	// 测试2
	// 测试4
    @org.junit.Test
    public  void testJpl7() {
        List<Customer> customers = customerDao.findByCustNameLikeAndCustAddress("%bill%", "SH");

        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
	
	// 你好，我要测试冲突

}
