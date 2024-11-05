package in.learnspringboot.main.Entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Blogs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLong;
	private String blogTitleString;
	private String blogContentString;
	private LocalDateTime createDateTime;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "unique_name_string", referencedColumnName = "uniqueNameString", nullable = false)
	@JsonBackReference 
	private Creater creater;
	
}
