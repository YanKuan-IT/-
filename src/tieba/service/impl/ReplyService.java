package tieba.service.impl;

import java.util.List;

import tieba.dao.IReplyDao;
import tieba.dao.impl.ReplyDao;
import tieba.entity.Reply;
import tieba.service.IReplyService;

public class ReplyService implements IReplyService {
	
	private IReplyDao replyDao = new ReplyDao();
	
	@Override
	public void save(Reply reply) {
		replyDao.save(reply);
	}

	@Override
	public List<Reply> findAllReplyByTopicid(int id) {
		return replyDao.findAllReplyByTopicid(id);
	}
	
}
