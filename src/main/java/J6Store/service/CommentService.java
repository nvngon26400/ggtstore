package J6Store.service;

import java.util.List;

import J6Store.entity.Comment;

public interface CommentService {

	List<Comment> findAll();

	Comment findCommentById(Integer id);

	List<Comment> findCommentByProductId(Integer id);

	Comment create(Comment comment);

	void delete(Integer id);

	long count();
}
