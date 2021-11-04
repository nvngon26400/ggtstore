package J6Store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import J6Store.entity.Comment;
import J6Store.entity.Product;

public interface ProductService {

	List<Product> findAll();

	Product findById(Integer id);

	List<Comment> findCommentByProductId(Integer id);

	List<Product> findByCategoryId(String cid);

	Product create(Product product);

	Product update(Product product);

	void delete(Integer id);

	List<Product> findByNameContaining(String name);

	long count();

	Page<Product> findAllPro(Pageable pageable);

	Page<Product> findAll(Pageable pageable);

	Page<Product> findByNameContaining(String name, Pageable pageable);

	Page<Product> findByCategory(String cid, Pageable pageable);

	Optional<Product> findById(Long productId);
}
