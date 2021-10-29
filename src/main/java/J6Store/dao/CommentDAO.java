package J6Store.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import J6Store.entity.Comment;

public interface CommentDAO extends JpaRepository<Comment, Integer> {
	@Query("SELECT c FROM Comment c WHERE c.product.id=?1")
	List<Comment> findCommentByProductId(Integer id);

	Optional<Comment> findCommentById(Integer id);

	// Optional<Comment> findCommentByProductId(Integer id);
}
