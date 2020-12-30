package com.hkb.dao;

import com.hkb.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * JpaRepository<操作的实体类类型,实体类中主键属性的类型>
 * *封装了基本CRUD
 * JpaSpecificationExecutor<操作的实体类类型>
 * *封装了复杂查询
 */
public interface CustomerDao extends
        JpaRepository<Customer, Long>,
        JpaSpecificationExecutor<Customer> {

    @Query(value = "from Customer where custName = ?1")
    public Customer findCustomerByName(String custName);

    @Query(value = "from Customer where custId=?2 and custName = ?1")
    public Customer findCustomerByNameAndId(String custName,Long id);

}

