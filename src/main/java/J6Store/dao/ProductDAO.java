package J6Store.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import J6Store.entity.Comment;
import J6Store.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {

	@Query("SELECT p from Product p where p.category.id=?1")
	List<Product> findByCategoryId(String cid);

	List<Product> findByNameContaining(String name);

	// tim kiem va phan trang
	Page<Product> findByNameContaining(String name, Pageable pageable);

	@Query("SELECT o FROM Product o WHERE o.price BETWEEN ?1 AND ?2")
	Page<Product> findByPrice(double minPrice, double maxPrice, Pageable pageable);

	@Query("SELECT p FROM Product p Where p.category.id=?1")
	Page<Product> findByCategory(String cid, Pageable pageable);

	@Query(value = "select * from Product where categoryid = ?", nativeQuery = true)
	Page<Product> findAllProductByCategoryId(Long id, Pageable pageable);

	Optional<Product> findById(Long productId);

	@Query("SELECT c FROM Comment c WHERE c.product.id=?1")
	List<Comment> findCommentByProductId();

	// // Optional<Comment> findById(Long id);

}
