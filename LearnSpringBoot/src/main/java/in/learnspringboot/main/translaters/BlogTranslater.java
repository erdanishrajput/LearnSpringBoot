package in.learnspringboot.main.translaters;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.learnspringboot.main.Entity.Blogs;
import in.learnspringboot.main.dto.BlogReqDTO;
import in.learnspringboot.main.dto.BlogResDTO;

@Component
public class BlogTranslater {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Blogs blogDtoToEntity(BlogReqDTO blogReqDTO) {
		return modelMapper.map(blogReqDTO, Blogs.class);
	}
	
	public BlogResDTO blogEntityToDto(Blogs blog) {
		return modelMapper.map(blog, BlogResDTO.class);
	}
	

}
