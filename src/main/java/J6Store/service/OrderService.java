package J6Store.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import J6Store.entity.Order;

public interface OrderService {

	Order create(JsonNode orderData);

	Order findById(Long id);

	List<Order> findByUsername(String username);

	List<Order> findAll();
	
	void delete(Long id);

	void deleteById(Long id);

	long count();
}
