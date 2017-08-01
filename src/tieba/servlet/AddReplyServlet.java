package tieba.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tieba.entity.Reply;
import tieba.service.IReplyService;
import tieba.service.impl.ReplyService;

@WebServlet("/AddReplyServlet")
public class AddReplyServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int topic_id = Integer.valueOf(request.getParameter("topic_id"));
		System.out.println(topic_id+"======================");
		boolean flag = isRepeatSubmit(request);
		if(flag==true){//false�ظ��ύ��������  true����
			
			String author = request.getParameter("author");
			String content = request.getParameter("content");
			
			Reply reply = new Reply();
			reply.setAuthor(author);
			reply.setContent(content);
			reply.setTopic_id(topic_id);
			
			IReplyService replyService = new ReplyService();
			replyService.save(reply);
		}
		request.getSession().removeAttribute("token");	//	�Ƴ�session�е�token
		request.getRequestDispatcher("FindAllReplyServlet?topic_id="+topic_id).forward(request, response);
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
		doGet(request, response);
	}

}
