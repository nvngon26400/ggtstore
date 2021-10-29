package J6Store.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import J6Store.entity.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long>{
	
	@Query(nativeQuery = true, value = "select count(status) from OrderDetails where status='4'")
	long orderDetailSuccess();
	
	@Query(nativeQuery = true, value = "select count(status) from OrderDetails where status='3'")
	long orderDetailFail();
	
	@Query(nativeQuery = true, value = "select count(status) from OrderDetails where status='1'")
	long orderDetailCancel();
	
	@Query(nativeQuery = true, value = "select count(status) from OrderDetails where status='2'")
	long orderDetailOnAir();
	
	@Query(nativeQuery = true, value = "select SUM(price) from OrderDetails")
	long totalRevenue();
	
	@Query(nativeQuery = true, value = "select count(quantity) from orderDetails")
	long totalQuantity();
}
