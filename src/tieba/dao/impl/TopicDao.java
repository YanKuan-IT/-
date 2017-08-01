package tieba.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tieba.dao.ITopicDao;
import tieba.entity.Topic;
import tieba.util.JdbcUtil;

public class TopicDao implements ITopicDao {

	@Override
	public void save(Topic topic) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "Insert into t_topic(title,content,author,click_amount) values(?,?,?,?) "; 
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, topic.getTitle());
			stmt.setString(2, topic.getContent());
			stmt.setString(3, topic.getAuthor());
			stmt.setInt(4, topic.getClick_amount());
			
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
			try {
				conn.close();
				stmt.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public List<Topic> findAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from t_topic";
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			List<Topic> list = new ArrayList<Topic>();
			while(rs.next()){
				Topic topic = new Topic();
				
				topic.setTopic_id(rs.getInt("topic_id"));
				topic.setTitle(rs.getString("title"));
				topic.setContent(rs.getString("content"));
				topic.setAuthor(rs.getString("author"));
				topic.setCreate_time(rs.getTimestamp("create_time"));
				topic.setClick_amount(rs.getInt("click_amount"));
				
				list.add(topic);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public Topic findById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from t_topic where topic_id=? ";
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			Topic topic = new Topic();
			while(rs.next()){
				topic.setTitle(rs.getString("title"));
				topic.setAuthor(rs.getString("author"));
				topic.setCreate_time(rs.getTimestamp("create_time"));
				topic.setClick_amount(rs.getInt("click_amount"));
				topic.setContent(rs.getString("content"));
				topic.setTopic_id(rs.getInt("topic_id"));
			}
			return topic;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public void updateClick_amount(Topic topic) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			//获取连接
			conn = JdbcUtil.getConnection();
			String sql = "UPDATE t_topic SET click_amount=? WHERE topic_id=? ";
			//创建PreparedStatement
			stmt = conn.prepareStatement(sql);
			//设置参数
			stmt.setInt(1,topic.getClick_amount());
			stmt.setInt(2, topic.getTopic_id());
			
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
			try {
				conn.close();
				stmt.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}
