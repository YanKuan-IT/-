package tieba.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tieba.entity.Topic;
import tieba.service.ITopicService;
import tieba.service.impl.TopicService;

@WebServlet("/AddTopicServlet")
public class AddTopicServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		ITopicService topicService = new TopicService();
		boolean flag = isRepeatSubmit(request);
		
		if(flag==true){//false�ظ��ύ��������  true����
		
			String author = request.getParameter("author");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			Topic topic = new Topic();
			topic.setAuthor(author);
			topic.setTitle(title);
			topic.setContent(content);

			topicService.save(topic);
		}
		List<Topic> allTopics = topicService.findAll();
		
		request.setAttribute("allTopics", allTopics);
		
		request.getSession().removeAttribute("token");	//	�Ƴ�session�е�token
		
		request.getRequestDispatcher("/allTopic.jsp").forward(request, response);
		
	}
	/**
	 * �Ƿ��ظ��ύ
	 * @param request
	 * @return
	 */
	private boolean isRepeatSubmit(HttpServletRequest request) {
		
		String tokenValue = request.getParameter("token");

		HttpSession session = request.getSession();
		String tokenSessionValue = (String) session.getAttribute("token");
		
		if(tokenValue==null){
			System.out.println("�ظ��ύ��");
			return false;
		}
		if(tokenSessionValue==null){
			System.out.println("�ظ��ύ��");
			return false;
		}
		if(!tokenSessionValue.equals(tokenValue)){
			System.out.println("�ظ��ύ��");
			return false;
		}
		return true;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
