package tieba.entity;

import java.sql.Timestamp;

/**
 * ���ɱ�
 *
 */
public class Topic {
	
	private int topic_id; 			// ���ӱ��
	private String title ;			// ����
	private String content ;		// ����
	private String author;			// ����
	private Timestamp create_time; 	// ����ʱ��
	private int click_amount ;		// ����� Ĭ��Ϊ��
	
	
	
	public int getTopic_id() {
		return topic_id;
	}
	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getClick_amount() {
		return click_amount;
	}
	public void setClick_amount(int click_amount) {
		this.click_amount = click_amount;
	}
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		return "Topic [id=" + topic_id + ", ����=" + title + ", ����=" + content + ", ����=" + author
				+ ", ʱ��=" + create_time + ", �����=" + click_amount + "]";
	}
	
	
}
