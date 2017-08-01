package tieba.test;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;

import tieba.dao.ITopicDao;
import tieba.dao.impl.TopicDao;
import tieba.entity.Topic;

public class Test1 {
	ITopicDao topicDao = new TopicDao();
	@Test
	public void add(){
		Topic topic = new Topic();
		
		topic.setAuthor("wu2");
		topic.setTitle("dahe2");
		topic.setContent("adfasdfasdassd");
		
		topicDao.save(topic);
	}
	
	@Test
	public void findById(){
		
		Topic findById = topicDao.findById(5);
		System.out.println(findById);
		Timestamp carete_time = findById.getCreate_time();
		System.out.println(carete_time);
	}
	
	@Test
	public void FindAll(){
		List<Topic> findAll = topicDao.findAll();
		
		for(Topic topic : findAll){
			System.out.println(topic);
		}
	}
	
}
