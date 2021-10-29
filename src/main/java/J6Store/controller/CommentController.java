package J6Store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import J6Store.dao.CommentDAO;
import J6Store.entity.Comment;
import J6Store.service.CommentService;
import org.springframework.ui.Model;

@Controller
public class CommentController {

	@Autowired
	CommentService commentService;

	@Autowired
	CommentDAO commentDao;

	// @RequestMapping("/product/comment/detail/{id}")
	// public String commentDetail(Model model, @PathVariable("id") Integer id) {
	// List<Comment> item = commentService.findByCommentId(id);
	// model.addAttribute("items", item);
	// return "product/detail";
	// }
}
