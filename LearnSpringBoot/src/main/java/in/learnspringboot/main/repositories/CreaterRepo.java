package in.learnspringboot.main.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.learnspringboot.main.Entity.Creater;

public interface CreaterRepo extends JpaRepository<Creater, Long>{
	public boolean existsByuniqueNameString(String uniqueName);
	
	public Optional<Creater> getByuniqueNameString(String uniqueName);

	public Integer deleteByuniqueNameString(String uniqueName);
	
<<<<<<< HEAD
=======
	public List<Creater> findByUniqueNameStringContainingIgnoreCase(String uniqueName);
	public List<Creater> findByemailStringContainingIgnoreCase(String emailString);
	public List<Creater> findBynameStringContainingIgnoreCase(String nameString);
>>>>>>> branch 'danish' of https://github.com/erdanishrajput/LearnSpringBoot.git
}
