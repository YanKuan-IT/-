package tieba.dao;

import java.util.List;

import tieba.entity.Reply;

public interface IReplyDao {
	void save(Reply reply);
	
	List<Reply> findAllReplyByTopicid(int id);
	
}
