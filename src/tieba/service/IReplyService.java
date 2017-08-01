package tieba.service;

import java.util.List;

import tieba.entity.Reply;

public interface IReplyService {
	void save(Reply reply);
	
	List<Reply> findAllReplyByTopicid(int id);
	
	
}
