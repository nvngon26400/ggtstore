package J6Store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import J6Store.dao.CommentDAO;
import J6Store.entity.Comment;
import J6Store.entity.Product;
import J6Store.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDAO commentDAO;

	@Override
	public List<Comment> findAll() {
		return commentDAO.findAll();
	}

	@Override
	public Comment findCommentById(Integer id) {
		return commentDAO.findCommentById(id).get();
	}

	@Override
	public List<Comment> findCommentByProductId(Integer id) {
		return commentDAO.findCommentByProductId(id);
	}

	@Override
	public Comment create(Comment comment) {
		return commentDAO.save(comment);
	}

	@Override
	public void delete(Integer id) {
		commentDAO.deleteById(id);
	}

	@Override
	public long count() {
		return commentDAO.count();
	}

}
