package J6Store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import J6Store.entity.Discount;

public interface DiscountDAO extends JpaRepository<Discount, String> {

}
