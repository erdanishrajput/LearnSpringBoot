package in.learnspringboot.main.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.learnspringboot.main.Entity.Creater;

public interface CreaterRepo extends JpaRepository<Creater, Long>{
	public boolean existsByuniqueNameString(String uniqueName);
	
	public Optional<Creater> getByuniqueNameString(String uniqueName);
	
}
