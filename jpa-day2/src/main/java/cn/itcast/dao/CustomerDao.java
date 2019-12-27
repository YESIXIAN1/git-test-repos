package cn.itcast.dao;

import cn.itcast.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ${ysxian}
 * Date: 2019/12/25
 * TIME: 14:55
 */
public interface CustomerDao extends JpaRepository<Customer,Long>,JpaSpecificationExecutor<Customer> {
    @Query(value = "FROM Customer where custAddress = ?")
    Customer findJPL(String cusAddress);

    @Query(value = "FROM Customer where custAddress = ?2 AND custId = ?1")
    Customer findCustomerByIdAndCustAddress(Long id, String cusAddress);

    @Query(value = "update Customer SET custAddress = ?2 where custId = ?1")
    @Modifying
    void updateById(Long id, String custAddress);

    @Query(value = "SELECT * FROM CST_CUSTOMER", nativeQuery = true)
    List<Object []> queryAllBySQL();

    @Query(value = "SELECT * FROM CST_CUSTOMER where cust_name = ?1", nativeQuery = true)
    List<Object []> queryAllByCustNameSQL(String custName);

    /**
     * 方法命名规则查询：基本查询
     * @Author       yesixian
     * @param
     * @return       
     * @exception    
     * @date         2019/12/26 14:16
     */
    Customer findByCustName(String custName);

    /**
     * 方法命名规则查询：基本查询
     * @Author       yesixian
     * @param
     * @return
     * @exception
     * @date         2019/12/26 14:16
     */
    List<Customer> findByCustNameLike(String custName);

    /**
     * 方法实现说明
     * @Author       yesixian
     * @param
     * @return       
     * @exception    
     * @date         2019/12/26 14:33
     */
    List<Customer> findByCustNameLikeAndCustAddress(String custName, String custAddress);
}
