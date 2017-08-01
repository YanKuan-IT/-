package tieba.service.impl;

import java.util.List;

import tieba.dao.ITopicDao;
import tieba.dao.impl.TopicDao;
import tieba.entity.Topic;
import tieba.service.ITopicService;

public class TopicService implements ITopicService{
	
	private ITopicDao topicDao = new TopicDao();
	
	@Override
	public void save(Topic topic) {
		topicDao.save(topic);
	}

	@Override
	public List<Topic> findAll() {
		return topicDao.findAll();
	}

	@Override
	public Topic findById(int id) {
		return topicDao.findById(id);
	}

	@Override
	public void updateClick_amount(Topic topic) {
		topicDao.updateClick_amount(topic);
	}

	

}
