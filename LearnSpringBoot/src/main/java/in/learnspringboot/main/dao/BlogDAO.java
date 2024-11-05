package in.learnspringboot.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.learnspringboot.main.Entity.Blogs;
import in.learnspringboot.main.repositories.BlogRepo;

@Repository
public class BlogDAO {
	
	@Autowired
	private BlogRepo blogRepo;
	
//	<----------------------------------------------------------------------------------------------------------------->
	
	public Blogs saveBlog(Blogs blogs) {
		return blogRepo.save(blogs);
	}
	
//	<----------------------------------------------------------------------------------------------------------------->

}
