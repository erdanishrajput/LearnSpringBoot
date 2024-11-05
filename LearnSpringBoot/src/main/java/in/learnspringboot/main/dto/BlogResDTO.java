package in.learnspringboot.main.dto;

import java.time.LocalDateTime;

import in.learnspringboot.main.Entity.Creater;
import lombok.Data;
@Data
public class BlogResDTO {
	
	private String blogTitleString;
	private String blogContentString;
	private LocalDateTime createDateTime;


}
