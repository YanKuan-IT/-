package tieba.entity;

import java.util.Date;
/**
 * ���۱�
 *
 */
public class Reply {
	
	private int replyId;		// ���۱��
	private String author;		// ����
	private String content;		// ����
	private Date create_time;	// ����ʱ��
	private int topic_id;
	
	
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public int getTopic_id() {
		return topic_id;
	}
	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}
	
	
}
