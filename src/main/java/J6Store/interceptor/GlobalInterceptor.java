package J6Store.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import J6Store.service.CategoryService;
import J6Store.service.CommentService;

@Component
public class GlobalInterceptor implements HandlerInterceptor {
	@Autowired
	CategoryService categoryService;
	@Autowired
	CommentService commentService;

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		request.setAttribute("cates", categoryService.findAll());
		// request.setAttribute("comment", commentService.findAll());
	}
}
