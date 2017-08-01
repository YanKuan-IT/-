package tieba.servlet;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tieba.entity.Reply;
import tieba.entity.Topic;
import tieba.service.IReplyService;
import tieba.service.ITopicService;
import tieba.service.impl.ReplyService;
import tieba.service.impl.TopicService;

@WebServlet("/FindAllReplyServlet")
public class FindAllReplyServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String uuid = UUID.randomUUID().toString();
		request.getSession().setAttribute("token", uuid);
		
		int topic_id = Integer.valueOf(request.getParameter("topic_id"));
		
		IReplyService replyService = new ReplyService();
		
		List<Reply> allReply = replyService.findAllReplyByTopicid(topic_id);
		
		request.setAttribute("allReply", allReply);
		
		ITopicService topicService = new TopicService();
		Topic topic = topicService.findById(topic_id);
		
		topic.setClick_amount(topic.getClick_amount()+1);	// ‰Ø¿¿¡ø+1
		
		topicService.updateClick_amount(topic);	
		
		request.setAttribute("topic", topic);
		
		request.getRequestDispatcher("/topicInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
}
