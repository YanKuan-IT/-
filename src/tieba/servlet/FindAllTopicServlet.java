package tieba.servlet;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tieba.entity.Topic;
import tieba.service.ITopicService;
import tieba.service.impl.TopicService;

@WebServlet("/FindAllTopicServlet")
public class FindAllTopicServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String uuid = UUID.randomUUID().toString();
		request.getSession().setAttribute("token", uuid);
		
		
		ITopicService topicService = new TopicService();
		
		List<Topic> allTopics = topicService.findAll();
		
		request.setAttribute("allTopics", allTopics);
		
		request.getRequestDispatcher("/allTopic.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
