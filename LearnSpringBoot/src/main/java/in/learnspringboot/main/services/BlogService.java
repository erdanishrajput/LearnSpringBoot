package in.learnspringboot.main.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.learnspringboot.main.Entity.Blogs;
import in.learnspringboot.main.Entity.Creater;
import in.learnspringboot.main.dao.BlogDAO;
import in.learnspringboot.main.dao.CreaterDAO;
import in.learnspringboot.main.dto.BlogReqDTO;
import in.learnspringboot.main.dto.BlogResDTO;
import in.learnspringboot.main.exceptions.UniqueNameNotFoundException;
import in.learnspringboot.main.translaters.BlogTranslater;

@Service
public class BlogService {
	
	@Autowired
	private BlogDAO blogDAO;
	
	@Autowired
	private CreaterDAO createrDAO;
	
	@Autowired
	private BlogTranslater blogTranslater;
	
//	<----------------------------------------------------------------------------------------------------------------->
	
	public BlogResDTO saveBlog(BlogReqDTO blogReqDTO) throws UniqueNameNotFoundException{
		Blogs blog = blogTranslater.blogDtoToEntity(blogReqDTO);
		
		Creater creater = blog.getCreater();
		Optional<Creater> existingCreaterOptional = createrDAO.findCreaterByUniqueName(creater.getUniqueNameString());

		if (existingCreaterOptional.isEmpty()) {
		    throw new UniqueNameNotFoundException("Creator cannot post...");
		}

		// Use the existing persisted Creater object
		Creater existingCreater = existingCreaterOptional.get();
		blog.setCreater(existingCreater);


		
		Blogs savedBlogs = blogDAO.saveBlog(blog);
		
		
		return blogTranslater.blogEntityToDto(savedBlogs);
		
	}
	
	

}
