package tieba.entity;

import java.sql.Timestamp;

/**
 * 贴吧表
 *
 */
public class Topic {
	
	private int topic_id; 			// 帖子编号
	private String title ;			// 标题
	private String content ;		// 内容
	private String author;			// 作者
	private Timestamp create_time; 	// 发帖时间
	private int click_amount ;		// 点击量 默认为零
	
	
	
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
		return "Topic [id=" + topic_id + ", 标题=" + title + ", 内容=" + content + ", 作者=" + author
				+ ", 时间=" + create_time + ", 点击量=" + click_amount + "]";
	}
	
	
}
