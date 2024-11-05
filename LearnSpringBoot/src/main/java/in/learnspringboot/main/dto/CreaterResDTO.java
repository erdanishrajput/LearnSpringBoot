package in.learnspringboot.main.dto;

import java.util.List;

import in.learnspringboot.main.Entity.Blogs;
import lombok.Data;

@Data
public class CreaterResDTO {
	private String nameString;
	private String uniqueNameString;
	private String emailString;
	private Long phoneNoLong;
	private String nicheOfCreaterString;
	
	private List<Blogs> blogs;
}
