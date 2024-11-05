package in.learnspringboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.learnspringboot.main.dto.BlogReqDTO;
import in.learnspringboot.main.dto.BlogResDTO;
import in.learnspringboot.main.services.BlogService;

@RestController
@RequestMapping("/blog")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@PostMapping("/post")
	public ResponseEntity<BlogResDTO> postBlog(@RequestBody BlogReqDTO blogReqDTO) {
		return new ResponseEntity<BlogResDTO>(blogService.saveBlog(blogReqDTO), HttpStatus.OK);
	}

}
