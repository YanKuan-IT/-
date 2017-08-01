package tieba.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tieba.dao.IReplyDao;
import tieba.entity.Reply;
import tieba.util.JdbcUtil;

public class ReplyDao implements IReplyDao {

	@Override
	public void save(Reply reply) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "Insert into t_reply(author,content,topic_id) values(?,?,?) "; 
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, reply.getAuthor());
			stmt.setString(2, reply.getContent());
			stmt.setInt(3, reply.getTopic_id());
			
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
	public List<Reply> findAllReplyByTopicid(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from t_reply where topic_id = ? ";
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			
			List<Reply> list = new ArrayList<Reply>();
			while(rs.next()){
				Reply reply = new Reply();
				reply.setReplyId(rs.getInt("replyId"));
				reply.setAuthor(rs.getString("author"));
				reply.setContent(rs.getString("content"));
				reply.setCreate_time(rs.getTimestamp("create_time"));
				reply.setTopic_id(rs.getInt("topic_id"));
				
				list.add(reply);
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

}
