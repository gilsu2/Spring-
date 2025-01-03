package dw.com.companyapp.repository;

import dw.com.companyapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,String> {

    @Query("select o from Order o where o.customer.id = :customerId and o.orderId " +
            "in (select orderId from OrderDetail od where od.product.Id = :productNumber)")
    List<Order> findByProductEmployee(Long productNumber, String customerId);


}
