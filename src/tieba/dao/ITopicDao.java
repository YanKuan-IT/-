package tieba.dao;

import java.util.List;

import tieba.entity.Topic;

public interface ITopicDao {
	void save(Topic topic);
	
	List<Topic> findAll();
	
	Topic findById(int id);
	
	void updateClick_amount(Topic topic);
	
}
